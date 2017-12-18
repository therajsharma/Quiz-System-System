import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI 
{
     JFrame jf1 = new JFrame("Examination System");
     
     JLabel username = new JLabel("USERNAME");
	 JTextField jtf_username = new JTextField(10);
	 JPanel u = new JPanel();
	 
	 JLabel password = new JLabel("PASSWORD");
	 JPasswordField jpf = new JPasswordField(10);
	 JPanel p = new JPanel();
     
	 JButton login = new JButton("LOGIN");
	 JButton cancel  = new JButton("CANCEL");
	 JButton Signup  = new JButton("SIGN UP");
	 JButton Delete  = new JButton("DELETE ACCOUNT");
	 JPanel lc = new JPanel();
	 
	 JLabel message = new JLabel("Message :");
	 JTextField message_out = new JTextField(100);
	 
	 GUI()
     {
    	 jf1.setSize(500,200);
    	 jf1.setVisible(true);
    	 jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
    	 BoxLayout boxLayout = new BoxLayout(jf1.getContentPane(), BoxLayout.Y_AXIS);
    	 jf1.setLayout(boxLayout);
    	 jf1.setLocation(500,300);
    	 
    	 //store password in *
    	 jpf.setEchoChar('*');
    	 u.setLayout(new FlowLayout());
    	 u.add(username);
    	 u.add(jtf_username);
    	 jf1.add(u);
    	 
    	 
    	 
    	 p.setLayout(new FlowLayout());
    	 p.add(password);
    	 p.add(jpf);
    	 jf1.add(p);
    	
    	 
    	 
    	 lc.add(login);
    	 login.addActionListener(new Handler());
    	 lc.add(cancel);
    	 cancel.addActionListener(new Handler());
    	 lc.add(Signup);
    	 Signup.addActionListener(new Handler());
    	 lc.add(Delete);
    	 Delete.addActionListener(new Handler());
    	 jf1.add(lc);
    	  
    	
    	 jf1.add(message);
    	 jf1.add(message_out);
    	  	 
    	 //jf1.validate();   // graphic objects are created after resizing so we ussed this
    	 
         
     }
     
     boolean login(String username,String password) throws Exception
    {
    	 int i=1;
    	 try
    	  {
     	    Class.forName("com.mysql.jdbc.Driver");
     	    Connection con = DriverManager.getConnection("jdbc:mysql://10.7.1.115:3306/demojava","root","root");
     	    Statement stat1 = con.createStatement(); 
     	   Statement stat2 = con.createStatement();
     	    ResultSet rs1;
     	    ResultSet rs2;
     	    rs1 = stat1.executeQuery("select name from user");
     	    rs2 = stat2.executeQuery("select password from user");
     	    rs1.next();
     	    rs2.next();
     	    
     	    do
     	     {
     	    	if( (username.equals(rs1.getString(i))==true) && (password.equals(rs2.getString(i))) )
     	    	{return(true);}
     	    
     	     }while(rs1.next()!=false && rs2.next()!=false);
     	   con.close();
          }
        catch(ClassNotFoundException cnfe)
          { cnfe.printStackTrace(); }
    
      return(false);
      
    }
    
	 
	 
	 class Handler implements ActionListener
	 //take certain type of input ..for certi functions
     {
    	 @Override
    	public void actionPerformed(ActionEvent e) 
    	 //ActionEvent is a class, e is an instance of that class. 
    	 //You can use e to call it's methods/properties
    	 {
    		 if( e.getSource()==login)
    			 //event object contains a reference to the component that generated the event. 
    		   {
    			      char[] check1 = jpf.getPassword();
    			      String check2 = jtf_username.getText();
    			      //GET--new values can be assigned to these variables and the values they hold can be accessed.
    			      String check3 = new String(check1);
//    			      char[] correctPass = new char[] {'L', 'N', 'M', '2', '0', '1', '5'};
//    		          if((Arrays.equals(check1,correctPass)==true) && (check2.equals("user")==true))
//    	               {
//    	            	   jf1.dispose();
//    	    	           GUI_AfterLogin page2 = new GUI_AfterLogin(); 
//    	               }
//    	         
    			      try {
						if(login(check2,check3)==true)
						   { 
						       jf1.dispose();
						       GUI_AfterLogin page2 = new GUI_AfterLogin(); 
          
						   }
						  else
						   {
						       message_out.setText("Username or password may be incorrect !!!!");
						   }
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    		    }
    		 
    		   else if(e.getSource()== cancel)
    	        {
    	    	      jf1.dispose();
    	        }
    		   else if(e.getSource()==Signup)
    		   {
    			       jf1.dispose();
    			       GUI_SignUp page3 = new GUI_SignUp();
    		   }
    		   else if(e.getSource()==Delete)
    		   {
    			       jf1.dispose();
    			       GUI_DeleteAccount page4 = new GUI_DeleteAccount();
    		   }
    		 
    	       
    	 }
     }
     
  
     



}
