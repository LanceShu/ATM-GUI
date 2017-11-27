package Main.View;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {

    public static void ATMGUI(){

        //主布局;
        Frame bodyFrame = new Frame("ATM");
        //设置主布局的布局格式;
        bodyFrame.setLayout(new BorderLayout());

        //左边的布局;
        Panel leftFrame = new Panel();
        //左边布局功能的布局格式;
        leftFrame.setLayout(new BorderLayout());
        //转帐按钮;
        Button bt1 = new Button("转帐");
        //转帐按钮的大小;
        bt1.setPreferredSize(new Dimension(150,80));
        //转帐按钮的颜色;
        bt1.setBackground(Color.gray);
        //查询余额按钮;
        Button bt2 = new Button("查询余额");
        //查询余额按钮的大小;
        bt2.setPreferredSize(new Dimension(150,80));
        //查询余额按钮的颜色;
        bt2.setBackground(Color.gray);
        //按钮在布局中的位置;
        leftFrame.add(bt1,BorderLayout.NORTH);
        leftFrame.add(bt2,BorderLayout.SOUTH);

        //右边的布局;
        Panel rightFrame = new Panel();
        //右边布局的布局格式;
        rightFrame.setLayout(new BorderLayout());
        //取款按钮；
        Button bt3 = new Button("取款");
        //取款按钮的大小；
        bt3.setPreferredSize(new Dimension(150,80));
        //取款按钮的颜色；
        bt3.setBackground(Color.gray);
        //存款按钮;
        Button bt4 = new Button("存款");
        //存款按钮的大小；
        bt4.setPreferredSize(new Dimension(150,80));
        //存款按钮的颜色；
        bt4.setBackground(Color.gray);
        //按钮在布局中的位置；
        rightFrame.add(bt3,BorderLayout.NORTH);
        rightFrame.add(bt4,BorderLayout.SOUTH);

        //中间显示内容部分;
        TextField area = new TextField(20);
        area.setPreferredSize(new Dimension(200,400));

        bodyFrame.add(leftFrame,BorderLayout.WEST);
        bodyFrame.add(rightFrame,BorderLayout.EAST);
        bodyFrame.add(area,BorderLayout.CENTER);

        bodyFrame.setSize(600,400);
        bodyFrame.setVisible(true);

        bodyFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
