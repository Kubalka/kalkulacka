package kalkulacka;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Kalkulacka extends JFrame implements ActionListener {

	/* A tady je vizuální část */

	JPanel[] row = new JPanel[6]; // máme 6 řádek dispej + butonků v okně
	JButton[] button = new JButton[18];// počet butonků

	// deklarace názvu butonků, inicializujeme v loopu (šetříme místem)
	String[] buttonString = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "+/-", "/", "C", "=" };

	int[] dimW = { 200, 50, 100 }; // jaké máme typy šířek pro butonky
	int[] dimH = { 30, 40 }; // dva druhy délek pro butonky

	Dimension displayDim = new Dimension(dimW[0], dimH[0]);
	Dimension regularDim = new Dimension(dimW[1], dimH[1]);
	Dimension ceeButDim = new Dimension(dimW[2], dimH[1]);

	boolean[] function = new boolean[4]; // deklarace funkcí pro sčítání,
											// odčítání, násobení a dělení
	double[] temporary = { 0, 0 };

	JTextArea display = new JTextArea(2, 15); // vytvoření displeje (řádky,
												// sloupce)
	Font font = new Font("Arial", Font.BOLD, 15);

	public Kalkulacka() {
		super("Kalkulačka");
		setDesign(); // nahodíme "look and feel" Nimbus, ať je ot k světu :)
		setSize(230, 330);// velikost okna (šířka, výška)
		setResizable(false);// nešahat na velikost okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);// okno se zavře křížkem
		setLayout(new GridLayout(6, 5)); // rozložení okna (řádky, množství
											// komponent)- chci 5 řádek po max 5
											// komponentech

		// inicializace řádek
		for (int i = 0; i < 6; i++)
			row[i] = new JPanel();

		// inicializace funkcí
		for (int i = 0; i < 4; i++)
			function[i] = false;

		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER); // vycentrujeme první
															// komponentu neboli
															// "displej" na
															// střed
		row[0].setLayout(f1);

		FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);// vycentrujeme
																// zbylé řádky
		for (int i = 1; i < 6; i++)
			row[i].setLayout(f2);

		// inicializace a specifikace butonků
		for (int i = 0; i < 18; i++) {
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
		}

		// nastavení displeje
		display.setFont(font);
		display.setEditable(false); // uživatel nemůže hrabat do displeje, nelze
									// ani psát z klávesnice
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);// vstup
																			// jde
																			// z
																			// prava
																			// do
																			// leva
		display.setPreferredSize(displayDim);

		// stanovíme velikosti butonků
		for (int i = 0; i < 16; i++)
			button[i].setPreferredSize(regularDim);

		for (int i = 16; i < 18; i++)
			button[i].setPreferredSize(ceeButDim);// C a =
		// -----

		row[0].add(display); // do první řádky vložíme displej
		add(row[0]);// vložíme do panelu

		// vkládání ostatních řádek
		for (int i = 0; i < 4; i++)
			row[1].add(button[i]);
		add(row[1]);

		for (int i = 4; i < 8; i++)
			row[2].add(button[i]);
		add(row[2]);

		for (int i = 8; i < 12; i++)
			row[3].add(button[i]);
		add(row[3]);

		for (int i = 12; i < 16; i++)
			row[4].add(button[i]);
		add(row[4]);

		for (int i = 16; i < 18; i++)
			row[5].add(button[i]); // C
		add(row[5]);
		// ------

		setVisible(true);
	}

	public final void setDesign() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		UIManager.put("Panel.background", new Color(189, 193, 200));
	}

	/* A tady je početní část: */

	public void vymaz() {
		try {
			display.setText(""); // nastaví text v dispeji na prázdné okno
			for (int i = 0; i < 4; i++)
				function[i] = false; // nastaví všechny 4 funkce na false, čili
										// je "vynuluje"
			for (int i = 0; i < 2; i++)
				temporary[i] = 0; // proměné pro načítání nastaví zpět na 0
		} catch (NullPointerException e) {// sice nevím, k čemu to je, ale je
											// dobré to tam mít dle
											// Stackoverflow :D
		}
	}

	public void getPosNeg() {
		try {
			double value = Double.parseDouble(display.getText()); // parseDouble
																	// vrací
																	// hodnotu
																	// zobrazenou
																	// v
																	// displaji
																	// parsovanou
																	// do doublu
			if (value != 0) {
				value = value * (-1); // pokud hodnota value není ronvna 0,
										// přidá se - vynásobení -1
				display.setText(Double.toString(value)); // na displej se vypíše
															// nová hodnota jako
															// String
			} else {
			}
		} catch (NumberFormatException e) {
		}
	}

	public void getResult() {
		double result = 0; //proměnná pro výsledek
		temporary[1] = Double.parseDouble(display.getText());// druhé dočasné číslo z dispeje
		String temp0 = Double.toString(temporary[0]); //řetězec pro text první dočasné proměnné
		String temp1 = Double.toString(temporary[1]); //řetězec pro text druhé dočasné proměnné
		try {
			if (temp0.contains("-")) { // pokud první řetězec obsahuje "-"
				String[] temp00 = temp0.split("-", 2); // rozdě řetězec na dca v místě "-"
				temporary[0] = (Double.parseDouble(temp00[1]) * -1); // a dej řetězec zpět ve formě doublu
			}
			if (temp1.contains("-")) { //totéž z druhou dočasnou proměnnou
				String[] temp11 = temp1.split("-", 2);
				temporary[1] = (Double.parseDouble(temp11[1]) * -1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (function[2] == true) //násobení
				result = temporary[0] * temporary[1];
			else if (function[3] == true) //dělení
				result = temporary[0] / temporary[1];
			else if (function[0] == true)//sčítání
				result = temporary[0] + temporary[1];
			else if (function[1] == true) //odčítání
				result = temporary[0] - temporary[1];
			display.setText(Double.toString(result)); 
			for (int i = 0; i < 4; i++)
				function[i] = false; //nastav zpět všechny funkce na false
		} catch (NumberFormatException e) {
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button[0]) 
			display.append("7");
		if (ae.getSource() == button[1]) 
			display.append("8");
		if (ae.getSource() == button[2]) 
			display.append("9");
	
		if (ae.getSource() == button[3]) {
			temporary[0] = Double.parseDouble(display.getText());
			function[0] = true; // sčítání
			display.setText("");
		}

		if (ae.getSource() == button[4]) 
			display.append("4");
		if (ae.getSource() == button[5]) 
			display.append("5");
		if (ae.getSource() == button[6]) 
			display.append("6");
		
		if (ae.getSource() == button[7]) {
			temporary[0] = Double.parseDouble(display.getText());
			function[1] = true;// odčítání
			display.setText("");
		}

		if (ae.getSource() == button[8]) 
			display.append("1");	
		if (ae.getSource() == button[9]) 
			display.append("2");
		if (ae.getSource() == button[10]) 
			display.append("3");
		
		if (ae.getSource() == button[11]) {
			temporary[0] = Double.parseDouble(display.getText());
			function[2] = true;// násobení
			display.setText("");
		}

		if (ae.getSource() == button[12]) 
			display.append("0");
		if (ae.getSource() == button[13]) 
			display.append(".");
		if (ae.getSource() == button[14])
			getPosNeg();
		if (ae.getSource() == button[15]) {
			temporary[0] = Double.parseDouble(display.getText());
			function[3] = true;// dělení
			display.setText("");
		}

		if (ae.getSource() == button[16])
			vymaz();
		if (ae.getSource() == button[17])
			getResult();

	}

	/* A tady je spouštěč :) */
	public static void main(String[] args) {
		Kalkulacka kalk = new Kalkulacka();

	}

}
