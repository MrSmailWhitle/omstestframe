package LoginScript.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LoginScript.LoginOms;

public class ModulesHome extends LoginOms{
	//ѡ��ģ��
		public void selectModel(){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oms_model_03")));
			WebElement element=browser.findElement(By.className("oms_model_03"));
			element.click();
			System.out.println("[+......]ѡ��ģ��ok");
                     }
		public static void main(String[] args){
			ModulesHome ms=new ModulesHome();
			ms.getIn();
			ms.selectModel();
		}
}