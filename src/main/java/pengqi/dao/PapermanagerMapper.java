package pengqi.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pengqi.model.pojo.Papermanager;
import pengqi.model.pojo.PapermanagerExample;

public interface PapermanagerMapper {
    long countByExample(PapermanagerExample example);

    int deleteByExample(PapermanagerExample example);

    int insert(Papermanager record);

    int insertSelective(Papermanager record);

    List<Papermanager> selectByExample(PapermanagerExample example);

    int updateByExampleSelective(@Param("record") Papermanager record, @Param("example") PapermanagerExample example);

    int updateByExample(@Param("record") Papermanager record, @Param("example") PapermanagerExample example);
}