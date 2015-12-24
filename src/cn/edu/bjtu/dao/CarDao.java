package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

public interface CarDao extends BaseDao<Carinfo>{
	public List<Carinfo> getAllcarNum(String carrierId);
	public boolean setcarState(String carNum,String carState);
}
