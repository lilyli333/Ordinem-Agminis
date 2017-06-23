import java.awt.Color;
import java.awt.Graphics;

public class SingleBox extends Block
{

	public SingleBox(int x, int y){
		super(x,y);
	}	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		setColor();
	    g.setColor(super.setColor());
	    
	    g.fillRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
	    
    	g.setColor(Color.BLACK);
    	g.drawRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
	}
	
	public boolean contained (int x, int y)
	{
		if (x < getX() + super.SHAPESIZE && x > getX())
		{
			if(y < getY() + super.SHAPESIZE && y > getY()){
				return true;
			}
		}
		
		return false;
	}

}
