import java.awt.Color;
import java.awt.Graphics;

public class HorizontalShape extends Block
{

		
	public HorizontalShape(int x, int y){
		super(x, y);
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		setColor();
	    g.setColor(super.setColor());
	    
	    g.fillRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX()+super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.fillRect(getX()+super.SHAPESIZE * 2, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	
    	g.setColor(Color.BLACK);
    	g.drawRect(getX(), getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX()+ super.SHAPESIZE, getY(), super.SHAPESIZE, super.SHAPESIZE);
    	g.drawRect(getX()+super.SHAPESIZE * 2, getY(), super.SHAPESIZE, super.SHAPESIZE);	}
	
	public boolean contained (int x, int y)
	{
		if (x < getX() + super.SHAPESIZE * 5 && x > getX())
		{
			if(y < getY() + super.SHAPESIZE && x > getY()){
				return true;
			}
		}
		
		return false;
	}

}
