package cave;

public class Kalkulator {
	private int hodnotaKZobrazeni;
	private int prvniOperand;
	private char operator;
	boolean noveCislo;

	public Kalkulator() {
		hodnotaKZobrazeni = 0;
		prvniOperand = 0;
		operator = ' ';
		noveCislo = true;

	}

	public int getHodnotaKzobrazeni() {
		return hodnotaKZobrazeni;
	}

	public void cislice(int cislo) {
		if (noveCislo) {
			hodnotaKZobrazeni = cislo;
			noveCislo = false;
		} else {
			this.hodnotaKZobrazeni = hodnotaKZobrazeni * 10 + cislo;
		}
	}

	public void plus() {
		if (operator == '+') {
			prvniOperand = prvniOperand + hodnotaKZobrazeni;
		}
		prvniOperand = hodnotaKZobrazeni;
		noveCislo = true;
		//hodnotaKZobrazeni = 0;
		operator = '+';

	}

	public void minus() {
		prvniOperand = hodnotaKZobrazeni;
		noveCislo = true;
		//hodnotaKZobrazeni = 0;
		operator = '-';
	}

	public void rovnaSe() {
		if (operator == '+') {
			hodnotaKZobrazeni = prvniOperand + hodnotaKZobrazeni;
		} else {
			if (operator == '-') {
				hodnotaKZobrazeni = prvniOperand - hodnotaKZobrazeni;
			}
		}
		operator = ' ';
		noveCislo = true;
	}

	public void vymaz() {
		prvniOperand = 0;
		operator =' ';
		hodnotaKZobrazeni = 0;
		noveCislo = true;
	}

}
