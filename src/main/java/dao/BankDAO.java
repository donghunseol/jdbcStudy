package dao;

import db.DBConnection;
import model.Account;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 * DAO - Data Access Object
 * SRP - 단일책임의 원칙
 */
public class BankDAO {

    private static BankDAO instance = new BankDAO();

    public static BankDAO getInstance() {
        return instance;
    }

    private BankDAO() {
    }

    public int deleteByNumber(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ?";
            // 버퍼
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 버퍼의 물음표 자리를 채우는 문법
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "INSERT INTO account_tb(password, balance, created_at) values(?, ?, now())";
            // 버퍼
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 버퍼의 물음표 자리를 채우는 문법
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(int balance, int number) {
        // 1. DB 소켓 가져오기
        Connection conn = DBConnection.getInstance();
        try {
            // 2. 버퍼에 쿼리 담기
            String sql = "update account_tb set balance = ? where number = ?";
            // 3. 쿼리 전송
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 버퍼의 물음표 자리를 채우는 문법
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);
            // 4. 리턴 값 가져오기
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Account selectByNumber(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            // ResultSet 은 테이블 형태의 데이터
            ResultSet rs = pstmt.executeQuery();

            // System.out.println(isRow);

            // 프로젝션 과정
            //System.out.println(rs.getInt("number"));
            //System.out.println(rs.getString("password"));
            //System.out.println(rs.getInt("balance"));
            //System.out.println(rs.getTimestamp("created_at"));

            if (rs.next()) { // 커서 한칸 내리기 (지금 컬럼 자리에 있으니 한 칸 내려야한다.)
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll() {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc"; // 전체 조회 시에는 거꾸로 조회한다. (최신순)
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
