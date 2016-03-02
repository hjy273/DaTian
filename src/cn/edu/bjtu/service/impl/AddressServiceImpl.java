package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.service.AddressService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Transactional
@Service
/**
 * ���˻������ʵ�� 
 * 
 *
 */
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressDao addressDao;
	
	/**
	 * ��ȡ��ַ�б�
	 */
	@Override
	public List getAddress(String userId) {
		
		return addressDao.find("from Address where clientId='"+userId+"'");
	}
	
	
	@Override
	public Address getAddressDetail(String id){
		
		return addressDao.get(Address.class, id);
	}
	
	
	@Override
	public boolean deleteAddress(String id){
		Address address=addressDao.get(Address.class, id);
		addressDao.delete(address);
		
		return true;
	}
	/**
	 * �������õ�ַ
	 */
	@Override
	public boolean insertAddress(HttpSession session,Address address){
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		address.setId(IdCreator.createAddressId());
		address.setRelDate(new Date());
		address.setClientId(userId);
		 addressDao.save(address);
		 return true;
	}
	
	@Override
	public boolean updateAddress(HttpSession session,Address address){
	
		Address addr= addressDao.get(Address.class, address.getId());// ����id����
		addr.setName(address.getName());
		addr.setPhone(address.getPhone());
		addr.setAddress(address.getAddress());
		addressDao.update(addr);
		return true;
	}
	


	/**
	 * �¶���ʱ��ȡ���ڵķ�����ַ�б�
	 */
	@Override
	public JSONArray getUserAddress(HttpSession session,Integer kind) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId and t.kind=:kind";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", kind);
		List<Address> addressList=addressDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		for(Address address: addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(address);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	/**
	 * ��ȡ������ַ
	 */
	@Override
	public String getAddress(HttpSession session, PageUtil pageUtil,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId and t.kind=:kind order by t.relDate desc ";//1Ϊ������ַ,2Ϊ�ջ���ַ
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Address> addressList=addressDao.find(hql, params, page, display);
		
		JSONArray jsonArray=new JSONArray();
		for(Address addr:addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(addr);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}

	/**
	 * ���÷�����ַ-�ܼ�¼��
	 */
	@Override
	public Integer getAddressTotalRows(HttpSession session,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count (*) from Address t where t.clientId=:clientId and t.kind=:kind ";//1Ϊ������ַ,2Ϊ�ջ���ַ
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		Long count =addressDao.count(hql, params);
		
		return count.intValue();
	}
	
}
