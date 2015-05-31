import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;


/*
 * Swing example for JList to add and remove items
 */

public class JListMain extends JFrame{

	private JList jl;
	private DefaultListModel<String> mdl;
	private JTextField et;
	private JButton add;
	private JButton rm;
	
	public JListMain(String name){
		super(name);
	}
	
	public static void main(String[] args) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JListMain window = new JListMain("List Test");
		window.createView(window);
	
		window.add.addActionListener(new AddListener(window.et, window.mdl));
		window.rm.addActionListener(new RmListener(window.jl, window.mdl));
	}

	
	public void createView(JFrame frame){
		GridLayout lm = new GridLayout(0,1);
		frame.setLayout(lm);
		
		mdl = new DefaultListModel<String>();
		jl = new JList(mdl);
		et = new JTextField();
		add = new JButton("ADD");
		rm = new JButton("REMOVE");
		
		frame.add(jl);
		frame.add(et);
		frame.add(add);
		frame.add(rm);
		
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
		frame.setVisible(true);
	}
	
	private static class AddListener implements ActionListener{
		
		private JTextField jt;
		private DefaultListModel dlm;
		
		public AddListener(JTextField jtf, DefaultListModel dlls){
			this.jt = jtf;
			this.dlm = dlls;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = this.jt.getText();
			this.dlm.addElement(s);
			this.jt.setText("");
		}
		
	}
	
	private static class RmListener implements ActionListener{

		private JList jl;
		private DefaultListModel dlm;
		
		public RmListener(JList jlf, DefaultListModel dlls){
			this.jl = jlf;
			this.dlm = dlls;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!jl.isSelectionEmpty()) {
				String s = this.jl.getSelectedValue().toString();
				//System.out.println(s);
				this.dlm.removeElement(s);
			}
		}
		
	}
}
