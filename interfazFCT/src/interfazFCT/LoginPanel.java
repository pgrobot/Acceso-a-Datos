package interfazFCT;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmail;
	private JTextField textFieldContra;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(264, 189, 62, 30);
		add(lblEmail);
		
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContra.setBounds(264, 271, 105, 30);
		add(lblContra);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(264, 230, 207, 32);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldContra = new JTextField();
		textFieldContra.setColumns(10);
		textFieldContra.setBounds(264, 312, 207, 32);
		add(textFieldContra);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(382, 377, 89, 23);
		add(btnEntrar);
		
		JButton btnSolicitar = new JButton("Solicitar Acceso");
		btnSolicitar.setBounds(516, 446, 156, 23);
		add(btnSolicitar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(679, 446, 89, 23);
		add(btnSalir);
	
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
	}
}
