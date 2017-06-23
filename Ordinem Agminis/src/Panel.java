import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */
public class Panel extends JPanel implements ActionListener
{
	private JComboBox<String> combo;
	private String[] difficulty;
	private JButton bt;
	private static Panel openingScreen;
	private static JFrame o, w;
	private JLabel name, instructions, instruct1, instruct2, instruct3, ins, diff;
	
	public Panel(){
		super();
		
		setLayout(null);
		
		setBackground(new Color(159, 53, 252));
		  
		Font points = new Font ("San Serif", Font.BOLD, 40);

		difficulty = new String[] {"easy", "medium", "hard"};
	    combo = new JComboBox<String>(difficulty); 
	    combo.setSelectedIndex(0);
	    combo.setFont(points);
	    combo.setBounds(100, 125, 200, 100);
	    add(combo);
	    
	    Font startFont = new Font("Sans Serif", Font.BOLD, 70);
	    bt = new JButton("Start");
	    bt.setBackground(Color.WHITE);
	    bt.setFont(startFont);
	    bt.setBounds(100, 400, 200, 100);
	    bt.addActionListener(this);
	    add(bt);
	    
	    name = new JLabel("Ordinem Agminis");
	    name.setFont(new Font("Sans Serif", Font.BOLD, 80));
	    name.setBounds(400, -50, 1000, 900);
	    add(name);
	    
	    ins = new JLabel("Instructions");
	    ins.setFont(new Font("Sans Serif", Font.BOLD, 30));
	    ins.setBounds(500, 10, 1000, 100);
	    add(ins);
	    
	    instructions = new JLabel("Use any button on the mouse to drag one of the 3 blocks from the box in the lower right corner to the grid.");
	    instructions.setFont(new Font("Sans Serif", Font.BOLD, 13));
	    instructions.setBounds(400, -400, 700, 1000);
	    add(instructions);
	    
	    instruct1 = new JLabel("Every time a shape in dragged into the grid, you receive a point.");
	    instruct1.setFont(new Font("Sans Serif", Font.BOLD, 13));
	    instruct1.setBounds(400, -380, 500, 1000);
	    add(instruct1);
	    
	    instruct2 = new JLabel("When an entire row or column is completely filled, the row or column will disappear. Additional points are added.");
	    instruct2.setFont(new Font("Sans Serif", Font.BOLD, 13));
	    instruct2.setBounds(400, -360, 800, 1000);
	    add(instruct2);
	    
	    instruct3 = new JLabel("Try to get as many points as possible until the timer goes off!");
	    instruct3.setFont(new Font("Sans Serif", Font.BOLD, 13));
	    instruct3.setBounds(400, -340, 800, 1000);
	    add(instruct3);
	    
	    diff = new JLabel("Difficulty");
	    diff.setFont(new Font("Sans Serif", Font.BOLD, 40));
	    diff.setBounds(110, 50, 400, 100);
	    add(diff);
	    
	    combo.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e)
	        {
	            String selectedItem = (String) combo.getSelectedItem();
	            if(selectedItem.equals("easy"))
	                GameScreen.setPlayTime(120);
	            if(selectedItem.equals("medium"))
	            	GameScreen.setPlayTime(60);
	            if(selectedItem.equals("hard"))
	            	GameScreen.setPlayTime(30);
	            System.out.println(GameScreen.getPlayTime());
	        }
	    });
	}
	
	public void PaintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		Font points = new Font ("San Serif", Font.BOLD, 100);
		g.setFont(points);
		g.drawString("MAKE A SHAPE", 0, 100);
	}
  
	@Override
	public void actionPerformed(ActionEvent e) {
			
	    JButton b = (JButton)e.getSource();
		if(b == bt){
			o.setVisible(false);
			w.setVisible(true);
			GameScreen.startClock();
			o.dispose();		}
	}
	
  public static void main(String[] args)
  {
    w = new JFrame("Ordinem Agminis");
    w.setBounds(100, 100, 1200, 600);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GameScreen gs = new GameScreen();
    openingScreen = new Panel();

    w.add(gs);
    w.setResizable(false);    
    
    o = new JFrame("Ordinem Agminis");
    o.setBounds(100, 100, 1200, 600);
    o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    o.setResizable(false);
    o.add(openingScreen);
    o.setVisible(true);
  }
}