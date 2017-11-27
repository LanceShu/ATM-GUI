package Main.View;

import java.awt.*;

public class GUI {

    public static void ATMGUI(){

        Frame bodyFrame = new Frame("ATM");
        bodyFrame.setLayout(new BorderLayout());

        //左边的布局;
        Panel leftFrame = new Panel();
        leftFrame.setLayout(new BorderLayout());
        //转帐按钮;
        Button bt1 = new Button("转帐");
        bt1.setSize(300,200);
        //查询余额按钮;
        Button bt2 = new Button("查询余额");
        bt2.setSize(300,200);
        leftFrame.add(bt1,BorderLayout.NORTH);
        leftFrame.add(bt2,BorderLayout.SOUTH);

        //右边的布局;
        Panel rightFrame = new Panel();
        rightFrame.setLayout(new BorderLayout());
        //取款按钮；
        Button bt3 = new Button("取款");
        bt3.setSize(300,200);
        //存款按钮;
        Button bt4 = new Button("存款");
        bt4.setSize(300,200);
        rightFrame.add(bt3,BorderLayout.NORTH);
        rightFrame.add(bt4,BorderLayout.SOUTH);

        //中间显示内容部分;
        TextArea area = new TextArea("显示部分");

        bodyFrame.add(leftFrame,BorderLayout.WEST);
        bodyFrame.add(rightFrame,BorderLayout.EAST);
        bodyFrame.add(area,BorderLayout.CENTER);

        bodyFrame.setSize(600,300);
        bodyFrame.setVisible(true);

    }
}
