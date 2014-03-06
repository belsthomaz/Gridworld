package gridworld.firstProject;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class SpawnRunner
{
	 public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();
	        SpawnBug Judith = new SpawnBug();
	        SpawnBug Carl = new SpawnBug();
	        world.add(new Bug());
	        world.add(new Location(7,2), Judith);
	        world.add(new Location(6,8), Carl);
	        world.add(new Rock());
	        world.show();
	    }
}
