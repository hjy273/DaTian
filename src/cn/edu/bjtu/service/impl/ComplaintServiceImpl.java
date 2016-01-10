package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.ComplaintBean;
import cn.edu.bjtu.dao.ComplaintDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.ComplaintService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Complaintform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("complaintServiceImpl")
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Resource
	ComplaintDao complaintDao;
	@Resource
	OrderService orderService;
	@Autowired
	OrderDao orderDao;

	@Override
	public List getAllUserCompliant() {

		return complaintDao.getAllUserCompliant();
	}

	@Override
	public Complaintform getComplaintById(String id) {

		return complaintDao.get(Complaintform.class,id);
	}

	@Override
	/**
	 * ����Ͷ��
	 */
	public boolean insertComplaint(ComplaintBean complaintBean, String userId) {
		Complaintform complaintform =new Complaintform();

		complaintform.setId(IdCreator.createCityLineId());
		complaintform.setType(complaintBean.getType());
		complaintform.setTheme(complaintBean.getTheme());
		complaintform.setContent(complaintBean.getContent());
		complaintform.setOrderNum(complaintBean.getOrderNum());
		complaintform.setRelatedMaterial(complaintBean.getRelativeMaterial());//add by russwest at 2015��9��4��,����1:18:44 
		//FIXME ??BUG?
		complaintform.setCarrierId(userId);
		complaintform.setClientId(userId);
		complaintform.setRelDate(new Date());
		// add by RussWest0 at 2015��5��30��,����10:05:22
 
		complaintform.setState("������");
		complaintDao.save(complaintform);
		return true;

	}

	@Override
	public boolean doAcceptComplaint(String id, String feedback) {

		Complaintform complaintform = getComplaintById(id);
		complaintform.setFeedback(feedback);
		complaintform.setState("������");
		complaintDao.update(complaintform);
		return true;
	}

	
	/**
	 * ��ȡ�û�Ͷ����
	 */
	@Override
	public Double getUserComplaintRateAjax(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql_count="select count(*) from Orderform t ";
		String hql="select count(*) from Complaintform t ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){//�����û�
			hql_count+=" where t.clientId=:clientId ";
			hql+=" where t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind==3){//��ҵ�û�
			hql_count+=" where t.carrierId=:carrierId ";
			hql+=" where t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		Long total_num=orderDao.count(hql_count, params);
		if(total_num == 0L){
			return 0D;
		}
		Long complaint_num=complaintDao.count(hql, params);
		
		return complaint_num.intValue()*1.0/total_num.intValue();
		
	}

	/**
	 * 
	 * ������Ϣ-�ҵ�Ͷ��
	 */
	@Override
	public JSONArray getUserComplaint(HttpSession session,PageUtil pageUtil,Complaintform complaint) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Complaintform t "+whereHql(complaint,params);
				
		hql+=" and t.clientId=:clientId order by t.relDate desc";
		params.put("clientId", userId);
		
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Complaintform> complaintList=complaintDao.find(hql,params,page,display);
		JSONArray jsonArray=new JSONArray();
		
		for(Complaintform complaintIns:complaintList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(complaintIns);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	/**
	 * where hql������ʹ��
	 * @param complaint
	 * @param params
	 * @return
	 */
	private String whereHql(Complaintform complaint,Map<String,Object> params){
		String hql=" where 1=1 ";
		if(complaint !=null && !"".equals(complaint.getTheme())){
			hql+=" and t.theme like '%"+complaint.getTheme()+"%'";
		}
		
		return hql;
	}
	
	/**
	 * ������Ϣ-�ҵ�Ͷ��-�ܼ�¼��
	 */
	@Override
	public Integer getUserComplaintTotalRows(HttpSession session,Complaintform complaint) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Complaintform t  "+whereHql(complaint,params);
		hql+=" and t.clientId=:clientId";
		params.put("clientId", userId);
		
		Long count=complaintDao.count(hql, params);
		
		return count.intValue();
	}
	
	
}
