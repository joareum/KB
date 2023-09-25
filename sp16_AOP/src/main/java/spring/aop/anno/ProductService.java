package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//핵심 관심사만 들어있는 클래스
//Target Class...CoreConcern
public class ProductService {

    public String deleteProduct(String id) {
        System.out.println(id+" :: deleteProduct..logic..삭제 성공");
        return "삭제된 상품 ID :"+id;
    }
}
