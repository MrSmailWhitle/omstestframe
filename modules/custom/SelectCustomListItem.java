package LoginScript.modules.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LoginScript.modules.ModulesHome;

public class SelectCustomListItem extends ModulesHome {
	public void switchWinAndSelectCustom(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("frm_Content")));
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='129271']/td[3]/a")));
		browser.findElement(By.xpath("//*[@id='129271']/td[3]/a")).click();
		System.out.println("[+......]ѡ��ͻ��ɹ�");
		
	}
	//ѡ��ͻ�������Ϣ-�ҵ��ͻ���ͬҳ��
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
	public void editCustomContractStart(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("div_dialog_close")));
		//browser.switchTo().frame("frm_Content_01");
		WebElement iframe=browser.findElement(By.tagName("iframe"));
		//browser.switchTo();
		browser.switchTo().frame(iframe);
	}
	
}
