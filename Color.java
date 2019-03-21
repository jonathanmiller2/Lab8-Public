/**
 * Enum to represent a color (with rgb values).
 *
 * @author Jonathan Miller
 * @version 2019-03-18
 */

public enum Color 
{
	RED (255, 0, 0),
	GREEN (0, 255, 0), //This green value doesn't agree with CSS color definitions
	BLUE (0, 0, 255),
	YELLOW (255, 255, 0),
	CYAN (0, 255, 255),
	MAGENTA (255, 0, 255);
	
	//Variables for the rgb of the color
	private int r, g, b;
	
	/**
	 * Constructor for the colors
	 * 
	 * @param r The color's red component
	 * @param g The color's green component
	 * @param b The color's blue component
	 */
	private Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;	
	}
	
	/**
	 * @return The color's red component
	 */
	public int getR()
	{
		return this.r;
	}
	
	/**
	 * @return The color's green component
	 */
	public int getG()
	{
		return this.g;
	}
	
	/**
	 * @return The color's blue component
	 */
	public int getB()
	{
		return this.b;
	}
}
