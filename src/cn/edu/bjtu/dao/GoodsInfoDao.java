package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

public interface GoodsInfoDao extends BaseDao<Goodsform>{
	
	
	public GoodsClientView getAllGoodsDetail(String id);
	public Goodsform getMyGoodsDetail(String id);
	
	public boolean commitResponse(String goodsId,String remarks,String userId,String path,String fileName);
	
	public boolean deleteGoods(String id);
}
