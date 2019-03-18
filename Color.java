
public enum Color 
{
	//These color values were chosen according to CSS color tables.
	RED (255, 0, 0),
	GREEN (0, 128, 0),
	BLUE (0, 0, 255),
	YELLOW (255, 255, 0),
	CYAN (0, 255, 255),
	MAGENTA (255, 0, 255);
	
	//Variables for the rgb of the color
	private int r, g, b;
	
	//Constructor for the d
	private Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;	
	}
	
	public int getR()
	{
		return this.r;
	}
	
	public int getG()
	{
		return this.g;
	}
	
	public int getB()
	{
		return this.b;
	}
}
