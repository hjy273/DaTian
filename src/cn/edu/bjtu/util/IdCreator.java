package cn.edu.bjtu.util;

import java.util.Calendar;
import java.util.Date;

/**
 * id生成类
 * @author RussWest0
 *
 */
public class IdCreator {

	/**
	 * 
	 * @return 返回需求方随机id
	 */
	public static String createClientId() {
		return "CL" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回商业客户的id
	 * @return
	 */
	public static String createBusinessClientId()
	{
		return "BU"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回承运方id
	 * @return
	 */
	public static String createCarrierId() {
		return "CA" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回干线id
	 * @return
	 */
	public static String createlineTransportId() {
		return "LI" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回货物id
	 * @return
	 */
	public static String createGoodsId() {
		return "GO" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回城市配送id
	 * @return
	 */
	public static String createCityLineId() {
		return "CI" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回车辆id（不是车牌）
	 * @return
	 */
	public static String createCarId() {
		return "CAR" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回仓库id
	 * @return
	 */
	public static String createRepositoryId() {
		return "RE" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回司机id
	 * @return
	 */
	public static String createDriverId() {
		return "DR" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回订单id-时间敏感
	 * @return
	 */
	public static String createOrderId() {
		return "OR"+(int)(Math.random() * 100000000);
	}
	
	/**
	 * 返回投诉id-时间敏感
	 * @return
	 */
	public static String createComplaintId() {
		return "CO"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回评价id-时间敏感
	 * @return
	 */
	public static String createAssessId() {
		return "AS"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回合同id
	 * @return
	 */
	public static String createContractId(){
		return "CO"+(int)(Math.random()*100000000);
	}
	
	public static String createOrderNum()
	{
		return "y"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回子账户id
	 * @return
	 */
	public static String createSubAccountId(){
		return "SA"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回常用地址id
	 * @return
	 */
	public static String createAddressId(){
		return "Add"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回车队信息的id
	 * @return
	 */
	public static String createCarteamId(){
		return "CT"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回关注id
	 * @return
	 */
	public static String createFocusId(){
		return "F"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回留言id
	 * @return
	 */
	public static String createMessageId(){
		return "M"+(int)(Math.random()*100000000);
	}
	
	/**
	 * 返回反馈表id
	 * @return
	 */
	public static String createResponseId(){
		return "RE"+(int )(Math.random()*100000000);
	}
	
	/**
	 * 返回结算表id
	 * @return
	 */
	public static String createSettlementId(){
		return "SE"+(int )(Math.random()*100000000);
	}
	
	/**
	 * 返回track表id
	 * @return
	 */
	public static String createTrackId(){
		return "T"+(int )(Math.random()*100000000);
	}

}
