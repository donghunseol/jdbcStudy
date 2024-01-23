import annotation.RequestMapping;
import controller.BankController;
import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.io.*;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public void route() {

    }

    public static void main(String[] args) {
        // http://bank.com/account GET (select, 계좌 전체 조회)
        // http://bank.com/account/10 GET (select, 계좌 부분 조회)
        // http://bank.com/account POST (insert, 계좌생성)
        // http://bank.com/account/1 DELETE (계좌삭제)
        // http://bank.com/account/1 PUT (계좌수정)
        // 뒤의 숫자는 자원명이 아닌 식별자(PK)이다. = 식별자 요청
        // 1. GET은 HTTP 요청에 body가 없다.
        // 2. POST와 PUT은 반드시 body가 필요 하다.

        // 라우터를 설계하고 컨트롤러를 만든다.


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg = br.readLine();

            Dispatcher.route(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
