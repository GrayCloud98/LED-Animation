import ledControl.BoardController;

public class Boden implements AnimatedObjects {
	
	private final int[] gruen = new int[]{0, 127, 0};
	private BoardController controller;
	private double xpos, ypos;
		
	public Boden(BoardController controller) {
		this.controller=controller;
		this.xpos=0;
		this.ypos=19;
	}

	public void draw() {	
		int y = (int) ypos;
		
		for(int x = (int) xpos; x<=ypos; x++)
			controller.maxColor(x, y, gruen);
		
		controller.updateBoard();
	}

	public void update() {
		
	}
}