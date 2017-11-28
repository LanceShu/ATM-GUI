package Main.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuView {

    public static void ATMGUI(){

        //主布局;
        JFrame bodyFrame = new JFrame("ATM");
        bodyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置主布局的布局格式;
        bodyFrame.setLayout(new BorderLayout());

        //左边的布局;
        JPanel leftFrame = new JPanel();
        //左边布局功能的布局格式;
        leftFrame.setLayout(new BorderLayout());
        //转帐按钮;
        JButton bt1 = new JButton("转帐");
        bt1.setBorderPainted(false);
        //转帐按钮的大小;
        bt1.setPreferredSize(new Dimension(150,140));
        //转帐按钮的颜色;
        //查询余额按钮;
        JButton bt2 = new JButton("查询余额");
        bt1.setBorderPainted(false);
        //查询余额按钮的大小;
        bt2.setPreferredSize(new Dimension(150,140));
        //查询余额按钮的颜色;
        //按钮在布局中的位置;
        leftFrame.add(bt1,BorderLayout.NORTH);
        leftFrame.add(bt2,BorderLayout.SOUTH);

        //右边的布局;
        JPanel rightFrame = new JPanel();
        //右边布局的布局格式;
        rightFrame.setLayout(new BorderLayout());
        //取款按钮；
        JButton bt3 = new JButton("取款");
        bt1.setBorderPainted(false);
        //取款按钮的大小；
        bt3.setPreferredSize(new Dimension(150,140));
        //取款按钮的颜色；
        //存款按钮;
        JButton bt4 = new JButton("存款");
        //存款按钮的大小；
        bt4.setPreferredSize(new Dimension(150,140));
        bt1.setBorderPainted(false);
        //存款按钮的颜色；
        //按钮在布局中的位置；
        rightFrame.add(bt3,BorderLayout.NORTH);
        rightFrame.add(bt4,BorderLayout.SOUTH);

        //中间显示内容部分;
        JTextField area = new JTextField(20);
        area.setPreferredSize(new Dimension(200,300));

        bodyFrame.add(leftFrame,BorderLayout.WEST);
        bodyFrame.add(rightFrame,BorderLayout.EAST);
        bodyFrame.add(area,BorderLayout.CENTER);

        bodyFrame.setSize(600,300);
        bodyFrame.setVisible(true);

    }
}
