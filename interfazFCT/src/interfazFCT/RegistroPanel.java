package interfazFCT;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistroPanel extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5034606363950294310L;
	private JTextField textFieldEmail;
	private JTextField textField;
	private JTextField textFieldRepetirContraseña;
	private JTextField textFieldNombre;
	private JTextField textField_1;

	public RegistroPanel() {
		setBounds(100,100,784,487);
		setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(385, 76, 53, 17);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(385, 93, 170, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setBounds(385, 124, 114, 17);
		add(lblContraseña);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(387, 140, 170, 20);
		add(textField);
		
		JLabel lblRepetirContraseña = new JLabel("RepetirContraseña:");
		lblRepetirContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepetirContraseña.setBounds(385, 171, 148, 17);
		add(lblRepetirContraseña);
		
		textFieldRepetirContraseña = new JTextField();
		textFieldRepetirContraseña.setColumns(10);
		textFieldRepetirContraseña.setBounds(385, 192, 170, 20);
		add(textFieldRepetirContraseña);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(385, 223, 77, 17);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(385, 243, 170, 20);
		add(textFieldNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(385, 274, 77, 17);
		add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(385, 289, 170, 20);
		add(textField_1);
		
		JLabel lblCicloFormativo = new JLabel("Ciclo Formativo:");
		lblCicloFormativo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCicloFormativo.setBounds(385, 320, 135, 17);
		add(lblCicloFormativo);
		
		JComboBox<String> comboBoxCiclo = new JComboBox<String>();
		comboBoxCiclo.setBounds(385, 348, 170, 22);
		comboBoxCiclo.addItem("DAM");
		add(comboBoxCiclo);
	}
}
