import java.awt.Color;
import java.awt.Graphics;

public class BackwardL extends Block
{

	public BackwardL(int x, int y){
		super(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	    g.setColor(super.setColor());
	    
	    g.fillRect(getX() + 2 * super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX() + 2 * super.SHAPESIZE, getY() + super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX(), getY() + 2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX() + super.SHAPESIZE, getY()+ 2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX() + 2 * super.SHAPESIZE, getY()+2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	
    	g.setColor(Color.BLACK);
    	g.drawRect(getX() + 2 * super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX() + 2 * super.SHAPESIZE, getY() + super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX(), getY() + 2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX() + super.SHAPESIZE, getY()+2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX() + 2 * super.SHAPESIZE, getY()+2 * super.SHAPESIZE, super.SHAPESIZE, super.SHAPESIZE);
	}
	
	public boolean contained (int x, int y)
	{
		if (x < getX() + 3 * super.SHAPESIZE && x > getX())
			if(y < getY() + 3 * super.SHAPESIZE && y > getY()){
				return true;
			}
		
		return false;
	}

}
