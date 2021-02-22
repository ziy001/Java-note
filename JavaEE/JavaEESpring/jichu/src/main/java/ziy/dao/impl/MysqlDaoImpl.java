package ziy.dao.impl;

import ziy.dao.SaveDao;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/25
 */
public class MysqlDaoImpl implements SaveDao {
    /**
     * mysql
     */
    @Override
    public void saveData() {
        System.out.println("Mysql Dao层保存成功!!!");
    }
}
