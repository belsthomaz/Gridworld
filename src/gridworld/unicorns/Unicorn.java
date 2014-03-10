package gridworld.unicorns;

import java.util.ArrayList;


import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Unicorn extends Actor
{
	public void act()
	{
		if(getGrid() == null)
		{
			return;
		}
		ArrayList<Actor> actors = getActors();
		processActors(actors);
		ArrayList<Location> moveLocs = getMoveLocations();
		Location loc = selectMoveLocation(moveLocs);
		
		makeMove(loc);
		
	}
	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors) 
		{ 
			if (!(a instanceof Unicorn) && !(a instanceof Rainbow));
			a.removeSelfFromGrid(); 
		} 
	}
	 public ArrayList<Location> getMoveLocations()
	    {
	       return getGrid(). getEmptyAdjacentLocations(getLocation());
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

	    /**
	     * If the crab critter doesn't move, it randomly turns left or right.
	     */
	    public void makeMove(Location loc)
	    {
	        if(loc == null)
	        {
	        	removeSelfFromGrid();
	        }
	        else
	        {
	        	Location oldLocation = getLocation();
	        	moveTo(loc);
	        	
		        Rainbow rainbow = new Rainbow();
		        rainbow.putSelfInGrid(getGrid(), oldLocation);
	        }  
	    }
	    
	   
}
