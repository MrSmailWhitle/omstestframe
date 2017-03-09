package LoginScript.modules.custom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import LoginScript.modules.ModulesHome;

public class CustomContract extends ModulesHome {
	private String contractid=null;
	public void switchWinAndSelectCustom(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("frm_Content")));
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='129271']/td[3]/a")));
		browser.findElement(By.xpath("//*[@id='129271']/td[3]/a")).click();
		System.out.println("[+......]ѡ��ͻ��ɹ�");
		
	}
	public void switch_CustomContractWindow(){
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frm_Content")));
		
		//�ص�������
		browser.switchTo().defaultContent();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/ul/li[3]")));
		browser.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/ul/li[3]")).click();
		System.out.println("[+......]�л��ͻ�������Ϣ");
		//browser.close();
	}
	public void add_CustomContract(){
		browser.switchTo().frame("frm_Content_01");
		//�ȴ��л���ҵ���ͬ����
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("body_content")));
		browser.findElement(By.className("btn_data_add")).click();
		//browser.switchTo().defaultContent();
		System.out.println("[+......]readey add �ͻ���ͬ");
		
	}
	//start����ʼ����ҵ���ͬ����ӱ༭��
	public void editCustomContractStart(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("div_dialog_close")));
		//browser.switchTo().frame("frm_Content_01");
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);
	}
	
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
	
	//FS1������У�飻
	public void testDataitem(){
		WebElement item=browser.findElement(By.xpath("//*[@id='div_LabourContractSet']/table/tbody/tr[1]/td[1]/b"));
		assert item.getText()=="FS1��ͬA�汾������";
		this.print("����FS1��ͬA�汾������༭���ݣ����Ե�һ��ͨ��");
		
	}
	//����������
	public void saveContract(){
		WebElement btmsave=browser.findElement(By.id("btn_Submit"));
		btmsave.click();
		
		
		this.print("�������������ʾ����");
	}	
		
	public void noWhole(){
		Alert massange=browser.switchTo().alert();
		assert massange.getText().contains("����д��������"):"��ʾ����,���޸ı�ע��ʾ��Ϣ";
		this.print("��ʾ��Ϣok��");
		massange.accept();
		this.print("�ر�alert�ɹ���");
		browser.close();
	}

}
