import javax.swing.*;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.awt.*;

public class Motdepasse extends Applet implements ActionListener {

	String Fichier = "password.txt";
	BufferedReader br;
	PrintWriter pr;
	URL url;
	
    public void init() {
    	setSize(400,100);
    	
        Frame title = (Frame)this.getParent().getParent();
        title.setTitle("Changer mot de passe");

        JLabel label_1 = new JLabel("Nom:");
        label_1.setBounds(20, 20, 80, 30);
        final JTextField Name = new JTextField();
        Name.setBounds(100, 20, 100, 30);

        JLabel label_2 = new JLabel("Password:");
        label_2.setBounds(20, 60, 80, 30);
        final JPasswordField MDP = new JPasswordField();
        MDP.setBounds(100, 60, 100, 30);

        JLabel label_3 = new JLabel("Nouveau:");
        label_3.setBounds(20, 100, 80, 30);
        final JPasswordField NouveauMDP = new JPasswordField();
        NouveauMDP.setBounds(100, 100, 100, 30);

        JLabel label_4 = new JLabel("Confirmer:");
        label_4.setBounds(20, 140, 80, 30);
        final JPasswordField ConfirmMDP = new JPasswordField();
        ConfirmMDP.setBounds(100, 140, 100, 30);

        JButton StartModif = new JButton("Lancer la modification");
        StartModif.setBounds(60, 200, 160, 30);

        final JLabel text = new JLabel();
        text.setBounds(20, 150, 200, 50);

        setLayout(new GridLayout(5, 2));
        add(label_1);
        add(Name);
        add(label_2);
        add(MDP);
        add(label_3);
        add(NouveauMDP);
        add(label_4);
        add(ConfirmMDP);

        //setLayout(new GridLayout(1, 1));
        add("Center", text);
        add("Center", StartModif);
        

        StartModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rdata = "";
				int resu = 0;

				String data = Name.getText();
				data += ":" + new String(MDP.getPassword());
				text.setText(data);

				System.out.println(new String(NouveauMDP.getPassword()));
				System.out.println(new String(ConfirmMDP.getPassword()));
				String newpwd = new String(NouveauMDP.getPassword());
				String copi = new String(ConfirmMDP.getPassword());
				if (newpwd.compareTo(copi) == 0) {
					String newdata = Name.getText() + ":" + new String(NouveauMDP.getPassword());

					rdata = readFile();
					System.out.println(rdata);
					System.out.println(data);

				 	resu = rdata.compareTo(data);
					System.out.println("GOOD " + resu);
					if (resu == 0) {  //data == rcvdata
						System.out.println("GOOD");
						writeFile(newdata, Fichier);
					}
				}
			}
		});
    }

  
	public void writeFile(String s, String fic) {
		String read = "";
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String ligne;

			read += (s + "\n");
			pr = new PrintWriter(new FileOutputStream(fic));
			pr.write(read);
			pr.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
    
	
	 public String readFile() {
			String data = "";
			String ligne = "";
			try {
				url = new URL(getCodeBase(), Fichier);
				br = new BufferedReader(new InputStreamReader(url.openStream()));

				while (null != (ligne = br.readLine())) {
					if (ligne.indexOf(':') > 0) {
						System.out.println(ligne);
						data = ligne;
					}
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return data;
		}
	 
    public void main(String[] args) {
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
