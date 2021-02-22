package 省赛真题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/5 下午8:02
 * @description TODO:子串分值 ---- 使用一个字符串来表示出现的重复子串，然后只需要替换其中的重复子串即可
 * @className J
 */
public class J {
    public static void main(String[] args) {
        System.out.println(test1("ababc"));
    }

    public static int test1(String s) {
        int res = 0;
        String repeat = "";
        StringBuilder sb = new StringBuilder("");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            for (int j = i; j < chars.length; j++) {
                String sh = String.valueOf(chars[j]);
                //判断是否重复
                boolean contains = sb.toString().contains(sh);
                if (contains) {
                    //重复，记录重复子串
                    repeat += sh;
                }
                sb.append(sh);
                //替换重复子串
                res += sb.toString().replaceAll(repeat, "").length();
            }
            repeat = "";
            sb = new StringBuilder("");
        }
        return res;
    }
}
