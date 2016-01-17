package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
/**
 * �˿�������Ҫ���ڼ򵥵�ҳ����ת��û����������
 * @author RussWest0
 *
 */
public class CommonController {
	
	private Logger logger=Logger.getLogger(CommonController.class);
	@Autowired
	DriverService driverService;
	@Autowired
	CompanyService companyService;
	@Autowired
	LinetransportService linetransportService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/myinfo")
	public ModelAndView getMyInfo(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		// add by RussWest0 at 2015��5��30��,����7:09:34 
		if(userId==null){
			mv.setViewName("login");
		}else{
			mv.setViewName("mgmt");
		}
		return mv;
	}

	@RequestMapping("/insert")
	/**
	 * �ҵ���Ϣ-�ҵ���Դ-���е���������
	 * @param flag
	 * @return
	 */
	public ModelAndView insert(@RequestParam int flag,HttpServletRequest request,HttpServletResponse response) {
		
		if (flag == 1)
			mv.setViewName("mgmt_r_line2");// ����
		else if (flag == 2)
			mv.setViewName("mgmt_r_city2");// �����
		else if (flag == 3){
			String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
			List driverList = driverService.getAllDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_car2");// ����
		}
		else if (flag == 4)
			mv.setViewName("mgmt_r_warehouse2");// �ֿ�
		else if (flag == 5)
			mv.setViewName("mgmt_r_driver2");// ˾��
		else if (flag == 6)
			mv.setViewName("mgmt_r_customer2");//�ͻ� 
		else if(flag==7)
		{
			String id=IdCreator.createContractId();
			mv.addObject("id", id);
			mv.setViewName("mgmt_r_contact_s2");//��ͬ
		}
		else if (flag == 8)
			mv.setViewName("mgmt_d_complain2");//Ͷ�� 
		else if (flag == 9)
			mv.setViewName("mgmt_r_cargo2");//���� 
		else if (flag == 10)
			mv.setViewName("mgmt_r_car_fleet2");//����
		else if(flag == 11)
			mv.setViewName("mgmt_r_airline2");//���ڿ���
		return mv;
	}
	
	@RequestMapping("loginForm")
	public String getLoginForm()
	{
		return "login";
	}
	@RequestMapping("registerForm")
	public String getRegisterForm()
	{
		return "register";
	}
	
	@RequestMapping("city")
	public String getCity()
	{
		return "city";
	}
	
	@RequestMapping("getSetHeadIconPage")
	public ModelAndView getSetHeadIconPage()
	{
		mv.setViewName("mgmt_a_info5");
		return mv;
	}
	
	/**
	 * �ص���ҳ
	 * @return
	 */
	@RequestMapping(value="homepage",method=RequestMethod.GET)
	public String gotoHomePage()
	{
		return "index";
	}
	/**
	 * ��ת����Դҳ�� 
	 * @param session
	 * @return
	 */
	@RequestMapping("turnToResourcePage")
	public String turnToResourcePage(HttpSession session){
		Integer userId=(Integer)session.getAttribute(Constant.USER_KIND);
		
		if(userId==2){
			return "mgmt_r_customer";
		}else if(userId==3){
			return "mgmt_r_line";
		}
		
		return "index";
	}
	/**
	 * ���淽��������ʹ��
	 * @param msg
	 * @return
	 */
	/*@RequestMapping("/views/testAjax")
	@ResponseBody
	public String testAjax(String msg){
		logger.info(msg+"--");
		
		List<Linetransport> lineList=linetransportService.getAllLinetransport(3, 1);
		
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<lineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lineList.get(i));
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}*/
	
	@RequestMapping("intro")
	public String introPage(){
		return "intro";
	}
}
