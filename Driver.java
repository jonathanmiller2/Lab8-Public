
public class Driver 
{
	public static void main(String[] args)
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		b.addPlayer("An existential horror", GamePiece.YELLOW_BOOT, Location.CONSERVATORY);
		b.addPlayer("Karen", GamePiece.GREEN_BOOT, Location.DINING_ROOM);
		
		System.out.println("Currently the game pieces at the Convservatory are: " + b.getGamePiecesAtLocation(Location.CONSERVATORY));
		System.out.println("Currently Karen's game piece is: " + b.getPlayerGamePiece("Karen"));
		System.out.println("Currently the occupied locations are: " + b.getPlayerLocations());
		System.out.println("Currently the pieces being used are: " + b.getPlayerPieces());
		System.out.println("Currently the players are: " + b.getPlayers());
		System.out.println("Currently the players at the Convservatory are: " + b.getPlayersAtLocation(Location.CONSERVATORY));
		System.out.println("Currently Karen is in the: " + b.getPlayersLocation("Karen"));
		System.out.println("The green boot belongs to: " + b.getPlayerWithGamePiece(GamePiece.GREEN_BOOT));
	}
}
