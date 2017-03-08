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
	//打包js执行
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
		
		assert browser.findElement(By.id("fad")).getText()=="常见问题";
		System.out.println("[+......]登录成功");
		
		}
	//选择模块
	public void selectModel(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oms_model_03")));
		WebElement element=browser.findElement(By.className("oms_model_03"));
		element.click();
		System.out.println("[+......]选择模块ok");
		
	}
	public void switchWinAndSelectCustom(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("frm_Content")));
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='129271']/td[3]/a")));
		browser.findElement(By.xpath("//*[@id='129271']/td[3]/a")).click();
		System.out.println("[+......]选择客户成功");
		
	}
	public void switch_CustomContractWindow(){
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frm_Content")));
		
		//回到主窗口
		browser.switchTo().defaultContent();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/ul/li[3]")));
		browser.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/ul/li[3]")).click();
		System.out.println("[+......]切换客户基本信息");
		//browser.close();
	}
	public void add_CustomContract(){
		browser.switchTo().frame("frm_Content_01");
		//等待切换至业务合同界面
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("body_content")));
		browser.findElement(By.className("btn_data_add")).click();
		//browser.switchTo().defaultContent();
		System.out.println("[+......]readey add 客户合同");
		
	}
	public void editCustomContract(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("div_dialog_close")));
		//browser.switchTo().frame("frm_Content_01");
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);

		//是否二次开发
		//if(browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody/tr[1]/td[2]/input[2]")).isSelected()){
			//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//}
		browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		
		//选择合同签订方式
		Select selectContractLawType=new Select(browser.findElement(By.id("ContractLawType")));
		selectContractLawType.selectByVisibleText("新合同");
		this.print("选择签订方式成功");
		//选择合同适用范围
		Select ContractLimits=new Select(browser.findElement(By.id("ContractLimits")));
		ContractLimits.selectByVisibleText("中外籍");
		this.print("范围成功");
		
		//选择合同类型
		Select ContractType=new Select(browser.findElement(By.id("ContractType")));
		ContractType.selectByVisibleText("FS1");
		this.print("类型成功");
		//生成业务合同编号
		//String js="funciton(){$('#Add_ContractNo').click();}function();";
		//this.jsE(js);
		browser.findElement(By.id("Add_ContractNo")).click();
		
		this.contractid=browser.findElement(By.id("txt_ContractNo")).getAttribute("value");
		this.print("生成编号成功，切为："+this.contractid);
		
		
		//选择签约方
		Select qy=new Select(browser.findElement(By.name("ContractParty")));
		qy.selectByValue("2");
		this.print("签约成功");
		
		//选择紧急程度
		Select hurrylevel=new Select(browser.findElement(By.id("ddl_notify_nevel")));
		hurrylevel.selectByVisibleText("紧急");
		this.print("紧急程度选择成功");
	}
	public void selectVerContract(String ver){
		if(ver.equals("标准")){
			browser.findElement(By.id("ContractVerType1")).click();
		}else if(ver.equals("非标准")){
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
		remark.sendKeys("Test测试，outpou 啊！");
	}
	
	public void testDataitem(){
		WebElement item=browser.findElement(By.xpath("//*[@id='div_LabourContractSet']/table/tbody/tr[1]/td[1]/b"));
		assert item.getText()=="FS1合同A版本数据项";
		this.print("发现FS1合同A版本数据项编辑数据，测试第一步通过");
		
	}
	public void saveContract(){
		WebElement btmsave=browser.findElement(By.id("btn_Submit"));
		btmsave.click();
		
		
		this.print("保存成功，请确定");
		Alert massange=browser.switchTo().alert();
		assert massange.getText().contains("请填写所有数据"):"提示有误,请修改备注提示信息";
		this.print("提示信息ok；");
		massange.accept();
		this.print("关闭alert成功；");
		browser.close();
	}
	
	
	
	public static void main(String[] args){
		LoginDataGet getdate=new LoginDataGet();
		args=getdate.testOracle("李菁");
		LoginOms oms=new LoginOms();
		oms.getIn(args[0],args[1]);
		oms.selectModel();
		oms.switchWinAndSelectCustom();
		oms.switch_CustomContractWindow();
		oms.add_CustomContract();
		oms.editCustomContract();
		oms.selectVerContract("标准");
		oms.contractTime();
		oms.Reamark();
		oms.testDataitem();
		oms.saveContract();
	}
}
