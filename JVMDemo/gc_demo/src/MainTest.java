/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */

/**
 * VM参数:-Xms20M -Xms20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
 * */
public class MainTest {
    private static int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
