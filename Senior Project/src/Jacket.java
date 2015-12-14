import java.awt.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Jacket {
	private Image jacket;
	private Color color;
	private String sleeve;
	private int style, index;
	
	public Jacket(String location) throws SlickException {
		jacket = new Image("Images/Jackets/"+location+".png");
	}
	
	public void addDetails(int index){
		switch (index){
			case 0:
				color = new Color(27, 36, 104); //blue
				sleeve = "long";
				style = 4;
				break;
			case 1:
				color = new Color(29, 30, 41); //navy blue
				sleeve = "long";
				style = 4;
				break;
			case 2:
				color = new Color(35, 40, 49); //navy blue
				sleeve = "long";
				style = 1;
				break;
			case 3:
				color = Color.BLACK;
				sleeve = "long";
				style = 1;
				break;
			default:
				color = Color.BLACK;
				sleeve = "long";
				style = 1;
				break;
		}//end switch
		this.index = index;
	}
	
	public Image getImage(){
		return jacket;
	}
	
	public int getStyle(){
		return style;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getColor(){
		return "Jacket Color: RGB("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+") ";
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
				+"Sleeve length: "+sleeve+"\n"
				+"Style: "+styleString;
	}
}