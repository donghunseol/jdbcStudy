package controller;

import annotation.RequestMapping;
import dao.BankDAO;
import lombok.AllArgsConstructor;
import model.Account;

/***
 * 책임(SRP) : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기
 */
public class BankController {

    private static BankController instance = new BankController();

    public static BankController getInstance() {
        return instance;
    }

    private BankController() {
    }

    @RequestMapping(uri = "/insert")
    public void insert() {
        System.out.println("controller : insert");
        BankDAO dao = BankDAO.getInstance();
        dao.insert("1234", 1000);
    }

    @RequestMapping(uri = "/delete")
    public void delete() {
        System.out.println("controller : delete");
        BankDAO dao = BankDAO.getInstance();
        dao.deleteByNumber(1);
    }

    @RequestMapping(uri = "/update")
    public void update() {
        System.out.println("controller : update");
        BankDAO dao = BankDAO.getInstance();
        dao.updateByNumber(1000, 1);
    }

    @RequestMapping(uri = "/selectOne")
    public void selectOne() {
        System.out.println("controller : selectOne");
        BankDAO dao = BankDAO.getInstance();
        dao.selectByNumber(1);
    }

    @RequestMapping(uri = "/selectAll")
    public void selectAll() {
        System.out.println("controller : selectAll");
        BankDAO dao = BankDAO.getInstance();
        dao.selectAll();
    }
}
