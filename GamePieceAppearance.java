
public class GamePieceAppearance 
{
	//Variables to hold the appearance of the game piece
	private Shape s;
	private Color c;
	
	//Constructor to fill the above variables
	public GamePieceAppearance(Color ic, Shape is)
	{
		s = is;
		c = ic;
	}
	
	public Shape getShape() 
	{
		return s;
	}

	public Color getColor() 
	{
		return c;
	}
}
