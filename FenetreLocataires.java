import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreLocataires extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreLocataires frame = new FenetreLocataires();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FenetreLocataires() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		try {
            // Établir la connexion à la base de données
            Connection conn = getConnection();

            // Créer la requête SQL
            String sql = "SELECT nom, prenom, adresse_domicil_société, e_mail, tél FROM SAE_Locataire";

            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(sql);
            
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String adresse = resultat.getString("adresse_domicil_société");
                String email = resultat.getString("e_mail");
                int tél = resultat.getInt("tél");
                model.addElement(nom + " " + prenom + " | ADRESSE : " + adresse + " | E-MAIL : " + email + " | TELEPHONE : " + tél);
            }

            
            JList<String> list = new JList<>(model);
            getContentPane().add(list);
            
            JLabel lblNewLabel = new JLabel("Liste de vos locataires :");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(lblNewLabel, BorderLayout.NORTH);
            
            JPanel panel_1 = new JPanel();
            contentPane.add(panel_1, BorderLayout.SOUTH);
            
            JButton btnNewButton = new JButton("Ajouter Locataires");
            btnNewButton.addActionListener(this);
            panel_1.add(btnNewButton);
            
            JButton btnNewButton_1 = new JButton("Retour");
            btnNewButton_1.addActionListener(this);
            panel_1.add(btnNewButton_1);
            
            // Fermer la connexion
            conn.close();
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
			case "Ajouter Locataires":
				FenetreAjouterLocataires FenAjouterLocataires;
				try {
					FenAjouterLocataires = new FenetreAjouterLocataires();
					FenAjouterLocataires.setVisible(true);
					FenAjouterLocataires.toFront();
					break;
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
		
			case "Retour":
				this.dispose();
		}
	}
	
}
