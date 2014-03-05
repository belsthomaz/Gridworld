package gridworld.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class TriangleBug extends Bug
{
	 private int steps;
	 private int sideLength;
	 
	 public void move()
	 {
		 Grid<Actor> gr = getGrid();
		 if (gr == null) 
		 {
			 return; 
		 }
		 Location loc = getLocation(); 
		 Location next = loc.getAdjacentLocation(getDirection()); 
		 if (gr.isValid(next)) 
		 {
			 moveTo(next); 
		 }
		 else 
		 {
			 removeSelfFromGrid();
		 }
//		 Rock rock = new Rock(getColor());
//		 rock.putSelfInGrid(gr, loc);
		 Flower flower = new Flower(getColor());
		 flower.putSelfInGrid(gr, loc);
	 }
	 
	 public TriangleBug(int length)
	 {
		 setColor(Color.GREEN);
		 steps = 0;
		 sideLength = 3;
	 }
	 
	 public void act()
	 {
		 if (steps < sideLength && canMove())
	     {
			 move();
	         steps++;
	     }
	     else
	     {
	         turn();
	         turn();
	         turn();
	         steps = 0;
	     }
	 }
}
