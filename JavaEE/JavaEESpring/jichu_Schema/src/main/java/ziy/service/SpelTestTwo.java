package ziy.service;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/10/1
 */
public class SpelTestTwo {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        //集合投影运算
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("#root.![]");
        System.out.println(exp.getValue(list));
    }
}
