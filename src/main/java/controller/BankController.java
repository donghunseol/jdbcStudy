package controller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

/***
 * 책임(SRP) : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기
 */
@AllArgsConstructor
public class BankController {

    private BankDAO dao;

    public void insert() {
        System.out.println("controller : insert");
        dao.insert("1234", 1000);
    }

    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    public void update() {
        System.out.println("controller : update");
        dao.updateByNumber(1000, 1);
    }

    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
