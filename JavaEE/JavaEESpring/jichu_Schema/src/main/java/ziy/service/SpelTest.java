package ziy.service;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import ziy.service.pack.Person;

import java.sql.SQLOutput;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 */
public class SpelTest {
    public static void main(String[] args) {
        SpelExpressionParser r = new SpelExpressionParser();
        //字符串表达式
        Expression exp = r.parseExpression("'Hello,World'");
        System.out.println(exp.getValue());
        //调用方法的表达式
        exp = r.parseExpression("'Hello,World'.concat('!')");
        System.out.println("调用.concat()的结果:  "+ exp.getValue());
        //调用getter方法
        //"你好".getBytes()
        exp = r.parseExpression("'你好'.bytes");
        System.out.println("调用getter方法:  "+exp.getValue());
        //访问对象属性
        //“你好”.getBytes.length;
        exp = r.parseExpression("'你好'.bytes.length");
        System.out.println("访问对象属性:  "+exp.getValue());
        //通过构造器创建对象
        exp = r.parseExpression("new String('hello').toUpperCase()");
        System.out.println("构造器创建对象:  "+ exp.getValue());

        Person p1 = new Person("小明", 1);
        Person p2 = new Person("小红", 2);
        //使用root对象
        //#this表示当前计算表达式所引用的对象（默认引用context变量的第一个，如果指定root则默认引用root）
        exp = r.parseExpression("#this.name");
        System.out.println("以Person对象为root的name表达式:  "+
                exp.getValue(p2, String.class));

        //使用上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(p1);
        System.out.println("以person对象为root的name表达式（以上下文传递）:  "+
                exp.getValue(context));
        context.setVariable("p1", p1);
        context.setVariable("p2", p2);
        exp = r.parseExpression("#p2.getAge() + '\n' +#root.toString()");
        System.out.println("访问Name:  "+ exp.getValue(context));

    }
}
