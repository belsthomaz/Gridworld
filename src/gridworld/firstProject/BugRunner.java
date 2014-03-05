package gridworld.firstProject;
/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        TriangleBug Jay = new TriangleBug(6);
        TriangleBug May = new TriangleBug(3);
        SpawnBug Judith = new SpawnBug();
        SpawnBug Carl = new SpawnBug();
        world.add(new Bug());
        world.add(new Location(7,8), Jay);
        world.add(new Location(5,4), May);
        world.add(new Location(7,2), Judith);
        world.add(new Location(6,8), Carl);
//        world.add(new Rock());
        world.show();
    }
}
