/**
 * 
 */
package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author solitudeycq
 * �������
 *
 */
@Controller
public class FullTruckController {
	
	
    /**
     * ��Դ������������Ϣ
     * @return
     */
	@RequestMapping(value="/fulltruckload",params="flag=0")
	public String getallFullTruckLoad(){
		
		return "resource_list";
		
	}

}
