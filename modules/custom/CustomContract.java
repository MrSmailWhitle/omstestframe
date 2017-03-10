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
	//添加业务合同
	//start：开始进行业务合同的添加编辑；
	//1。是否二次开发
	//当前默认非二次开发；若是，label1.否：label2；
	public void com_SencondDev(){
		
		browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
		//browser.findElement(By.xpath("//*[@id='Form1']/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();
	}
	//2.合同签订方式：包含三类
	//a.新合同；b。补充协议；c.备忘录
	public void switch_ContractSign(){
		//选择合同签订方式
		Select selectContractLawType=new Select(browser.findElement(By.id("ContractLawType")));
		selectContractLawType.selectByVisibleText("新合同");
		this.print("选择签订方式成功");
		
	}
		//a-1.签订为新合同适用次方法
		//新合同-合同范围
	public void switch_ContractLimits(){
		Select ContractLimits=new Select(browser.findElement(By.id("ContractLimits")));
		ContractLimits.selectByVisibleText("中外籍");
		this.print("范围成功");
	}
		//a-1.选择新合同可以选择Fs1,FS2....;
	    //2.；非新合同则只读
	public void switch_ContractType(){
		Select ContractType=new Select(browser.findElement(By.id("ContractType")));
		ContractType.selectByVisibleText("FS1");
		this.print("类型成功");
	}
		//a-3.生成业务合同编号
		//新合同的时候可生成；非新合同合同类型只能选择；
		//String js="funciton(){$('#Add_ContractNo').click();}function();";
		//this.jsE(js);
	public void switch_Add_ContractNo_orNot(){
		browser.findElement(By.id("Add_ContractNo")).click();
		
		this.contractid=browser.findElement(By.id("txt_ContractNo")).getAttribute("value");
		this.print("生成编号成功，切为："+this.contractid);
	}
		
		//3.选择签约方
	public void com_ContractParty(){
		Select qy=new Select(browser.findElement(By.name("ContractParty")));
		qy.selectByValue("2");
		this.print("签约成功");
		
		//4.选择紧急程度
		Select hurrylevel=new Select(browser.findElement(By.id("ddl_notify_nevel")));
		hurrylevel.selectByVisibleText("紧急");
		this.print("紧急程度选择成功");
	}
	public void switch_selectVerContract(String ver){
		if(ver.equals("标准")){
			browser.findElement(By.id("ContractVerType1")).click();
		}else if(ver.equals("非标准")){
			browser.findElement(By.id("ContractVerType2")).click();
		}
		else{return;}
	}
	//4.签订合同开始结束时间
	public void com_ContractTime(){
		WebElement startTime=browser.findElement(By.id("startTime"));
		startTime.sendKeys("2017-01-01");
		WebElement endTime=browser.findElement(By.id("endTime"));
		endTime.sendKeys("2019-12-31");
	}
	//5.备注
	public void com_Reamark(){
		WebElement remark=browser.findElement(By.id("Remark"));
		remark.sendKeys("Test测试，outpou 啊！");
	}
	


}
