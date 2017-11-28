package Main.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuView {

    private static JFrame frame;

    public MenuView(){
        Font font = new Font("黑体",Font.PLAIN,20);
        frame = new JFrame("欢迎使用ATM机");
        frame.setSize(600,540);

        ImageIcon imageIcon = new ImageIcon("E:/Java/ATM/back.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600
                ,600,Image.SCALE_DEFAULT));

        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        JTextField content = new JTextField();
        content.setText("欢迎使用ATM机");
        content.setBounds(60,60,450,150);
        content.setFont(new Font("黑体",Font.PLAIN,24));

        //存款按钮;
        JButton deposit = new JButton("存款");
        deposit.setFont(font);
        deposit.setBounds(80,240,150,50);

        //取款按钮;
        JButton draw = new JButton("取款");
        draw.setFont(font);
        draw.setBounds(340,240,150,50);

        //查询按钮;
        JButton query = new JButton("查询余额");
        query.setFont(font);
        query.setBounds(80,320,150,50);

        //查询按钮;
        JButton exit = new JButton("退出");
        exit.setFont(font);
        exit.setBounds(340,320,150,50);

        label.add(content);
        label.add(deposit);
        label.add(draw);
        label.add(query);
        label.add(exit);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,100);
    }

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
    }
}
