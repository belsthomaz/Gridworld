package gridworld.unicorns;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class UnicornRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Unicorn MaoMao = new Unicorn();
		world.add(new Location(2,4),MaoMao);
		world.add(new Location(7, 8), new Butterflies());
	    world.add(new Location(3, 5), new Butterflies());
	    world.add(new Location(2, 8), new Butterflies());
	    world.add(new Location(6, 3), new Butterflies());
	    world.add(new Location(4, 1), new Butterflies());
	    world.add(new Location(2, 2), new Butterflies());
	    world.add(new Location(1, 3), new Butterflies());
	    world.add(new Location(5, 4), new Butterflies());
	    world.add(new Location(4, 7), new Butterflies());
		world.show();
	}
}
