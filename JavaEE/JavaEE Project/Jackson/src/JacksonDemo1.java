import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import test.Person;

import java.util.Date;


/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/21
 */
public class JacksonDemo1 {
    public static void main(String[] args) throws JsonProcessingException {
        //设置对象
        Person xiaomin = create("小明", 20, new Date(), "XX中学");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(xiaomin);

        System.out.println(s);
    }
    private static Person create(String name, int age, Date birthday, String school) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setBirthday(birthday);
        person.setSchool(school);
        return person;
    }
}
