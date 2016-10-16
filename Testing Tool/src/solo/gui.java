package solo;
/**
 *  @author Meng Cao, Weike Wu
 *  @version 1.3
 */
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class can generate out interface. All of our operation should be done within this interface.
 * @author alvin
 *
 */
public class gui extends JFrame{
	
	public static ArrayList<String> query_list=new ArrayList<String>();
	public static ArrayList<String[]> create_list=new ArrayList<String[]>();

	Container c=getContentPane();
Font my_font=new Font("Dialog",1,20);
	
	JLabel l_class_name=new JLabel("Class for Name:");
	JLabel l_URL=new JLabel("       URL:");
	JLabel l_user_name=new JLabel("    User Name:");
	JLabel l_password=new JLabel("    Password:");
	JLabel l_SQL_Query=new JLabel("  SQL Query:");
	JLabel l_loops=new JLabel("loops:");
	JLabel l_create_table=new JLabel("Create your own sample table:");
	JLabel l_create_name=new JLabel("Column Name:");
	JLabel l_create_type=new JLabel("Column Type:");
	JLabel l_create_lenth=new JLabel("Column Lenth:");
	JLabel l_create_example=new JLabel("Date Example:");	
	JLabel l_create_table_name=new JLabel("Name:");
	JLabel l_create_rows=new JLabel("Rows:");
	JLabel l_key=new JLabel("Primary Key:");

	
	static JTextArea ta_SQL_Querys=new JTextArea();	
	static JScrollPane sp_SQL_Querys=new JScrollPane(ta_SQL_Querys);
	
	static JTextArea ta_create_table=new JTextArea();
	static JScrollPane sp_create_table=new JScrollPane(ta_create_table);
	
