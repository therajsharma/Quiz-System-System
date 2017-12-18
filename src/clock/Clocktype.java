package clock;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class  Clocktype{
	 public JLabel jb;
		public int sec=59;
		public int min=20;
		
		JFrame jf;
		public Clocktype(JFrame jf1)
		{
			jf = jf1;
			jb = new JLabel(+min+":"+sec);
			 
			Seconds R1 = new Seconds( );
		      R1.start();
		     Minutes R2 = new Minutes();
		      R2.start();
		   
		      
		}
		public String zero(int num)
	    {
	      String number=( num < 10) ? ("0"+num) : (""+num);
	      return number;                                    //Add leading zero if needed
	      
	    }

		class Seconds implements Runnable 
		{
			   private Thread t;
			   private String threadName;
			 
			   
			   Seconds( )
			   {
			       threadName = "Second";
			   }
			  
			   public void run() 
			   {
			      try {
			    	     while(true)
			    	     {
			                 for(int i = 59; i>=0; i--) 
			                 {
			        	            sec=i;
			        	            jb.setFont(new Font("Broadway",5,24));
			        	            jb.setForeground(Color.red);
			                        jb.setText(zero(min)+":"+zero(sec));
			                      if(min ==0 && sec==0)
			        	          {
			                    	  
			                    	  jf.setEnabled(false);
			                    	  jf.setVisible(false);
			                    	  return;
			                    	 
			        		           
			        	          }
			                        Thread.sleep(1000);
			                        //in millisecond
			                  }
			               }
			          }
			      catch (InterruptedException e) 
			      {
			         System.out.println("Thread " +  threadName + " interrupted.");
			      }
			   }
			   
			   public void start ()
			   {
			      if (t == null)
			      {
			         t = new Thread (this, threadName);
			         t.start ();
			      }
			   }

			}
		
		class Minutes implements Runnable {
			   private Thread t;
			   private String threadName;
			   
			   
			   Minutes( )
			   {threadName = "Minute";}
			   
			   public void run() 
			   {
			      try {
			    	     while(true)
			    	     {
			                   for(int i =20; i>=0; i--) 
			                   {
			        	            min=i;
			                        Thread.sleep(60000);
			                        //in millisec
			                   }
			              }
			          }
			      catch (InterruptedException e) 
			      {System.out.println("Thread " +  threadName + " interrupted.");}
			   }
			   
			   public void start ()
			   {
			      if (t == null)
			      {
			         t = new Thread (this, threadName);
			         t.start ();
			      }
			   }

			}
	
	}
			
