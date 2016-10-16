package solo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * This class contains two methods that will be called by the button listener in gui.
 * @author Weike Wu, Meng Cao
 *
 */
public class Entry {
	
	gui g=new gui();
	Connection conn = null;
	Statement stmt = null;
	String url = g.t_URL.getText();
	String username = g.t_user_name.getText();
	String password = g.t_password.getText();
	String className= g.t_class_name.getText();
	DBTest test = new DBTest();
	
	
	public void runCreate() {

		ArrayList<String[]> list = g.create_list;

		try {

			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			test.createData(list, stmt);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				stmt.close();
				conn.close();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}
	}

	public void runTest() {

		

		try {
			
			
			
			int loopCount = Integer.parseInt(g.t_loops.getText());
			
			
			
			ArrayList<String> sqls = g.query_list;
			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			test.testDB(loopCount, sqls, stmt);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				stmt.close();
				conn.close();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		

	}

}
