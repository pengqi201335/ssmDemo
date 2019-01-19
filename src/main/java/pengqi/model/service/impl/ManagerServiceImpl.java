package pengqi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pengqi.dao.ManagerDao;
import pengqi.dao.PapermanagerMapper;
import pengqi.model.pojo.Manager;
import pengqi.model.pojo.Papermanager;
import pengqi.model.pojo.PapermanagerExample;
import pengqi.model.service.ManagerService;

import java.util.List;

/**
 * ManagerService的实现类
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;
    private PapermanagerMapper papermanagerMapper;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Autowired
    public void setPapermanagerMapper(PapermanagerMapper papermanagerMapper) {
        this.papermanagerMapper = papermanagerMapper;
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

    /**
     * 利用mybatis逆向工程生成的代码做模糊查询
     * @param str 关键字
     * @return 满足查询条件的记录集合
     */
    @Override
    public List<Papermanager> fuzzyQuery(String str) {
        PapermanagerExample papermanagerExample = new PapermanagerExample();
        PapermanagerExample.Criteria criteria = papermanagerExample.createCriteria();
        //添加查询条件，等价于"and managerName like 'str.value' "
        criteria.andManagerNameLike(str);
        return papermanagerMapper.selectByExample(papermanagerExample);
    }

}
