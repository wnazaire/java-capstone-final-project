/* Willene Drine Nazaire
 * Title: Closet Match-Up!
 * Last Revised: 3.23.14
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
 
public class Game extends StateBasedGame{
	public static final String gamename = "Closet Match-up!";
	public static final int menu = 1;
	public static final int room = 2;
	public static final int closet = 3;
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new DressingRoom(room));
		this.addState(new Closet(closet));
	} 

	public static void main(String[] argv) {  
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(1000, 600, false);  
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.setIcon("Images/icon16.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(room).init(gc, this);
		this.getState(closet).init(gc, this);
		this.enterState(menu);
	} 
}