package com.ziy;

import com.ziy.dao.IUserDao;
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
    private SqlSession sqlSession;
    private IUserDao mapper;

    private void init() throws IOException {
        //读取文件
        in = Resources.getResourceAsStream("SqlConfig.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //打开与数据库的会话连接
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
    }

    private void close() throws IOException {
        sqlSession.commit();
        in.close();
        sqlSession.close();
    }
    @Test
    public void testFindAll() throws IOException {
        init();
        //执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        close();
    }

    /**
     * 测试保存操作
     * @throws IOException
     */
    @Test
    public void testSave() throws IOException {
        init();

        User user = new User();
        user.setUsername("风车车");
        user.setUserpassword("0099911");
        user.setAddress("天津");
        System.out.println("保存之前的id: "+ user.getId());
        mapper.saveUser(user);
        close();
        System.out.println("保存之后的id: "+ user.getId());
    }

    /**
     *测试 更新操作
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        init();
        User user = new User();
        user.setUsername("李四");
        user.setUserpassword("1222");
        user.setAddress("中国");
        mapper.update(user);

        close();
    }

    /**
     * 测试删除操作
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        init();

        mapper.delete(1);

        close();
    }

    /**
     * 测试Byid查询
     * @throws IOException
     */
    @Test
    public void testFindById() throws IOException {
        init();

        User byId = mapper.findById(5);
        System.out.println(byId);

        close();
    }

    /**
     * 根据用户名模糊查询
     * @throws IOException
     */
    @Test
    public void testFindByName() throws IOException {
        init();
//        List<User> users = mapper.findByName("%王%");
        List<User> users = mapper.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
        close();
    }

    @Test
    public void testFindTotal() throws IOException {
        init();
        int total = mapper.findTotal();
        System.out.println("用户个数: "+ total);
        close();
    }

    /**
     * 测试条件查询  GONL表达式测试方法
     */
    @Test
    public void testFindByVo() throws IOException {
        init();
        User user = new User();
        user.setUsername("%王%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> byVo = mapper.findByVo(vo);
        for (User user1 : byVo) {
            System.out.println(user1);
        }
        close();

    }
}
