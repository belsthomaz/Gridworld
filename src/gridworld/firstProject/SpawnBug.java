package gridworld.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class SpawnBug extends Bug
{
	
	 public SpawnBug()
	 {
		 setColor(Color.BLUE);
		 
	 }

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

		 SpawnBug spawnBug = new SpawnBug();
		 spawnBug.putSelfInGrid(gr, loc);
	 }
	 
	
}
