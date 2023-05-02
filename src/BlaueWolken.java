import java.util.Random;
import ledControl.BoardController;

public class BlaueWolken implements AnimatedObjects {
	
	private final int[] innerColor	= new int[]{0, 0, 95};
	private final int[] outerColor	= new int[]{0, 0, 55};
	private final Random rng;
	private BoardController controller;
	private double xpos, ypos;
	private double speedHorizontal;
	
	public BlaueWolken(BoardController controller) {
		this.controller=controller;
		rng = new Random();
		this.xpos		= 3+rng.nextInt(controller.getWidth()-3);
		this.ypos		= rng.nextInt(controller.getHeight() - 16);
		this.speedHorizontal	= rng.nextDouble() / 5. + 0.5;
	}
	
	public void draw(){
		int x = (int) xpos;
		int y = (int) ypos;

		controller.setColor(x + 1, y + 1, innerColor);
		controller.setColor(x + 2, y + 1, innerColor);
		controller.setColor(x + 1, y, outerColor);
		controller.setColor(x + 2, y, outerColor);
		controller.setColor(x, y + 1, outerColor);
		controller.setColor(x + 3, y + 1, outerColor);
	}
	
	public void update(){
		xpos += speedHorizontal;
				
		if (xpos > controller.getWidth()){
			xpos = 3;
			this.ypos		= rng.nextInt(controller.getHeight() - 16);
			this.speedHorizontal	= rng.nextDouble() / 5. + 0.3;
		}
	}
}