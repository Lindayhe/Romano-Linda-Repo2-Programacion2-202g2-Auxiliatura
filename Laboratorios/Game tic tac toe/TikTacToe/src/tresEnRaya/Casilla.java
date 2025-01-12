package tresEnRaya;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Casilla extends JButton{

	private static boolean turnoJugadorUno = true;
	private static boolean ganar, lleno=false;
	private static String simbolo; //para guardar el simbolo a comprobar
	
	public Casilla() {
		this.setFont(new Font("Roboto", Font.BOLD, 80));
		this.setBackground(Color.WHITE);
	}
	
	public static void logicaJuego(Casilla[][] casillas, Casilla c) {
		pintarCasilla(c);
		compruebaLinea(casillas); //para comprobar que no sean igulaes,esto para saber si es empate o gano
		compruebaColumnas(casillas); //para comprobar las columnas 
		compruebaDiagonal(casillas);
		compruebaLleno(casillas);
		
		
	}

	private static void compruebaLleno(Casilla[][] casillas) {
		// TODO Auto-generated method stub
		lleno=true;
		
		for(Casilla[]  arrayCasillas: casillas) {
			for(Casilla c:arrayCasillas) { 
				if(c.getText().equals("")) lleno=false;
				
			}
		}
		if(lleno) ganar("It was a tie ");
	}

	private static void compruebaDiagonal(Casilla[][] casillas) {
		// TODO Auto-generated method stub
		ganar=true;
		simbolo = casillas[0][0].getText();
		if(!simbolo.equals("")) {
			for(int i=1; i<casillas.length; i++) {
				if (!simbolo.equals(casillas[i][i].getText())) ganar=false;
			}
			if(ganar) ganar("It was a tie " + simbolo);
		}
		ganar=true;
		simbolo = casillas[0][2].getText();
		if(!simbolo.equals("")) {  //para que compruebe diagonal de abajo hacia la derecha superior
			for(int i=1, j=1; i<casillas.length; i++,j--) {
				if (!simbolo.equals(casillas[i][j].getText())) ganar=false;
			}
			if(ganar) ganar("Player " + simbolo + "  Won ");
		}
	}

	private static void compruebaColumnas(Casilla[][] casillas) {
		// TODO Auto-generated method stub
		for(int j=0; j<casillas.length; j++) { //bucle anidado
			ganar=true;
			simbolo= casillas[0][j].getText();
			if(!simbolo.equals("")) {   //difernte de vacio
				for(int i=0; i<casillas[0].length; i++) {
					if(!simbolo.equals(casillas[i][j].getText())) ganar=false;
					
				}
				if(ganar) ganar("Player " + simbolo + "  Won ");
			}
		}
		
	}

	private static void compruebaLinea(Casilla[][] casillas) { //metodo que comprueba si gano en filas
		// TODO Auto-generated method stub
		for(int i=0; i<casillas.length; i++) { //bucle anidado
			ganar=true;
			simbolo= casillas[i][0].getText();
			if(!simbolo.equals("")) {
				for(int j=0; j<casillas[0].length; j++) {
					if(!simbolo.equals(casillas[i][j].getText())) ganar=false;
					
				}
				if(ganar) ganar("Player " + simbolo + "  Won ");
			}
		}
	}

	private static void ganar(String s) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, s);
		System.exit(0);
	}

	private static void pintarCasilla(Casilla c) {
		// TODO Auto-generated method stub
		if(turnoJugadorUno) {
			c.setText("X");
			turnoJugadorUno=false;
			c.setEnabled(false);
		}else {
			c.setText("O");
			turnoJugadorUno=true;
			c.setEnabled(false);
		}
	}
}
