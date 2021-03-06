package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import classes.Cell;
import classes.Grid;
import classes.NegativeCoordinateException;


public class TestGrid {

	@Test
	public void gridTest(){
		Grid grid = new Grid(10, 10);
		assertEquals(10, grid.getWidth());
		assertEquals(10, grid.getHeight());
	}

	@Test
	public void eachCellShallBeAccessibleByUniqueXY() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(true, 1, 2));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(true, 2, 2));

		Grid grid = new Grid(cells, 2, 2);
		//Act
		Cell cell = grid.get(2, 1);

		//Assert
		assertEquals(2, cell.getX());
		assertEquals(1, cell.getY());
	}
	
	@Test
	public void numberOfAliveCellsShouldBeInitializedRoughlyEqualToDeadCellNumber2X2() 
			throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(false, 2, 2));
		
		//Act
		Grid grid = new Grid(cells, 2, 2);

		//Assert
		assertEquals(true, grid.areCellsUniformlyInitialized());
	}
	
	@Test
	public void numberOfAliveCellsAreNotInitializedRoughlyEqualToDeadCellNumber2X2() 
			throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(true, 1, 2));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(false, 2, 2));
		
		//Act
		Grid grid = new Grid(cells, 2, 2);

		//Assert
		assertEquals(false, grid.areCellsUniformlyInitialized());
	}

	@Test
	public void numberOfAliveCellsShouldBeInitializedRoughlyEqualToDeadCellNumber3X3() 
			throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		
		//Act
		Grid grid = new Grid(cells, 3, 3);

		//Assert
		assertEquals(true, grid.areCellsUniformlyInitialized());
	}
	
	@Test
	public void numberOfAliveCellsAreNotInitializedRoughlyEqualToDeadCellNumber3X3() 
			throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(true, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		
		//Act
		Grid grid = new Grid(cells, 3, 3);

		//Assert
		assertEquals(false, grid.areCellsUniformlyInitialized());
	}

	@Test
	public void getNeighborsCellInsideTheGrid3X3() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		
		//Act
		Grid grid = new Grid(cells, 3, 3);

		//Assert
		assertEquals(8, grid.getNeighborsNumber( 4 ));
	}
	
	@Test
	public void getNeighborsCellInsideTheGrid4X4() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(true, 1, 4));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 2, 4));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		cells.add(new Cell(true, 3, 4));
		cells.add(new Cell(true, 4, 1));
		cells.add(new Cell(false, 4, 2));
		cells.add(new Cell(true, 4, 3));
		cells.add(new Cell(true, 4, 4));
		
		//Act
		Grid grid = new Grid(cells, 4, 4);

		//Assert
		assertEquals(8, grid.getNeighborsNumber( 5 ));
		assertEquals(8, grid.getNeighborsNumber( 6 ));
		assertEquals(8, grid.getNeighborsNumber( 9 ));
		assertEquals(8, grid.getNeighborsNumber( 10 ));
	}
	
	@Test
	public void getNeighborsCellAtTheBorderOfTheGrid3X3() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		
		//Act
		Grid grid = new Grid(cells, 3, 3);

		//Assert
		assertEquals(5, grid.getNeighborsNumber( 1 ));
		assertEquals(5, grid.getNeighborsNumber( 3 ));
		assertEquals(5, grid.getNeighborsNumber( 5 ));
		assertEquals(5, grid.getNeighborsNumber( 7 ));
	}
	
	@Test
	public void getNeighborsCellAtTheBorderOfTheGrid4X4() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(true, 1, 4));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 2, 4));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		cells.add(new Cell(true, 3, 4));
		cells.add(new Cell(true, 4, 1));
		cells.add(new Cell(false, 4, 2));
		cells.add(new Cell(true, 4, 3));
		cells.add(new Cell(true, 4, 4));
		
		//Act
		Grid grid = new Grid(cells, 4, 4);

		//Assert
		assertEquals(5, grid.getNeighborsNumber( 1 ));
		assertEquals(5, grid.getNeighborsNumber( 2 ));
		assertEquals(5, grid.getNeighborsNumber( 4 ));
		assertEquals(5, grid.getNeighborsNumber( 7 ));
		assertEquals(5, grid.getNeighborsNumber( 8 ));
		assertEquals(5, grid.getNeighborsNumber( 11 ));
		assertEquals(5, grid.getNeighborsNumber( 13 ));
		assertEquals(5, grid.getNeighborsNumber( 14 ));
	}
	
	@Test
	public void getNeighborsCellAtTheCornerOfTheGrid2X2() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(false, 2, 2));
		
		//Act
		Grid grid = new Grid(cells, 2, 2);

		//Assert
		assertEquals(3, grid.getNeighborsNumber( 0 ));
		assertEquals(3, grid.getNeighborsNumber( 1 ));
		assertEquals(3, grid.getNeighborsNumber( 2 ));
		assertEquals(3, grid.getNeighborsNumber( 3 ));
	}
	
	@Test
	public void getNeighborsCellAtTheCornerOfTheGrid3X3() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		
		//Act
		Grid grid = new Grid(cells, 3, 3);

		//Assert
		assertEquals(3, grid.getNeighborsNumber( 0 ));
		assertEquals(3, grid.getNeighborsNumber( 2 ));
		assertEquals(3, grid.getNeighborsNumber( 6 ));
		assertEquals(3, grid.getNeighborsNumber( 8 ));
	}
	
	@Test
	public void getNeighborsCellAtTheCornerOfTheGrid34X4() throws NegativeCoordinateException{
		//Arrange
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 1, 3));
		cells.add(new Cell(true, 1, 4));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(true, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 2, 4));
		cells.add(new Cell(true, 3, 1));
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));
		cells.add(new Cell(true, 3, 4));
		cells.add(new Cell(true, 4, 1));
		cells.add(new Cell(false, 4, 2));
		cells.add(new Cell(true, 4, 3));
		cells.add(new Cell(true, 4, 4));
		
		//Act
		Grid grid = new Grid(cells, 4, 4);

		//Assert
		assertEquals(3, grid.getNeighborsNumber( 0 ));
		assertEquals(3, grid.getNeighborsNumber( 3 ));
		assertEquals(3, grid.getNeighborsNumber( 12 ));
		assertEquals(3, grid.getNeighborsNumber( 15 ));
	}
	
	@Test
	public void cellWithFewerThanTwoLiveNeighborsDiesTest2X2() throws NegativeCoordinateException{
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(false, 1, 2));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(false, 2, 2));

		Grid grid = new Grid(cells, 2, 2);
		
		Grid grid2 = grid.tick();
		
		assertEquals( 4, grid2.getDeadCells() );
		assertEquals( 0, grid2.getAliveCells() );
	}
	
	@Test
	public void twoCellWithFewerThanTwoLiveNeighborsDiesTest2X2() throws NegativeCoordinateException{
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(true, 1, 2));
		cells.add(new Cell(false, 2, 1));
		cells.add(new Cell(false, 2, 2));

		Grid grid = new Grid(cells, 2, 2);
		
		Grid grid2 = grid.tick();
		
		assertEquals( 4, grid2.getDeadCells() );
		assertEquals( 0, grid2.getAliveCells() );
	}
	
	@Test
	public void twoCornerCellWithFewerThanTwoLiveNeighborsDiesTest3X3() throws NegativeCoordinateException{
		ArrayList<Cell> cells = new ArrayList<>();
		cells.add(new Cell(true, 1, 1));
		cells.add(new Cell(true, 1, 2));
		cells.add(new Cell(false, 1, 3));
		cells.add(new Cell(true, 2, 1));
		cells.add(new Cell(false, 2, 2));
		cells.add(new Cell(false, 2, 3));
		cells.add(new Cell(true, 3, 1));	//dies
		cells.add(new Cell(false, 3, 2));
		cells.add(new Cell(true, 3, 3));	//dies

		Grid grid = new Grid(cells, 2, 2);
		
		Grid grid2 = grid.tick();
		
		assertEquals( 6, grid2.getDeadCells() );
		assertEquals( 3, grid2.getAliveCells() );
	}
	
	
	
	
	
	
}
