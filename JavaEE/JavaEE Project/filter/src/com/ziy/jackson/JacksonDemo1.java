package com.ziy.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/21
 */
public class JacksonDemo1 {

    public void test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(null);
        System.out.println(s);
    }
}
