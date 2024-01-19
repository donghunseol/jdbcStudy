import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            // 이렇게 만들면 다양하게 활용이 가능해진다.
            String insert = "INSERT INTO account_tb(password, balance, created_at) values(?, ?, now())";
            String delete = "delete from account_tb where number = ?";
            String update = "update account_tb set balance = balance + ? where number = ?";
            // 버퍼
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO account_tb(password, balance, created_at) values(?, ?, now())");
            // 버퍼의 물음표 자리를 채우는 문법
            pstmt.setString(1, "1234"); // 앞자리는 몇 번째 물음표를 만들건지 기입, 원하는 것 -> 이 문법은 1부터 시작하고 0이 없다.
            pstmt.setInt(2, 1000);      // 타입이 무엇이냐에 따라 setInt(), setString() 등 으로 한다.
            int num = pstmt.executeUpdate(); // flush와 같다. 무언가 실행되는데 들어가보니 아무것도 없으면 그냥 동적 바인딩이라 생각하면 된다.
            System.out.println(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
