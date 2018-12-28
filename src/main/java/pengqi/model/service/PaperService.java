package pengqi.model.service;

import pengqi.model.pojo.Paper;

import java.util.List;

/**
 * 处理paper表的业务逻辑接口
 */
public interface PaperService {
    /**
     * 增加论文
     * @param paper 论文实例
     * @return 该论文编号
     */
    int addPaper(Paper paper);

    /**
     * 删除论文
     * @param paperID 要删除论文的编号
     * @return 该论文编号
     */
    int deletePaper(int paperID);

    /**
     * 更新论文信息
     * @param paper 论文实例
     * @return 该论文编号
     */
    int updatePaper(Paper paper);

    /**
     * 根据编号查询论文
     * @param paperID 论文ID
     * @return 该论文实例
     */
    Paper queryPaperByID(int paperID);

    /**
     * 查询所有论文
     * @return 所有论文的集合
     */
    List<Paper> queryAllPaper();
}
