import controller.BankController;
import lombok.AllArgsConstructor;

/***
 * 책임(SRP) : 라우팅
 */

@AllArgsConstructor
public class Dispatcher {

    private BankController con;

    public void route(String url) {


        // 라우터, 디스패쳐
        if (url.equals("insert")) {
            con.insert();
        } else if (url.equals("delete")) {
            con.delete();
        } else if (url.equals("update")) {
            con.update();
        } else if (url.equals("selectOne")) {
            con.selectOne();
        } else if (url.equals("selectAll")) {
            con.selectAll();
        }
    }
}
