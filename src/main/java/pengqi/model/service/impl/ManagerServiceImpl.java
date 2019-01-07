package pengqi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pengqi.model.dao.ManagerDao;
import pengqi.model.pojo.Manager;
import pengqi.model.service.ManagerService;

/**
 * ManagerService的实现类
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    /**
     * 根据管理员账号名查询管理员信息的接口函数
     * @param managerName 管理员账号名
     * @return 管理员实例
     */
    @Override
    public Manager queryManagerByID(String managerName) {
        return managerDao.queryManagerByID(managerName);
    }
}
