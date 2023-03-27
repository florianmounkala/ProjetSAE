import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FenetreAjouterLocataires extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField NomField;
	private JTextField PrenomField;
	private JTextField AdresseField;
	private JTextField MailField;
	private JTextField TelField;
	private JTextField IDLocField;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterLocataires frame = new FenetreAjouterLocataires();
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
	public FenetreAjouterLocataires() throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Ajouter un locataire : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Id du locataire :");
		panel.add(lblNewLabel_6);
		
		IDLocField = new JTextField();
		panel.add(IDLocField);
		IDLocField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		panel.add(lblNewLabel_1);
		
		NomField = new JTextField();
		panel.add(NomField);
		NomField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom : ");
		panel.add(lblNewLabel_2);
		
		PrenomField = new JTextField();
		panel.add(PrenomField);
		PrenomField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse : ");
		panel.add(lblNewLabel_3);
		
		AdresseField = new JTextField();
		panel.add(AdresseField);
		AdresseField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mail : ");
		panel.add(lblNewLabel_4);
		
		MailField = new JTextField();
		panel.add(MailField);
		MailField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("T\u00E9l : ");
		panel.add(lblNewLabel_5);
		
		TelField = new JTextField();
		panel.add(TelField);
		TelField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
		
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
			String requete = "{call ajouter_locataire(?, ?, ?, ?, ?, ?)}";
			try {
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setInt(1, Integer.parseInt(IDLocField.getText()));
				cstmt.setString(2, NomField.getText());
				cstmt.setString(3, PrenomField.getText());
				cstmt.setString(4, AdresseField.getText());
				cstmt.setString(5, MailField.getText());
				cstmt.setInt(6, Integer.parseInt(TelField.getText()));
				cstmt.execute();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
}
}
