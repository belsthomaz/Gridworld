package gridworld.critters;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class CreepyCritter extends Actor
{
	public CreepyCritter()
	{
		setColor(Color.GRAY);
	}
	public void act()
	{
		if(getGrid() == null)
		{
			return;
		}
		ArrayList<Actor> actors = getActors(); 

		ArrayList<Location> moveLocs = getMoveLocations(); 
		Location loc = selectMoveLocation(moveLocs); 
		makeMove(loc); 
	}
	
	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
	
	
	
	public ArrayList<Location> getMoveLocations()
	{
		return getGrid().getEmptyAdjacentLocations(getLocation());
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs)
	{
		int n = locs.size();
		if(n == 0)
		{
			return getLocation();
		}
		int r = (int) (Math.random() * n); 
		return locs.get(r); 
	}
	
	public void makeMove(Location loc)
	{
		if(loc == null)
		{
			removeSelfFromGrid();
		}
		else
		{
			moveTo(loc);
		}
	}
}
