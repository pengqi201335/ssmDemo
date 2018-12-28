package pengqi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pengqi.model.dao.PaperDao;
import pengqi.model.pojo.Paper;
import pengqi.model.service.PaperService;

import java.util.List;

/**
 * PaperService的实现类
 */
@Service
public class PaperServiceImpl implements PaperService {
    private PaperDao paperDao;  //声明mapper接口变量

    //注入mapper接口动态代理对象
    @Autowired
    public void setPaperDao(PaperDao paperDao){
        this.paperDao = paperDao;
    }

    /**
     * 增加论文
     *
     * @param paper 论文实例
     * @return 该论文编号
     */
    @Override
    public int addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    /**
     * 删除论文
     *
     * @param paperID 要删除论文的编号
     * @return 该论文编号
     */
    @Override
    public int deletePaper(int paperID) {
        return paperDao.deletePaper(paperID);
    }

    /**
     * 更新论文信息
     *
     * @param paper 论文实例
     * @return 该论文编号
     */
    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    /**
     * 根据编号查询论文
     *
     * @param paperID 论文ID
     * @return 该论文实例
     */
    @Override
    public Paper queryPaperByID(int paperID) {
        return paperDao.queryPaperByID(paperID);
    }

    /**
     * 查询所有论文
     *
     * @return 所有论文的集合
     */
    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }
}
