import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s0017 extends JFrame{

    private Container c;
    JButton bot[]=new JButton[10];
    JButton bot_dt=new JButton(".");
    JButton bot_a=new JButton("+");
    JButton bot_s=new JButton("-");
    JButton bot_m=new JButton("*");
    JButton bot_d=new JButton("/");
    JButton bot_e=new JButton("=");
    JButton bot_AC=new JButton("AC");
    JButton bot_sqrt=new JButton("sqrt");
    JButton bot_PI=new JButton("PI");
    JButton bot_exit=new JButton("EXIT");

    double A=0, B=0;
    int op=0,dot=0;

    JTextField txt;
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 5, 3));
    private JPanel jPane2 = new JPanel(new GridLayout(4, 3, 5, 3));




    public s0017(){
        init();
    }
    private  void init(){
        int i;
        for (i=0;i<10;i=i+1)
        {
            bot[i]=new JButton(Integer.toString(i));
        }
        txt=new JTextField(10);
        txt.setEditable(false);//設定成不能修改
        c=getContentPane();
        c.setLayout(new BorderLayout());//設定為用Borderlayout
        jpl.setLayout(new GridLayout(4,4));//設定為用gridlayout
        c.add(jPane2,BorderLayout.NORTH);
        jPane2.add(txt);
        c.add(jpl,BorderLayout.CENTER);
        //注意加入元件的順序
        for (i=0;i<10;i=i+1)
        {
            bot[i].setFont(new Font(null,Font.BOLD,40));
            jpl.add(bot[i]);
            bot[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i;
                    JButton tmpjbn =(JButton) e.getSource();
                    for (i=0;i<10;i=i+1)
                    {
                        if (tmpjbn==bot[i])
                        {
                            txt.setText(txt.getText()+Integer.toString(i));
                            A=Double.parseDouble(txt.getText());
                        }
                    }
                }
            });
        }
        jpl.add(bot_dt);
        bot_dt.setFont(new Font(null,Font.BOLD,40));
        bot_dt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_dt)
                {
                    txt.setText(txt.getText()+".");
                    dot=1;
                }
            }
        });
        jpl.add(bot_a);
        bot_a.setFont(new Font(null,Font.BOLD,40));
        bot_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_a)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=1;//add
                    dot=0;
                }
            }
        });
        jpl.add(bot_s);
        bot_s.setFont(new Font(null,Font.BOLD,40));
        bot_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_s)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=2;//減
                    dot=0;
                }
            }
        });
        jpl.add(bot_m);
        bot_m.setFont(new Font(null,Font.BOLD,40));
        bot_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_m)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=3;//乘
                    dot=0;
                }
            }
        });
        jpl.add(bot_d);
        bot_d.setFont(new Font(null,Font.BOLD,40));
        bot_d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_d)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=4;//除
                    dot=0;
                }
            }
        });
        jpl.add(bot_e);
        bot_e.setFont(new Font(null,Font.BOLD,40));
        bot_e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_e)
                {
                    txt.setText("=");
                    if (op==0) A=B;
                    else if (op==1) A=B+A;
                    else if (op==2) A=B-A;
                    else if (op==3) A=B*A;
                    else if (op==4) A=B/A;
                    txt.setText(Double.toString(A));
                    dot=0;
                }
            }
        });
        jpl.add(bot_AC);
        bot_AC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("");
                A=0;
                B=0;
            }
        });
        jpl.add(bot_sqrt);
        bot_sqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               txt.setText(Double.toString(Math.sqrt(Double.parseDouble(txt.getText()))));
            }
        });
        jpl.add(bot_PI);
        bot_PI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               txt.setText(Double.toString(A*Math.PI));
            }
        });
        jpl.add(bot_exit);

        setSize(600,480);

    }
}
