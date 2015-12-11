package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.BusinessClientDao;
import cn.edu.bjtu.service.BusinessClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Businessclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service
@Transactional
public class BusinessClientServiceImpl implements BusinessClientService{

	@Autowired
	BusinessClientDao businessClientDao;
	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ
	 */
	@Override
	public JSONArray getUserBusinessClient(HttpSession session,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Businessclient t where t.carrierId=:userId order by t.relDate desc ";
		params.put("userId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Businessclient> clientList=businessClientDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		if(clientList!=null && clientList.size()>0){
			for(int i=0;i<clientList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(clientList.get(i));
				jsonArray.add(jsonObject);
			}
			
		}
		
		return jsonArray;
	}
	
	
	/**
	 * ��ȡ�û��ͻ�
	 */
	@Override
	public JSONArray getUserBusinessClient(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Businessclient t where t.carrierId=:userId";
		params.put("userId", userId);
		List<Businessclient> clientList=businessClientDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		if(clientList!=null && clientList.size()>0){
			for(int i=0;i<clientList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(clientList.get(i));
				jsonArray.add(jsonObject);
			}
			
		}
		
		return jsonArray;
	}



	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ-�ܼ�¼��
	 */
	@Override
	public Integer getUserBusinessClientTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Businessclient t where t.carrierId=:userId";
		params.put("userId", userId);
		Long count=businessClientDao.count(hql, params);
		return count.intValue();
	}

	/**
	 * �����ͻ���Ϣ
	 */
	@Override
	public boolean insertNewClient(Businessclient client,MultipartFile file,HttpServletRequest request){
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, userId, "businessClient");
		client.setId(IdCreator.createBusinessClientId());
		client.setCarrierId(userId);
		client.setRelDate(new Date());
		//�����ļ�λ�� 
		client.setRelatedMaterial(fileLocation);
		businessClientDao.save(client);// ����ʵ��
		return true;
	}
	
	@Override
	public boolean updateNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "businessClient");

		Businessclient clientInstance = businessClientDao.get(Businessclient.class,client.getId());
		
		clientInstance.setAccount(client.getAccount());
		clientInstance.setClientName(client.getClientName());
		clientInstance.setClientBusiness(client.getClientBusiness());
		clientInstance.setContact(client.getContact());
		clientInstance.setPhone(client.getPhone());
		clientInstance.setRemarks(client.getRemarks());
		
		//�����ļ�λ�� 
		clientInstance.setRelatedMaterial(fileLocation);

		//����
		businessClientDao.update(clientInstance);
		return true;
	}
}
