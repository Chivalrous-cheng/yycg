package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.business.dao.YpxxCustomerMapper;
import yycg.business.pojo.vo.YpxxCustomer;
import yycg.business.service.YpmlService;

public class YpmlServiceImpl implements YpmlService {

	@Autowired
	private YpxxCustomerMapper ypxxcustomermapper;
	
	@Override
	public List<YpxxCustomer> findYpxx() {
		return ypxxcustomermapper.findYpxx();
	}

}
