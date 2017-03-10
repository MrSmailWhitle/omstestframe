package LoginScript.modules.custom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import LoginScript.modules.ModulesHome;

public class CustomContract extends SelectCustomListItem 
implements switch_ContractSign,
	switch_ContractLimits,
	switch_ContractType,
	switch_Add_ContractNo_orNot,
	switch_selectVerContract{
	private String contractid=null;
	//���ҵ���ͬ
	//start����ʼ����ҵ���ͬ����ӱ༭��
	//1���Ƿ���ο���
	//��ǰĬ�ϷǶ��ο��������ǣ�label1.��label2��
	public void com_SencondDev(){
		
		browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
	}
	//2.��ͬǩ����ʽ����������
	//a.�º�ͬ��b������Э�飻c.����¼
	public void switch_ContractSign(){
		//ѡ���ͬǩ����ʽ
		Select selectContractLawType=new Select(browser.findElement(By.id("ContractLawType")));
		selectContractLawType.selectByVisibleText("�º�ͬ");
		this.print("ѡ��ǩ����ʽ�ɹ�");
		
	}
		//a-1.ǩ��Ϊ�º�ͬ���ôη���
		//�º�ͬ-��ͬ��Χ
	public void switch_ContractLimits(){
		Select ContractLimits=new Select(browser.findElement(By.id("ContractLimits")));
		ContractLimits.selectByVisibleText("���⼮");
		this.print("��Χ�ɹ�");
	}
		//a-1.ѡ���º�ͬ����ѡ��Fs1,FS2....;
	    //2.�����º�ͬ��ֻ��
	public void switch_ContractType(){
		Select ContractType=new Select(browser.findElement(By.id("ContractType")));
		ContractType.selectByVisibleText("FS1");
		this.print("���ͳɹ�");
	}
		//a-3.����ҵ���ͬ���
		//�º�ͬ��ʱ������ɣ����º�ͬ��ͬ����ֻ��ѡ��
		//String js="funciton(){$('#Add_ContractNo').click();}function();";
		//this.jsE(js);
	public void switch_Add_ContractNo_orNot(){
		browser.findElement(By.id("Add_ContractNo")).click();
		
		this.contractid=browser.findElement(By.id("txt_ContractNo")).getAttribute("value");
		this.print("���ɱ�ųɹ�����Ϊ��"+this.contractid);
	}
		
		//3.ѡ��ǩԼ��
	public void com_ContractParty(){
		Select qy=new Select(browser.findElement(By.name("ContractParty")));
		qy.selectByValue("2");
		this.print("ǩԼ�ɹ�");
		
		//4.ѡ������̶�
		Select hurrylevel=new Select(browser.findElement(By.id("ddl_notify_nevel")));
		hurrylevel.selectByVisibleText("����");
		this.print("�����̶�ѡ��ɹ�");
	}
	public void switch_selectVerContract(String ver){
		if(ver.equals("��׼")){
			browser.findElement(By.id("ContractVerType1")).click();
		}else if(ver.equals("�Ǳ�׼")){
			browser.findElement(By.id("ContractVerType2")).click();
		}
		else{return;}
	}
	//4.ǩ����ͬ��ʼ����ʱ��
	public void com_ContractTime(){
		WebElement startTime=browser.findElement(By.id("startTime"));
		startTime.sendKeys("2017-01-01");
		WebElement endTime=browser.findElement(By.id("endTime"));
		endTime.sendKeys("2019-12-31");
	}
	//5.��ע
	public void com_Reamark(){
		WebElement remark=browser.findElement(By.id("Remark"));
		remark.sendKeys("Test���ԣ�outpou ����");
	}
	


}
