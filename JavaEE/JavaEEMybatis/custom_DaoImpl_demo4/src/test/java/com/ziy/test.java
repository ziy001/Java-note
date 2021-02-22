package com.ziy;

import com.ziy.dao.IUserDao;
import com.ziy.daoImpl.IUserDaoImpl;
import com.ziy.domain.User;
import com.ziy.querycondition.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/30
 */
public class test {
    private InputStream in;
    private IUserDaoImpl impl;

    private void init() throws IOException {
        //读取文件
        in = Resources.getResourceAsStream("SqlConfig.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        impl = new IUserDaoImpl(factory);
    }

    @Test
    public void testFindAll() throws IOException {
        init();
        final List<User> all = impl.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     * @throws IOException
     */
    @Test
    public void testSave() throws IOException {
        init();
        User user = new User();
        user.setUsername("尼古拉斯*翠花");
        user.setUserpassword("123");
        user.setAddress("美国");
        impl.saveUser(user);

    }

    /**
     *测试 更新操作
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        init();
        User user = new User();
        user.setUsername("尼古拉斯*翠花");
        user.setUserpassword("123");
        user.setAddress("美国");
    }

    /**
     * 测试根据id值删除操作
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        init();
        impl.delete(5);

    }

    /**
     * 测试Byid查询
     * @throws IOException
     */
    @Test
    public void testFindById() throws IOException {
        init();

    }

    /**
     * 根据用户名模糊查询
     * @throws IOException
     */
    @Test
    public void testFindByName() throws IOException {
        init();

    }

    @Test
    public void testFindTotal() throws IOException {
        init();

    }

    /**
     * 测试条件查询  GONL表达式测试方法
     */
    @Test
    public void testFindByVo() throws IOException {
        init();

    }
}
