package gridworld.critters;

import gridworld.rock.DeathRock;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class HungryRunner
{
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        HungryCritter JeanValJean = new HungryCritter();
        world.add(new Location(2,2), JeanValJean);
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Flower(Color.BLUE));
        world.add(new Location(5, 5), new Flower(Color.PINK));
        world.add(new Location(1, 5), new Flower(Color.RED));
        world.add(new Location(7, 2), new Flower(Color.YELLOW));
        world.add(new Location(4, 4), new CreepyCritter());
        world.add(new Location(5, 8), new CreepyCritter());
        world.add(new Location(4,7), new CrabCritter());
        world.add(new Location(3,8), new CrabCritter());
        world.show();
    }

}
