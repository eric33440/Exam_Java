import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class dessin extends Applet implements MouseListener, MouseMotionListener{

	int x = 200;
	int y = 200;
	
	public void init() {
		setSize(400, 400);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
				
		g.setColor(Color.black);
		g.fillRect(x, y, 20, 20);// dessine un carre de de 20 de largeur et hauteur à la position x et y
		
	}

	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//recupere la position x et y de la souris à chaque changement et redessine le carre à la nouvelle position
		x = arg0.getX();
		y = arg0.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
