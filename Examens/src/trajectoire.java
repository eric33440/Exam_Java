
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class trajectoire extends Frame implements Runnable, ActionListener {

	String NomFichier = "position.txt";
	int[] Y = new int[100];
	Thread processus = null;
	
	Button Tracer = new Button("Tracer");
	int speed = 1000;

	public trajectoire() {
		setSize(400, 400);
		lecture(NomFichier);
		setVisible(true);
		addWindowListener(new Fermeture());
	}

    public void init() {
    	add(Tracer);
		Tracer.addActionListener(this);
		add("North", Tracer);
    }
        
	
	public void lecture(String nom) {
		try {
			int i = 0;
			StringTokenizer st;
			File f = new File(nom);

			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String ligne;

			while ((ligne = bf.readLine()) != null) {
				st = new StringTokenizer(ligne, ":");
				st.nextToken();
				Y[i] = Integer.parseInt(st.nextToken());
				System.out.println(Y[i]);
				i++;
			}
			bf.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}



	public void paint(Graphics g) {

		
		int[] X = new int[100];

		for (int j = 0; j < X.length; j++) {

			X[j] = j * 10;
		}

		g.setColor(Color.black);
		g.drawLine(10, 0, 10, getSize().height);
		g.drawLine(10, getSize().height / 2, getSize().width, getSize().height / 2);
		g.setColor(Color.blue);
		int i = 0;
		for (i = 0; i < (Y.length - 1); i++) {
			g.drawLine(X[i] + 10, - Y[i] + getSize().height / 2, X[i + 1] + 10,
					- Y[i + 1] + getSize().height / 2);
		}
	}

	public static void main(String[] args) {

		trajectoire ex = new trajectoire();

	}

	@Override
	public void run() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getActionCommand().equals("Tracer")) {
			while (true) {
				lecture(NomFichier);
				repaint();
			}		
		}
	}
}
