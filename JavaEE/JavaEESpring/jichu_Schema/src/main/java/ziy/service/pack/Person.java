package ziy.service.pack;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 */
public class Person {
    private String name;
    private int age;
    private boolean sex;
    private String address;
    private Introduction introduction;

    @ConstructorProperties({"personName", "intro"})
    public Person(String name, Introduction introduction) {
        this.name = name;
        this.introduction = introduction;
    }

    public Person(){}

    public Person(String name, int age) {
        System.out.println("构造器注入");
        this.name = name;
        this.age = age;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", introduction=" + introduction +
                '}';
    }
}
