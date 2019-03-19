import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BoardGame 
{
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame()
	{	
		playerPieces = new LinkedHashMap<>();
		playerLocations = new LinkedHashMap<>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		if(playerPieces.containsKey(playerName))
		{
			return false;
		}
		
		playerPieces.put(playerName, gamePiece);
		playerLocations.put(playerName, initialLocation);
		
		return true;
	}
	
	public GamePiece getPlayerGamePiece(String playerName)
	{
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		//This can also be accomplished by converting the entrySet into a stream, then using filter(), findFirst(), and orElse().
		//However, that code is messy, so I prefer the classic iterator.
		String res = null;
		for(Map.Entry<String, GamePiece> a : playerPieces.entrySet())
		{
			if(a.getValue() == gamePiece)
			{
				res = a.getKey();
			}
		}
		return res;
	}
	
	public void movePlayer(String playerName, Location newLocation)
	{
		playerLocations.put(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		GamePiece first = GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1]));
		
		if(playerPieces.get(playerNames[0]) == first)
		{
			String[] res = {playerNames[0], playerNames[1]};
			return res;
		}
		else
		{
			String[] res = {playerNames[1], playerNames[0]};
			return res;
		}
	}
	
	public Location getPlayersLocation(String player)
	{
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> p = new ArrayList<String>();
		
		for(Map.Entry<String, Location> a : playerLocations.entrySet())
		{
			if(a.getValue() == loc)
			{
				p.add(a.getKey());
			}
		}
		
		return p;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		ArrayList<String> pl = new ArrayList<String>();
		ArrayList<GamePiece> gp = new ArrayList<GamePiece>();
		
		pl = getPlayersAtLocation(loc);
		
		for(String p : pl)
		{
			gp.add(playerPieces.get(p));
		}
		
		return gp;
	}
	
	public Set<String> getPlayers()
	{
		return playerPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations()
	{
		return (Set<Location>)playerLocations.values();
	}
	
	public Set<GamePiece> getPlayerPieces()
	{
		return (Set<GamePiece>)playerPieces.values();
	}
}
	
