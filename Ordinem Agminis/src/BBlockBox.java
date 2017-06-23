import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BBlockBox extends JPanel
{
	private int xLoc, yLoc, i;
	private int shapeX, shapeY;
	private ArrayList<Block> blocks;
	
	public BBlockBox()
	{
		xLoc = 520;
		yLoc = 310;
		blocks = new ArrayList<Block>();
		//makeShapes();
		i = 0;
	}
	
	public void drawBBlockBox (Graphics g)
	{
		if(i == 0){
			makeShapes();
			i = 1;
		}
		g.setColor(Color.BLACK);
		//g.drawRect(xLoc, yLoc, 250, 200);
		g.drawRect(570, 310, 600, 250);
		drawShapes(g);
		
	}
	
	private void makeShapes(){
		for(int i = 600; i < 1200; i +=200){
			blocks.add(Block.generateRandom(i,350));
		}
	}
	
	private void drawShapes(Graphics g){
		for(Block f: blocks){
	    	f.draw(g);
	    }
	}
	
	public Block getFromArrayList(int num){
		return blocks.get(num);
	}
	
	public void clearArray(){
		blocks.clear();
		i =0;
	}
	
}
