import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author ziy
 * @version 1.0
 * @date 上午11:28 2020/11/10
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void test1() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new A().aaa");
        System.out.println(exp.getValue());
    }
}
