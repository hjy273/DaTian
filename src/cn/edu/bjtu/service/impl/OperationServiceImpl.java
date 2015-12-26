package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;

public class OperationServiceImpl implements OperationService{
	
	@Autowired
	OrderDao orderDao;	

	/**
	 * �������-��Ӫָ���б�
	 */
	@Override
	public List getTransportAccuracyList(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select date(t.submitTime) from Orderform t "+whereHql(operationBean,session,params);
		hql+=" group by date(t.submitTime) order by t.submitTime desc";
		
		List<Orderform> list=orderDao.find(hql, params);
		List<OperationBean> opList=new ArrayList<OperationBean>();
		//Ŀǰϵͳ��û�й���׼ȷ�ʺ�׼ȷ��������� FIXME
		for(Orderform order:list){
			
		}
		
		return opList;
	}
	
	/**
	 * �������-��Ӫָ���б��ܼ�¼��
	 */
	@Override
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		return 0L;//FIXME
		
	}
	
	private String whereHql(OperationBean operationBean,
			HttpSession session, Map<String,Object> params){
		String whereHql=" where t.carrierId=:carrierId ";
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

	
	
}
