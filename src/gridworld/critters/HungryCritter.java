package gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class HungryCritter extends Critter
{
	public HungryCritter()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() *255);
		int green = (int) (Math.random() *255);
		 
		this.setColor(new Color(red,green,blue));
		
	}
	
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
			if (!(a instanceof HungryCritter)) 
			a.removeSelfFromGrid(); 
		} 
	}
	 public ArrayList<Location> getMoveLocations()
	    {
	        ArrayList<Location> locs = new ArrayList<Location>();
	        int[] dirs =
	            { Location.LEFT, Location.RIGHT };
	        for (Location loc : getLocationsInDirections(dirs))
	            if (getGrid().get(loc) == null)
	                locs.add(loc);

	        return locs;
	    }

	    /**
	     * If the crab critter doesn't move, it randomly turns left or right.
	     */
	    public void makeMove(Location loc)
	    {
	        if (loc.equals(getLocation()))
	        {
	            double r = Math.random();
	            int angle;
	            if (r < 0.5)
	            {
	                angle = Location.LEFT;
	                
	            }
	            else
	            {
	                angle = Location.RIGHT;
	                
	            }
	           
	            setDirection(getDirection() + angle);
	        }
	        else
	            super.makeMove(loc);
	    }
	    
	    /**
	     * Finds the valid adjacent locations of this critter in different
	     * directions.
	     * @param directions - an array of directions (which are relative to the
	     * current direction)
	     * @return a set of valid locations that are neighbors of the current
	     * location in the given directions
	     */
	    public ArrayList<Location> getLocationsInDirections(int[] directions)
	    {
	        ArrayList<Location> locs = new ArrayList<Location>();
	        Grid gr = getGrid();
	        Location loc = getLocation();
	    
	        for (int d : directions)
	        {
	            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	            if (gr.isValid(neighborLoc))
	                locs.add(neighborLoc);
	        }
	        return locs;
	    }    
}
