package ziy.dao.impl;

import ziy.dao.SaveDao;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/25
 */
public class OracleDaoImpl implements SaveDao {
    {
        System.out.println("oracle");
    }
    /**
     * Oracle
     */
    @Override
    public void saveData() {
        System.out.println("Oracle Dao层保存成功!!!");
    }
}
