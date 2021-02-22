package bean;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午3:46 2020/11/30
 * @description TODO:
 * @className Author
 */
public class Author {
    private String name;
    private Integer age;

    public Author() {}

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
