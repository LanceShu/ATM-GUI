package Main.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuView {

    /**
     * ATM机的功能界面
     * */
    private static JFrame frame;

    public MenuView(){

        /**
         * 字体的样式
         * */
        Font font = new Font("黑体",Font.PLAIN,20);
        /**
         * 初始化GUI界面；
         * 大小为600*540
         * */
        frame = new JFrame("欢迎使用ATM机");
        frame.setSize(600,540);

        /**
         * 界面的背景图案；
         * 背景图片大小为600*600
         * */
        ImageIcon imageIcon = new ImageIcon("E:/Java/ATM/back.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600
                ,600,Image.SCALE_DEFAULT));

        /**
         * 标签显示区；
         * */
        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        /**
         * 内容显示部分；
         * 显示边框为450*150
         * */
        JTextField content = new JTextField();
        content.setText("欢迎使用ATM机");
        content.setBounds(60,60,450,150);
        content.setFont(new Font("黑体",Font.PLAIN,24));

        /**
         * 存款按钮;
         * */
        JButton deposit = new JButton("存款");
        deposit.setFont(font);
        deposit.setBounds(80,240,150,50);

        /**
         * 取款按钮;
         * */
        JButton draw = new JButton("取款");
        draw.setFont(font);
        draw.setBounds(340,240,150,50);

        /**
         * 查询按钮;
         * */
        JButton query = new JButton("查询余额");
        query.setFont(font);
        query.setBounds(80,320,150,50);

        /**
         * 退出按钮;
         * */
        JButton exit = new JButton("注销");
        exit.setFont(font);
        exit.setBounds(340,320,150,50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choose = JOptionPane.showConfirmDialog(null
                        ,"是否确认注销该用户？"
                        ,"温馨提示："
                        ,JOptionPane.YES_NO_OPTION);
                System.out.println(choose);
                if(choose == 0){
                    new MainView();
                    frame.dispose();
                }
            }
        });

        /**
         * 显示区添加元素；
         * */
        label.add(content);
        label.add(deposit);
        label.add(draw);
        label.add(query);
        label.add(exit);
        /**
         * 主框架添加显示区；
         * 使主框架可显示出来
         * 并且主框架能进行关闭设置；
         * */
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,100);
    }

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
    }
}
