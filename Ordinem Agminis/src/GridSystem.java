import java.awt.Color;
import java.awt.Graphics;

public class GridSystem {
	
	private static int rect = 50;
	private int [][] grid;
	private Color [][] color; 
	private boolean dropped;
	
	public GridSystem(){
		grid = new int[10][10];
		color = new Color[10][10];
		
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid.length; j ++){
				grid[i][j] = 0;
				color[i][j] = Color.WHITE;
			}
		}
		
		dropped = false;
	}
	
	public String toString(){
		
		String str = "";
		
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid.length; j ++){
				str += grid[i][j] + " ";
			}
			str += "\n";
		}	
		
		return str;
	}
	
	public void drawGrid(Graphics g){
		int gridX = 10;
		int gridY = 10;
	    
	    for(int i = 0 ; i < grid.length; i ++){
	    	for(int j = 0; j < grid.length; j ++){
	    		g.setColor(color[i][j]);
	    		g.fillRect(gridX + rect, gridY + rect, rect, rect);
	    		g.setColor(Color.BLACK);
	    		g.drawRect(gridX + rect, gridY + rect, rect, rect);
	    		
	    		
	    		gridX += rect;
	    	}
	    	gridX = 10;
	    	gridY += rect;
	    }
	}
	
	public void getLoc(int x, int y, Color color, Block blk){
		int column = -1;
		int row = -1;
		
		if(inGrid(x,y)){
		
			for(int i = 10; i < 560; i += rect){
				column ++;
				if(x > i && x < i + rect){
					break;
				}
			}
			
			for(int i = 10; i < 560; i += rect){
				row ++;
				if(y > i && y < i + rect){
					break;
				}
			}
		}
		
		System.out.println("row: " + row + " column: " + column);
		
		column --;
		row --;

		if(blk.getType() == 1){
			if((this.color[row + 2][column] == Color.WHITE) && this.color[row + 2][column + 1] == Color.WHITE 
					&& this.color[row + 2][column + 2] == Color.WHITE && this.color[row][column + 2] == Color.WHITE
					&& this.color[row + 1][column + 2] == Color.WHITE){
				this.color[row + 2][column] = blk.getColor();
				this.color[row + 2][column + 1] = blk.getColor();
				this.color[row + 2][column + 2] = blk.getColor();
				this.color[row][column + 2] = blk.getColor();
				this.color[row + 1][column + 2] = blk.getColor();
				dropped = true;
			}
		}
		else if(blk.getType() == 2){
			if(this.color[row][column] == Color.WHITE && this.color[row + 1][column] == Color.WHITE 
					&& this.color[row][column +1] == Color.WHITE && this.color[row + 1][column + 1] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				this.color[row + 1][column] = blk.getColor();
				this.color[row][column + 1] = blk.getColor();
				this.color[row + 1][column + 1] = blk.getColor();
				dropped = true;

			}
		}
		else if(blk.getType() == 3){
			if(this.color[row][column + 1] == Color.WHITE && this.color[row + 1][column + 1] == Color.WHITE 
					&& this.color[row + 2][column + 1] == Color.WHITE && this.color[row + 1][column] == Color.WHITE
					&& this.color[row + 1][column + 2] == Color.WHITE){
				this.color[row][column + 1] = blk.getColor();
				this.color[row + 1][column + 1] = blk.getColor();
				this.color[row + 2][column + 1] = blk.getColor();
				this.color[row + 1][column] = blk.getColor();
				this.color[row + 1][column + 2] = blk.getColor();
				dropped = true;

			}
		}
		else if(blk.getType() == 4){
			if (this.color[row][column] == Color.WHITE && this.color[row + 1][column] == Color.WHITE 
					&& this.color[row + 2][column] == Color.WHITE && this.color[row][column + 1] == Color.WHITE
					&& this.color[row + 2][column + 1] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				this.color[row + 1][column] = blk.getColor();
				this.color[row + 2][column] = blk.getColor();
				this.color[row][column + 1] = blk.getColor();
				this.color[row + 2][column + 1] = blk.getColor();
				dropped = true;
			}
		}
		else if(blk.getType() == 5){
			if(this.color[row][column] == Color.WHITE && this.color[row][column + 1] == Color.WHITE 
					&& this.color[row][column + 2] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				this.color[row][column + 1] = blk.getColor();
				this.color[row][column + 2] = blk.getColor();
				dropped = true;
			}

		}
		else if(blk.getType() == 6){
			if(this.color[row][column] == Color.WHITE && this.color[row + 1][column] == Color.WHITE
					&& this.color[row + 1][column + 1] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				this.color[row + 1][column] = blk.getColor();
				this.color[row + 1][column + 1] = blk.getColor();
				dropped = true;
			}
		}
		else if(blk.getType() == 7){
			if(this.color[row][column] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				dropped = true;
			}
		}
		else if(blk.getType() == 8){
			if(this.color[row][column] == Color.WHITE && this.color[row][column + 1] == Color.WHITE
					&& this.color[row + 1][column + 1] == Color.WHITE && this.color[row][column + 2] == Color.WHITE){
				this.color[row][column] = blk.getColor();
				this.color[row][column + 1] = blk.getColor();
				this.color[row + 1][column + 1] = blk.getColor();
				this.color[row][column + 2] = blk.getColor();
				dropped = true;
			}
		}
		else if(blk.getType() == 9){
			if(this.color[row][column] == Color.WHITE && this.color[row][column + 1] == Color.WHITE
					&& this.color[row + 1][column + 1] == Color.WHITE && this.color[row + 1][column + 2] == Color.WHITE)
			this.color[row][column] = blk.getColor();
			this.color[row][column + 1] = blk.getColor();
			this.color[row + 1][column + 1] = blk.getColor();
			this.color[row + 1][column + 2] = blk.getColor();
			dropped = true;

		}
	}
	
	public boolean isDropped(){
		boolean boo;
		if(dropped == true){
			boo = true;
			dropped = false;
		}
		else{
			boo = false;
		}
		return boo;
	}
	
	public boolean inGrid(int x, int y){
		if(x > 60 && x < 560 && y > 60 && y < 560)
			return true;
		else
			return false;
	}
	
	public void check(){
		//color[row][column]
		
		//check rows
		
		for(int row = 0; row < color.length; row ++){
			int notWhite = 0;
			for(int col = 0; col < color.length; col ++){
				if(this.color[row][col] == Color.WHITE){
					notWhite --;
					
				}
				else{
					notWhite ++;
				}
			}
			if(notWhite == 10){
				for(int i = 0; i < color.length; i ++){
					this.color[row][i] = Color.WHITE;
					GameScreen.changePoints(2);
				}
			}
		}
		
		//check columns
		for(int row = 0; row < color.length; row ++){
			int notWhite = 0;
			for(int col = 0; col < color.length; col ++){
				if(this.color[col][row] == Color.WHITE){
					notWhite --;
					
				}
				else{
					notWhite ++;
				}
			}
			if(notWhite == 10){
				for(int i = 0; i < color.length; i ++){
					this.color[i][row] = Color.WHITE;
					GameScreen.changePoints(2);
				}
			}
		}
		
	}
	
}
