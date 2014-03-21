package gridworld.unicorns;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * 
 * @author itho1735
 * need to make arrayList that keeps track of rainbows and adds one everytime a butterfly is eaten.
 */
public class Rainbow extends Flower
{
	private static final double DARKENING_FACTOR = 0.05;
	
	public Rainbow()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() *255);
		int green = (int) (Math.random() *255);
		
		this.setColor(new Color(red,green,blue));
	}
	
	public void act()
	{
		Color c = getColor();
		int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
		int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
		int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
		setColor(new Color(red, green, blue));
	}
	
	


	
}
