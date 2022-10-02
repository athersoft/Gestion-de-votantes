package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Controladores.Controlador_Ventanas;

import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

	private JFrame frmGestinDeVotantes;

	/**
	 * Launch the application.
	 */
	public static void newWindow(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmGestinDeVotantes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Controlador_Ventanas controlador = new Controlador_Ventanas ();
		frmGestinDeVotantes = new JFrame();
		frmGestinDeVotantes.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmGestinDeVotantes.setFont(new Font("Arial", Font.PLAIN, 16));
		frmGestinDeVotantes.setOpacity(10.0f);
		frmGestinDeVotantes.setTitle("Gestión de votantes");
		frmGestinDeVotantes.setBounds(100, 100, 500, 500);
		frmGestinDeVotantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinDeVotantes.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Inscribir Votante");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlador.botonPresionado(txtValor1.getText(), txtValor2.getText());
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(64, 224, 208));
		btnNewButton_1.setBounds(37, 65, 180, 45);
		frmGestinDeVotantes.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar locales");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_1_1.setBounds(37, 215, 200, 45);
		frmGestinDeVotantes.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Consultar local de votación");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(64, 224, 208));
		btnNewButton_2.setBounds(37, 365, 275, 45);
		frmGestinDeVotantes.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Locales por región");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(64, 224, 208));
		btnNewButton_3.setBounds(37, 290, 220, 45);
		frmGestinDeVotantes.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Filtrar votantes");
		btnNewButton_4.setToolTipText("Muestra los votantes según su rango de edad");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_4.setBackground(new Color(64, 224, 208));
		btnNewButton_4.setBounds(37, 140, 180, 45);
		frmGestinDeVotantes.getContentPane().add(btnNewButton_4);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
