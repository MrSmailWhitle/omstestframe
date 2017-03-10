package LoginScript.modules.custom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExceptedResults extends CustomContract {

	//FS1数据项校验；
	public void testDataitem(){
		WebElement item=browser.findElement(By.xpath("//*[@id='div_LabourContractSet']/table/tbody/tr[1]/td[1]/b"));
		assert item.getText()=="FS1合同A版本数据项";
		this.print("发现FS1合同A版本数据项编辑数据，测试第一步通过");
		
	}
	//保存数据项
		public void saveContract(){
			WebElement btmsave=browser.findElement(By.id("btn_Submit"));
			btmsave.click();
			
			
			this.print("保存后请依据提示操作");
		}
		
	public void testAlertFail(){
		Alert massange=browser.switchTo().alert();
		assert massange.getText().contains("请填写所有数据"):"提示有误,请修改备注提示信息";
		this.print("提示信息ok；");
		massange.accept();
		this.print("关闭alert成功；");
		browser.close();
	}

}
