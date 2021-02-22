import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @Author ziy
 * @Date 2020/6/11 10:29
 * @Version 1.0
 * TODO:文件编码
 */
public class MainTest {
    public static void main(String[] args) {
        int[] arr = {1};
        int[] ints = Arrays.copyOfRange(arr, 0, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
