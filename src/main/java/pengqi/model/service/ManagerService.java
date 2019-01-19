package pengqi.model.service;

import pengqi.model.pojo.Manager;
import pengqi.model.pojo.Papermanager;

import java.util.List;

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

    /**
     * 利用mybatis逆向工程生成的代码做模糊查询
     * @param str 关键字
     * @return 满足查询条件的记录集合
     */
    List<Papermanager> fuzzyQuery(String str);
}
