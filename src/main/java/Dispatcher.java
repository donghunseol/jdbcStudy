import annotation.RequestMapping;
import controller.BankController;
import dao.BankDAO;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***
 * 책임(SRP) : 라우팅
 */
public class Dispatcher {

    private static Dispatcher instance = new Dispatcher();

    public static Dispatcher getInstance() {
        return instance;
    }

    private Dispatcher() {
    }

    public static void route(String url) throws InvocationTargetException, IllegalAccessException {
        BankController con = BankController.getInstance();
        Method[] methods = con.getClass().getDeclaredMethods();

        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(url)) {
                method.invoke(con);
            }
        }
    }
}
