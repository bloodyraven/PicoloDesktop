package ui.menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FilePanel extends JPanel {

	JButton delete;
	FilePanel fp = this;
	JLabel jl;
	private File file;
	
	public FilePanel(FileListPanel flp, File file) {
		this.setFile(file);
		jl = new JLabel(file.getName());
		jl.setPreferredSize(new Dimension(100, 30));
		delete = new JButton("X");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flp.removeFile(fp);
			}
		});
		this.add(jl);
		this.add(delete);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
