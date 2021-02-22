package 省赛真题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/2 下午1:56
 * @description TODO:单词分析
 * @className G
 */
public class G {
    static char c = 'a';
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c).intValue() + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        //最后寻找value最大的key
        map.forEach((k, v) -> {
            if (v > count) {
                count = v;
                c = k;
            }
            if (v == count && k < c) {
                c = k;
            }
        });
        System.out.println(c);
        System.out.println(count);
    }
}
