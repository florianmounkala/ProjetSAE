import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class FenetreLocations extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreLocations frame = new FenetreLocations();
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
	public FenetreLocations() throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		try {
            // Établir la connexion à la base de données
            Connection conn = getConnection();
            System.out.println("Connexion réussi !");
            // Créer la requête SQL
            String sql = "SELECT typelogement, localisation FROM SAE_Logement";
            
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(sql);
            
            while (resultat.next()) {
                String typeLogement = resultat.getString("typelogement");
                String adresse = resultat.getString("localisation");
                model.addElement("TYPE DE LOGEMENT : " + typeLogement + " | ADRESSE : " + adresse);
            }
            
            
            JList<String> list = new JList<>(model);
            getContentPane().add(list);
            
            JPanel panel = new JPanel();
            contentPane.add(panel, BorderLayout.SOUTH);
            
            JButton btnNewButton = new JButton("Ajouter");
            btnNewButton.addActionListener(this);
            btnNewButton.setPreferredSize(new Dimension(99, 18));
            btnNewButton.setMinimumSize(new Dimension(93, 18));
            panel.add(btnNewButton);
            
            JButton btnNewButton_2 = new JButton("Modifier");
            btnNewButton_2.addActionListener(this);
            btnNewButton_2.setPreferredSize(new Dimension(99, 18));
            panel.add(btnNewButton_2);
            
            JButton btnNewButton_1 = new JButton("Retour");
            btnNewButton_1.addActionListener(this);
            panel.add(btnNewButton_1);
            
            JPanel panel_1 = new JPanel();
            contentPane.add(panel_1, BorderLayout.EAST);
            panel_1.setLayout(new GridLayout(0, 1, 0, 0));
            
            JLabel lblNewLabel = new JLabel("Statut : ");
            panel_1.add(lblNewLabel);
            
            JRadioButton BoutonStatutActif = new JRadioButton("Actif");
            panel_1.add(BoutonStatutActif);
            
            JLabel label = new JLabel("");
            panel_1.add(label);
            
            JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Passif");
            panel_1.add(rdbtnNewRadioButton_1);
            
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
	

	public void actionPerformed(ActionEvent e){
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		
			case "Ajouter":
				FenetreAjouterLocations FenAjouterLocations;
				try {
					FenAjouterLocations = new FenetreAjouterLocations();
					FenAjouterLocations.setVisible(true);
					FenAjouterLocations.toFront();
					break;
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			case "Modifier":
				FenetreModifierLocations FenModifierLocations;
				try {
					FenModifierLocations = new FenetreModifierLocations();
					FenModifierLocations.setVisible(true);
					FenModifierLocations.toFront();
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