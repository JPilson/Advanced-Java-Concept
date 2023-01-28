package winterProgram;

import acm.graphics.GLabel;
import acm.program.DialogProgram;
import acm.program.GraphicsProgram;

/**
 *
 */
public class HelloProgram extends DialogProgram {

    @Override
    public void run() {
       addNumbers();
    }
    void sayHello(){
        GLabel label = new GLabel("Hello World");
        double x  = getWidth() /2;
        double y = getHeight() /2;
//        add(label,x,y);
    }
    void addNumbers(){
        println("Add Numbers");
        int n1 = readInt("Enter 1st Number: ");
        int n2 = readInt("Add Second Number: ");
        int total = n1 +n2;
        println("The Sum is "+total+" .");
    }

}
