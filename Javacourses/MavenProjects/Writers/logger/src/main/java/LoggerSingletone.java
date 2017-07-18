import org.apache.log4j.Logger;

/**
 * Created by Сирожа и Маха on 17.07.2017.
 */
public class LoggerSingletone {

    private static Logger logger=null;
    private static LoggerSingletone ourInstance = new LoggerSingletone();

    public static LoggerSingletone getInstance() {
        return ourInstance;
    }

    private LoggerSingletone() {
    }
    public Logger getLogger(String className){
        if(logger==null){
            setLogger(className);
        }
        return logger;
    }
    private static void setLogger(String className){
        if(logger==null){
            logger=Logger.getLogger(className);
        }
    }
}
