package tresEnRaya;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;

public class InterfazJuego {
	private JFrame marco;
	private JPanel panel;
	
	private Casilla[][] casillas;
	
	public InterfazJuego () {
		marco = new JFrame ();
		panel = new JPanel(new GridLayout(3,3));
		
		casillas = new Casilla[3][3];
		
		rellenaCasillas();
		montarInterfaz();
		}

	private void montarInterfaz() {
		// TODO Auto-generated method stub
		insertarCasillasAlPanel();
		marco.add(panel);
		marco.setSize(500,500);
		marco.setTitle("Tres en Raya - TicTacToe");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setLocationRelativeTo(null);
	}

	private void insertarCasillasAlPanel() {
		// TODO Auto-generated method stub
		for(Casilla[]  arrayCasillas: casillas) {
			for(Component c:arrayCasillas) { //objeto llamado c
				panel.add(c);
			}
		}
	}

	private void rellenaCasillas() {
		// TODO Auto-generated method stub
		for(int i=0; i<casillas.length; i++) {
			
			for(int j=0; j<casillas[0].length; j++) {
				 casillas[i][j] = new Casilla();
				 casillas[i][j].addActionListener(e->Casilla.logicaJuego(casillas, (Casilla)e.getSource()));
				 
			}
		}
	}
	
	public void abrir() {
		marco.setVisible(true);
	}

}
