package solo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class contains two basic method that will be used in our testing tool.
 * @author Weike Wu, Meng Cao
 * @version 1.1
 *
 */
public class DBTest {

/**
 * This method is used to create a temporary database.</p>
 * Users should input the information of the table name, column name, type, length and an example data.</br>
 * 
 * @param list The list that contains the table information.
 * @param stmt Statement used in database connection.
 */
	public void createData(ArrayList<String[]> list, Statement stmt) {

		try {						
			String tableName = gui.t_create_table_name.getText();

			String create = "create table " + tableName + "(";

			for (int i = 0; i < list.size(); i++) {

				create = create + list.get(i)[0] + " " + list.get(i)[1] + "("
						+ list.get(i)[2] + "),";

			}

			create = create + "primary key(" + gui.t_key.getText()
					+ "))";

			stmt.execute(create);

			for (int i = 0; i < Integer.parseInt(gui.t_create_rows.getText()); i++) {

				String insert = "insert into " + tableName + "(";

				for (int j = 0; j < list.size() - 1; j++) {

					insert = insert + list.get(j)[0] + ",";

				}

				insert = insert + list.get(list.size() - 1)[0] + ") values(";

				for (int j = 0; j < list.size() - 1; j++) {

					insert = insert + "'" + list.get(j)[3] + i + "',";

				}

				insert = insert + "'" + list.get(list.size() - 1)[3] + i + "')";
				
				long startMili = System.currentTimeMillis();
				stmt.execute(insert);
				long endMili = System.currentTimeMillis();
				
				System.out.println("The "+ i +" data inserted"
						+ " , use " + (endMili - startMili) + "ms");
				
				gui.ta_create_table.append("The "+ i +" data inserted"
						+ " , use " + (endMili - startMili) + "ms"+"\n");
			
			}
			
			
			
			ArrayList<String> temp=new ArrayList<String>();
			
			
			

			
			
			
			
			
			
			
			String create1 = "create table " + tableName + "1(";

			for (int i = 0; i < list.size(); i++) {

				create1 = create1 + list.get(i)[0] + " " + list.get(i)[1] + "("
						+ list.get(i)[2] + "),";

			}

			create1 = create1 + "primary key(" + gui.t_key.getText()
					+ "))";

			stmt.execute(create1);

			for (int i = 0; i < 1000; i++) {

				String insert = "insert into " + tableName + "1(";

				for (int j = 0; j < list.size() - 1; j++) {

					insert = insert + list.get(j)[0] + ",";

				}

				insert = insert + list.get(list.size() - 1)[0] + ") values(";

				for (int j = 0; j < list.size() - 1; j++) {

					insert = insert + "'" + list.get(j)[3] + i + "',";

				}

				insert = insert + "'" + list.get(list.size() - 1)[3] + i + "')";
				
				
				temp.add(insert);
								
				
			
			}
			long startMili = System.currentTimeMillis();
			for(int i=0;i<temp.size();i++){
				
				stmt.execute(temp.get(i));
				
			}
			long endMili = System.currentTimeMillis();
			
			String s="drop table "+tableName+"1";
			
			stmt.execute(s);
			
			double throughput = 1000000.0/((double)(endMili - startMili));
			
			System.out.println("The throughput is "+throughput);
			gui.ta_create_table.append("The throughput is "+throughput+"\n");
			
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
/**
 *  This method can be used to test the performance of the database operations.
 * @param loopCount How many times should we test.
 * @param sqls The sqls we want to test. Get them from user interface.
 * @param stmt Statement used in database connection.
 */
	public void testDB(int loopCount, ArrayList<String> sqls,
			Statement stmt) {

		
		
		try {

			

			ResultSet rs = null;

			for (int i = 0; i < loopCount; i++) {

				for (int j = 0; j < sqls.size(); j++) {

					long startMili = System.currentTimeMillis();
					rs = stmt.executeQuery(sqls.get(j));
					long endMili = System.currentTimeMillis();
					
					System.out.println("Loop " + i + " Query " + j
							+ " success, use " + (endMili - startMili) + "ms");
					gui.ta_create_table.append("Loop " + i + " Query " + j
							+ " success, use " + (endMili - startMili) + "ms"+"\n");

				}

			}

			

			long startMili = System.currentTimeMillis();

			for (int i = 0; i < 10000 / sqls.size(); i++) {

				for (int j = 0; j < sqls.size(); j++) {

					rs = stmt.executeQuery(sqls.get(j));

				}

			}

			long endMili = System.currentTimeMillis();

			double temp = ((double) (endMili - startMili)) / 10000.0;

			double throughPut = 1000.0 / temp;

			System.out.println("The throughput is " + throughPut);
			gui.ta_create_table.append("The throughput is " + throughPut+"\n");

			

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		

	}

}
