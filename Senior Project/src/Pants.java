import java.awt.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pants {
	private Image pants;
	private Color color;
	private String length, type;
	private int style, index;
	
	public Pants(String location) throws SlickException {
		pants = new Image("Images/Pants/"+location+".png");
	}
	
	public void addDetails(int index){
		switch (index){
			case 0:
				color = new Color(170, 124, 120); //blue
				length = "long";
				type = "skinny";
				style = 1;
				break;
			case 1:
				color = new Color(148, 110, 101); //green
				length = "long";
				type = "straight";
				style = 0;
				break;
			case 2:
				color = new Color(252, 203, 185); //yellow
				length = "long";
				type = "straight";
				style = 0;
				break;
			case 3:
				color = new Color(229, 56, 22); //orange
				length = "long";
				type = "skinny";
				style = 0;
				break;
			case 4:
				color = new Color(200, 200, 193); //gray
				length = "long";
				type = "sweats";
				style = 1;
				break;
			case 5:
				color = Color.black;
				length = "long";
				type = "straight";
				style = -1;
				break;
			case 6:
				color = new Color(38, 39, 41); //dark blue
				length = "long";
				type = "skinny";
				style = 1;
				break;
			case 7:
				color = new Color(66, 86, 119); //blue
				length = "short";
				type = "rolled up";
				style = 1;
				break;
			case 8:
				color = new Color(143, 40, 57); //red
				length = "short";
				type = "cut offs";
				style = 1;
				break;
			case 9:
				color = new Color(192, 170, 146); //khaki
				length = "long";
				type = "straight";
				style = -1;
				break;
			default:
				color = Color.BLACK;
				length = "long";
				type = "straight";
				style = 1;
				break;
		}//end switch
		this.index = index;
	}
	
	public Image getImage(){
		return pants;
	}
	
	public String getType(){
		return "Pants Type: "+type;
	}
	
	public int getStyle(){
		return style;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String toString(){
		String styleString;
		switch (style){
			case -1: styleString = "semi-formal";
			case 0: styleString = "business casual";
			case 1: styleString = "casual";
			case 2: styleString = "semi-formal";
			case 3: styleString = "formal";
			case 4: styleString = "business formal";
			case 5: styleString = "business";
			default: styleString = "semi-casual";
		}
		return "Color: RGB("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+") "+"\n"
				+"Length: "+length+"\n"
				+"Type: "+type+"\n"
				+"Style: "+styleString;
	}
}