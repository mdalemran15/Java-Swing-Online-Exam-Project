import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopUpProject1 extends JFrame implements ActionListener
{
    JLabel label;
    ButtonGroup bgrp;
    JRadioButton jrb[]=new JRadioButton[5];
    JButton jb1,jb2,jb3;
    int score=0,current=0;
    
    TopUpProject1(String s)
    {
        super(s);
        label=new JLabel();
        add(label);
        bgrp=new ButtonGroup();
        
        for(int i=0;i<5;i++) //ADD RADIOBUTTON GROUPS
        {
            jrb[i]=new JRadioButton(); 
            add(jrb[i]);
            bgrp.add(jrb[i]);
        }                    
                
        jb1=new JButton("Next");
        jb2=new JButton("Result");
        jb3=new JButton("Previous");
        jb2.setEnabled(false);
        jb3.setEnabled(false);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        add(jb1);add(jb2); add(jb3);
        
        disp();

        jb1.setBounds(50,270,100,30);
        jb2.setBounds(350,270,100,30);
        jb3.setBounds(200,270,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(150,100);
        setVisible(true);
        setSize(550,400);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jb1)
        {
            
            if(check())
                score=score+1;
            current++;
            disp(); 
            if(current==9)
            {
                jb1.setEnabled(false);
                jb2.setEnabled(true);

            }
             if(current<9)
            {
                jb1.setEnabled(true);
                jb2.setEnabled(false);

            }
             
             
        }
        
        if(current >=1){
          jb3.setEnabled(true);
        }
        
        
         if(e.getActionCommand().equals("Previous"))
        {
             jb2.setEnabled(false);
          if(score==0){
             score=0; 
          }
          else{
            score--;
          }
  
          current--;
             
             disp();
             if(current<9){
            jb1.setEnabled(true);   
        }
             if(current<=0)
            {
                jb3.setEnabled(false);

            }
            
        }
        
        
        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                score=score+1;
            
            current++;
            if(score==10){
                JOptionPane.showMessageDialog(this,"Congratulations! you scored 100%");
            }
            else{
                JOptionPane.showMessageDialog(this,"You got "+score+" answers correct.");
            }
            System.exit(0);
        }
        
       
    }
    
    
    public void disp()//*CALL THIS METHOD TO GENEREATE QUESTIONS******
    {
        jrb[4].setSelected(true); //this button is always selected but not shown in the frame.
        if(current==0)
        {
            label.setText("Question1:  Which one among these is not a primitive datatype?");
            jrb[0].setText("int");
            jrb[1].setText("Float");
            jrb[2].setText("boolean");
            jrb[3].setText("char"); 
        }
        if(current==1)
        {
            label.setText("Question2:  Which class is available to all the class automatically?");
            jrb[0].setText("Swing");
            jrb[1].setText("Applet");
            jrb[2].setText("Object");
            jrb[3].setText("ActionEvent");
        }
        if(current==2)
        {
            label.setText("Question3:  Which package is directly available to our class without importing it?");
            jrb[0].setText("swing");
            jrb[1].setText("applet");
            jrb[2].setText("net");
            jrb[3].setText("lang");
        }
        if(current==3)
        {
            label.setText("Question4:  String class is defined in which package?");
            jrb[0].setText("lang");
            jrb[1].setText("Swing");
            jrb[2].setText("Applet");
            jrb[3].setText("awt");
        }
        if(current==4)
        {
            label.setText("Question5:  Which institute is best for java coaching?");
            jrb[0].setText("Utek");
            jrb[1].setText("Aptech");
            jrb[2].setText("SSS IT");
            jrb[3].setText("jtek");
        }
        if(current==5)
        {
            label.setText("Question6:  Which one among these is not a keyword?");
            jrb[0].setText("class");
            jrb[1].setText("int");
            jrb[2].setText("get");
            jrb[3].setText("if");
        }
        if(current==6)
        {
            label.setText("Question7:  Which one among these is not a class? ");
            jrb[0].setText("Swing");
            jrb[1].setText("Actionperformed");
            jrb[2].setText("ActionEvent");
            jrb[3].setText("Button");
        }
        if(current==7)
        {
            label.setText("Question8:  which one among these is not a function of Object class?");
            jrb[0].setText("toString");
            jrb[1].setText("finalize");
            jrb[2].setText("equals");
            jrb[3].setText("getDocumentBase");  
        }
        if(current==8)
        {
            label.setText("Question9:  which function is not present in Applet class?");
            jrb[0].setText("init");
            jrb[1].setText("main");
            jrb[2].setText("start");
            jrb[3].setText("destroy");
        }
        if(current==9)
        {
            label.setText("Question10:  Which one among these is not a valid component?");
            jrb[0].setText("JButton");
            jrb[1].setText("JList");
            jrb[2].setText("JButtonGroup");
            jrb[3].setText("JTextArea");
        }
        label.setBounds(30,40,475,20);
        for(int i=0,j=0;i<=105;i+=35,j++)
            jrb[j].setBounds(50,80+i,200,20);
    }                                                           
    
    
    public boolean check()//CHECKS IF THE CORRECT ANSWER IS SELECTED******
    {
        if(current==0) return(jrb[1].isSelected());
        if(current==1) return(jrb[2].isSelected());
        if(current==2) return(jrb[3].isSelected());
        if(current==3) return(jrb[0].isSelected());
        if(current==4) return(jrb[2].isSelected());
        if(current==5) return(jrb[2].isSelected());
        if(current==6) return(jrb[1].isSelected());
        if(current==7) return(jrb[3].isSelected());
        if(current==8) return(jrb[1].isSelected());
        if(current==9) return(jrb[2].isSelected());
        return false;
    }                                                          
    
    
    public static void main(String s[])
    {
        new TopUpProject1("Java Exam System with SWING");
    }
}

