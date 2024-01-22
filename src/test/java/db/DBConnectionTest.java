package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    // 리턴타입을 적을 수 없다. (void 타입만 사용 가능)
    // 매개변수를 적을 수 없다.
    // @Test 붙이면 메서드 별로 실행 가능
    @Test // 제이유닛 → 자바로 테스트 할 수 있는 도구
    public void getInstance_test(){
        // given = 파라미터


        // when = 본코드 실행
        Connection conn = DBConnection.getInstance();

        // then = 눈 검증
        if(conn == null){
            System.out.println("실패");
        } else {
            System.out.println("성공");
        }
    }
}