	static JTextField t_class_name=new JTextField();
	static JTextField t_URL=new JTextField();
	static JTextField t_user_name=new JTextField();
	static JTextField t_password=new JTextField();
	static JTextField t_loops=new JTextField();
	static JTextField t_key=new JTextField();

	
	static JTextField t_create_name=new JTextField();
	static JTextField t_create_type=new JTextField();
	static JTextField t_create_lenth=new JTextField();
	static JTextField t_create_example=new JTextField();
	static JTextField t_create_table_name=new JTextField();
	static JTextField t_create_rows=new JTextField();

	
	JButton b_search=new JButton("Search");
JButton b_create=new JButton("Add");
JButton b_SQL_Query=new JButton("Add");
JButton b_execute=new JButton("Execute!");
JButton b_execute2=new JButton("Execute");

	
	public void buildGui(){
		setLayout(null);
		
		c.add(l_loops);
		l_loops.setBounds(590, 170, 70, 20);
	l_loops.setFont(my_font);
	c.add(t_loops);t_loops.setBounds(655, 172, 40, 20);
	
	c.add(b_execute);
	b_execute.setFont(my_font);
	b_execute.setBounds(590, 230, 120, 30);
		
		c.add(l_class_name);
		l_class_name.setBounds(30, 10, 170, 25);
		l_class_name.setFont(my_font);
		
		c.add(t_class_name);
		t_class_name.setBounds(190,12,220,20);
		
		c.add(l_URL);
		l_URL.setBounds(30, 40, 150, 25);
		l_URL.setFont(my_font);
		c.add(t_URL);
		t_URL.setBounds(190,42,220,20);
		
		c.add(l_user_name);
		l_user_name.setBounds(30, 70, 150, 25);
		l_user_name.setFont(my_font);
		c.add(t_user_name);
		t_user_name.setBounds(190,72,220,20);
		
		c.add(l_password);
		l_password.setBounds(30, 100, 150, 25);
		l_password.setFont(my_font);
		c.add(t_password);
		t_password.setBounds(190,102,220,20);
		
		
		
		
		c.add(l_SQL_Query);l_SQL_Query.setBounds(30, 130, 150, 25);
		l_SQL_Query.setFont(my_font);
		b_SQL_Query.setFont(my_font);
		c.add(b_SQL_Query);
		b_SQL_Query.setBounds(590, 195, 120, 30);
		
		c.add(sp_SQL_Querys);
		sp_SQL_Querys.setBounds(30, 170, 550, 100);
		
		c.add(l_create_table);l_create_table.setBounds(30, 300, 350, 25);
		l_create_table.setFont(my_font);
		c.add(l_create_table_name);
		l_create_table_name.setFont(my_font);
		l_create_table_name.setBounds(340, 300, 150, 25);
		c.add(t_create_table_name);t_create_table_name.setBounds(400, 303, 100, 25);
		c.add(l_create_rows);l_create_rows.setFont(my_font);l_create_rows.setBounds(550, 300, 100, 25);
		c.add(t_create_rows);t_create_rows.setBounds(610, 303, 100, 25);
		
		c.add(l_create_name);c.add(l_create_type);c.add(l_create_lenth);
		c.add(l_create_example);
		l_create_name.setBounds(30, 330, 200, 25);
		l_create_name.setFont(my_font);
		c.add(t_create_name);t_create_name.setBounds(170, 333, 100, 25);
		
		l_create_type.setBounds(30, 360, 200, 25);
		l_create_type.setFont(my_font);
		c.add(t_create_type);t_create_type.setBounds(170, 363, 100,25);
		
		l_create_lenth.setBounds(30, 390, 200, 25);
		l_create_lenth.setFont(my_font);
		c.add(t_create_lenth);t_create_lenth.setBounds(170, 393, 100, 25);
		
		l_create_example.setBounds(30, 420, 200, 25);
		l_create_example.setFont(my_font);
		c.add(t_create_example);t_create_example.setBounds(170, 423, 100, 25);
		
		
		c.add(b_create);b_create.setFont(my_font);b_create.setBounds(300, 370, 80, 40);
		c.add(sp_create_table);sp_create_table.setBounds(30, 470, 720, 400);
		c.add(b_execute2);b_execute2.setFont(my_font);b_execute2.setBounds(400, 370, 120, 40);
		c.add(l_key);  l_key.setFont(my_font);l_key.setBounds(400, 420, 150, 25);
		c.add(t_key);t_key.setBounds(523, 423, 100, 25);
		
		
		setTitle("Testing Tool   wirtten by Meng Cao, Weike Wu");
		setBounds(50, 10, 800, 1000);
		setVisible(true);
		setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
		
		
		b_execute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					Entry ee=new Entry();
					ee.runTest();
					query_list=new ArrayList<String>();
					
					
					
				
				
			}
		});
		
		b_execute2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Entry ee= new Entry();
				ee.runCreate();
				
				
				
				create_list=new ArrayList<String[]>();
				
			}
			
			
			
			
			
		});
		b_create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] data=new String[4];
				data[0]=t_create_name.getText();
				data[1]=t_create_type.getText();
				data[2]=t_create_lenth.getText();
				data[3]=t_create_example.getText();
				create_list.add(data);
				
				ta_create_table.append("Your attribute has been saved!"+"\n");
				t_create_name.setText("");
				t_create_type.setText("");
				t_create_lenth.setText("");
				t_create_example.setText("");
			}
		});
		
		
		b_SQL_Query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta_create_table.append("Your Query: "+ta_SQL_Querys.getText()+" has been saved!"+"\n");
			query_list.add(ta_SQL_Querys.getText());
			ta_SQL_Querys.setText("");

			}
		});
		
	}
	
	
	public static boolean ifNull(){
		
		boolean empty=t_class_name.getText().isEmpty()||t_loops.getText().isEmpty()||t_password.getText().isEmpty()||t_URL.getText().isEmpty()||t_user_name.getText().isEmpty()||ta_SQL_Querys.getText().isEmpty();
		
		return !empty;
	}
	
}
