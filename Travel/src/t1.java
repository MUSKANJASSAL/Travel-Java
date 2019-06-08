import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class t1 extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	JLabel l1=new JLabel("TRAVEL AND TOURISM");
	JLabel l2=new JLabel(new ImageIcon("C:\\Users\\hp\\Pictures\\travel.jpg"));
	JLabel l3=new JLabel("THE JOURNEY OF A THOUSAND MILES BEGIN WITH A SINGLE STEP");
	JButton b1=new JButton("LOGIN");
	JButton b2=new JButton("OPTIONS");
	public t1()
	{
		add(l1);add(l2);add(l3);add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.setVisible(true);
		this.setSize(600,400);
		this.setLayout(null);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Arial Black",Font.BOLD,20));
		l1.setBounds(400,100,400,40);
		l2.setBounds(450,200,120,98);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Arial",Font.BOLD,17));
		l3.setBounds(300,350,550,30);
		b1.setBounds(350,400,120,30);
		b2.setBounds(550,400,120,30);
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
		new t1();
	}

	public void actionPerformed(ActionEvent ar)
	{
		if(ar.getSource().equals(b1))
		{
			new t2();
			this.hide();
		}

		if(ar.getSource().equals(b2))
		{
			new t3();
			this.hide();
		}
	}

}