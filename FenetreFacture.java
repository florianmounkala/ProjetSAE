import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.Box;

public class FenetreFacture extends JFrame implements ActionListener  {

	static String requete1 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE RÉFÉRENCE NOT LIKE '666%' ";
	private JPanel contentPane;
	private JTextField textFieldAP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreFacture frame = new FenetreFacture(requete1);
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
	public FenetreFacture (String requete) throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButtonRecherche = new JButton("Rechercher");
		btnNewButtonRecherche.addActionListener(this);
		panel.add(btnNewButtonRecherche);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		Component horizontalStrut = Box.createVerticalStrut(20);
		panel.add(horizontalStrut);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lbFacture = new JLabel("Liste des factures");
		panel_1.add(lbFacture);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{127, 103, 214, 0};
		gbl_panel_2.rowHeights = new int[]{21, 21, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnNewAjouterFacture = new JButton("Ajouter Facture");
		btnNewAjouterFacture.addActionListener(this);
		
		JButton btnModifierFacture = new JButton("Modifier une Facture");
		btnModifierFacture.addActionListener(this);
		GridBagConstraints gbc_btnModifierFacture = new GridBagConstraints();
		gbc_btnModifierFacture.anchor = GridBagConstraints.NORTH;
		gbc_btnModifierFacture.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifierFacture.gridx = 0;
		gbc_btnModifierFacture.gridy = 0;
		panel_2.add(btnModifierFacture, gbc_btnModifierFacture);
		GridBagConstraints gbc_btnNewAjouterFacture = new GridBagConstraints();
		gbc_btnNewAjouterFacture.anchor = GridBagConstraints.NORTH;
		gbc_btnNewAjouterFacture.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewAjouterFacture.gridx = 1;
		gbc_btnNewAjouterFacture.gridy = 0;
		panel_2.add(btnNewAjouterFacture, gbc_btnNewAjouterFacture);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		GridBagConstraints gbc_btnRetour = new GridBagConstraints();
		gbc_btnRetour.anchor = GridBagConstraints.NORTH;
		gbc_btnRetour.insets = new Insets(0, 0, 5, 0);
		gbc_btnRetour.gridx = 2;
		gbc_btnRetour.gridy = 0;
		panel_2.add(btnRetour, gbc_btnRetour);
		
		JLabel lblNewLabel = new JLabel("Ann\u00E9e des facture propri\u00E9taire :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Accéder facture proprietaire");
		btnNewButton.addActionListener(this);
		
		textFieldAP = new JTextField();
		textFieldAP.setText("DD/MM /YYYY");
		GridBagConstraints gbc_textFieldAP = new GridBagConstraints();
		gbc_textFieldAP.anchor = GridBagConstraints.WEST;
		gbc_textFieldAP.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldAP.gridx = 1;
		gbc_textFieldAP.gridy = 1;
		panel_2.add(textFieldAP, gbc_textFieldAP);
		textFieldAP.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		
		
		try {
            // Établir la connexion à la base de données
            Connection conn = getConnection();
	
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                String reference = resultat.getString("RÉFÉRENCE");
                String reference_paiement = resultat.getString("REFERENCE_DU_PAIEMENT");
                Date date_facture = resultat.getDate("DATE_FACTURE");
                Date date_paiement = resultat.getDate("DATE_DE_PAIEMENT");
                String type_paiement = resultat.getString("TYPE_DE_PAIEMENT");
                int id_type_facture = resultat.getInt("ID_TYPE_FACTURE");
                float prix_facture = resultat.getFloat("PRIX");
                String description = resultat.getString("DESCRIPTION_F");
                model.addElement("Référence de la facture : "+ reference + " | Référence du paiement : " + reference_paiement + " | date de la facture : " + date_facture + " | date du paiement : " + date_paiement + " | Type de paiement: " + type_paiement + " | Type de facture: " + id_type_facture +" | Montant: " + prix_facture + " | Description : " + description);
            }

            JList<String> liste_facture = new JList<>(model);
    		contentPane.add(liste_facture, BorderLayout.CENTER);
            getContentPane().add(liste_facture);
      
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
			case "Ajouter Facture":
				FenetreAjouterFacture FenAjouterFac;
				FenAjouterFac = new FenetreAjouterFacture();
				FenAjouterFac.setVisible(true);
				FenAjouterFac.toFront();
				this.dispose();
				break;
			case "Modifier une Facture":	
				FenetreModifierFacture FenModifFac ;
				FenModifFac = new FenetreModifierFacture();
				FenModifFac.setVisible(true);
				FenModifFac.toFront();
				this.dispose();
				break;
			case "Rechercher" :
				Filtre_recherche recherche ;
				recherche = new Filtre_recherche();
				recherche.setVisible(true);
				this.dispose();
				break;
			case "Accéder facture proprietaire":
				FenetFacturePropiétaire FactProprio ;
				try {
					FactProprio = new FenetFacturePropiétaire(textFieldAP.getText());
					FactProprio.setVisible(true);
					FactProprio.toFront();
					this.dispose();
				} catch (ParseException e2) {
				// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
				
			case "Retour":
				try {
					FenetrePrincipal x ;
					x = new FenetrePrincipal();
					x.setVisible(true);
					x.toFront();
					this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;	
		}
	}



}
