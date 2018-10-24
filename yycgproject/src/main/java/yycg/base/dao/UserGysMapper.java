package yycg.base.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.po.UserGysExample;

public interface UserGysMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(UserGys record);

    List<UserGys> selectByExampleWithBLOBs(UserGysExample example);

    List<UserGys> selectByExample(UserGysExample example);

    UserGys selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserGys record, @Param("example") UserGysExample example);

    int updateByExampleWithBLOBs(@Param("record") UserGys record, @Param("example") UserGysExample example);

    int updateByExample(@Param("record") UserGys record, @Param("example") UserGysExample example);

    int updateByPrimaryKeySelective(UserGys record);

    int updateByPrimaryKeyWithBLOBs(UserGys record);

    int updateByPrimaryKey(UserGys record);
}