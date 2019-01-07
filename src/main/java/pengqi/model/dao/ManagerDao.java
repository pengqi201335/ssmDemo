package pengqi.model.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import pengqi.model.pojo.Manager;

/**
 * paperManager表的数据访问层,位于mybatis持久层的上一层,作为mybatis中的mapper接口
 */
public interface ManagerDao {
    /**
     * 根据管理员账号名查询管理员信息的接口函数
     * @param managerName 管理员账号名
     * @return 管理员实例
     */
    Manager queryManagerByID(@Param("managerName") String managerName);
}
