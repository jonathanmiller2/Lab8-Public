/**
 * Enum to represent a color (with rgb values).
 *
 * @author Jonathan Miller
 * @version 2019-03-18
 */


public enum GamePiece 
{
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0),
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2),
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1),
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10),
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5),
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8),
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance app;
	private int pri;
	
	/**
	 * The constructor for the different GamePieces
	 * 
	 * @param iapp The gamePieceAppearance
	 * @param ipri The priority
	 */
	private GamePiece(GamePieceAppearance iapp, int ipri)
	{
		app = iapp;
		pri = ipri;
	}
	
	/**
	 * @return The color value of the game piece
	 */
	public Color getColor()
	{
		return app.getColor();
	}
	
	/**
	 * @return The shape of the game piece
	 */
	public Shape getShape()
	{
		return app.getShape();
	}
	
	/**
	 * @return The priority of the game piece
	 */
	public int getPriority()
	{
		return pri;
	}
	
	/**
	 * Determines which of two pieces should move first
	 * 
	 * @param a The first game piece to be compared
	 * @param b The second game piece to be compared
	 * @return The piece that should move first
	 */
	public static GamePiece movesFirst(GamePiece a, GamePiece b)
	{	
		//Lower priorities go first, so we determine which has the lower priority
		if(a.getPriority() < b.getPriority())
		{
			return a;
		}
		else
		{
			return b;
		}
	}
}
