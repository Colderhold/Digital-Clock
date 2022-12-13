import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.Color;

public class DigitalClock extends JFrame implements Runnable
{
	Thread runner;
	Font clockFont;
	public DigitalClock()
	{
		setVisible(true);
		setSize(500,200);
		setLocation(550,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		clockFont=new Font("Serif",Font.BOLD,48);
		Container c=getContentPane();
		ClockContent clk=new ClockContent();
		c.add(clk);
		setContentPane(c);
		start();
	}
	class ClockContent extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Image img=Toolkit.getDefaultToolkit().getImage("bg.png");
		if(img!=null)
		{
			g.drawImage(img,25,10,this);
			g.setFont(clockFont);
			g.setColor(Color.black);
			g.drawString(currentTime(),150,100);
			
			
		}
		
	}
	public String currentTime()
	{
		Calendar cal=Calendar.getInstance();
		int hours=cal.get(Calendar.HOUR_OF_DAY);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
		return ""+hours+":"+min+":"+sec+"";
	}
	
	
}

	public void start()
	{
		if(runner==null)
		{
			runner=new Thread(this);
			runner.start();
		}
	}
		
	public void run()
	{
		while(runner==Thread.currentThread())
		{
		repaint();
		}
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new DigitalClock();
	}
}