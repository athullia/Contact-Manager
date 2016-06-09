package projectFinal;

import javax.swing.*;

class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			System.out.println("Cant get laf");
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ContactManager app = new ContactManager();
				app.JTableTest();
			}
		});
	}

}