package LoginScript.modules.custom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExceptedResults extends CustomContract {

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
		
	public void testAlertFail(){
		Alert massange=browser.switchTo().alert();
		assert massange.getText().contains("����д��������"):"��ʾ����,���޸ı�ע��ʾ��Ϣ";
		this.print("��ʾ��Ϣok��");
		massange.accept();
		this.print("�ر�alert�ɹ���");
		browser.close();
	}

}
