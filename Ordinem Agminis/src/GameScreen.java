
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */
public class GameScreen extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	private GridSystem grid;
	private Block currentDrag;
	private BBlockBox box;
	private Color currentDragColor;
	private boolean drawBox;
	private PointSystem ps;
	private static int points;
	private int time;
	private static Timer clock;
	private static int timeToPlay;

	public GameScreen() {
		super();

		setBackground(new Color(159, 53, 252));
		grid = new GridSystem();
		currentDrag = null;

		addMouseListener(this);
		addMouseMotionListener(this);

		box = new BBlockBox();
		ps = new PointSystem();
		drawBox = true;
		points = 0;
		time = 0;
		clock = new Timer(1000, this);
		// clock.start();
		timeToPlay = 120;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font t = new Font("Sans Serif", Font.BOLD, 40);
		g.setFont(t);

		int x = 793;
		if (time < 10) {
			x = 780;
		} else if (time >= 10 && time < 100) {
			x = 800;
		} else if (time >= 100) {
			x = 850;
		}
			
		g.drawString("Time:", 780, 110);
		
		
		g.setFont(new Font("Sans Serif", Font.BOLD, 90));
		g.drawString(timeToPlay - time + "", x, 200);

		
		g.drawRect(760, 60, 200, 200);
		
		grid.drawGrid(g);
		ps.drawPoints(g);

		box.drawBBlockBox(g);
		drawBox = false;

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		if (currentDrag != null) {
			System.out.print("dragged ");
			currentDrag.setX(arg0.getX());
			currentDrag.setY(arg0.getY());
			repaint();
			System.out.println(arg0.getX() + " " + arg0.getY() + " " + currentDrag.getX() + " " + currentDrag.getY());
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int mouseX = arg0.getX();
		int mouseY = arg0.getY();
		if (box.getFromArrayList(0).contained(mouseX, mouseY)) {
			currentDrag = box.getFromArrayList(0);
			currentDragColor = box.getFromArrayList(0).getColor();
			System.out.println("on shape 1" + " color is: " + currentDragColor);
		} else if (box.getFromArrayList(1).contained(mouseX, mouseY)) {
			currentDrag = box.getFromArrayList(1);
			currentDragColor = box.getFromArrayList(1).getColor();
			System.out.println("on shape 2" + " color is: " + currentDragColor);

		} else if (box.getFromArrayList(2).contained(mouseX, mouseY)) {
			currentDrag = box.getFromArrayList(2);
			currentDragColor = box.getFromArrayList(2).getColor();
			System.out.println("on shape 3" + " color is: " + currentDragColor);

		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		if (currentDrag != null) {
			grid.getLoc(currentDrag.getX(), currentDrag.getY(), currentDrag.getColor(), currentDrag);

			repaint();
			if (grid.inGrid(currentDrag.getX(), currentDrag.getY()) && grid.isDropped() == true) {
				grid.check();
				points++;
				box.clearArray();
			}
			drawBox = true;
			System.out.println(currentDrag.getColor());
		}
		currentDrag = null;
		repaint();
	}

	public static int getPoints() {
		return points;
	}

	public static void changePoints(int n) {
		points += n;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time++;
		repaint();
		if (time >= timeToPlay) {
			clock.stop();
			JOptionPane.showMessageDialog(null, "Final Points: " + points + "\n" + "Press OK to quit", "GAME OVER",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

	public int getTimer() {
		return time;
	}

	public static void setPlayTime(int t) {
		timeToPlay = t;
	}

	public static int getPlayTime() {
		return timeToPlay;
	}

	public static void startClock() {
		clock.start();
	}
}
