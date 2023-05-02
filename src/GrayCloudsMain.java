import java.util.LinkedList;
import java.util.List;
import ledControl.BoardController;
import ledControl.LedConfiguration;
/*
 *HINWEIS: Diese Animation ist eine Endlosschleife.
 *Um das zu aendern, Sehen Sie bitte die Zeile 158-160
 */
public class GrayCloudsMain {
	
	private final static int CLOUDS_COUNT = 4;	
	private static List<AnimatedObjects> animatedObjects;
	private static AnimationStage stage = AnimationStage.GUTESWETTER;
	private static BoardController controller;
	
	public static void main(String[] args) {
		controller		= BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR,Integer.MAX_VALUE);
		
		int yi = 19;
		int[] gruen = new int[]{0, 127, 0};
		
		for(int i=0; i<=yi; i++)
			controller.maxColor(i, yi, gruen);

		int x = 0;
		int y = 0;
		int[] sunColor = new int[]{127,127,0};
		
		controller.setColor(x, y, sunColor);
		controller.updateBoard();
		controller.sleep(1000);
		controller.setColor(x+1, y, sunColor);
		controller.setColor(x, y+1, sunColor);
		controller.updateBoard();
		controller.sleep(1000);
		controller.setColor(x+1, y+1, sunColor);
		controller.setColor(x+2, y, sunColor);
		controller.setColor(x, y+2, sunColor);
		controller.updateBoard();
		controller.sleep(2000);
		
		initialize();
		animatedLoop();			
	}

	private static void initialize() {
		controller		= BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR,Integer.MAX_VALUE);
		animatedObjects = new LinkedList<>();
	}
		
	private static void animatedLoop() {
		int count = 0;
		
		while(true) {
			controller.resetColors();
			
			switch(stage) {
				case GUTESWETTER: 
					if(count==0) {
						animatedObjects.clear();
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Sonne(controller));
					
						for (int i=0; i<=CLOUDS_COUNT; i++)
							animatedObjects.add(new BlaueWolken(controller));
					}
					else if(count==20) {
						stage = AnimationStage.MENSCH;
						count = -1;
					}				
					break;
				
				case MENSCH:
					if(count==0) {
						animatedObjects.clear();			
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Sonne(controller));
						animatedObjects.add(new Mensch(controller));	
						
						for (int i=0; i<=CLOUDS_COUNT; i++)
							animatedObjects.add(new BlaueWolken(controller));
					}
					else if(count==30) {
						stage = AnimationStage.DUNKLEWOLKEN;
						count = -1;
					}
					break;
				
				case DUNKLEWOLKEN:
					if(count==0) {
						animatedObjects.clear();
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Mensch(controller));
						animatedObjects.add(new GraueWolken(controller));
					}
					else if(count==20) {
						stage = AnimationStage.VORREGEN;
						count = -1;
					}
					break;
				
				case VORREGEN:
					if(count==0) {
						animatedObjects.clear();
						animatedObjects.add(new GraueWolken(controller));
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Mensch(controller));
						animatedObjects.add(new Regenschirm(controller));			
					}
					else if(count==5) {
						stage = AnimationStage.REGEN;
						count = -1;
					}
					break;
				
				case REGEN:
					if(count==0) {
						animatedObjects.clear();
						animatedObjects.add(new Regen(controller));
						animatedObjects.add(new Regenschirm(controller));					
						animatedObjects.add(new GraueWolken(controller));
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Mensch(controller));
					}
					else if(count==333) {								//count verringern, um die Animation zu verkuerzen
						stage = AnimationStage.BLITZ;
						count = -1;
					}
					break;
				
				case BLITZ:
					if(count==0) {
						animatedObjects.clear();
						animatedObjects.add(new Boden(controller));
						animatedObjects.add(new Mensch(controller));
						animatedObjects.add(new Regenschirm(controller));
						animatedObjects.add(new GraueWolken(controller));
						animatedObjects.add(new Regen(controller));
						animatedObjects.add(new Blitz(controller));
						stage = AnimationStage.ENDE;
						count=-1;
					}			
					break;
				
				case ENDE:
					if(count==0) {
						for(int i=0; i<=33; i++) {
							animatedObjects.clear();
							controller.setBoardColor(127, 127, 127);
							controller.updateBoard();
							controller.sleep(20);
							controller.resetColors();
							controller.updateBoard();
							controller.sleep(20);
						}
					}
					else if(count==20){
						stage = AnimationStage.GUTESWETTER;			/*Diese Zeile kommentieren*/
						count = -1;									/*Diese Zeile kommentieren*/
						//return;									/*Diese Zeile auskommentieren*/
					}
					break;
			}
			
			drawAnimatedObjects();
			updateAnimatedObjects();
			controller.updateBoard();
			if(stage==AnimationStage.GUTESWETTER ||
			   stage==AnimationStage.MENSCH ||
			   stage==AnimationStage.DUNKLEWOLKEN ||
			   stage==AnimationStage.VORREGEN ||
			   stage==AnimationStage.BLITZ)
				controller.sleep(500);
			else if(stage==AnimationStage.REGEN || stage==AnimationStage.ENDE)
				controller.sleep(69);
			count++;
		}	
	}
	
	private static void drawAnimatedObjects(){
		for(AnimatedObjects ao: animatedObjects)
			ao.draw();		
	}
	
	private static void updateAnimatedObjects(){
		for(AnimatedObjects ao: animatedObjects)
			ao.update();
	}	
}