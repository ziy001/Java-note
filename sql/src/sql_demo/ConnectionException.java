package sql_demo;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/12 9:31
 */
public class ConnectionException extends Throwable {
    public ConnectionException(){}
    public ConnectionException(String msg) {
        super(msg);
    }
}
