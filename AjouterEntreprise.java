import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AjouterEntreprise extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldSiren;
	private JTextField textFieldNom;
	private JTextField textFieldAdresse;
	private JTextField textField_CodePostal;
	private JTextField textField_Iban;
	private JTextField textField_Téléphone;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEntreprise frame = new AjouterEntreprise();
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
	public AjouterEntreprise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Siren de l'entreprise :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldSiren = new JTextField();
		GridBagConstraints gbc_textFieldSiren = new GridBagConstraints();
		gbc_textFieldSiren.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSiren.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSiren.gridx = 7;
		gbc_textFieldSiren.gridy = 1;
		panel.add(textFieldSiren, gbc_textFieldSiren);
		textFieldSiren.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 7;
		gbc_textFieldNom.gridy = 2;
		panel.add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldAdresse = new JTextField();
		GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
		gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse.gridx = 7;
		gbc_textFieldAdresse.gridy = 3;
		panel.add(textFieldAdresse, gbc_textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Code postal :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 5;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_CodePostal = new JTextField();
		GridBagConstraints gbc_textField_CodePostal = new GridBagConstraints();
		gbc_textField_CodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_CodePostal.gridx = 7;
		gbc_textField_CodePostal.gridy = 4;
		panel.add(textField_CodePostal, gbc_textField_CodePostal);
		textField_CodePostal.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("IBAN :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_Iban = new JTextField();
		GridBagConstraints gbc_textField_Iban = new GridBagConstraints();
		gbc_textField_Iban.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Iban.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Iban.gridx = 7;
		gbc_textField_Iban.gridy = 5;
		panel.add(textField_Iban, gbc_textField_Iban);
		textField_Iban.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("T\u00E9l\u00E9phone :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 6;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_Téléphone = new JTextField();
		GridBagConstraints gbc_textField_Téléphone = new GridBagConstraints();
		gbc_textField_Téléphone.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Téléphone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Téléphone.gridx = 7;
		gbc_textField_Téléphone.gridy = 6;
		panel.add(textField_Téléphone, gbc_textField_Téléphone);
		textField_Téléphone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 5;
		gbc_lblNewLabel_7.gridy = 7;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 7;
		gbc_textFieldEmail.gridy = 7;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Ajouter une Entreprise");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
	private static Connection getConnection() throws SQLException {
    	// Connexion à la base de données
    	CictOracleDataSource bd = new CictOracleDataSource();
    	Connection cn = bd.getConnection();
		return cn;
    }

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Annuler":
			Fenetre_entreprise Fenent2;
			Fenent2 = new Fenetre_entreprise();
			Fenent2.setVisible(true);
			Fenent2.toFront();
			this.dispose();
			break;
		case "Valider":
			String requete = "{call AJOUTER_ENTREPRISE(?, ?, ?, ?, ?, ?, ?)}";
			try {
				
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setString(1,textFieldSiren.getText());
				cstmt.setString(2,textFieldNom.getText());
				cstmt.setString(3, textFieldAdresse.getText());
				cstmt.setString(4, textField_CodePostal.getText());
				cstmt.setString(5, textField_Iban.getText());
				cstmt.setString(6,textFieldEmail.getText());
				cstmt.setString(7,textField_Téléphone.getText());
				cstmt.execute();
				Fenetre_entreprise Fenent;
				Fenent = new Fenetre_entreprise();
				Fenent.setVisible(true);
				Fenent.toFront();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
