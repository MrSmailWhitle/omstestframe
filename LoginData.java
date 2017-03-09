package LoginScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface LoginData {
	public static final String name="李菁";
	public static void testOracle(){
	}
}
class Data implements LoginData{
	//重写接口获取登录名登录密码接口方法
	public  String[] testOracle(String name){
		Connection con=null;//创建一个数据库连接
		PreparedStatement pre=null;//创建一个预编译对象，而不是Statement
		ResultSet result=null;//创建一个结果集合
		String[] list=new String[2];
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[+......]bging to connet the oracle。。。。。。");
			String url="jdbc:oracle:"+"thin:@192.168.253.11:1521:Ora2813";
			//String url="jdbc:oracle:"+"thin:@127.0.1:1521:Ora2813";
			String user="oms_v3_dev";
			String password="oms_v3_dev";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("[+......]connet。。。。。。 ok");
			String sql="select * "
					+ "from tb_sys_staff tss where tss.user_name=? ";
			pre=con.prepareStatement(sql);
			pre.setString(1,name);
			result=pre.executeQuery();
			
			while(result.next()){
				assert result.getInt("status")==1:"此工作人员已经离职，请更换登录人";
			/*System.out.println("uname:"
					+result.getString("login_name")
					+"\npassword:"+result.getString("password")
					+"\nstatus:"+result.getInt("status"));*/
				list[0]=result.getString("login_name");
				list[1]=result.getString("password");
				//System.out.println(list);
			}
			return list;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
			if (result!=null)
			result.close();
			if(pre!=null)
				pre.close();
			if(con!=null)
				con.close();
			System.out.println("[+......]Have closed the dbcon.");
			}
			catch(
			Exception e){e.printStackTrace();
			}
		}
		return list;	
	}
}
	

