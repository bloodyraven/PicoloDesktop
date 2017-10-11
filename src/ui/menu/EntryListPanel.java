package ui.menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.Joueur;
import constants.Constants;

@SuppressWarnings("serial")
public class EntryListPanel extends JPanel {

	JPanel buttonWrapper = new JPanel();
	JPanel entriesWrapper = new JPanel();
	JButton add = new JButton("Nouveau joueur");
	JButton start = new JButton("Commencer");
	JFrame f;

	public EntryListPanel(JFrame f) {
		this.f=f;
		this.setLayout(new BorderLayout());
		
		buttonWrapper.add(add);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEntry();
			}
		});
		
		buttonWrapper.add(start);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Joueur> listJoueur = new ArrayList<Joueur>();
				for (Component c : entriesWrapper.getComponents()) {
					EntryPanel entry = ((EntryPanel) c);
					String nom = entry.tf.getText();
					if("".equals(nom)) {
						JOptionPane.showMessageDialog(f, Constants.MSG_JOUEUR_NOM_BLANK, "", JOptionPane.WARNING_MESSAGE);
						return;
					}
					listJoueur.add(new Joueur(nom));
					if(findDuplicates(listJoueur)) {
						JOptionPane.showMessageDialog(f, Constants.MSG_JOUEUR_DOUBLON, "", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(listJoueur.size()==0) {
					JOptionPane.showMessageDialog(f, Constants.MSG_NO_JOUEUR, "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				f.setContentPane(new FileSelectPanel(f, listJoueur));
				f.repaint();
				f.revalidate();
			}
		});
		
		this.add(buttonWrapper, BorderLayout.SOUTH);
		this.add(entriesWrapper, BorderLayout.CENTER);
	}
	
	boolean findDuplicates(List<Joueur> listContainingDuplicates) {

        final Set<String> set1 = new HashSet<String>();

        for (Joueur j : listContainingDuplicates) {
            if (!set1.add(j.getName())) {
                return true;
            }
        }
        return false;
    }
	
	void addEntry() {
		entriesWrapper.add(new EntryPanel(this));
		f.repaint();
		f.revalidate();
	}
	
	void removeEntry(EntryPanel ep) {
		entriesWrapper.remove(ep);
		f.repaint();
		f.revalidate();
	}
	
}
