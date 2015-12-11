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

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.SubAccount;

import com.alibaba.fastjson.JSONObject;

@Controller
public class SubAccountController {
	
	ModelAndView mv=new ModelAndView();
	
	@Resource 
	SubAccountService subAccountService;
	@Autowired
	RegisterService registerService;
	
	/**
	 * ��ʾ�������˻���Ϣ
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("subaccountdetail")
	public String subAccountDetail(@RequestParam String id,
			HttpServletRequest request){
		request.setAttribute("id", id);
		return "mgmt_a_subaccount4";
	}
	
	/**
	 * �����û�ͣ������״̬
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("changestatus")
	public String changeStatus(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
//		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = subAccountService.changeStatus(id);
		
		return "redirect:getsubaccount";
	}
	
	/**
	 * ɾ�����˻� 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("deletesubaccount")
	public String deleteSubAccount(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		subAccountService.deleteSubAccount(id);
		return "redirect:getsubaccount";
	}
	
	@RequestMapping("addsubaccount")
	/**
	 * ��ȡ��Ӹ����˻��� -��ת�������û�����
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addSubAccount(
			HttpServletRequest request,HttpServletResponse response){
		String username=(String)request.getSession().getAttribute("username");
		mv.addObject("username", username);
		mv.setViewName("mgmt_a_subaccount2");
		return mv;
	}
	
	/**
	 * ���������˻�
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
	@RequestMapping("insertsubaccount")
	public String insertSubAccount(SubAccountBean subAccountBean,HttpSession session){
		
			subAccountService.addNewSubAccount(subAccountBean,session);
			return "redirect:getsubaccount";
	}
	
		/**
		 * ��ȡ�����˻���Ϣ
		 * @param id
		 * @return
		 */
		@RequestMapping(value="getSubAccountInfoAjax",produces="text/html;charset=UTF-8")
		@ResponseBody
	 	public String updateSubAccount(@RequestParam String id,
				HttpServletRequest request,HttpServletResponse response){
			SubAccount subAccount=subAccountService.getSubAccountDetail(id);
			String str=JSONObject.toJSONString(subAccount);
			return str;
	 }
		
	/**
	 * ���������˻���Ϣҳ��(���²���)
	 * @return
	 */
	@RequestMapping("getUpdateSubAccountPage")
	public String getSubAccountInfoPage(String id,HttpServletRequest request){
		request.setAttribute("id", id);
		return "mgmt_a_subaccount3";
	}
	
	/**
	 * ���¸����˻�
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
		@RequestMapping("doupdate")
		public String doUpdate(SubAccountBean subAccountBean,HttpSession session){
			//����subaccount��	//����userinfo��
			subAccountService.updateSubAccount(subAccountBean,session);
			
			return "redirect:getsubaccount";
		}
		
		/**
		 * 
		 * @Title: getSubAccountPage 
		 *  
		 * @param: @return 
		 * @return: String 
		 * @throws: �쳣 
		 * @author: chendonghao 
		 * @date: 2015��7��27�� ����3:59:57
		 */
		@RequestMapping("getsubaccount")
		public String getSubAccountPage(){
			return "mgmt_a_subaccount";
		}
		/**
		 * ��ȡ�����˻��б�
		 * @Title: getSubAccountList 
		 *  
		 * @param: @param session
		 * @param: @return 
		 * @return: String 
		 * @throws: �쳣 
		 * @author: chendonghao 
		 * @date: 2015��7��27�� ����4:02:21
		 */
		@ResponseBody
		@RequestMapping(value="getSubAccountAjax",produces="text/html;charset=UTF-8")
		public String getSubAccountList(HttpSession session,SubAccount subAccount,PageUtil pageUtil){
			return subAccountService.getSubAccountList(session,subAccount,pageUtil);
		}
		
		/**
		 * �����˻�-�ܼ�¼����
		 * @Title: getSubAccountTotalRows 
		 *  
		 * @param: @param session
		 * @param: @return 
		 * @return: Integer 
		 * @throws: �쳣 
		 * @author: chendonghao 
		 * @date: 2015��7��27�� ����4:03:41
		 */
		@ResponseBody
		@RequestMapping("getSubAccountTotalRowsAjax")
		public Integer getSubAccountTotalRows(HttpSession session,SubAccount subAccount){
			
			return subAccountService.getSubAccountTotalRows(session,subAccount);
		}
		
		/**
		 * ��鸽���˻��Ƿ��Ѿ�����
		 * @param username
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value="checkSubAccountUsername",produces="text/html;charset=UTF-8")
		public String checkSubAccountUsername(String username){
			
			boolean flag=subAccountService.checkSubAccountUsername(username);
			if(flag){
				return "�û��Ѵ��ڣ�";
			}else{
				return "�û������ڣ�����ʹ�ã�";
			}
		}
	 
}
