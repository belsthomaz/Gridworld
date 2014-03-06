package gridworld.firstProject;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class TriangleRunner
{
	 public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();
	        TriangleBug Jay = new TriangleBug(6);
	        TriangleBug May = new TriangleBug(3);

	        world.add(new Bug());
	        world.add(new Location(7,8), Jay);
	        world.add(new Location(5,4), May);
	        world.add(new Rock());
	        world.show();
	    }
}
