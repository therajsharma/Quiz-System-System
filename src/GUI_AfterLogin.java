import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI_AfterLogin 
{
	JFrame jf2 = new JFrame("BMU Quiz System");
	ImageIcon oop_pic = new ImageIcon("oop.jpg");
	    JButton oop = new JButton(oop_pic);
	ImageIcon daa_pic = new ImageIcon("daa.jpg");
	    JButton daa = new JButton(daa_pic);
	ImageIcon ds_pic = new ImageIcon("ds.jpg");
	    JButton ds = new JButton(ds_pic);
	ImageIcon os_pic = new ImageIcon("os.jpg");
	    JButton os = new JButton(os_pic);
	
	//JPanel options = new JPanel();
	
	GUI_AfterLogin()
	{
		 jf2.setSize(738,700);
    	 jf2.setVisible(true);
    	 jf2.setDefaultCloseOperation(jf2.EXIT_ON_CLOSE);
    	 //BoxLayout boxLayout = new BoxLayout(options, BoxLayout.Y_AXIS);
    	 //layout a single row or column of components in a container
    	 jf2.setLayout(new GridLayout(2,2));
    	 jf2.setLocation(300,10);
    	// options.setLayout(boxLayout);
    	 jf2.add(oop);
    	 jf2.add(daa);
    	 jf2.add(ds);
    	 jf2.add(os);
    	 jf2.validate();
    	 os.addActionListener(new Handler());
    	 oop.addActionListener(new Handler());
    	 daa.addActionListener(new Handler());
    	 ds.addActionListener(new Handler());
	    
	}
	
	class Handler implements ActionListener
	//Declare an event handler class and specify that the class either implements an ActionListener 
	//interface or extends a class that implements an ActionListener interface
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//when oop button clicked
		    	if(e.getSource()==oop)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Object Orinted Programming","oop");
		    		      jf2.dispose();} 
		    		catch (SQLException e1) {e1.printStackTrace();}
		    	}
		    	else if(e.getSource()==ds)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Database System","ds");
		    		jf2.dispose();}
		    		catch (SQLException e1) {e1.printStackTrace();}
		    		//checked exception, which means that your code should only see it if you 
		    		//either explicitly throw it, or you call a method that declares it in its throws clause
		    	}
		    	else if(e.getSource()==daa)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Design and Analysis of Algorithm","daa");
		    		jf2.dispose();}
		    		catch (SQLException e1) {e1.printStackTrace();
					}
		    	}
		    	else if(e.getSource()==os)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Operating System","os");
		    		jf2.dispose();} 
		    		catch (SQLException e1) {e1.printStackTrace();}
		    	}
			
		}
	}
}