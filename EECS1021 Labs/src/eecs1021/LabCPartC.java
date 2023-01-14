package eecs1021;
import UsefulClasses.MathVector;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LabCPartC {

    private static int[] parselst(String s) {
        String[] arr = s.split("\\s+");
        int len = arr.length;
        int[] outputlst = new int[len];

        for (int i = 0; i < len; i++){
            outputlst[i] = Integer.parseInt(arr[i]);
        }
        return outputlst;
    }

    public static void main(String args[]){

        JFrame jf = new JFrame("Vector Input"); // or JFrame()
        jf.setSize(800, 600); // width, height in pixels (required)
        jf.setVisible(true); // (required)
        jf.setTitle("Vector Input");
        jf.setLocation(50, 100); // x and y from upper-left corner
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel l1 = new JLabel("Enter Vector 1:");
        l1.setBounds(50,50, 200,30);

        JTextField t1,t2;
        t1=new JTextField();
        t1.setBounds(50,80, 200,30);

        JCheckBox r1 = new JCheckBox("Random");
        r1.setBounds(250,80, 80,30);
        JCheckBox f1 = new JCheckBox("Filled");
        f1.setBounds(350,80, 60,30);


        JLabel l2 = new JLabel("Enter Vector 2:");
        l2.setBounds(50,120, 200,30);

        t2=new JTextField();
        t2.setBounds(50,150, 200,30);

        JCheckBox r2 = new JCheckBox("Random");
        r2.setBounds(250,150, 80,30);
        JCheckBox f2 = new JCheckBox("Filled");
        f2.setBounds(350,150, 60,30);

        JButton button = new JButton();
        button.setText("GO!");
        button.setBounds(50,250, 200,30);
        panel.add(l1);
        panel.add(t1);
        panel.add(r1);
        panel.add(f1);
        panel.add(l2);
        panel.add(t2);
        panel.add(r2);
        panel.add(f2);
        panel.add(button);
        jf.add(panel);

        JLabel lr1 = new JLabel("Size");
        lr1.setBounds(440,80, 50,30);

        JTextField tr1;
        tr1 = new JTextField();
        tr1.setBounds(470,80, 80,30);

        JLabel lf1 = new JLabel("Value");
        lf1.setBounds(570,80, 50,30);

        JTextField tf1;
        tf1 = new JTextField();
        tf1.setBounds(610,80, 80,30);


        JLabel lr2 = new JLabel("Size");
        lr2.setBounds(440,150, 50,30);

        JTextField tr2;
        tr2 = new JTextField();
        tr2.setBounds(470,150, 80,30);

        JLabel lf2 = new JLabel("Value");
        lf2.setBounds(570,150, 50,30);

        JTextField tf2;
        tf2 = new JTextField();
        tf2.setBounds(610,150, 80,30);

        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(lr1);
                panel.add(tr1);

                panel.revalidate();
                panel.repaint();
            }
        });

        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(lr2);
                panel.add(tr2);

                panel.revalidate();
                panel.repaint();
            }
        });


        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(lr1);
                panel.add(tr1);

                panel.add(lf1);
                panel.add(tf1);

                panel.revalidate();
                panel.repaint();
            }
        });

        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(lr2);
                panel.add(tr2);

                panel.add(lf2);
                panel.add(tf2);

                panel.revalidate();
                panel.repaint();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = t1.getText();
                String s2 = t2.getText();

                MathVector vec1; MathVector vec2;

                if (r1.isSelected()){
                    vec1 = MathVector.random(Integer.parseInt(tr1.getText()), 0, 10);
                }
                else if (f1.isSelected()){
                     vec1 = MathVector.filled(Integer.parseInt(tr1.getText()), Integer.parseInt(tf1.getText()));
                }
                else {
                     vec1 = new MathVector(parselst(s1));
                }

                if (r2.isSelected()){
                     vec2 = MathVector.random(Integer.parseInt(tr2.getText()), 0, 10);
                }
                else if (f2.isSelected()){
                     vec2 = MathVector.filled(Integer.parseInt(tr2.getText()), Integer.parseInt(tf2.getText()));
                }
                else {
                     vec2 = new MathVector(parselst(s2));
                }

                MathVector additionresultObject = vec1.add(vec2);
                double mag1 = vec1.magnitude();
                double mag2 = vec2.magnitude();

                int valueAt2ndPosition = -100000;
                valueAt2ndPosition = vec1.at(1);

                JFrame oF = new JFrame("Vector Output");
                oF.pack();
                oF.setSize (new Dimension (500, 500));
                oF.setVisible(true);

                JPanel op = new JPanel();
                op.setLayout(null);
                oF.add(panel);


                System.out.println("The first vector is: " + vec1.toString());
                System.out.println("The second vector is: " + vec2.toString());

                System.out.println("The sum of the two vectors is: " + additionresultObject.toString());
                System.out.println("The magnitude of vector 1 is " + mag1 + " and the magnitude of vector 2 is " + mag2);

                System.out.println("The second value in the first vector is " + valueAt2ndPosition);
            }
        });
    }
}
