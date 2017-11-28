package Main.View;

import javax.swing.*;
import java.awt.*;

public class Main {

    //主框架;
    private static JFrame bodyFrame;

    public static void main(String[] args) {

    }

    private static void MainView(){

        Font font = new Font("黑体",Font.PLAIN,20);

        bodyFrame = new JFrame("ATM登录界面");
        bodyFrame.setSize(600,600);

        ImageIcon imageIcon = new ImageIcon("E:/alback.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()
                ,imageIcon.getIconHeight(),Image.SCALE_DEFAULT));

        JLabel label1 = new JLabel();
        label1.setIcon(imageIcon);
    }
}
