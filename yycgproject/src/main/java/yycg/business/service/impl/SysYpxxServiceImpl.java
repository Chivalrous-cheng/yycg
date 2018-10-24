package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.business.dao.SysYpxxMapper;
import yycg.business.service.SysYpxxService;

public class SysYpxxServiceImpl implements SysYpxxService{

	@Autowired
	private SysYpxxMapper sysypxxmapper;
	
	@Override
	public List<String> findYplb() {
		// TODO Auto-generated method stub
		return sysypxxmapper.findYplb();
	}

	@Override
	public List<String> findJyzt() {
		// TODO Auto-generated method stub
		return sysypxxmapper.findJyzt();
	}

}
