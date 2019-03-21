
public class GamePieceAppearance 
{
	//Variables to hold the appearance of the game piece
	private Shape s;
	private Color c;
	
	/**
	 * Constructor to fill the appearance variables
	 * 
	 * @param ic The color of the game piece
	 * @param is The shape of the game piece
	 */
	public GamePieceAppearance(Color ic, Shape is)
	{
		s = is;
		c = ic;
	}
	
	/**
	 * @return The shape of the gamePiece
	 */
	public Shape getShape() 
	{
		return s;
	}

	/**
	 * @return The color of the gamePiece
	 */
	public Color getColor() 
	{
		return c;
	}
}
