import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.color.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;



public class Display extends JFrame implements KeyListener  {
    
	
static JTextArea  text = new JTextArea(30,150);
	
	static int i=0;
	int fileToSave;
	int fileToSubmit;
	JFileChooser fileSubmit;
	JFileChooser fileSave;
	static String path;

	
static KeyBoard keyboard1=new KeyBoard();
static KeyBoard2 keyboard2=new KeyBoard2();
static KeyBoard3 keyboard3=new KeyBoard3();
int count=1,k=1;

	

	
private void print(){
	MenuBar menuBar = new MenuBar();
	MenuItem menutem = new MenuItem();
	
	setMenuBar(menuBar);
	Menu file = new Menu("File");
	menuBar.add(file);
	MenuItem save = new MenuItem("Save");
	file.add(save);
	getContentPane().add(text);
	text.setFocusable(true);	

	boolean b=text.requestFocusInWindow();
	//System.out.println(b);


	
	save.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			saveFile();
			if (fileToSave == JFileChooser.APPROVE_OPTION){
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
					path=fileSave.getSelectedFile().getPath();
					//System.out.println(path);
					out.write(text.getText());
					out.close();
					backEnd();
					String fileToCompile=(Display.path+".java")+java.io.File.separator ;
			String file=		fileToCompile.substring(0, fileToCompile.lastIndexOf('/'));
					JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
					int compilationResult=compiler.run(null, null, null, file);
					if(compilationResult==0){
						System.out.println("OK");
						
					}else{
						System.out.println("sorry");
					}
					String path1="file://"+path.substring(0, path.lastIndexOf('/')+1);
					URL[] url=new URL[]{new URL(path1)};
					//System.out.println("Class has ");

					URLClassLoader ucl = new URLClassLoader(url);
					//System.out.println("Class has been");

					Class clazz = ucl.loadClass("k");
					//System.out.println("Class has been successfully loaded");
					Method method = clazz.getDeclaredMethod("main", null);
					Class<?> cls = Class.forName("k", true, ucl);
					Object object = clazz.newInstance();
					method.invoke(object, null);
				
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	});
		 
JPanel jpCenter = new JPanel();
		//set the text area on top 
	 
   add( jpCenter, BorderLayout.CENTER);
	  
  //text.setPreferredSize(new Dimension(800,400));

	  
  jpCenter.add(text);
	   
 jpCenter.setLayout( new BorderLayout());
	  
  jpCenter.add(text, BorderLayout.WEST);
	   
 jpCenter.add(text, BorderLayout.CENTER);
 text.setFont(new Font("Helvetica",Font.PLAIN,15));
	 
