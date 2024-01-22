package dao;

import org.junit.jupiter.api.Test;

public class BankDAOTest {

    @Test
    public void deleteByNumber_test(){
        // given
        int number = 2;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        // then
        if(result == 1){
            System.out.println("삭제 성공");
        } else if(result == 0){
            System.out.println(number+"번호를 찾을 수 없습니다");
        }else{
            System.out.println("삭제 실패");
        }
    }

    @Test
    public void insert(){
        // given
        String password = "334455";
        int balance = 13000;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        //then
        if(result == 1){
            System.out.println("입력 성공");
        }else {
            System.out.println("입력에 실패 하였습니다.");
        }
    }

    @Test
    public void updateByNumber(){
        // given
        int balance = 2;
        int number = 4;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance,number);

        // then
        if(result == 1){
            System.out.println("수정 성공");
        } else if (result == 0) {
            System.out.println(number+"번호가 없습니다");
        }else {
            System.out.println("수정 실패");
        }
    }

}
