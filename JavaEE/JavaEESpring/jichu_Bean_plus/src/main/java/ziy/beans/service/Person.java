package ziy.beans.service;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/29
 */
public class Person {
    int age;
    Son son;

    public void setAge(int age) {
        this.age = age;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public int getAge() {
        return age;
    }

    public Son getSon() {
        return son;
    }
    public static void test() {
        System.out.println("testtest....");
    }
}
