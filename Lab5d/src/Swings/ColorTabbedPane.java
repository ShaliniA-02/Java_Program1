package Swings;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;
public class ColorTabbedPane {
JFrame f;
ColorTabbedPane(){
f=new JFrame();
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
p1.setBackground(Color.CYAN);
p2.setBackground(Color.MAGENTA);
p3.setBackground(Color.YELLOW);
JTabbedPane tp=new JTabbedPane();
tp.setBounds(70,70,250,250);
tp.add("CYAN",p1);
tp.add("MAGENTA",p2);
tp.add("YELLOW",p3);
tp.addChangeListener(new ChangeListener(){
public void stateChanged(ChangeEvent e){
int i=tp.getSelectedIndex();
String t=tp.getTitleAt(i);
System.out.println("Selected Color is: "+t);
}
});
f.add(tp);
f.setSize(450,450);
f.setLayout(null);
f.setVisible(true);
}
public static void main(String[] args){
new ColorTabbedPane();
}
}