package LoginScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface LoginData {
	public static final String name="��ݼ";
	public static void testOracle(){
	}
}
class Data implements LoginData{
	//��д�ӿڻ�ȡ��¼����¼����ӿڷ���
	public  String[] testOracle(String name){
		Connection con=null;//����һ�����ݿ�����
		PreparedStatement pre=null;//����һ��Ԥ������󣬶�����Statement
		ResultSet result=null;//����һ���������
		String[] list=new String[2];
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[+......]bging to connet the oracle������������");
			String url="jdbc:oracle:"+"thin:@192.168.253.11:1521:Ora2813";
			//String url="jdbc:oracle:"+"thin:@127.0.1:1521:Ora2813";
			String user="oms_v3_dev";
			String password="oms_v3_dev";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("[+......]connet������������ ok");
			String sql="select * "
					+ "from tb_sys_staff tss where tss.user_name=? ";
			pre=con.prepareStatement(sql);
			pre.setString(1,name);
			result=pre.executeQuery();
			
			while(result.next()){
				assert result.getInt("status")==1:"�˹�����Ա�Ѿ���ְ���������¼��";
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
	

