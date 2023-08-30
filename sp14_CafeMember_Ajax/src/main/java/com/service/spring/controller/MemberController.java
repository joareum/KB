package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.MemberVO;
import com.service.spring.model.MemberDAO;
import com.service.spring.model.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("find.do")
	public String find(Model model, String id) throws Exception {
		
		MemberVO rvo = memberService.getMember(id);
		String path = "find_fail";
		if(rvo!=null) {
			model.addAttribute("vo", rvo);
			model.addAttribute("msg", "회원 발견 - 성공");
			path = "find_ok";
			return path;
		} else {
			model.addAttribute("msg", "회원 발견 - 실패");
			path = "find_fail";
			return path;
		}
	}
	
	@RequestMapping("showAll.do")
	public String showAll(Model model) throws Exception {
		
		List<MemberVO> list = memberService.showAllMember();
		
		model.addAttribute("list", list);
		return "allView";
		
	}
	
	@RequestMapping("update.do")
	public String update(Model model, MemberVO member) throws Exception{
		
		memberDAO.updateMember(member);
		model.addAttribute("vo", member);
		
		return "update_result";
	}
	
	@RequestMapping("register.do")
    public String register(Model model, MemberVO member) throws Exception{

        System.out.println(member);
        String path = "Error.jsp";
        try {
            memberDAO.registerMember(member);
            model.addAttribute("vo", member);
            model.addAttribute("msg", "회원가입 완료");
            // 디비에 성공적으로 등록을 하면 다시 이곳으로 리턴된다.
            path = "register_result";
        }catch(Exception e) {
            // 디비에 성공적으로 등록을 하지 못했다면 이곳으로 리턴된다.
            System.out.println(e);
            model.addAttribute("msg", "회원가입 중 오류 발생");
        }
        return path;
    }
	
	@RequestMapping("login.do")
    public String login(Model model, MemberVO member, HttpSession session) throws Exception {
        MemberVO rvo = memberDAO.login(member);
        System.out.println("rvo :: " + rvo);


         String path="index.jsp"; 
         String msg="아이디 혹은 패스워드가 틀렸습니다."; 
         if(rvo != null) {
             path="login_result";
             model.addAttribute("vo", rvo);
             session.setAttribute("vo", rvo);
             model.addAttribute("msg", "로그인 완료");
         }
         else {
             model.addAttribute("msg", "로그인 안됨");
         }

        return path;
    }
	
	@RequestMapping("logout.do")
    public String logout(HttpServletRequest request) throws Exception{
        String path = "logout";
        try {
            //세션을 죽이는 로직 ...invalidate()
            HttpSession session = request.getSession();
            if(session.getAttribute("vo")!=null) {
                //로그인 된 상태
                session.invalidate();
                //path = "logout.jsp";
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return path;
    }
}
