package packageArt;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import packageArt.*;
public class Game {
	public KeyboordCallback keyboardCallback;
	private WindowMain windowMain;
	private boolean isWindowInit =false;
	private int windowWidth,windowHeight;
	private boolean windowned;
	public Game(int wWidth,int wHeight,boolean wWindowned)
	{
		windowWidth= wWidth;
		windowHeight= wHeight;
		windowned=wWindowned;
		windowMain = new WindowMain();
		windowMain.init();//first init to have special window handler
		isWindowInit=true;
		keyboardCallback= new KeyboordCallback(windowMain.getWindowHandler());
		windowMain.run();
	}
	public WindowMain getWindow()
	{
		if(isWindowInit)
		{
			return windowMain;
		}
		else return null;
	}
	public KeyboordCallback getKeyboordCallback()
	{
		return keyboardCallback;
	}
	public void shutDownGame()
	{
		if(isWindowInit)
		{
			glfwSetWindowShouldClose(windowMain.getWindowHandler(), GL_TRUE); 
		}
	}
}
