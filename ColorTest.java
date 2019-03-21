import static org.junit.Assert.*;

import org.junit.Test;

public class ColorTest 
{
	@Test
	public void colorValuesTest() 
	{
		Color col = null;
		
		col = Color.RED;
		assertEquals(255, col.getR());
		assertEquals(0, col.getG());
		assertEquals(0, col.getB());
		
		col = Color.GREEN;
		assertEquals(0, col.getR());
		assertEquals(255, col.getG());
		assertEquals(0, col.getB());
		
		col = Color.BLUE;
		assertEquals(0, col.getR());
		assertEquals(0, col.getG());
		assertEquals(255, col.getB());
		
		col = Color.YELLOW;
		assertEquals(255, col.getR());
		assertEquals(255, col.getG());
		assertEquals(0, col.getB());
		
		col = Color.CYAN;
		assertEquals(0, col.getR());
		assertEquals(255, col.getG());
		assertEquals(255, col.getB());
		
		col = Color.MAGENTA;
		assertEquals(255, col.getR());
		assertEquals(0, col.getG());
		assertEquals(255, col.getB());
	}
}
