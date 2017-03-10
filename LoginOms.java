package LoginScript;

import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.StopWatch;
import Interface.extend.ExtendInterfacesClass;
import Login.LoginDataGet;


public class LoginOms{
	private static Logger logger=Logger.getLogger(LoginOms.class);
	
	public static String url="http://whwdev03.ciic.com:8018/verification/index?ReturnUrl=%2f";
	public String username=null;
	public String pwd=null;
	protected WebDriver browser=new InternetExplorerDriver();
	protected WebDriverWait wait=new WebDriverWait(browser,3000);
	
	Data da=new Data();
	String[] data=da.testOracle("��ݼ");
	//���jsִ��
	public void jsE(String js){
		((JavascriptExecutor) browser).executeScript(js);
	 }
	//�����ӡ
	public void print(String s){
		System.out.println("[+......]"+s);
	}
	

	//��¼�ű�
	public void getIn(){
		this.username=data[0];
		this.pwd=data[1];
		
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
	public static void main(String[] args){
		LoginOms loginer=new LoginOms();
		loginer.getIn();
		
		
		
	}
}
