import ledControl.BoardController;

public class Sonne implements AnimatedObjects {
		
	private final int[] sunColor = new int[]{127,127,0};
	private BoardController controller;
	private double xpos, ypos;
	
	public Sonne(BoardController controller) {
		this.controller=controller;
		this.xpos=0;
		this.ypos=0;
	}

	public void draw() {
		int x = (int) xpos;
		int y = (int) ypos;
		controller.maxColor(x, y, sunColor);
		controller.maxColor(x+1, y, sunColor);
		controller.maxColor(x, y+1, sunColor);
		controller.maxColor(x+1, y+1, sunColor);
		controller.maxColor(x+2, y, sunColor);
		controller.maxColor(x, y+2, sunColor);
		controller.updateBoard();
	}

	public void update() {
		
	}
}