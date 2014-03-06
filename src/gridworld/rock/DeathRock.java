package gridworld.rock;

import java.awt.Color;
import java.util.ArrayList;


import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

public class DeathRock extends Rock
{
	public DeathRock()
	{
		setColor(Color.DARK_GRAY);
	}

	public void act()
	{
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
			if (!(a instanceof DeathRock)) 
			a.removeSelfFromGrid(); 
		} 
	}
}
