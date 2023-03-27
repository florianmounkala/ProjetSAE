import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreModifierLocataire extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JTextField IDLocField;
	private JTextField NomField;
	private JTextField PrenomField;
	private JTextField AdresseField;
	private JTextField EmailField;
	private JTextField TelField;
	private Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreModifierLocataire frame = new FenetreModifierLocataire();
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
	public FenetreModifierLocataire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Modifier un locataire");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("ID locataire : ");
		panel_1.add(lblNewLabel_1);
		
		IDLocField = new JTextField();
		panel_1.add(IDLocField);
		IDLocField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom :");
		panel_1.add(lblNewLabel_2);
		
		NomField = new JTextField();
		panel_1.add(NomField);
		NomField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom : ");
		panel_1.add(lblNewLabel_3);
		
		PrenomField = new JTextField();
		panel_1.add(PrenomField);
		PrenomField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adresse : ");
		panel_1.add(lblNewLabel_4);
		
		AdresseField = new JTextField();
		panel_1.add(AdresseField);
		AdresseField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail : ");
		panel_1.add(lblNewLabel_5);
		
		EmailField = new JTextField();
		panel_1.add(EmailField);
		EmailField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("T\u00E9l : ");
		panel_1.add(lblNewLabel_6);
		
		TelField = new JTextField();
		panel_1.add(TelField);
		TelField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
		
		try {
			conn = getConnection();
            System.out.println("Connexion réussi !");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
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
			this.dispose();
			break;
		case "Valider":
			String requete = "update sae_locataire set nom = ?, prenom = ?, adresse_domicil_société = ?, e_mail = ?, Tél = ? where id_locataire = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(requete);
				pstmt.setString(1, NomField.getText());
				pstmt.setString(2, PrenomField.getText());
				pstmt.setString(3, AdresseField.getText());
				pstmt.setString(4, EmailField.getText());
				pstmt.setInt(5, Integer.parseInt(TelField.getText()));
				pstmt.setInt(6, Integer.parseInt(IDLocField.getText()));
				pstmt.executeUpdate();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
}
}
