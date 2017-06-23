import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PointSystem extends JPanel
{
	private int boxX, boxY;
	private int width, height;
	private int xWord;
	
	public PointSystem()
	{
		boxX = 570;
		boxY = 60;
		width = 180;
		height = 200;
		xWord = 625;
	}
	
	public void drawPoints (Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(boxX, boxY, width, height);
		
		Font points = new Font ("San Serif", Font.BOLD, 40);
		g.setFont(points);
		g.drawString("Points: ", 580, 110);
		
		int p = GameScreen.getPoints();
		if (p > 9)
		{
			xWord = 600;
		}
		if (p > 99)
		{
			xWord = 570;
		}
		Font pt = new Font ("San Serif", Font.BOLD, 90);
		g.setFont(pt);
		g.drawString(p + "", xWord, 200);
	}
}
