package LoginScript;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Interface.extend.ExtendInterfacesClass;
import Login.LoginDataGet;

public class LoginOms{
	public static String url="http://whwdev03.ciic.com:8018/verification/index?ReturnUrl=%2f";
	public String username=null;
	public String pwd=null;
	WebDriver browser=new InternetExplorerDriver();
	WebDriverWait wait=new WebDriverWait(browser,3000);
	private String contractid=null;
	//���jsִ��
	public void jsE(String js){
		((JavascriptExecutor) browser).executeScript(js);
	 }
	public void print(String s){
		System.out.println("[+......]"+s);
	}
	
	
	public void getIn(String username,String pwd){
		this.username=username;
		this.pwd=pwd;
		
		browser.manage().window().maximize();
		browser.get(url);
		browser.findElement(By.id("txt_login_name")).clear();
		browser.findElement(By.id("txt_login_name")).sendKeys(username);
		browser.findElement(By.id("txt_Pwd_01")).sendKeys(pwd);	
		browser.findElement(By.className("div_login_button")).click();
		browser.getCurrentUrl();
		
		assert browser.findElement(By.id("fad")).getText()=="��������";
		System.out.println("[+......]��¼�ɹ�");
		
		}
	//ѡ��ģ��
	public void selectModel(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oms_model_03")));
		WebElement element=browser.findElement(By.className("oms_model_03"));
		element.click();
		System.out.println("[+......]ѡ��ģ��ok");
		
	}
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
	public void editCustomContract(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("div_dialog_close")));
		//browser.switchTo().frame("frm_Content_01");
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);

		//�Ƿ���ο���
		//if(browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody/tr[1]/td[2]/input[2]")).isSelected()){
			//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//}
		browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		
		//ѡ���ͬǩ����ʽ
		Select selectContractLawType=new Select(browser.findElement(By.id("ContractLawType")));
		selectContractLawType.selectByVisibleText("�º�ͬ");
		this.print("ѡ��ǩ����ʽ�ɹ�");
		//ѡ���ͬ���÷�Χ
		Select ContractLimits=new Select(browser.findElement(By.id("ContractLimits")));
		ContractLimits.selectByVisibleText("���⼮");
		this.print("��Χ�ɹ�");
		
		//ѡ���ͬ����
		Select ContractType=new Select(browser.findElement(By.id("ContractType")));
		ContractType.selectByVisibleText("FS1");
		this.print("���ͳɹ�");
		//����ҵ���ͬ���
		//String js="funciton(){$('#Add_ContractNo').click();}function();";
		//this.jsE(js);
		browser.findElement(By.id("Add_ContractNo")).click();
		
		this.contractid=browser.findElement(By.id("txt_ContractNo")).getAttribute("value");
		this.print("���ɱ�ųɹ�����Ϊ��"+this.contractid);
		
		
		//ѡ��ǩԼ��
		Select qy=new Select(browser.findElement(By.name("ContractParty")));
		qy.selectByValue("2");
		this.print("ǩԼ�ɹ�");
		
		//ѡ������̶�
		Select hurrylevel=new Select(browser.findElement(By.id("ddl_notify_nevel")));
		hurrylevel.selectByVisibleText("����");
		this.print("�����̶�ѡ��ɹ�");
	}
	public void selectVerContract(String ver){
		if(ver.equals("��׼")){
			browser.findElement(By.id("ContractVerType1")).click();
		}else if(ver.equals("�Ǳ�׼")){
			browser.findElement(By.id("ContractVerType2")).click();
		}
		else{return;}
	}
	public void contractTime(){
		WebElement startTime=browser.findElement(By.id("startTime"));
		startTime.sendKeys("2017-01-01");
		WebElement endTime=browser.findElement(By.id("endTime"));
		endTime.sendKeys("2019-12-31");
	}
	public void Reamark(){
		WebElement remark=browser.findElement(By.id("Remark"));
		remark.sendKeys("Test���ԣ�outpou ����");
	}
	
	public void testDataitem(){
		WebElement item=browser.findElement(By.xpath("//*[@id='div_LabourContractSet']/table/tbody/tr[1]/td[1]/b"));
		assert item.getText()=="FS1��ͬA�汾������";
		this.print("����FS1��ͬA�汾������༭���ݣ����Ե�һ��ͨ��");
		
	}
	public void saveContract(){
		WebElement btmsave=browser.findElement(By.id("btn_Submit"));
		btmsave.click();
		
		
		this.print("����ɹ�����ȷ��");
		Alert massange=browser.switchTo().alert();
		assert massange.getText().contains("����д��������"):"��ʾ����,���޸ı�ע��ʾ��Ϣ";
		this.print("��ʾ��Ϣok��");
		massange.accept();
		this.print("�ر�alert�ɹ���");
		browser.close();
	}
	
	
	
	public static void main(String[] args){
		LoginDataGet getdate=new LoginDataGet();
		args=getdate.testOracle("��ݼ");
		LoginOms oms=new LoginOms();
		oms.getIn(args[0],args[1]);
		oms.selectModel();
		oms.switchWinAndSelectCustom();
		oms.switch_CustomContractWindow();
		oms.add_CustomContract();
		oms.editCustomContract();
		oms.selectVerContract("��׼");
		oms.contractTime();
		oms.Reamark();
		oms.testDataitem();
		oms.saveContract();
	}
}
