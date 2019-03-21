import static org.junit.Assert.*;

import org.junit.Test;

public class GamePieceAppearanceTest 
{
	@Test
	public void getShapeTest() 
	{
		GamePieceAppearance gpa = new GamePieceAppearance(Color.RED, Shape.BOOT);
		assertEquals(Shape.BOOT, gpa.getShape());
	}
	
	@Test
	public void getColorTest() 
	{
		GamePieceAppearance gpa = new GamePieceAppearance(Color.RED, Shape.BOOT);
		assertEquals(Color.RED, gpa.getColor());
	}
}
