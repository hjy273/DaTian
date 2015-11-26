package cn.edu.bjtu.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bjtu.vo.SettlementCarrierView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelCreator {
	public void createSingleExcel(SettlementCarrierView settlement,OutputStream os) throws WriteException,IOException{
        //����������
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //�����µ�һҳ
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
        Label orderNum = new Label(0,0,"�������");
        sheet.addCell(orderNum);
        Label clientName = new Label(1,0,"�ͻ�����");
        sheet.addCell(clientName);
        Label companyName = new Label(2,0,"���˷�");
        sheet.addCell(companyName);
        Label contractId = new Label(3,0,"���˷���ͬ���");
        sheet.addCell(contractId);
        Label submitTime = new Label(4,0,"�������ʱ��");
        sheet.addCell(submitTime);
        Label expectedPrice = new Label(5,0,"�����˷�(Ԫ)");
        sheet.addCell(expectedPrice);
        Label actualPrice = new Label(6,0,"�����˷�(Ԫ)");
        sheet.addCell(actualPrice);
        
        Label orderNum_data = new Label(0,1,settlement.getOrderNum());
        sheet.addCell(orderNum_data);
        Label clientName_data = new Label(1,1,settlement.getClientName());
        sheet.addCell(clientName_data);
        Label companyName_data = new Label(2,1,settlement.getCompanyName());
        sheet.addCell(companyName_data);
        Label contractId_data = new Label(3,1,settlement.getContractId());
        sheet.addCell(contractId_data);
        Label submitTime_data = new Label(4,1,settlement.getSubmitTime().toString());
        sheet.addCell(submitTime_data);
        Label expectedPrice_data = new Label(5,1,settlement.getExpectedPrice().toString());
        sheet.addCell(expectedPrice_data);
        Label actualPrice_data = new Label(6,1,settlement.getActualPrice().toString());
        sheet.addCell(actualPrice_data);
        
        //�Ѵ���������д�뵽������У����ر������
        workbook.write();
        workbook.close();
        os.close();
    }
	
	public void createMultipleExcel(List<SettlementCarrierView> multipleStatement,OutputStream os) throws WriteException,IOException{
        //����������
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //�����µ�һҳ
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
        Label orderNum = new Label(0,0,"�������");
        sheet.addCell(orderNum);
        Label clientName = new Label(1,0,"�ͻ�����");
        sheet.addCell(clientName);
        Label companyName = new Label(2,0,"���˷�");
        sheet.addCell(companyName);
        Label contractId = new Label(3,0,"���˷���ͬ���");
        sheet.addCell(contractId);
        Label submitTime = new Label(4,0,"�������ʱ��");
        sheet.addCell(submitTime);
        Label expectedPrice = new Label(5,0,"�����˷�(Ԫ)");
        sheet.addCell(expectedPrice);
        Label actualPrice = new Label(6,0,"�����˷�(Ԫ)");
        sheet.addCell(actualPrice);
        
        for(int i=0;i<multipleStatement.size();i++)
        {
        	Label orderNum_data = new Label(0,i+1,multipleStatement.get(i).getOrderNum());
            sheet.addCell(orderNum_data);
            Label clientName_data = new Label(1,i+1,multipleStatement.get(i).getClientName());
            sheet.addCell(clientName_data);
            Label companyName_data = new Label(2,i+1,multipleStatement.get(i).getCompanyName());
            sheet.addCell(companyName_data);
            Label contractId_data = new Label(3,i+1,multipleStatement.get(i).getContractId());
            sheet.addCell(contractId_data);
            Label submitTime_data = new Label(4,i+1,multipleStatement.get(i).getSubmitTime().toString());
            sheet.addCell(submitTime_data);
            Label expectedPrice_data = new Label(5,i+1,multipleStatement.get(i).getExpectedPrice().toString());
            sheet.addCell(expectedPrice_data);
            Label actualPrice_data = new Label(6,i+1,multipleStatement.get(i).getActualPrice().toString());
            sheet.addCell(actualPrice_data);
        }
        //�Ѵ���������д�뵽������У����ر������
        workbook.write();
        workbook.close();
       // os.close();
    }
}
