package com.ziy.daoImpl;

import com.ziy.dao.IUserDao;
import com.ziy.domain.User;
import com.ziy.querycondition.QueryVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/2
 */
public class IUserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    private SqlSession getSession() {
        return this.factory.openSession();
    }
    /**
     * 实现fingAll方法
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> list = null;
        try(SqlSession session = getSession()) {
            list = session.selectList("com.ziy.dao.IUserDao.findAll");
        }
        return list;
    }

    @Override
    public void saveUser(User user) {
        try(SqlSession session = getSession()) {
            session.insert("com.ziy.dao.IUserDao.saveUser", user);
            session.commit();
        }
    }

    @Override
    public void update(User user) {
        try(final SqlSession session = getSession()) {
            session.update("com.ziy.dao.IUserDao.update", user);
            session.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try(final SqlSession session = getSession()) {
            session.delete("com.ziy.dao.IUserDao.delete", id);
            session.commit();
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }

    @Override
    public List<User> findByVo(QueryVo vo) {
        return null;
    }
}
