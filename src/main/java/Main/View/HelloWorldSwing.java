package Main.View;

import javax.swing.*;
import java.awt.*;

public class HelloWorldSwing {
    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.setLayout(new BorderLayout());

        frame.add("North",new Button("North"));
        frame.add("East",new Button("North"));
        frame.add("West",new Button("North"));
        frame.add("South",new Button("North"));
        frame.add("Center",new Button("North"));

        frame.setSize(200,200);
        frame.setVisible(true);

    }

}
