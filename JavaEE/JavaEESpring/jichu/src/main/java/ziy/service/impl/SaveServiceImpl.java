package ziy.service.impl;

import ziy.dao.SaveDao;
import ziy.service.SaveService;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/25
 */
public class SaveServiceImpl implements SaveService {
    private SaveDao saveDao;
    @Override
    public void service() {
        System.out.println("构造");
        saveDao.saveData();
    }
    private SaveServiceImpl(){}

    public void setSaveDao(SaveDao saveDao) {
        System.out.println("调用setter方法");
        this.saveDao = saveDao;
    }

    public SaveDao getSaveDao() {
        return saveDao;
    }
}
