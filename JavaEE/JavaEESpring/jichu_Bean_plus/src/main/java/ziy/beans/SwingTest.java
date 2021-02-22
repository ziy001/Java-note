package ziy.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/29
 */
public class SwingTest {
    public static void main(String[] args) {
//        var win = new JFrame("我的窗口");
//        var jta = new JTextArea(7, 14);
//        var jb1 = new JButton("确定");
//        var jb2 = new JButton("取消");
//        JPanel jp = new JPanel();
//
//        win.add(new JScrollPane(jta));
//        win.add(jp, BorderLayout.SOUTH);
//
//        jp.add(jb1);
//        jp.add(jb2);
//
//        win.pack();
//        win.setVisible(true);

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("swingBeans.xml");
//        Object win = ctx.getBean("win");
//        JFrame win1 = (JFrame) win;

    }
}
