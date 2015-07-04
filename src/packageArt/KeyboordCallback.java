package packageArt;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import packageArt.ClassWithKeyboardUse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




import org.lwjgl.*;
import org.lwjgl.glfw.GLFWKeyCallback;


public class KeyboordCallback {
	private GLFWKeyCallback   keyCallback;
	List<ClassWithKeyboardUse> toCall;
	public KeyboordCallback(long window)
	{
		toCall= new ArrayList<ClassWithKeyboardUse>();
		glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                	{
                	glfwSetWindowShouldClose(window, GL_TRUE); 
                	
                	}
                for(Iterator<ClassWithKeyboardUse> i = toCall.iterator(); i.hasNext(); ) {
                    ClassWithKeyboardUse item = i.next();
                    item.keyState(new KeyState(key,scancode,action,mods));
                }
            }
        });
	}
	public boolean addClassToKeyboardUse(ClassWithKeyboardUse keyboardClass)
	{
		toCall.add(keyboardClass);
		return true;
	}
}
