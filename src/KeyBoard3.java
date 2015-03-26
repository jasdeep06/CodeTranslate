
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Simple swing based typing tutor using frame
 * @author
 * @date 
 */
public class KeyBoard3 extends JFrame implements KeyListener
{  
//Individual keyboard rows  
String firstRow[] = {"इंटरफ़ेस","लॉन्ग","नया","अमान्य","पैकेज","निजी","संरक्षित","सार्वजनिक","वापस","शार्ट","स्थिर","सुपर","बदल","Rub"};//BackSpace
String secondRow[] = {"Tab","श्रंखला","यह","फेंक","फेंकता","क्षणिक","कोशिश","सच","ख़ाली","जबतक","लेंग","बुलियन","सार","तोड़"};
String thirdRow[] = {"Caps","इसपर_अक्षर","तुलना_इससे","जोड़ो","शामिल_है","अंत_में","क्रमांक","लम्बाई","इसका_आखरी_क्रमांक","इसका_पहला_क्रमांक","की_जगह","अनुशृंखला","Enter"};
String fourthRow[] = {"Shift","शृंखला_में","जाँचक","व्यवस्था.में","अगला_है","अगली_पंक्ति","अगला_पूर्णांक","घात","वर्गमूल","जावा.","यूटिल","Shift"   };
String fifthRow[]={"      " ,"<" ,"\\/",">" };
//Jbuttons corresponting to each individual rows 
JButton first[];
JButton second[];

JButton third[];

JButton fourth[];
static KeyBoard3 keyboard=new KeyBoard3();



@Override
public void keyTyped(KeyEvent e) {
	
}
@Override
public void keyPressed(KeyEvent e) {
	char ch=e.getKeyChar();
	if(ch=='q'||ch=='Q'){
		keyboard.second[1].setBackground(Color.PINK);
		second[1].setOpaque(true);
		second[1].setBorderPainted(false);
	

		}
}
@Override
public void keyReleased(KeyEvent e) {
	char ch=e.getKeyChar();
	if(ch=='q'||ch=='Q'){
		keyboard.second[1].setBackground(new JButton().getBackground());
		second[1].setOpaque(true);
		second[1].setBorderPainted(false);

}	
}
/*
 * Driver main method to start the application 
 */
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	//UIManager.setLookAndFeel(
	  //      UIManager.getCrossPlatformLookAndFeelClassName());
    //launch typing tutor
   keyboard.setVisible(true);
}
/*
 * No argument construtor to create frame
 */
public KeyBoard3()
{
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //set non resizable 
    this.setResizable(true);
    //super.setSize(500,300);
    //set size of the content pane ie frame
    this.getContentPane().setPreferredSize(new Dimension(1000,300));
    //super.getContentPane().setSize(800,400);
    //set location for the frame 
    this.setLocation(200,600);
    this.addKeyListener(this);

    //init and paint frame 
    initWidgets();
}

private void initWidgets()
{
	//panel for keyboard
	JPanel jpKeyboard = new JPanel();
	
	 add(jpKeyboard, BorderLayout.SOUTH);
	 //layout for keyboard 
	    jpKeyboard.setLayout(new GridLayout(5,1));
	    //pack the components
	    pack();
	 /*paint first keyboard row  and add it to the keyboard*/
    first = new JButton[firstRow.length];
    //get the panel for the  row
    JPanel p = new JPanel(new GridLayout(1, firstRow.length));
    for(int i = 0; i < firstRow.length; ++i) 
    {
        JButton b= new JButton(firstRow[i]);

        b.setPreferredSize(new Dimension(100,50));
        first[i] = b;
        first[i].setFont(new Font("Helvetica", Font.PLAIN, 16));

        p.add(first[i]);
    }
    jpKeyboard.add(p);
    /*paint second keyboard row  and add it to the keyboard*/
    second = new JButton[secondRow.length];
    //get the panel for the  row
    p = new JPanel(new GridLayout(1, secondRow.length));
    for(int i = 0; i < secondRow.length; ++i) 
    {
        second[i] = new JButton(secondRow[i]);
        second[i].setFont(new Font("Helvetica", Font.PLAIN, 16));

       
        p.add(second[i]);

    }
    jpKeyboard.add(p);

    /*paint third keyboard row  and add it to the keyboard*/

    third = new JButton[thirdRow.length];
    //get the panel for the  row
    p = new JPanel(new GridLayout(1, thirdRow.length));
    for(int i = 0; i < thirdRow.length; ++i)
    {
        third[i] = new JButton(thirdRow[i]);
        third[i].setFont(new Font("HEVELETICA", Font.PLAIN, 16));
        

        p.add(third[i]);
    }
    jpKeyboard.add(p);

    /*paint fourth keyboard row  and add it to the keyboard*/
    fourth = new JButton[fourthRow.length];
    //get the panel for the  row
    p = new JPanel(new GridLayout(1, fourthRow.length));
    for(int i = 0; i < fourthRow.length; ++i)
    {
        fourth[i] = new JButton(fourthRow[i]);
        fourth[i].setFont(new Font("Helvetica", Font.PLAIN, 16));

        p.add(fourth[i]);
        if(i==fourthRow.length-2)
            p.add(new JPanel());

    }
    p.add(new JPanel());
    jpKeyboard.add(p);
    


}



}


