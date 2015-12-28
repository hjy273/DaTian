package cn.edu.bjtu.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.DriverLoginService;
import cn.edu.bjtu.vo.Driverinfo;


/*
 *add by solitudeycq at 2015-12-19 14:40
 *��׿�ͻ���˾����¼�ӿ�
 */
@Controller
public class DriverLoginController {
	
	@Autowired
	DriverLoginService driverloginService;
	
	@Autowired
	Driverinfo driverinfo;
	
	@RequestMapping(value="/driverlogin",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String driverlogin(@RequestParam(value="phone",required=false) String phone,@RequestParam(value="passwd",required=false) String passwd) throws JSONException{
		
		//Ŀǰʹ��˾���ֻ���ֱ�ӵ�¼����������.
		//String passwd = driver.getString("passwd");---˾����¼����---�ֻ���---Ŀǰ�ݲ�ʹ��
		String successJson = "{\"logBean\":\"success\"}";
		JSONObject success = new JSONObject(successJson);
		
		String failJson = "{\"logBean\":\"fail\"}";
		JSONObject fail = new JSONObject(failJson);
		if(!(phone.equals(passwd))){
			return fail.toString();
		}
		
		Driverinfo driverinfo = driverloginService.checkLogin(phone);
		if(driverinfo!=null){
			return success.toString();
		}else{
			return fail.toString();
		}
	}
}
