package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bean.Joueur;

@SuppressWarnings("serial")
public class FileListPanel extends JPanel{
	
	JPanel buttonWrapper = new JPanel();
	JPanel fileWrapper = new JPanel();
	JButton add = new JButton("Ajout fichier");
	JButton start = new JButton("Confirmer");
	JFrame f;
	ArrayList<File> fileList = new ArrayList<File>();

	public FileListPanel(JFrame f, ArrayList<Joueur> listJoueur) {
		this.f=f;
		this.setLayout(new BorderLayout());
		
		buttonWrapper.add(add);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setMultiSelectionEnabled(true);
				chooser.showOpenDialog(f);
				File[] files = chooser.getSelectedFiles();
				for (File file : files) {
					addFile(file);
				}
			}
		});
		
		buttonWrapper.add(start);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		this.add(buttonWrapper, BorderLayout.SOUTH);
		this.add(fileWrapper, BorderLayout.CENTER);
	}
	
	void addFile(File file) {
		fileList.add(file);
		fileWrapper.add(new FilePanel(this, file));
		f.repaint();
		f.revalidate();
	}
	
	void removeFile(FilePanel fp) {
		fileList.remove(fp.getFile());
		fileWrapper.remove(fp);
		f.repaint();
		f.revalidate();
	}

	public JPanel getButtonWrapper() {
		return buttonWrapper;
	}

	public void setButtonWrapper(JPanel buttonWrapper) {
		this.buttonWrapper = buttonWrapper;
	}

	public JPanel getFileWrapper() {
		return fileWrapper;
	}

	public void setFileWrapper(JPanel fileWrapper) {
		this.fileWrapper = fileWrapper;
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public ArrayList<File> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<File> fileList) {
		this.fileList = fileList;
	}
	
}
