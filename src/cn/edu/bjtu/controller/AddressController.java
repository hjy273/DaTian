package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.AddressService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;


@Controller
public class AddressController {
	
	ModelAndView mv=new ModelAndView();
	
	@Autowired
	AddressService addressService;
	@Resource
	Address address;
	/**
	 * ��ת�����÷�����ַ
	 * @return
	 */
	@RequestMapping("getaddress")
	public String getAddress(){
		return "mgmt_a_address";
	}
	
	/**
	 * ��ת�������ջ���ַ
	 * @return
	 */
	@RequestMapping("getRecieveAddress")
	public String getRecieveAddress(){
		return "mgmt_a_address1";
	}
	
	/**
	 * ɾ�����õ�ַ 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("deleteaddress")
	public String deleteAddress(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		addressService.deleteAddress(id);

		return "redirect:getaddress";
	}
	
	/**
	 * ��ת����������
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("addaddress")
	public String addAddress(
			HttpServletRequest request,HttpServletResponse response){
		
		return "mgmt_a_address2";
	}
	
	/**
	 * �������õ�ַ
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("insertaddress")
	public String insertAddress(HttpSession session,Address address){
		
		addressService.insertAddress(session,address);
		return "redirect:getaddress";
	}
	
		/**
		 * ��ת�����½���
		 * @param id
		 * @return
		 */
	@RequestMapping("updateaddress")
	public ModelAndView updateAddress(@RequestParam String id,
			HttpServletRequest request, HttpServletResponse response){
			
			Address address = addressService.getAddressDetail(id);
			mv.addObject("address", address);
			mv.setViewName("mgmt_a_address3");
			return mv;
	 }
	
		/**
		 * ���³��õ�ַ
		 * @param session
		 * @param address
		 * @return
		 */
		@RequestMapping("doupdateaddress")
		public String updateAddress(HttpSession session,Address address){
				
			addressService.updateAddress(session,address);

			return "redirect:getaddress";
		}
	 
	 /**
	  * �¶���ʱ��ȡ�û����õ�ַ�б�
	  * @param session
	  * @param address
	  */
	 
	 @RequestMapping(value="getUserAddressAjax",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String getUserFrequentAddress(HttpSession session,Integer kind){
		 
		 JSONArray jsonArray=addressService.getUserAddress(session,kind);
		 return jsonArray.toString();
		 
	 }
	 
	/**
	 * ��ȡ���÷�����ַ
	 * 
	 * @Title: getSendAddress
	 * 
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return
	 * @return: String
	 * @throws: �쳣
	 * @author: chendonghao
	 * @date: 2015��7��29�� ����11:24:19
	 */
	@RequestMapping(value = "getAddressAjax", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSendAddress(HttpSession session, PageUtil pageUtil,
			Address address) {
		return addressService.getAddress(session, pageUtil, address);
	}

	/**
	 * ���÷�����ַ-�ܼ�¼��
	 * 
	 * @Title: getSendAddressTotalRows
	 * 
	 * @param: @param session
	 * @param: @return
	 * @return: Integer
	 * @throws: �쳣
	 * @author: chendonghao
	 * @date: 2015��7��29�� ����11:30:34
	 */
	@RequestMapping("getAddressTotalRowsAjax")
	@ResponseBody
	public Integer getSendAddressTotalRows(HttpSession session, Address address) {
		return addressService.getAddressTotalRows(session, address);
	}

}
