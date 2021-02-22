package com.redis.jedis.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/23
 * TODO:jedis客户端
 */
public class JedisDemo {
    @Test
    public void test1() {
        Jedis jedis = new Jedis();

        //操作
        jedis.set("name", "lisi");
        //输出
        String name = jedis.get("name");
        System.out.println(name);
    }
    @Test
    public void test2() {
        //连接池
        JedisPool jedisPool = new JedisPool();
        JedisPoolConfig config = new JedisPoolConfig();
        Jedis jedis = jedisPool.getResource();
        
    }
}
