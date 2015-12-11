package cn.edu.bjtu.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.common.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SearchService;
import cn.edu.bjtu.util.PageUtil;

import com.alibaba.fastjson.JSONArray;

/**
 * ����������
 * 
 * @author RussWest0
 *
 */
@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	private static final Logger logger=Logger.getLogger(SearchController.class);
	ModelAndView mv = new ModelAndView();
	
	/**
	 * ��������
	 * @param search_content
	 * @param resource_kind
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="searchResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSearchResult(String search_content, String resource_kind,
			PageUtil pageUtil, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		String request_url=request.getHeader("referer");
		String url="";
		if(!checkURL(request_url)){
			try{
				if("��·".equals(resource_kind)){
					/*RequestDispatcher dispatcher= request.getRequestDispatcher("linetransport?flag=0");
					 dispatcher.forward(request, response);*/
					response.sendRedirect("linetransport?flag=0");
					url="linetransport?flag=0";
				}else if("����".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("cityline?flag=0");
					dispatcher.forward(request, response);
				}else if("����".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("car?flag=0");
					dispatcher.forward(request, response);
				}else if("�ֿ�".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("warehouse?flag=0");
					dispatcher.forward(request, response);
				}else if("��˾".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("company");
					dispatcher.forward(request, response);
				}else{//����
					RequestDispatcher dispatcher= request.getRequestDispatcher("goodsform?flag=0");
					dispatcher.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return url;
			
		}else{//����Դlist����������

		JSONArray jsonArray=new JSONArray();
		if(resource_kind.equals("��·")){
			jsonArray=searchService.getLineResourceByCityName(search_content, pageUtil, session);
		}else if(resource_kind.equals("����")){
			jsonArray=searchService.getCitylineResourceByName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("����")){
			jsonArray=searchService.getCarResourceByCarNum(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("�ֿ�")){
			jsonArray=searchService.getWarehouseResourceByName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("��˾")){
			jsonArray=searchService.getCompanyResourceByCompanyName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("����")){
				jsonArray=searchService.getGoodsResourceByName(search_content, pageUtil, session);
		}
		
		return jsonArray.toString();
		}
		
	}
	
	/**
	 * ��������������ǲ�������Դlistҳ�淢�����ģ�����ǣ�ҳ�治����ת���������
	 * ҳ����Ҫ��ת��listҳ���Թ���ʾ��Դ
	 * @Title: checkURL 
	 *  
	 * @param: @param url
	 * @param: @return 
	 * @return: boolean 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��6��29�� ����4:18:38
	 */
	private boolean checkURL(String url){
		
		if (url.contains("linetransport?flag=0")
				|| url.contains("cityline?flag=0")
				|| url.contains("car?flag=0")
				|| url.contains("warehouse?flag=0") || url.contains("company")
				|| url.contains("goodsform?flag=0")) {
			
			return true;
		}
		else
			return false;
		
	}
	/**
	 * ���������ܼ�¼��
	 * @param resource_kind
	 * @param search_content
	 * @return
	 */
	@RequestMapping("searchResourceTotalRowsAjax")
	@ResponseBody
	public Integer searchLinetransportTotalRows(String resource_kind,String search_content){
		
		return searchService.searchLinetransportTotalRows(resource_kind,search_content);
	}

	
}
