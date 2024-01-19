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
        String username = "root";
        String password = "1234";
        // url이란 건 앞에 프로토콜을 적어줘야한다. -> 웹은 http, 파일 서버는 ftp, db는 db마다 다른데 MariaDB는 jdbc:mariadb:// 나머지는 상황에 따라 검색!
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
