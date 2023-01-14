package UsefulClasses;

import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class keyLis implements KeyListener {
    private	final Pin xservomotor;
    private	final Pin yservomotor;
    private	final JButton upbut;
    private	final JButton downbut;
    private	final JButton leftbut;
    private	final JButton rightbut;


    public keyLis(Pin xservomotor, Pin yservomotor, JButton upbut, JButton downbut, JButton leftbut, JButton rightbut){
        this.xservomotor = xservomotor;
        this.yservomotor = yservomotor;
        this.upbut = upbut;
        this.downbut = downbut;
        this.leftbut = leftbut;
        this.rightbut = rightbut;

    }

    public void keyPressed (KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_UP){
            upbut.setBackground(Color.yellow);
            try {
                yservomotor.setValue(20);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downbut.setBackground(Color.yellow);
            try {
                yservomotor.setValue(80);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftbut.setBackground(Color.yellow);
            try {
                xservomotor.setValue(90);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightbut.setBackground(Color.yellow);
            try {
                xservomotor.setValue(30);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    public void keyReleased (KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_UP){
            upbut.setBackground(Color.white);
            try {
                yservomotor.setValue(47);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downbut.setBackground(Color.white);
            try {
                yservomotor.setValue(47);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftbut.setBackground(Color.white);
            try {
                xservomotor.setValue(55);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightbut.setBackground(Color.white);
            try {
                xservomotor.setValue(55);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void keyTyped (KeyEvent e){}

}
