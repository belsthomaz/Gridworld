package gridworld.unicorns;


import info.gridworld.actor.Actor;

import java.awt.Color;
import java.util.ArrayList;
/**
 * 
 * @author itho1735
 * need to make arrayList that keeps track of rainbows and adds one everytime a butterfly is eaten.
 */
public class Rainbow extends Actor
{
	private ArrayList<Rainbow> myRainbows;
	
	public Rainbow()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() *255);
		int green = (int) (Math.random() *255);
		
		this.setColor(new Color(red,green,blue));
		
		myRainbows = new ArrayList<Rainbow>();
	}
	
	public void act()
	{
		ArrayList<Actor> actors = getActors();
		processActors(actors);
		addNewRainbow(myRainbows);
	}
	
	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors) 
		{ 
			if (!(a instanceof Unicorn) && !(a instanceof Rainbow) && !(a instanceof Butterflies)) 
			a.removeSelfFromGrid(); 
		} 
	}

	public ArrayList<Rainbow> getMyRainbows()
	{
		return myRainbows;
	}

	public void setMyRainbows(ArrayList<Rainbow> myRainbows)
	{
		this.myRainbows = myRainbows;
	}
	
}
