package pengqi.model.service;

import pengqi.model.pojo.Manager;

/**
 * 处理paperManager表的业务逻辑接口
 */
public interface ManagerService {
    /**
     * 根据管理员账号名查询管理员信息的接口函数
     * @param managerName 管理员账号名
     * @return 管理员实例
     */
    Manager queryManagerByID(String managerName);
}
