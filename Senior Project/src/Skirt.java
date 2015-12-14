import java.awt.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skirt {
	private Image skirt;
	private Color color;
	private String length, type;
	private int style, index;
	
	public Skirt(String location) throws SlickException {
		skirt = new Image("Images/Skirts/"+location+".png");
	}
	
	public void addDetails(int index){
		switch (index){
			case 0:
				color = new Color(232, 27, 94); //pink
				length = "short";
				type = "pencil";
				style = 0;
				break;
			case 1:
				color = new Color(148, 110, 101); //blue
				length = "long";
				type = "wrap";
				style = 1;
				break;
			case 2:
				color = new Color(231, 150, 166); //pink
				length = "long";
				type = "high-lo";
				style = 0;
				break;
			case 3:
				color = new Color(46, 52, 74); //blue
				length = "long";
				type = "maxi";
				style = 1;
				break;
			case 4:
				color = new Color(1, 38, 109); //blue
				length = "short";
				type = "pencil";
				style = -1;
				break;
			case 5:
				color = new Color(245, 13, 52); //pink
				length = "short";
				type = "pencil";
				style = 0;
				break;
			case 6:
				color = new Color(251, 99, 137); //pink
				length = "long";
				type = "straigt";
				style = 0;
				break;
			case 7:
				color = new Color(252, 84, 57); //orange
				length = "long";
				type = "pencil";
				style = -1;
				break;
			case 8:
				color = new Color(34, 33, 51); //blue
				length = "short";
				type = "a-line";
				style = 1;
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
		return skirt;
	}
	
	public String getType(){
		return "Skirt Type: "+type;
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