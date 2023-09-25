package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list = bookService.getBooks();
		
		return new ModelAndView("book/bookList","list",list); //request, forward
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(Book book, HttpServletRequest request, HttpSession session) throws Exception{
		//result.jsp / Error.jsp
		System.out.println("register BookVO before ::" + book);
		
		String isbn1 = request.getParameter("isbn1").trim();
		String isbn2 = request.getParameter("isbn2").trim();
		String isbn3 = request.getParameter("isbn3").trim();
		book.setIsbn(isbn1+"-"+isbn2+"-"+isbn3);
		
		System.out.println("register BookVO after::"+ book);
		
		String msg="";
		String path="Error.jsp";
		try {
			bookService.insertBook(book);
			msg = "책 정보가 정상적으로 디비에 저장되었습니다.";
			path= "result.jsp";
		}catch(Exception e) {
			System.out.println(e);
			msg="책 정보 저장 중 오류 발생...";
		}
		session.setAttribute("msg", msg);
		return new ModelAndView("redirect:"+path);
	}
	
	@RequestMapping("bookSearch.do")
    public ModelAndView search(String searchField ,String searchText, HttpServletRequest request) throws Exception{ 
		 System.out.println(searchField+", "+searchText);
		 //book/bookList
		 List<Book> list = null;
		 try {
			 switch(searchField) {
			 case "TITLE":
			 		//searchByTitle()...
				 list=bookService.searchByTitle(searchText);
			 		break;
			 case "PUBLISHER":
				//searchByPublisher()...
				 list = bookService.searchByPublisher(searchText);
				 break;
			 case "PRICE":
				//searchByPrice()...
				 list = bookService.searchByPrice(Integer.parseInt(searchText));
				 break;
			 default:
				 //getBooks()...
				 list = bookService.getBooks();
			 }
		 }catch(Exception e) {
			 return new ModelAndView("redirect:Error");
		 }
		return new ModelAndView("book/bookList","list",list);
	}
	
	@RequestMapping("bookView.do")
    public ModelAndView bookview(String isbn, HttpServletRequest request)throws Exception{
        String path = "find_fail.jsp";
        Book book = null;

        try {
            book = bookService.searchByIsbn(isbn);
            path = "book/bookView";
        }catch(Exception e) {
            System.out.println(e);
            request.setAttribute("msg", "isbn으로 검색중 오류 발생했습니다.");
        }
        return new ModelAndView(path, "book", book);
    }
	
	@RequestMapping("bookDesc.do")
	public ModelAndView desc(String isbn, HttpServletRequest request) throws Exception{
		Book book = null;
		try {
			book = bookService.searchByIsbn(isbn);
			System.out.println(book);
		}catch(Exception e) {
			System.out.println(e);
			request.setAttribute("msg", "비동기 통신 오류 발생, 다시 시도해주세요");
		}
		return new ModelAndView("JsonView", "book", book);
	}
}