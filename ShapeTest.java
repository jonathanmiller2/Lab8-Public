import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeTest 
{
	@Test
	public void shapeValueTest() 
	{
		Shape s = null;
		
		s = Shape.BOOT;
		assertEquals("boot", s.toString());
		
		s = Shape.THIMBLE;
		assertEquals("thimble", s.toString());
		
		s = Shape.RACECAR;
		assertEquals("racecar", s.toString());
	}
}
