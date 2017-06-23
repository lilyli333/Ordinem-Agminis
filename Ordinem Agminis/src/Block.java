
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Block
{
	private int colorKey;
	private Color color;
	public static final int SHAPESIZE = 50;
	public int x, y;
	private int type;
	
	public Block (int xPos, int yPos)
	{
		colorKey = (int)(Math.random()*3 + 1);
		x = xPos;
		y = yPos;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contained(int x, int y);
	
	public Color setColor()
	{
		if (colorKey == 1)
	    {
			//pink-purple
	    	color = new Color (255, 21, 76);
	    }
	    else if (colorKey == 2)
	    {
	    	//orange
	    	color = new Color (250, 138, 40);
	    }
	    else
	    {
	    	//blue
	    	color = new Color (40, 131, 250);
	    }
		return color;
	}
	
	public Color getColor(){
		setColor();
		return color;
	}
	
	public int getX (){
		return x;
	}
	public int getY (){
		return y;
	}
	
	public void setX(int in){
		x = in;
	}
	
	public void setY(int in){
		y = in;
	}
	
	public int getType(){
		return type;
	}
	
	public void setType(int t) {
		type = t;
	}
	
	public static Block generateRandom(int x, int y){

		Block shp;
		
		int rand = (int)(Math.random()* 9 + 1);

		if(rand == 1){
			shp = new BackwardL(x,y);
			  
		}
		else if(rand == 2){
			shp = new Box (x, y);
			  
		}
		else if(rand == 3){
			shp = new Cross (x, y);
			  
		}
		else if(rand == 4){
			shp = new CShape (x, y);
			  
		}
		else if(rand == 5){
			shp = new HorizontalShape (x, y);
			  
		}
		else if(rand == 6){
			shp = new nubL (x, y);
			  
		}
		else if(rand == 7){
			shp = new SingleBox (x, y);
			  
		}
		else if(rand == 8){
			shp = new TShape (x, y);
			  
		}
		else {
			shp = new ZShape (x, y);
		}
		
		shp.setType(rand);
		
		
		return shp;
	}
	
	
	/*(public void check(){
		if(dropped == true){
			
		}*/
}
