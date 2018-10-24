package yycg.base.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.DictInfoExample;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.po.UserGysExample;
import yycg.base.pojo.vo.DictInfoCoustomer;
import yycg.base.pojo.vo.DictInfoVo;

public interface DictInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DictInfo record);

    int insertSelective(DictInfo record);

    List<DictInfo> selectByExample(DictInfoExample example);

    DictInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictInfo record, @Param("example") DictInfoExample example);

    int updateByExample(@Param("record") DictInfo record, @Param("example") DictInfoExample example);

    int updateByPrimaryKeySelective(DictInfo record);

    int updateByPrimaryKey(DictInfo record);

	List<DictInfo> selectGys(DictInfoExample example);
	
	/**
	 * 查询所有数据字典信息条目数
	 * @param dictinfovo
	 * @return
	 * @author chengkeli
	 */
	int findTotalItem(DictInfoVo dictinfovo);

	/**
	 * 查询所有数据字典信息
	 * @param dictinfovo
	 * @return
	 * @author chengkeli
	 */
	List<DictInfoCoustomer> findAllBasicinfo(DictInfoVo dictinfovo);

	DictInfoCoustomer selectById(String id);

	List<String> findTypename(@Param("typecode") String typecode);

	void insertDictType(@Param("typecode") String typecode, @Param("typename") String typename);
}