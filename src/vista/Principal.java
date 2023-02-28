package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.GestorBBDD;

import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField direccion;
	private JTextField localidad;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI :");
		lblDNI.setBounds(60, 51, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblnombre = new JLabel("NOMBRE :");
		lblnombre.setBounds(60, 84, 68, 14);
		contentPane.add(lblnombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS :");
		lblApellidos.setBounds(60, 123, 68, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("DIRECCIÓN:");
		lblDireccion.setBounds(60, 159, 68, 14);
		contentPane.add(lblDireccion);
		
		dni = new JTextField();
		dni.setBounds(174, 48, 129, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(174, 81, 129, 20);
		contentPane.add(nombre);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(174, 120, 129, 20);
		contentPane.add(apellidos);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(174, 156, 129, 20);
		contentPane.add(direccion);
		
		
		
		
		JButton btnENTER = new JButton("GUARDAR");
		btnENTER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente=new Cliente();
				cliente.setDni(dni.getText());
				cliente.setNombre(nombre.getText());
				cliente.setApellidos(apellidos.getText());
				cliente.setLocalidad(localidad.getText());
				cliente.setApellidos(direccion.getText());
				
				GestorBBDD gestor = new GestorBBDD();
				gestor.conectar();
				try {
					gestor.insertarCliente(cliente);
					gestor.cerrar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
			
		});
		btnENTER.setBounds(203, 212, 108, 23);
		contentPane.add(btnENTER);
		
		JLabel lblLocalidad = new JLabel("LOCALIDAD :");
		lblLocalidad.setBounds(60, 184, 68, 14);
		contentPane.add(lblLocalidad);
		
		localidad = new JTextField();
		localidad.setColumns(10);
		localidad.setBounds(174, 181, 129, 20);
		contentPane.add(localidad);
		
		
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateClienteJDialog dialog = new UpdateClienteJDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
			}
		});
		btnModificar.setBounds(324, 119, 108, 23);
		contentPane.add(btnModificar);
	}
}
