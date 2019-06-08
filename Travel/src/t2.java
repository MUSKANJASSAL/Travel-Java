import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class t2 extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet  rs;
	JLabel l1=new JLabel("LOGIN");
	JLabel l2=new JLabel("Username");
	JLabel l3=new JLabel("Password");
	JTextField t1=new JTextField();
	JPasswordField p1=new JPasswordField();
	JButton b1=new JButton("Login");
	public t2()
	{
		add(l1);add(l2);add(l3);add(t1);add(p1);add(b1);
		b1.addActionListener(this);
		this.setVisible(true);
		this.setSize(600,600);
		this.setLayout(null);
		l1.setBounds(500,100,300,40);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Copper Black",Font.BOLD,40));
		l2.setFont(new Font("Arial",Font.BOLD,20));
		l2.setBounds(250,200,100,40);
		t1.setBounds(400,200,100,40);
		l3.setFont(new Font("Arial",Font.BOLD,20));
		l3.setBounds(250,250,100,40);
		p1.setBounds(400,250,100,40);
		b1.setBounds(550,350,100,30);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/travel","root","riccs");
			st=con.createStatement();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	public static void main(String[] args) 
	{
		new t2();
	}

	public void actionPerformed(ActionEvent ar) 
	{
		if(ar.getSource().equals(b1))
		{
			try
			{
				rs=st.executeQuery("select * from admin where username='"+t1.getText()+"' and password='"+p1.getText()+"'");
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"Welcome user "+t1.getText());
					this.hide();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Not a valid Username or Password");
		
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
	}

}