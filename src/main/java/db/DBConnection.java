package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getInstance(){
        String username = "root";
        String password = "1234";
        // url이란 건 앞에 프로토콜을 적어줘야한다. -> 웹은 http, 파일 서버는 ftp, db는 db마다 다른데 MariaDB는 jdbc:mariadb:// 나머지는 상황에 따라 검색!
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("DB Connection success");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
