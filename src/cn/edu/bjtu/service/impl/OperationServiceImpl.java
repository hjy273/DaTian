package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;
@Service
@Transactional
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	OrderDao orderDao;	

	/**
	 * �������-��Ӫָ���б�
	 */
	@Override
	public List<OperationBean> getTransportAccuracyList(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereHql(operationBean,session,params);
		hql+=" group by date(t.submitTime) order by t.submitTime desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> list=orderDao.find(hql, params,page,display);
		List<OperationBean> opList=new ArrayList<OperationBean>();
		//Ŀǰϵͳ��û�й���׼ȷ�ʺ�׼ȷ��������� FIXME
		for(Orderform order:list){
			OperationBean opBean=new OperationBean();
			opBean.setDate(order.getSubmitTime());
			opList.add(opBean);
		}
		
		return opList;
	}
	
	/**
	 * �������-��Ӫָ���б��ܼ�¼��
	 */
	@Override
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from (select * from Orderform t "+whereHql(operationBean,session,params);
		hql+=" group by date(t.submitTime) order by t.submitTime desc) as t2";
		return orderDao.count(hql, params);
		
	}
	
	private String whereHql(OperationBean operationBean,
			HttpSession session, Map<String,Object> params){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String whereHql=" where t.carrierId=:carrierId ";
		params.put("carrierId", userId);
		String startDate=operationBean.getStartDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getStartDate());
		String endDate=operationBean.getEndDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			whereHql+=" and t.submitTime>=:startDate ";
			params.put("startDate", operationBean.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			//�����ʱ����Ҫ��һ�죬�ӵ���һ���0��ʱ�����ʹ�������׼ȷ
			whereHql+=" and t.submitTime<=:endDate ";
			params.put("endDate", operationBean.getEndDate());
		}
		return whereHql;
	}

	/**
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ������list
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@Override
	public List<OperationBean> getClientConsentList(
			OperationBean operationBean, HttpSession session, PageUtil pageUtil) {
		return null;
	}

	/**
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ�������ܼ�¼�� 
	 * @param operationBean
	 * @param session
	 * @return
	 */
	@Override
	public Long getClientConsentTotalRows(OperationBean operationBean,
			HttpSession session) {
		return 0l;
	}

	
	
}