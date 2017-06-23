import java.awt.Color;
import java.awt.Graphics;

public class ZShape extends Block
{

	public ZShape(int x, int y) {
		super(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		setColor();
	    g.setColor(super.setColor());
	    
	    g.fillRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX()+super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX()+super.SHAPESIZE, getY()+super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX()+2 * super.SHAPESIZE, getY()+super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	
    	g.setColor(Color.BLACK);
    	g.drawRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX()+super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX()+super.SHAPESIZE, getY()+super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX()+2 * super.SHAPESIZE, getY()+super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
	}
	
	public boolean contained (int x, int y)
	{
		if (x < getX() + 2 * super.SHAPESIZE && x > getX() - 50)
		{
			if(y < getY() + 2 * super.SHAPESIZE && y > getY()- 50){
				return true;
			}
		}
		
		return false;
	}

}
