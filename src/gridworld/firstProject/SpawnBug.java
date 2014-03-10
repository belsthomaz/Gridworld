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
		 int red = (int) (Math.random() * 255);
		 int blue = (int) (Math.random() *255);
		 int green = (int) (Math.random() *255);
		 int direction = ((int) (Math.random() * red * blue * green) % 8) * 45;
		 this.setDirection(direction);
		 this.setColor(new Color(red,green,blue));
		 
	 }

	 public void move()
	 {
		 Grid<Actor> gr = getGrid();
		 if (gr == null) 
		 {
			 return; 
		 }
		 Location loc = getLocation(); 
		 Location nextLoc = loc.getAdjacentLocation(getDirection()); 
		 Location backRightLoc = loc.getAdjacentLocation(90);
		 Location backLeftLoc = loc.getAdjacentLocation(270);
		 Location furtherLeftLoc = loc.getAdjacentLocation(225);
		 Location furtherRightLoc = loc.getAdjacentLocation(135);
		 
		 if (gr.isValid(nextLoc)) 
		 {
			 moveTo(nextLoc);
		 }
		 else 
		 {
			 removeSelfFromGrid();
		 }

		 SpawnBug spawnBug = new SpawnBug();
		 spawnBug.putSelfInGrid(gr, loc);
		
	 }
	 
	
}
