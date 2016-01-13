/**
 * 
 */
package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.FullTruckLoadService;
import cn.edu.bjtu.util.PageUtil;

/**
 * @author solitudeycq
 * �������
 *
 */
@Controller
public class FullTruckController {
	@Autowired
    FullTruckLoadService fulltruckloadService;
    /**
     * ��Դ������������Ϣ
     * @return
     */
	@RequestMapping(value="/fulltruckload",params="flag=0")
	public String getallFullTruckLoad(){
		
		return "resource_list";
		
	}
	
	/**
	 * ��Դ������ɸѡ
	 * @return
	 */
	@RequestMapping(value="fulltruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String fulltrackloadAjax(TruckBean truckBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model){
		JSONArray fulltruckloadArray = fulltruckloadService.getSelectedFullTruckLoadNew(truckBean, page, session);
		return fulltruckloadArray.toString();	
	}

}
