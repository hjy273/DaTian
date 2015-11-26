package cn.edu.bjtu.dao.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.WarehouseDao;

import cn.edu.bjtu.vo.Warehouse;

@Repository
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao{
	
	@Override
	/**
	 * ���ؾ��������Ϣ
	 */
	public Warehouse getWarehouseInfo(String warehouseid) {
		
		return this.get(Warehouse.class, warehouseid);
		
	}

}
