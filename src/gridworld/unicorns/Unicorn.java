package gridworld.unicorns;

import java.awt.Color;
import java.util.ArrayList;
import gridworld.unicorns.Rainbow;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Unicorn extends Actor
{
	
	public Unicorn()
	{
		setColor(Color.MAGENTA);
	}
	
	public void act()
	{
		if (canMove()) 
		{
			move();
			
		}
		else 
		{
			 turn(); 
			 turn();
			 turn();
			 turn();
			 turn();
		}
		
		ArrayList<Actor> actors = getActors(); 
		processActors(actors); 
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
	

	/**
	 * moves the unicorn
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
	    	return (neighbor == null)  || (neighbor instanceof Rainbow); 
	   }
	    
	    public void turn() 
	    { 
	    	setDirection(getDirection() + Location.HALF_RIGHT); 
	    }
}
