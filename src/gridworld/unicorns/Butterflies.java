package gridworld.unicorns;


import info.gridworld.actor.Actor;

import java.awt.Color;
import java.util.ArrayList;

public class Butterflies extends Actor
{
	public Butterflies()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() *255);
		int green = (int) (Math.random() *255);
		this.setColor(new Color(red,green,blue));
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
			if (!(a instanceof Butterflies) && !(a instanceof Unicorn) && !(a instanceof Rainbow)) 
			a.removeSelfFromGrid(); 
		} 
	}
}
