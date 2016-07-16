package cave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KalkulatorFrame extends JFrame {

	public KalkulatorFrame() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		this.setTitle("Kalkulačka");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adjustAndDisplayWindow();
		createKalkulator();
	}

	private void adjustAndDisplayWindow() {
		this.setResizable(false);
		this.pack();
		this.setVisible(true);

	}

	private void createKalkulator() {
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		JTextField resultField = new JTextField(String.valueOf("DOPLNIT"));
		resultField.setHorizontalAlignment(JTextField.TRAILING);//zarovnání výsledku na pravo
		resultField.setEditable(false);//aby nám uživatel nešmatal do pole s výsledkem
		resultField.setBackground(Color.white);//nastavíme bílé pozadí
		
		panel.add(panel);

	}
	// JTextArea textArea = new JTextArea();
	// JButton button = new JButton("Click me");

}

//
// public static void main(String[] args) {
// JFrame frame = new JFrame("Kalkulačka");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.setSize(500, 400);
// frame.setVisible(true);
//
//
// }

