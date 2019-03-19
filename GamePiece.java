
public enum GamePiece 
{
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 1),
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2),
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 3),
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 4),
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5),
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 6),
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance app;
	private int pri;
	
	private GamePiece(GamePieceAppearance iapp, int ipri)
	{
		app = iapp;
		pri = ipri;
	}
	
	public Color getColor()
	{
		return app.getColor();
	}
	
	public Shape getShape()
	{
		return app.getShape();
	}
	
	public int getPriority()
	{
		return pri;
	}
	
	public static GamePiece movesFirst(GamePiece a, GamePiece b)
	{	
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
