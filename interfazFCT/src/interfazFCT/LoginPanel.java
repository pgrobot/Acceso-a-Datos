package interfazFCT;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import aplicacionFCT.exceptions.FCTServiceException;
import aplicacionFCT.servicio.UsuarioService;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmail;
	private JTextField textFieldContra;
	private UsuarioService uS;
	private VentanaMain vMain;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel(VentanaMain vM) {
		vMain=vM;
		uS= new UsuarioService();
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
		
		textFieldContra = new JPasswordField();
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
				try {
					uS.login(textFieldEmail.getText(), textFieldContra.getText());
				} catch (FCTServiceException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSolicitar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vMain.cambiarRegistroPanel();
			}
		});
		
	}
}
