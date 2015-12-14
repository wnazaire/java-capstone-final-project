import javax.swing.JOptionPane;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;

public class Menu extends BasicGameState{
	private Image title, continueButton, newButton;
	User user;
	private int state;
	public static final int menuID = 1;
	public static final int roomID = 2;
	public static final int closetID = 3;
	
	public Menu (int state){
		this.state=state;
	}
	
	public void init (GameContainer gc, StateBasedGame sbg) throws SlickException{
		gc.setShowFPS(false);
		title = new Image("Images/Title.png"); //width: 1000 height:600
		continueButton = new Image("Images/ContinueButton.png"); //width: 100 height: 60
		newButton = new Image("Images/NewButton.png");
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(title, 0, 0);
		g.drawImage(newButton, 450, 320);
		g.drawImage(continueButton, 450, 400);
	}

	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = input.getAbsoluteMouseX();
		int ypos = input.getAbsoluteMouseY();
		
		//New button
		if((xpos>450 && xpos<550) && (ypos>320 && ypos<380)){
			if(input.isMouseButtonDown(0)){
				user = new User();
				sbg.enterState(roomID, new FadeOutTransition(Color.white, 300), new FadeInTransition(Color.magenta, 300));
			}
		}
		
		//Continue button
		if((xpos>450 && xpos<550) && (ypos>400 && ypos<460)){
			if(input.isMouseButtonDown(0)){
				if (User.load(JOptionPane.showInputDialog(null, "Please enter your name:", "Find a user", JOptionPane.INFORMATION_MESSAGE)))
					sbg.enterState(roomID, new FadeOutTransition(Color.white, 300), new FadeInTransition(Color.magenta, 300));
				else
					sbg.enterState(menuID);
			}
		}
	}

	public int getID(){
		return state;
	}

}
