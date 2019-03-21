/**
 * Class to represent a board game.
 *
 * @author Jonathan Miller
 * @version 2019-03-18
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class BoardGame 
{
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	//Constructor to instantiate the variables
	public BoardGame()
	{	
		playerPieces = new LinkedHashMap<>();
		playerLocations = new LinkedHashMap<>();
	}
	
	/**
	 * Adds a Player to the linkedHashMaps playerPieces and playerLocations. 
	 *
	 * @param playerName The name of the player that is being added.
	 * @param gamePiece The piece the player should have
	 * @param initialLocation The location the player should start at
	 * @return Returns false if the player already exists in the game. Returns truw otherwise.
	 */
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		//If there's already a player with that gamePiece, return false
		if(playerPieces.containsValue(gamePiece))
		{
			return false;
		}
		
		//Otherwise, assign the new player the piece and location, and return true
		playerPieces.put(playerName, gamePiece);
		playerLocations.put(playerName, initialLocation);
		
		return true;
	}
	
	
	/**
	 * Gets the player's game piece from their player name
	 * 
	 * @param playerName The name of the player to get the piece for
	 * @return The game piece of the player
	 */
	public GamePiece getPlayerGamePiece(String playerName)
	{
		//Retrieve the gamepiece from the linkedhashmap
		return playerPieces.get(playerName);
	}
	
	/**
	 * Get the player from the game piece
	 * 
	 * @param gamePiece The game piece we're looking for
	 * @return The string player name associated with the game piece
	 */
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		//This can also be accomplished by converting the entrySet into a stream, then using filter(), findFirst(), and orElse().
		//However, that code is messy, so I prefer the classic iterator.
		for(Map.Entry<String, GamePiece> a : playerPieces.entrySet())
		{
			//If we find the matching GamePiece, return the key, which indicates the player
			if(a.getValue() == gamePiece)
			{
				return a.getKey();
			}
		}
		//If we don't find the right GamePiece, return null
		return null;
	}
	
	/**
	 * Moves a single player to a new location
	 * 
	 * @param playerName The name of the player to be moved
	 * @param newLocation The destination location
	 */
	public void movePlayer(String playerName, Location newLocation)
	{
		//Assignt the player to a new location
		playerLocations.put(playerName, newLocation);
	}
	
	/**
	 * Moves two players to new locations
	 * 
	 * @param playerNames The players to be moved
	 * @param newLocations The locations to move them
	 * @return An array of the playerNames in the order they were moved
	 */
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		//Use the .movesFirst to determine in what order to move them
		GamePiece first = GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1]));
		
		//Two options depending on which one is first
		if(playerPieces.get(playerNames[0]) == first)
		{
			//If 0 is first, move it first
			movePlayer(playerNames[0], newLocations[0]);
			movePlayer(playerNames[1], newLocations[1]);
			
			//Return a string that indicates the order in which they were moved
			String[] res = {playerNames[0], playerNames[1]};
			return res;
		}
		else
		{
			//If 1 is first, move it first			
			movePlayer(playerNames[1], newLocations[1]);
			movePlayer(playerNames[0], newLocations[0]);
			
			//Return a string that indicates the order in which they were moved
			String[] res = {playerNames[1], playerNames[0]};
			return res;
		}
	}
	
	/**
	 * Gets a player's location
	 * 
	 * @param player The player to get the location of
	 * @return The Location of the player
	 */
	public Location getPlayersLocation(String player)
	{
		//Retrieve the location associated with the player
		return playerLocations.get(player);
	}
	
	/**
	 * Gets the players at a specified location
	 * 
	 * @param loc The location to inspect
	 * @return An arraylist players at the specified location
	 */
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> p = new ArrayList<String>();
		
		//Iterate through each entry in the map
		for(Map.Entry<String, Location> a : playerLocations.entrySet())
		{
			if(a.getValue() == loc)
			{
				//If an entry is at a location, add the player to the result list
				p.add(a.getKey());
			}
		}
		
		return p;
	}
	
	
	/**
	 * Gets the game pieces at a specified location
	 * 
	 * @param loc The location to inspect
	 * @return An arraylist gamePieces at the specified location
	 */
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		//pl is an array list for players, gp is an array list for their game pieces
		ArrayList<String> pl = new ArrayList<String>();
		ArrayList<GamePiece> gp = new ArrayList<GamePiece>();
		
		pl = getPlayersAtLocation(loc);
		
		//We know what players are at a location, so we just have to get the gamePieces of those players
		for(String p : pl)
		{
			//Add them to the result array list
			gp.add(playerPieces.get(p));
		}
		
		//Return the result array list
		return gp;
	}
	
	/**
	 * Gets all of the players
	 * 
	 * @return A set of the players
	 */
	public Set<String> getPlayers()
	{
		//The keyset is all of the players added
		return playerPieces.keySet();
	}
	
	/**
	 * Gets all of the location that are occupied
	 * 
	 * @return A set of the locations
	 */
	public Set<Location> getPlayerLocations()
	{
		//Set has to be instantiated as a hashset (??), so we make a new hashset with all of the values from the player locations
		Set<Location> f = new HashSet<Location>(playerLocations.values());
		return f;
	}
	
	/**
	 * Gets all of the player pieces being used
	 * 
	 * @return A set of the player pieces
	 */
	public Set<GamePiece> getPlayerPieces()
	{
		//Set has to be instantiated as a hashset (??), so we make a new hashset with all of the values from the player pieces
		Set<GamePiece> f = new HashSet<GamePiece>(playerPieces.values());
		return f;
	}
}
	