   text.addKeyListener(this);
	   

	 
   pack();
	    
setVisible(true);

/*text.requestFocus();
addWindowListener(new WindowAdapter(){ 
	  public void windowOpened( WindowEvent e){ 
	    text.requestFocus();
	  } 
	}); */
	    

		
	
}
	
	
public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException
{
Display obj=new Display();


	obj.print();
	keyboard1.setVisible(true);
	
		
//KeyBoard.main(args);
//Process p=Runtime.getRuntime().exec(path+".java");
//System.out.println(obj.path);
}
	

	
@Override
	public void keyTyped(KeyEvent e) {

		char ch=e.getKeyChar();
if(ch=='='){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ऋ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ऋ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("बदल");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("बदल", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='-'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("अः");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("अः", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("सुपर");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("सुपर", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='0'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("अं");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("अं", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("स्थिर");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("स्थिर", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='9'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("औ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("औ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("शार्ट");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("शार्ट", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='8'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ओ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ओ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("वापस");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("वापस", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='7'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ऐ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ऐ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("सार्वजनिक");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("सार्वजनिक", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='6'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ए");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ए", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("संरक्षित");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("संरक्षित", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='5'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ऊ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ऊ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("निजी");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("निजी", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='4'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("उ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("उ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("पैकेज");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("अमान्य", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='3'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("ई");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("ई", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("अमान्य");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("अमान्य", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
if(ch=='2'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("इ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("इ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("नया");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("नया", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
		if(ch=='1'){
			
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("आ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("आ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("लॉन्ग");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("लॉन्ग", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}
		
		
		
		if(ch=='`'){
		
			if(count==2){
				if(text.getCaretPosition()==text.getText().length()){
					
					text.append("अ");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("अ", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("इंटरफ़ेस");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("इंटरफ़ेस", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}

		
if(ch=='q'){
if(count==1)
{
if(text.getCaretPosition()==text.getText().length()){
			
text.append("क");


			
e.consume();
			
			
}

			
else{
				
text.insert("क", text.getCaretPosition());
			
e.consume();
			
}}
if(count==2){
	if(text.getCaretPosition()==text.getText().length()){
		
		text.append("र");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("र", text.getCaretPosition());
					
		e.consume();
					
		}
	
}
if(count==3){
if(text.getCaretPosition()==text.getText().length()){
		
		text.append("श्रंखला");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("श्रंखला", text.getCaretPosition());
					
		e.consume();
					
		}
	
}

		
}

else
/*if(ch=='w'){
			
if(text.getCaretPosition()==text.getText().length()){
			try {
				//System.out.println(text.getText(text.getCaretPosition()-1, text.getCaretPosition()));
				if(text.getText(text.getCaretPosition()-1, text.getCaretPosition()).equals("क")){
				
					text.replaceRange("ख", text.getCaretPosition()-1, text.getCaretPosition());
					
					e.consume();
					
				}
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//text.append("ख");
			
//e.consume();
			
			
}
			
else{
				
text.insert("ख", text.getCaretPosition());
			
e.consume();

}
}*/
	if(ch=='w'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ख");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ख", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("ल");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("ल", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
			if(text.getCaretPosition()==text.getText().length()){
					
					text.append("यह");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("यह", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}

					
			}

				
		
else
if(ch=='e'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("ग");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("ग", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("व");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("व", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("फेंक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("फेंक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}

		
}
else
if(ch=='r'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("घ");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("घ", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("स");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("स", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("फेंकता");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("फेंकता", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}

		
}
else
if(ch=='t'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("ङ");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("ङ", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("श");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("श", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("क्षणिक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("क्षणिक", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}
	
}
else
if(ch=='y'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("च");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("च", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("ष");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("ष", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("कोशिश");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("कोशिश", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}

}
else
if(ch=='u'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("छ");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("छ", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("ह");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("ह", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("सच");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("सच", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}
}
else
if(ch=='i'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("ज");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("ज", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("क्ष");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("क्ष", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("ख़ाली");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("ख़ाली", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}

}
else
if(ch=='o'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("झ");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("झ", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("त्र");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("त्र", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("जबतक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("जबतक", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}

}
else
if(ch=='p'){
			
	if(count==1)
	{
	if(text.getCaretPosition()==text.getText().length()){
				
	text.append("ञ");


				
	e.consume();
				
				
	}

				
	else{
					
	text.insert("ञ", text.getCaretPosition());
				
	e.consume();
				
	}}
	if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
			
			text.append("ज्ञ");


						
			e.consume();
						
						
			}

						
			else{
							
			text.insert("ज्ञ", text.getCaretPosition());
						
			e.consume();
						
			}
		
	}
	if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
				
				text.append("लेंग");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("लेंग", text.getCaretPosition());
							
				e.consume();
							
				}
			
	}

}
else
	if(ch=='['){
		if(count==2){
if(text.getCaretPosition()==text.getText().length()){
				
				text.append("{");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("{", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
if(text.getCaretPosition()==text.getText().length()){
				
				text.append("बुलियन");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("बुलियन", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
	}
	else
		if(ch==']'){
			if(count==2){
	if(text.getCaretPosition()==text.getText().length()){
					
					text.append("}");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("}", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
			if(count==3){
	if(text.getCaretPosition()==text.getText().length()){
					
					text.append("सार");


								
					e.consume();
								
								
					}

								
					else{
									
					text.insert("सार", text.getCaretPosition());
								
					e.consume();
								
					}
				
			}
		}
		else
			if(ch=='\\'){
				if(count==2){
		if(text.getCaretPosition()==text.getText().length()){
						
						text.append("|");


									
						e.consume();
									
									
						}

									
						else{
										
						text.insert("|", text.getCaretPosition());
									
						e.consume();
									
						}
					
				}
				if(count==3){
		if(text.getCaretPosition()==text.getText().length()){
						
						text.append("तोड़");


									
						e.consume();
									
									
						}

									
						else{
										
						text.insert("तोड़", text.getCaretPosition());
									
						e.consume();
									
						}
					
				}
			}
else
	if(ch=='a'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ट");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ट", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("बाइट");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("बाइट", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("इसपर_अक्षर");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("इसपर_अक्षर", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
		else
		if(ch=='s'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ठ");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ठ", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("प्रकरण");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("प्रकरण", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("तुलना_इससे");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("तुलना_इससे", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
		else
		if(ch=='d'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ड");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ड", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("पकड़");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("पकड़", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("जोड़ो");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("जोड़ो", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
		else
		if(ch=='f'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ढ");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ढ", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अक्षर");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अक्षर", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("शामिल_है");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("शामिल_है", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
		else
		if(ch=='g'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ण");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ण", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("कक्षा");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("कक्षा", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अंत_में");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अंत_में", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
		else
		if(ch=='h'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("त");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("त", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("जारी");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("जारी", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("क्रमांक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("क्रमांक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		    
				
		}
					
		if(ch=='j'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("थ");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("थ", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("बाकी");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("बाकी", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("लम्बाई");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("लम्बाई", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }   
			
		else
		if(ch=='k'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("द");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("द", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("कर");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("कर", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("इसका_आखरी_क्रमांक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("इसका_आखरी_क्रमांक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='l'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ध");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ध", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("डबल");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("डबल", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("इसका_पहला_क्रमांक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("इसका_पहला_क्रमांक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		 if(ch==';'){
		    if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अन्यथा");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अन्यथा", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("की_जगह");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("की_जगह", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		 if(ch=='\''){
		    if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("विस्तार");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("विस्तार", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अनुशृंखला");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अनुशृंखला", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}}else
		if(ch=='z'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("न");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("न", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("झूठ");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("झूठ", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("शृंखला_में");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("शृंखला_में", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='x'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("प");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("प", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("निर्णायक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("निर्णायक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("जाँचक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("जाँचक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='c'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("फ");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("फ", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("फाइनली");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("फाइनली", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("व्यवस्था.में");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("व्यवस्था.में", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='v'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("ब");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("ब", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("फ्लोट");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("फ्लोट", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अगला_है");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अगला_हैं", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='b'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("भ");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("भ", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("के_लिए");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("के_लिए", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अगली_पंक्ति");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अगली_पंक्ति", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='n'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("म");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("म", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अगर");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अगर", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("अगला_पूर्णांक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("अगला_पूर्णांक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		else
		if(ch=='m'){
		if(count==1)
		{
		if(text.getCaretPosition()==text.getText().length()){
					
		text.append("य");


					
		e.consume();
					
					
		}

					
		else{
						
		text.insert("य", text.getCaretPosition());
					
		e.consume();
					
		}}
		if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("लागू");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("लागू", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}else
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("घात");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("घात", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		 }
		 if(ch==','){
		    if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("आयात");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("आयात", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("वर्गमूल");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("वर्गमूल", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}}
		else
		if(ch=='.'){
		    if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("मुख्य");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("मुख्य", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("जावा.");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("जावा.", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}}else
		if(ch=='.'){
		    if(count==2){
			if(text.getCaretPosition()==text.getText().length()){
				
				text.append("पूर्णांक");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("पूर्णांक", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}
		if(count==3){
		    if(text.getCaretPosition()==text.getText().length()){
				
				text.append("यूटिल");


							
				e.consume();
							
							
				}

							
				else{
								
				text.insert("यूटिल", text.getCaretPosition());
							
				e.consume();
							
				}
			
		}}	

if(ch=='>'){
	
	count++;
	e.consume();
}
if(ch=='<'){
	
	count--;
	e.consume();
}
if(count>3){
	count=1;
}
if(count<1){
	
	count=3;
}
if(k!=count){
if(count==1){
	keyboard1.setVisible(true);
	keyboard2.dispose();
	keyboard3.dispose();
	k=count;
}
if(count==2){
	keyboard2.setVisible(true);
	keyboard1.dispose();
	keyboard3.dispose();

	k=count;
	
}
if(count==3){
	keyboard2.dispose();
	keyboard3.setVisible(true);
	keyboard1.dispose();

	k=count;
	
}
}
}
	


	
@Override
	public void keyPressed(KeyEvent e) {
		
		}
		
@Override
	public void keyReleased(KeyEvent e) {
}
	
public void saveFile(){
	JFileChooser save = new JFileChooser();
	int option = save.showSaveDialog(this);
	fileToSave = option;
	fileSave = save;
}


	
	

public File backEnd() throws IOException
{
	String OutputPath=path+".java",k;
	File input=new File(path);
	File output=new File(OutputPath);
	output.createNewFile();
	BufferedWriter writer=new BufferedWriter(new FileWriter(output));
	Scanner scan = new Scanner(new FileReader(path));
	while (scan.hasNext())
	{
		k=scan.next();
		if(k.equals("कक्षा")){
			writer.append("class ");
		}else
			if(k.equals("सार्वजनिक")){
				writer.append("public ");
			}else
				if(k.equals("स्थिर")){
					writer.append("static ");
				}else
					if(k.equals("मुख्य")){
						writer.append("main ");
					}else
						if(k.equals("(")){
							writer.append("( ");
						}else
							if(k.equals("श्रृंखला")||k.equals("श्रंखला")){
								writer.append("String ");
								System.out.println("hi");
							}else
								if(k.equals("अ[]")){
									writer.append("args[] ");
								}else
									if(k.equals(")")){
										writer.append(") ");
									}else
										if(k.equals("{")){
											writer.append("{ ");
										}else
											if(k.equals("}")){
												writer.append("} ");
											}else
												if(k.equals("लिखो")){
													writer.append("println ");
												}else
													if((k.startsWith("\"")&&k.endsWith("\"")))
												    	 writer.append(k);
													else
													if(k.startsWith("\"")){
														String st=k+" ";
														k=scan.next();
														while((k.endsWith("\"")==false))
														{
															st=st+k+" ";
															k=scan.next();
														}
														st=st+k+" ";
														writer.append(st);
													}else
													     
														if(k.equals(";")){
															writer.append(";");
														
														}else
															if(k.length()==1){
																writer.append(k);
															
															}else
																if(k.equals("शुन्य")){
																	writer.append("void ");
																}else
																	if(k.equals("सार")){
																		writer.append("abstract ");
																	}else
																		if(k.equals("बुलियन")){
																			writer.append("boolean ");
																		}else
																			if(k.equals("तोड़")){
																				writer.append("break ");
																			}else
																				if(k.equals("बाइट")){
																					writer.append("byte ");
																				}else
																					if(k.equals("प्रकरण")){
																						writer.append("case ");
																					}else
																						if(k.equals("पकड़")){
																							writer.append("catch ");
																						}else
																							if(k.equals("अक्षर")){
																								writer.append("char ");
																							}else
																								if(k.equals("जारी")){
																									writer.append("continue ");
																								}else
																									if(k.equals("बाकी")){
																										writer.append("default ");
																									}else
																										if(k.equals("कर")){
																											writer.append("do ");
																										}else
																											if(k.equals("डबल")){
																												writer.append("double ");
																											}else
																												if(k.equals("अन्यथा")){
																													writer.append("else ");
																												}else
																													if(k.equals("विस्तार")){
																														writer.append("extends ");
																													}else
																														if(k.equals("झूठ")){
																															writer.append("false ");
																														}else
																															if(k.equals("निर्णायक")){
																																writer.append("final ");
																															}else
																																if(k.equals("फाइनली")){
																																	writer.append("finally ");
																																}else
																																	if(k.equals("फ्लोट")){
																																		writer.append("float ");
																																	}else
																																		if(k.equals("के_लिए")){
																																			writer.append("for ");
																																		}else
																																			if(k.equals("अगर")){
																																				writer.append("if ");
																																			}else
																																				if(k.equals("लागू")){
																																					writer.append("impements  ");
																																				}else
																																					if(k.equals("आयात")){
																																						writer.append("import ");
																																					}else
																																						if(k.equals("उदाहरण")){
																																							writer.append("instanceOf ");
																																						}else
																																							if(k.equals("पूर्णांक")){
																																								writer.append("int ");
																																							}else
																																								if(k.equals("इंटरफ़ेस")){
																																									writer.append("interface ");
																																								}else
																																									if(k.equals("लॉन्ग")){
																																										writer.append("long ");
																																									}else
																																										if(k.equals("नया")){
																																											writer.append("new ");
																																										}else
																																											if(k.equals("अमान्य")){
																																												writer.append("null ");
																																											}else
																																												if(k.equals("पैकेज")){
																																													writer.append("package ");
																																												}else
																																													if(k.equals("निजी")){
																																														writer.append("private ");
																																													}else
																																														if(k.equals("संरक्षित")){
																																															writer.append("protected ");
																																														}else
																																															if(k.equals("सार्वजनिक")){
																																																writer.append("public ");
																																															}else
																																																if(k.equals("वापस")){
																																																	writer.append("return ");
																																																}else
																																																	if(k.equals("शार्ट")){
																																																		writer.append("short ");
																																																	}else
																																																		if(k.equals("स्थिर")){
																																																			writer.append("static ");
																																																		}else
																																																			if(k.equals("सुपर")){
																																																				writer.append("super ");
																																																			}else
																																																				if(k.equals("बदल")){
																																																					writer.append("replace ");
																																																				}else
																																																					if(k.equals("सिंक्रनाइज़")){
																																																						writer.append("synchronise ");
																																																					}else
																																																						if(k.equals("यह")){
																																																							writer.append("this ");
																																																						}else
																																																							if(k.equals("फेंक")){
																																																								writer.append("throw ");
																																																							}else
																																																								if(k.equals("फेंकता")){
																																																									writer.append("throws ");
																																																								}else
																																																									if(k.equals("क्षणिक")){
																																																										writer.append("transient ");
																																																									}else
																																																										if(k.equals("कोशिश")){
																																																											writer.append("try ");
																																																										}else
																																																											if(k.equals("सच")){
																																																												writer.append("true ");
																																																											}else
																																																												if(k.equals("जबतक")){
																																																													writer.append("while ");
																																																												}else
																																																													if(k.equals("लेंग")){
																																																														writer.append("lang");
																																																													}else
																																																														if(k.equals("इसपर_अक्षर")){
																																																															writer.append("charAt ");
																																																														}else
																																																															if(k.equals("समान")){
																																																																writer.append("equals ");
																																																															}else
																																																																if(k.equals("जोड़ो")){
																																																																	writer.append("concat ");
																																																																}else
																																																																	if(k.equals("शामिल_है")){
																																																																		writer.append("contains ");
																																																																	}else
																																																																		if(k.equals("अंत_में")){
																																																																			writer.append("endsWith ");
																																																																		}else
																																																																			if(k.equals("क्रमांक")){
																																																																				writer.append("indexOf ");
																																																																			}else
																																																																				if(k.equals("लम्बाई")){
																																																																					writer.append("length ");
																																																																				}else
																																																																					if(k.equals("इसका_आखरी_क्रमांक")){
																																																																						writer.append("lastIndexOf ");
																																																																					}else
																																																																						if(k.equals("इसका_पहला_क्रमांक")){
																																																																							writer.append("firstIndexOf ");
																																																																						}else
																																																																							if(k.equals("की_जगह")){
																																																																								writer.append("replace ");
																																																																							}else
																																																																								if(k.equals("अनुशृंखला")){
																																																																									writer.append("substring ");
																																																																								}else
																																																																									if(k.equals("शृंखला_में")){
																																																																										writer.append("toString ");
																																																																									}else
																																																																										if(k.equals("जाँचक")){
																																																																											writer.append("Scanner ");
																																																																										}else
																																																																											if(k.equals("अगला_है")){
																																																																												writer.append("hasNext ");
																																																																											}else
																																																																												if(k.equals("अगली_पंक्ति")){
																																																																													writer.append("nextLine ");
																																																																												}else
																																																																													if(k.equals("अगला_पूर्णांक")){
																																																																														writer.append("nextInt ");
																																																																													}else
																																																																														if(k.equals("घात")){
																																																																															writer.append("pow ");
																																																																														}else
																																																																															if(k.equals("वर्गमूल")){
																																																																																writer.append("sqrt ");
																																																																															}else
																																																																																if(k.equals("जावा")){
																																																																																	writer.append("java ");
																																																																																}else
																																																																																	if(k.equals("यूटिल")){
																																																																																		writer.append("util ");
																																																																																	}else
																																																																																		if(k.equals("व्यवस्था")){
																																																																																			writer.append("System");
																																																																																		}else
																																																																																			if(k.equals("बहार")){
																																																																																				writer.append("out");
																																																																																			}else
																																																																																			if(k.equals("मे")){
																																																																																				writer.append("in");
																																																																																			}else
																																																																																				if(k.contains(".")||k.contains("\"")){
																																																																																					
																																																																																				}else
																																																																																					writer.append(k);
        int l=k.length(),r=0,j=k.lastIndexOf('.');
        String s,s1;
        for(int i=0;i<l;i++)
        {
            if(k.charAt(i)=='.')
            {
                if(i==j)
                {
                     s=k.substring(r,i);
                    	 if(s.equals("बहार")){
								writer.append("out.");
							}else
								if(s.equals("व्यवस्था")){
									writer.append("System.");
								}else
									if(s.equals("जावा")){
										writer.append("java.");
									}else
										if(s.equals("गणित")){
											writer.append("Math.");
										}
									else
										if(s.equals("लेंग")){
											writer.append("lang.");
										}else
											if(s.equals("यूटिल")){
												writer.append("util.");
											}else
										writer.append(s+".");
                    s1=(k.substring(i+1,l));
                    if(s1.equals("अंदर")){
						writer.append("in");
                    }else
                    	if(s1.equals("बहार")){
							writer.append("out");
						}else
							if(s1.equals("व्यवस्था")){
								writer.append("System");
							}else
								if(s1.equals("जावा")){
									writer.append("java");
								}else
									if(s1.equals("घात")){
										writer.append("pow");
									}else
										if(s1.equals("लेंग")){
											writer.append("lang");
										}else
											if(s1.equals("इसपर_अक्षर")){
												writer.append("charAt ");
											}else
												if(s1.equals("समान")){
													writer.append("equals ");
												}else
													if(s1.equals("जोड़ो")){
														writer.append("concat ");
													}else
														if(s1.equals("शामिल_है")){
															writer.append("contains ");
														}else
															if(s1.equals("अंत_में")){
																writer.append("endsWith ");
															}else
																if(s1.equals("क्रमांक")){
																	writer.append("indexOf ");
																}else
																	if(s1.equals("लम्बाई")){
																		writer.append("length ");
																	}else
																		if(s1.equals("इसका_आखरी_क्रमांक")){
																			writer.append("lastIndexOf ");
																		}else
																			if(s1.equals("इसका_पहला_क्रमांक")){
																				writer.append("firstIndexOf ");
																			}else
																				if(s1.equals("की_जगह")){
																					writer.append("replace ");
																				}else
																					if(s1.equals("अनुशृंखला")){
																						writer.append("substring ");
																					}else
																						if(s1.equals("शृंखला_में")){
																							writer.append("toString ");
																						}else
																							if(s1.equals("अगला_है")){
																								writer.append("hasNext ");
																							}else
																								if(s1.equals("अगली_पंक्ति")){
																									writer.append("nextLine ");
																								}else
																									if(s1.equals("अगला_पूर्णांक")){
																										writer.append("nextInt ");
																									}else
																										if(s1.equals("लिखो")){
																											writer.append("println ");
																										}else
																										{
																											writer.append(s1);
																											System.out.println(s1);
                }}
                else{
                s=(k.substring(r,i));
                if(s.equals("मे")){
					writer.append("in.");
             }else
            	 if(s.equals("बहार")){
						writer.append("out.");
					}else
						if(s.equals("व्यवस्था")){
							writer.append("System.");
						}else
							if(s.equals("गणित")){
								writer.append("Math.");
							}else
							if(s.equals("जावा")){
								writer.append("java.");
							}else
								if(s.equals("यूटिल")){
									writer.append("util.");
								}else
								writer.append(s+".");
                }
                r=i+1;
            }
        }
    }
	
	writer.close();
	return output;
	
}

}



