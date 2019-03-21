import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BoardGameTest {

	@Test
	public void addPlayerTest() 
	{
		BoardGame b = new BoardGame();
		boolean res = b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		assertTrue(res);
		res = b.addPlayer("A liquid", GamePiece.RED_RACER, Location.BILLIARD_ROOM);
		assertFalse(res);
	}
	
	@Test
	public void getPlayerGamePieceTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		assertEquals(GamePiece.RED_RACER, b.getPlayerGamePiece("A dead cat"));
	}
	
	@Test
	public void getPlayerWithGamePieceTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		assertEquals("A dead cat", b.getPlayerWithGamePiece(GamePiece.RED_RACER));
	}
	
	@Test
	public void movePlayerTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		b.movePlayer("A dead cat", Location.BILLIARD_ROOM);
		assertEquals(Location.BILLIARD_ROOM, b.getPlayersLocation("A dead cat"));
	}
	
	@Test
	public void moveTwoPlayersTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		
		String[] p = {"A liquid", "A dead cat"};
		Location[] l = {Location.HALL, Location.KITCHEN}; 
		
		String[] r = b.moveTwoPlayers(p, l);
		String[] e = {"A dead cat", "A liquid"};
		
		assertArrayEquals(e, r);
		
		b.addPlayer("An existential horror", GamePiece.YELLOW_BOOT, Location.CONSERVATORY);
		b.addPlayer("Karen", GamePiece.GREEN_BOOT, Location.DINING_ROOM);
		
		String[] p2 = {"An existential horror", "Karen"};
		Location[] l2 = {Location.LIBRARY, Location.LOUNGE}; 
		
		String[] e2 = {"An existential horror", "Karen"};
		String[] r2 = b.moveTwoPlayers(p2, l2);
		assertArrayEquals(e2, r2);
	}
	
	@Test
	public void getPlayersLocationTest()
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		assertEquals(Location.DINING_ROOM, b.getPlayersLocation("A dead cat"));
	}
	
	@Test
	public void getPlayersAtLocationTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.CONSERVATORY);
		ArrayList<String> e = new ArrayList<String>();
		e.add("A liquid");
		e.add("A dead cat");
		assertEquals(e, b.getPlayersAtLocation(Location.CONSERVATORY));
	}
	
	@Test
	public void getGamePiecesAtLocationTest() 
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.CONSERVATORY);
		ArrayList<GamePiece> e = new ArrayList<GamePiece>();
		e.add(GamePiece.MAGENTA_RACER);
		e.add(GamePiece.RED_RACER);
		assertEquals(e, b.getGamePiecesAtLocation(Location.CONSERVATORY));
	}
	
	@Test
	public void getPlayersTest()
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		Set<String> e = new HashSet<>();
		e.add("A dead cat");
		assertEquals(e, b.getPlayers());
	}
	
	@Test
	public void getPlayerLocationsTest()
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		Set<Location> e = new HashSet<>();
		e.add(Location.DINING_ROOM);
		e.add(Location.CONSERVATORY);
		assertEquals(e, b.getPlayerLocations());
	}
	
	@Test
	public void getPlayerPiecesTest()
	{
		BoardGame b = new BoardGame();
		b.addPlayer("A dead cat", GamePiece.RED_RACER, Location.DINING_ROOM);
		b.addPlayer("A liquid", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		Set<GamePiece> e = new HashSet<>();
		e.add(GamePiece.RED_RACER);
		e.add(GamePiece.MAGENTA_RACER);
		assertEquals(e, b.getPlayerPieces());
	}
}
