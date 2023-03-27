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
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class FenetFacturePropiétaire extends JFrame implements ActionListener {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetFacturePropiétaire frame = new FenetFacturePropiétaire("20/12/2021");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FenetFacturePropiétaire(String charges) throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Factures propri\u00E9taires");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{85, 0};
		gbl_panel_1.rowHeights = new int[]{21, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Ajouter une facture");
		btnNewButton_1.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour au factures classiques");
		btnNewButton_2.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour au menu principal");
		btnNewButton_3.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JTextPane txtpnAttentionCette = new JTextPane();
		txtpnAttentionCette.setForeground(new Color(255, 0, 0));
		txtpnAttentionCette.setEditable(false);
		txtpnAttentionCette.setText("Attention : Cette page affiche que les factures du propri\u00E9taire .\r\nElles sont NON MODIFIABLES et poss\u00E8de une r\u00E9f\u00E9rence sp\u00E9cifique en plus d'avoir forc\u00E9ment le type Fiscales !\r\nMerci de faire Attention lors de toute manipulation de ses factures.");
		contentPane.add(txtpnAttentionCette, BorderLayout.SOUTH);
		
		try {
            // Établir la connexion à la base de données
            Connection conn = getConnection();
	
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(charges);
            java.sql.Date date_x = new java.sql.Date(date.getTime());
            String requete = "Select RÉFÉRENCE , DESCRIPTION_F ,PRIX ,REFERENCE_DU_PAIEMENT from SAE_FACTURE Where RÉFÉRENCE LIKE '666%' AND date_facture = ? ORDER BY DESCRIPTION_F ";
            PreparedStatement resultat = conn.prepareStatement(requete) ;
            resultat.setDate(1, date_x);
            ResultSet resultSet = resultat.executeQuery();
            while (resultSet.next()) {
                String reference = resultSet.getString("RÉFÉRENCE");
                String reference_paiement = resultSet.getString("REFERENCE_DU_PAIEMENT");
                float prix_facture = resultSet.getFloat("PRIX");
                String description = resultSet.getString("DESCRIPTION_F");
                model.addElement("Référence de la facture : "+ reference + " | Type de facture : " + reference_paiement +" | Montant" + prix_facture +" | Batiment : " + description);
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
			case "Ajouter une facture":
				AjouterFacturePropriétaire AjouterFactureProprio ;
				AjouterFactureProprio = new AjouterFacturePropriétaire();
				AjouterFactureProprio.setVisible(true);
				AjouterFactureProprio.toFront();
				this.dispose();
				break;
			case "Retour au factures classiques":
				String requete1 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
				FenetreFacture FenFac;
				try {
					FenFac = new FenetreFacture(requete1);
					FenFac.setVisible(true);
					FenFac.toFront();
					this.dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Retour au menu principal":
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







/*これを読んでいる場合は、SQLとJavaのこのプロジェクトについて苦労しましたが、それは価値があったということを知っていてください。 しかし、あなたは私たちの先生です（少なくとも13点を教えてください）または非常に愚かです。また！ */
/* c'est surement mal traduit mais bon cet easter egg en vaut la peine (merci de le prendre au second degrès) */
