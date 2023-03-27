import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Fenetre_entreprise extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_entreprise frame = new Fenetre_entreprise();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static Connection getConnection() throws SQLException {
	    // Connexion à la base de données
	    CictOracleDataSource bd = new CictOracleDataSource();
	    Connection cn = bd.getConnection();
		return cn;
	}
	/**
	 * Create the frame.
	 */
	public Fenetre_entreprise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Ajouter une entreprise");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		JButton btnNewButtonAjouterEntreprise = new JButton("Modifier une entreprise");
		btnNewButtonAjouterEntreprise.addActionListener(this);
		panel_1.add(btnNewButtonAjouterEntreprise);
		
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(this);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Liste des entreprsies r\u00E9pertori\u00E9es");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JList list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		try {
			String requete = "SELECT * FROM SAE_ENTREPRISE";
			// Établir la connexion à la base de données
            Connection conn = getConnection();
	
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                String  siren = resultat.getString("N_SIREN");
                String nom_entreprise = resultat.getString("NOM");
                String addresse_entreprise = resultat.getString("ADRESSE");
                String code_postal_entreprise = resultat.getString("CP");
                String iban = resultat.getString("IBAN");
                String mail_entreprise= resultat.getString("ADRESSE_MAIL");
                String tel_entreprise = resultat.getString("TEL");
                model.addElement("-Nom de l'entreprise : "+ nom_entreprise +" .Siren de l'entreprise : "+ siren + ".Adresse : "+ addresse_entreprise +" "+ code_postal_entreprise +" .Mail et telephone de l'entreprise : "+ mail_entreprise + " " +tel_entreprise+" .IBAN : " + iban );
            }

            JList<String> liste_facture = new JList<>(model);
    		contentPane.add(liste_facture, BorderLayout.CENTER);
            getContentPane().add(liste_facture);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
			case "Ajouter une entreprise" :
				AjouterEntreprise Ajouter_ent ;
				Ajouter_ent = new AjouterEntreprise();
				Ajouter_ent.setVisible(true);
				Ajouter_ent.toFront();
				this.dispose();
				break;
			case "Modifier une entreprise" :
				ModifierEntreprise Modifier_ent ;
				Modifier_ent = new ModifierEntreprise();
				Modifier_ent.setVisible(true);
				Modifier_ent.toFront();
				this.dispose();
				break;
			case "Retour":
			try {
				FenetrePrincipal Fenp;
				Fenp = new FenetrePrincipal();
				Fenp.setVisible(true);
				Fenp.toFront();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
