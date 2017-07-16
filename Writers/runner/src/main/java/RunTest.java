import com.mysql.jdbc.Connection;
import org.apache.log4j.BasicConfigurator;

public class RunTest {
    public static void main(String[] args){



BasicConfigurator.configure();
        ConnectionSingletone singletone=ConnectionSingletone.getInstance();
     singletone.getConnection();

    }
}
