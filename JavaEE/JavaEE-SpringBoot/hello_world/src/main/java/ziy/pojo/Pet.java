package ziy.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/15 上午11:50
 * @description TODO:
 * @className Pet
 */
@Data
@NoArgsConstructor
@ToString
public class Pet {
    private String petName;
    private int age;
    private String describe;
}
