import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // http://bank.com/account GET (select, 계좌 전체 조회)
        // http://bank.com/account/10 GET (select, 계좌 부분 조회)
        // http://bank.com/account POST (insert, 계좌생성)
        // http://bank.com/account/1 DELETE (계좌삭제)
        // http://bank.com/account/1 PUT (계좌수정)
        // 뒤의 숫자는 자원명이 아닌 식별자(PK)이다. = 식별자 요청
        // 1. GET은 HTTP 요청에 body가 없다.
        // 2. POST와 PUT은 반드시 body가 필요 하다.

        System.out.println("http 메서드를 입력하세요");
        String method = sc.nextLine();

        System.out.println("식별자를 입력하세요");
        String action = sc.nextLine();

        String body = "";
        String[] saveAction;
        int saveNum;

        BankDAO bankDAO = new BankDAO();
        if (method.equals("GET")) {
            if (action.equals("/account")) {
                List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            } else {
                saveAction = action.split("/");
                saveNum = Integer.parseInt(saveAction[2]);
                Account account = bankDAO.selectByNumber(saveNum);
                System.out.println(account);
            }

        } else if (method.equals("POST")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            // passowrd=1234&balacnce=1000
            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if (action.equals("/account")) {
                bankDAO.insert(password, balance);
            }
        } else if (method.equals("PUT")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            String[] st1 = body.split("&");
            int num = Integer.parseInt(action.split("/")[2]);
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if (!action.equals("/account")) {
                saveAction = action.split("/");
                saveNum = Integer.parseInt(saveAction[2]);
                bankDAO.updateByNumber(saveNum, balance);
            }
        } else if (method.equals("DELETE")) {
            if (action.equals("/account/1")) {
                bankDAO.deleteByNumber(1);
            }
        }
    }
}
