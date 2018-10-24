package yycg.base.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import yycg.base.dao.DictInfoMapper;
import yycg.base.pojo.vo.DictInfoCoustomer;
import yycg.base.pojo.vo.DictInfoVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.DictinfoService;
import yycg.util.UUIDBuild;

public class DictinfoServiceImpl implements DictinfoService{

	@Autowired
	private DictInfoMapper dictinfomapper;
	
	@Override
	public int getCount(DictInfoVo dictinfovo) {
		return dictinfomapper.findTotalItem(dictinfovo);
	}

	@Override
	public List<DictInfoCoustomer> finddictinfor(DictInfoVo dictinfovo) {
		return dictinfomapper.findAllBasicinfo(dictinfovo);
	}

	@Override
	public void insertdictInfo(DictInfoVo dictinfovo) throws ExceptionResultInfo{
		/**
		 * js校验
		 * 后台校验
		 * 字典类型代码不能为空,
		 * dicttype若不存在此代码,插入到dicttype中
		 * dicttype若存在此代码,回显到页面
		 * 字典信息不能为空
		 * isenable不能为空
		 * 添加主键
		 */
		
		DictInfoCoustomer dictinfocoustomer = dictinfovo.getDictinfocoustomer();
		String typecode = dictinfocoustomer.getTypecode();
		if(!StringUtils.hasLength(typecode.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 806));
		}
		List<String> typenamelist = dictinfomapper.findTypename(typecode);
		if(typenamelist.size() == 0){
			String typename = dictinfocoustomer.getTypename();
			if(!StringUtils.hasLength(typename.trim())){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 807));
			}
			dictinfomapper.insertDictType(typecode,typename);
		}
		String info = dictinfocoustomer.getInfo();
		if(!StringUtils.hasLength(info.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 808));
		}
		String isenable = dictinfocoustomer.getIsenable();
		if(!StringUtils.hasLength(isenable.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 809));
		}
		//补全主键
		dictinfocoustomer.setId(UUIDBuild.getUUID());
		
		//设置更新时间
		DateTime now = new DateTime();
		dictinfocoustomer.setUpdatetime(now.toString("yyyy/MM/dd HH:mm:ss EE"));
		
		dictinfomapper.insert(dictinfocoustomer);
		
	}
	
	@Override
	public List<String> findtypename(String typecode) {
		return dictinfomapper.findTypename(typecode);
	}

	@Override
	public DictInfoCoustomer finddictInfoById(String id) {
		return dictinfomapper.selectById(id);
	}

	@Override
	public void updatetdictInfo(DictInfoCoustomer dictinfocoustomer) throws ExceptionResultInfo{
		/**
		 * js校验
		 * 后台校验
		 * 字典类型代码不能为空,
		 * dicttype若不存在此代码,插入到dicttype中
		 * dicttype若存在此代码,回显到页面
		 * 字典信息不能为空
		 * isenable不能为空
		 * 添加主键
		 */
		
		String typecode = dictinfocoustomer.getTypecode();
		if(!StringUtils.hasLength(typecode.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 806));
		}
		List<String> typenamelist = dictinfomapper.findTypename(typecode);
		if(typenamelist.size() == 0){
			String typename = dictinfocoustomer.getTypename();
			if(!StringUtils.hasLength(typename.trim())){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 807));
			}
			dictinfomapper.insertDictType(typecode,typename);
		}
		String info = dictinfocoustomer.getInfo();
		if(!StringUtils.hasLength(info.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 808));
		}
		String isenable = dictinfocoustomer.getIsenable();
		if(!StringUtils.hasLength(isenable.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 809));
		}
		
		//设置更新时间
		DateTime now = new DateTime();
		dictinfocoustomer.setUpdatetime(now.toString("yyyy/MM/dd HH:mm:ss EE"));
		System.out.println(now.toString("yyyy/MM/dd HH:mm:ss EE"));
		
		dictinfomapper.updateByPrimaryKeySelective(dictinfocoustomer);
	}

	@Override
	public void deletedictInfoById(String id) {
		dictinfomapper.deleteByPrimaryKey(id);
	}


}
