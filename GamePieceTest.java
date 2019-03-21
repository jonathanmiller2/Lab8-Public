import static org.junit.Assert.*;

import org.junit.Test;

public class GamePieceTest 
{
	@Test
	public void getColorTest() 
	{
		GamePiece a;
		
		a = GamePiece.RED_RACER;
		assertEquals(Color.RED, a.getColor());
		a = GamePiece.BLUE_RACER;
		assertEquals(Color.BLUE, a.getColor());
		a = GamePiece.MAGENTA_RACER;
		assertEquals(Color.MAGENTA, a.getColor());
		a = GamePiece.RED_THIMBLE;
		assertEquals(Color.RED, a.getColor());
		a = GamePiece.BLUE_BOOT;
		assertEquals(Color.BLUE, a.getColor());
		a = GamePiece.GREEN_BOOT;
		assertEquals(Color.GREEN, a.getColor());
		a = GamePiece.YELLOW_BOOT;
		assertEquals(Color.YELLOW, a.getColor());
	}

	@Test
	public void getShapeTest() 
	{
		GamePiece a;
		
		a = GamePiece.RED_RACER;
		assertEquals(Shape.RACECAR, a.getShape());
		a = GamePiece.BLUE_RACER;
		assertEquals(Shape.RACECAR, a.getShape());
		a = GamePiece.MAGENTA_RACER;
		assertEquals(Shape.RACECAR, a.getShape());
		a = GamePiece.RED_THIMBLE;
		assertEquals(Shape.THIMBLE, a.getShape());
		a = GamePiece.BLUE_BOOT;
		assertEquals(Shape.BOOT, a.getShape());
		a = GamePiece.GREEN_BOOT;
		assertEquals(Shape.BOOT, a.getShape());
		a = GamePiece.YELLOW_BOOT;
		assertEquals(Shape.BOOT, a.getShape());
	}
	
	@Test
	public void getPriorityTest() 
	{
		GamePiece a;
		
		a = GamePiece.RED_RACER;
		assertEquals(0, a.getPriority());
		a = GamePiece.BLUE_RACER;
		assertEquals(2, a.getPriority());
		a = GamePiece.MAGENTA_RACER;
		assertEquals(1, a.getPriority());
		a = GamePiece.RED_THIMBLE;
		assertEquals(10, a.getPriority());
		a = GamePiece.BLUE_BOOT;
		assertEquals(5, a.getPriority());
		a = GamePiece.GREEN_BOOT;
		assertEquals(8, a.getPriority());
		a = GamePiece.YELLOW_BOOT;
		assertEquals(7, a.getPriority());
	}
	
	@Test
	public void movesFirstTest() 
	{	
		GamePiece a = GamePiece.RED_RACER;
		GamePiece b = GamePiece.BLUE_RACER;
		assertEquals(GamePiece.RED_RACER, GamePiece.movesFirst(a, b));
		
		GamePiece c = GamePiece.GREEN_BOOT;
		GamePiece d = GamePiece.MAGENTA_RACER;
		assertEquals(GamePiece.MAGENTA_RACER, GamePiece.movesFirst(c, d));
	}
}
