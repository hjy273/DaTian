package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.BusinessClientService;
import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

/**
 * ��˾�ͻ�businessclient��ؿ�����
 * @author RussWest0
 * @date   2015��5��28�� ����11:16:36
 */
@Controller
public class BusinessClientController {
	
	@Resource
	ClientService clientService;
	@Autowired
	BusinessClientService businessClientService;
	
	ModelAndView mv=new ModelAndView();
	
	
	/**
	 * ��ȡ��˾���пͻ�
	 * @param request
	 * @return
	 */
	@RequestMapping("/client")
	public String getCompanyClient(HttpServletRequest request) {
		return "mgmt_r_customer";
	}
	
	@RequestMapping("clientdetail")
	/**
	 * ��ȡ�ͻ���ϸ��Ϣ
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getClientInfo(@RequestParam String clientId,
			@RequestParam int flag) {
		Businessclient clientInfo = clientService
				.getBusinessclientInfo(clientId);
		mv.addObject("clientInfo", clientInfo);
		if (flag == 1) {
			mv.setViewName("mgmt_r_customer4");
		} else if (flag == 2) {
			mv.setViewName("mgmt_r_customer3");
		}
		return mv;
	}

	/**
	 * ���businessclient�¿ͻ�
	 * @return
	 */
	@RequestMapping(value = "insertClient", method = RequestMethod.POST)
	public String insertNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=businessClientService.insertNewClient(client,file,request);
		return "redirect:client";
	}

	@RequestMapping(value = "updateClient", method = RequestMethod.POST)
	public String updateNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=businessClientService.updateNewClient(client,file,request);
		return "redirect:client";
	}
	
	/**
	 * ɾ��businessclient
	 */
	@RequestMapping(value = "clientdelete", method = RequestMethod.GET)
	public String deleteClient(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		clientService.deleteBusinessClient(id);
		return "redirect:client";
	}
	
	/**
	 * ����businessclient��ص��ļ�
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "downloadclientrelated", method = RequestMethod.GET)
	public ModelAndView downloadClientRelated(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Businessclient clientInfo = clientService.getBusinessclientInfo(id);
		String file = clientInfo.getRelatedMaterial();
		DownloadFile.downloadFile(file,request,response);

		return mv;
	}
	
	/**
	 * ��ȡ�û��������ͻ�(����ҳ��)
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserBusinessClientAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserBusinessClientAjax(HttpSession session){
		
		JSONArray jsonArray=businessClientService.getUserBusinessClient(session);
		
		return jsonArray.toString();
		
		
	}
	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ
	 * @Title: getUserBusinessClient 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:26:54
	 */
	@ResponseBody
	@RequestMapping(value="getUserBusinessClientResourceAjax",produces = "text/html;charset=UTF-8")
	public String getUserBusinessClient(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=businessClientService.getUserBusinessClient(session,pageUtil);
		
		return jsonArray.toString();
		
	}
	
	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ�ܼ�¼��
	 * @Title: getUserBusinessClientTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:28:30
	 */
	@ResponseBody
	@RequestMapping(value="getUserBusinessClientTotalRowsAjax")
	public Integer getUserBusinessClientTotalRows(HttpSession session){
		return businessClientService.getUserBusinessClientTotalRows(session);
		
	}
}
