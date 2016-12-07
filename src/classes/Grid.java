package classes;

import java.util.ArrayList;

public class Grid {
	private ArrayList<Cell> cells;
	private int width;
	private int height;


	public Grid(ArrayList<Cell> cells, int w, int h) throws CellCoordinateOutOfBoundariesException{
		this( w, h );
		this.cells = cells;
	}
	
	public Grid(int w, int h) throws CellCoordinateOutOfBoundariesException {
		this.width = w;
		this.height = h;
	}
	
	

	public String print() {
	    return null;
	}
	
	public Grid tick() {
	    return null;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	public Cell get(int x, int y) {
		// TODO Auto-generated method stub
		for( Cell cell: cells ){
			if( cell.getX() == x && cell.getY() == y ){
				return cell;
			}
		}
		
		return null;
	}

	public int getAliveCells() {
		// TODO Auto-generated method stub
		int count = 0;
		
		for( Cell cell : cells ){
			if( cell.isAlive() ){
				count++;
			}
		}
		
		return count;
	}
	
	public int getDeadCells() {
		// TODO Auto-generated method stub
		int count = 0;
		
		for( Cell cell : cells ){
			if( ! cell.isAlive() ){
				count++;
			}
		}
		
		return count;
	}

	public int getNeighborsNumber(int index) {
		// TODO Auto-generated method stub
		if( index == 0 || index == (width-1) || index == (width*height - width) || index == (width*height -1) ){	//corner cell
			return 3;
		}
		return 0;
	}
}
