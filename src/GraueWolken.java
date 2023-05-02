import ledControl.BoardController;

public class GraueWolken implements AnimatedObjects{
	
	private final int [] grau = new int [] {99,99,99};
	private BoardController controller;
	private double xpos, ypos;
	
	public GraueWolken (BoardController controller) {
		this.controller = controller;
		this.xpos=0;
		this.ypos=0;
	}
	
	public void draw() {
		int ende  = 19;
		int y     = (int) ypos;
		
		for(int x=(int) xpos; x<=ende; x++)
			controller.setColor(x, y, grau);
		y++;
		for(int x=(int) xpos; x<=ende; x++)
			controller.setColor(x, y, grau);
		y++;
		for(int x=(int) xpos; x<=ende; x++)
			controller.setColor(x, y, grau);
			
		controller.updateBoard();
	}
	
	public void update() {
		
	}
}