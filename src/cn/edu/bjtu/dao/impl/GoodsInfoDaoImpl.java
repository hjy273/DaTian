package cn.edu.bjtu.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.GoodsClientViewDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.ResponseDao;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Response;

@Repository
public class GoodsInfoDaoImpl extends BaseDaoImpl<Goodsform> implements GoodsInfoDao {

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private ResponseDao responseDao;
	@Autowired
	GoodsClientViewDao goodsClientViewDao;

	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		

		return goodsClientViewDao.get(GoodsClientView.class, id);

	}

	/**
	 * ����id�õ�����
	 */
	@Override
	public Goodsform getMyGoodsDetail(String id) {

		return this.get(Goodsform.class, id);

	}


	@Override
	/**
	 * �ύ����Dao
	 */
	public boolean commitResponse(String goodsId, String remarks, String userId,String path,String fileName) {
		
		Goodsform goods = this.get(Goodsform.class, goodsId);
		String clientId="";
		String committer="";
		String phone="";
		if(goods!=null){
			clientId=goods.getClientId();
		}
		Carrierinfo carrier=companyDao.getCarrierInfo(userId);
		if(carrier!=null){
			committer=carrier.getCompanyContact();
			phone=carrier.getPhone();
		}
		//goods.setRemarks(remarks);
		int feedBackQuantity=goods.getFeedbackQuantity();
		feedBackQuantity++;//����������1
		goods.setFeedbackQuantity(feedBackQuantity);
		this.update(goods);
		//�˴�����Ҫ��¼����������
		Response response=new Response();
		response.setId(IdCreator.createResponseId());
		response.setCarrierId(userId);
		response.setClientId(clientId);
		response.setCommitter(committer);
		response.setGoodsId(goodsId);
		response.setPhone(phone);
		response.setRemarks(remarks);
		response.setRelDate(new Date());
		response.setStatus("��ȷ��");//add by RussWest0 at 2015��6��6��,����3:07:08 
		// �����ļ�·��
				if (path != null && fileName != null) {
					String fileLocation = path + "//" + fileName;
					response.setRelatedMaterial(fileLocation);
				}
		//���淴����Ϣ
		responseDao.save(response);
		
		return true;
	}


	@Override
	public boolean deleteGoods(String id) {

		Goodsform goodsform = this.get(Goodsform.class, id);
		this.delete(goodsform);
		return true;
	}

}
