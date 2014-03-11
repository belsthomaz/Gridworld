package gridworld.unicorns;

import java.util.ArrayList;


import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
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
//		ArrayList<Actor> actors = getActors();
//		processActors(actors);
//		ArrayList<Location> moveLocs = getMoveLocations();
	
		if (canMove()) 
		{
			move();
		}
		else 
		{
			 turn(); 
			 turn();
			 turn();
		}
		
	}
	
//	public ArrayList<Actor> getActors()
//	{
//		return getGrid().getNeighbors(getLocation());
//	}
//	
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors) 
		{ 
			if (!(a instanceof Unicorn) && !(a instanceof Rainbow));
			a.removeSelfFromGrid(); 
		} 
	}
	
//	public ArrayList<Location> getMoveLocations()
//	{
//	    return getGrid().getEmptyAdjacentLocations(getLocation());
//	}
//	public Location selectMoveLocation(ArrayList<Location> locs)
//	{
//		int n = locs.size();
//		if(n == 0)
//		{
//			 return getLocation();
//		}
//		int r = (int) (Math.random() * n);
//		return locs.get(r);
//	}

	    /**
	     * If the crab critter doesn't move, it randomly turns left or right.
	     */
	    public void move()
	    {
	    	Grid<Actor> gr = getGrid();
	    	
	    	if(gr == null)
	    	{
	    		return;
	    	}
	    	
	    	Location oldLocation = getLocation();
	    	Location nextLocation = oldLocation.getAdjacentLocation(getDirection());
	    	
	    	if(gr.isValid(nextLocation))
	    	{
	    		moveTo(nextLocation);
	    	}
	    	else
	    	{
	    		removeSelfFromGrid();
	    	}
	    	
	        Rainbow rainbow = new Rainbow();
		    rainbow.putSelfInGrid(gr, oldLocation);
	    }	
	    public boolean canMove() 
	    { 
	    	Grid<Actor> gr = getGrid(); 
	    	if (gr == null)
	    	{
	    		return false; 
	    	}
	    	Location loc = getLocation(); 
	    	Location next = loc.getAdjacentLocation(getDirection()); 
	    	if (!gr.isValid(next)) 
	    	{
	    		return false; 
	    	}
	    	Actor neighbor = gr.get(next); 
	    	return (neighbor == null) || (neighbor instanceof Rainbow); 
	    }
	    
	    public void turn() 
	    { 
	    	setDirection(getDirection() + Location.HALF_RIGHT); 
	    }
}
