import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
public class Filtre_recherche extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldReponse;
	private int valeur_filtre = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filtre_recherche frame = new Filtre_recherche();
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
	public Filtre_recherche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut_2);
		
		JLabel lblNewLabelNameR = new JLabel("Type de filtre :");
		contentPane.add(lblNewLabelNameR);
		
		JComboBox comboBox_Filtres = new JComboBox();
		comboBox_Filtres.setEditable(true);
		comboBox_Filtres.setMaximumRowCount(20);
		comboBox_Filtres.setModel(new DefaultComboBoxModel(new String[] {"", "Reference", "Locataire", "Batiment", "Entreprise", "Type de Facture", "Type de paiement", "Statut de la facture (Payee ou Impayee)", "Date paiement", "Date facture", "Description", "Prix Minimum", "Prix Maximum", "Prix exact", "Montant aide exact", "Aide ", "Montant max aide", "Montant min aide", "Aucun filtre"}));
		comboBox_Filtres.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			// Get the selected item
		    String selectedItem = comboBox_Filtres.getSelectedItem().toString();
		    switch (selectedItem) {
		    case "Montant aide exact":
		    	setValeur_filtre(15);
		    	break;
		    case "Prix exact":
		    	setValeur_filtre(14);
		    	break;
		    case "Aucun filtre":
		    	setValeur_filtre(0);
		    	break;
		    case "Reference":
		    	setValeur_filtre(1);
		    	break;
			case "Locataire":
				setValeur_filtre(2);
				break;
			case "Batiment":
				setValeur_filtre(3);
				break;
			case "Entreprise":
				setValeur_filtre(4);
				break;
			case "Type de Facture":
				setValeur_filtre(5);
				break;
			case "Type de paiement":
				setValeur_filtre(6);
				break;
			case "Statut de la facture (Payee ou Impayee)":
				setValeur_filtre(7);
				break;
			case "Description":
				setValeur_filtre(8);
				break;
			case "Prix Minimum":
				setValeur_filtre(9);
				break;
			case "Prix Maximum":
				setValeur_filtre(10);
				break;
			case "Aide ":
				setValeur_filtre(11);
				break;
			case "Montant min aide":
				setValeur_filtre(12);
				break;
			case "Montant max aide":
				setValeur_filtre(13);
				break;
			case "Date facture":
				setValeur_filtre(16);
				break;
			case "Date paiement":
				setValeur_filtre(17);
				break;
			}
		    System.out.println(getValeur_filtre());
		}
		});
		contentPane.add(comboBox_Filtres);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut_1);
		
		JLabel Valeur_recherché = new JLabel("Valeur recherch\u00E9 :");
		contentPane.add(Valeur_recherché);
		
		textFieldReponse = new JTextField();
		contentPane.add(textFieldReponse);
		textFieldReponse.setColumns(10);
		
		JButton Valid = new JButton("Valider");
		Valid.addActionListener(this);
		contentPane.add(Valid);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(this);
		contentPane.add(btnNewButtonRetour);
	}
	
	public void setValeur_filtre(int valeur_filtre) {
		this.valeur_filtre = valeur_filtre;
	}

	public int getValeur_filtre() {
		return valeur_filtre;
	}
	@Override
	public String toString() throws IllegalArgumentException{
		String requete = null ;
		switch(getValeur_filtre()) {
			case 0:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 1:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE RÉFÉRENCE = '" + textFieldReponse.getText() + "' AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 2:
				String originalString = textFieldReponse.getText();
				String[] parts = originalString.split(" ");
				String part1 = parts[0];
				String part2 = parts[1];
				requete = "SELECT  SAE_FACTURE.RÉFÉRENCE , SAE_FACTURE.REFERENCE_DU_PAIEMENT , SAE_FACTURE.DATE_FACTURE , SAE_FACTURE.CHARGES_DUES , SAE_FACTURE.CHARGES_REGULARISES , SAE_FACTURE.DATE_DE_PAIEMENT , SAE_FACTURE.TYPE_DE_PAIEMENT , SAE_FACTURE.AIDE , SAE_FACTURE.MONTANT_DE_L_AIDE , SAE_FACTURE.PRIX , SAE_FACTURE.ID_TYPE_FACTURE , SAE_FACTURE.N_SIREN , SAE_FACTURE.DESCRIPTION_F FROM SAE_FACTURE , SAE_LIER ,SAE_LOGEMENT , SAE_CONTRAT_BAIL , SAE_SIGNER , SAE_LOCATAIRE WHERE SAE_FACTURE.RÉFÉRENCE = SAE_LIER.RÉFÉRENCE AND SAE_LIER.N_BATIMENT = SAE_LOGEMENT.N_BATIMENT AND SAE_LIER.N_LOGEMENT = SAE_LOGEMENT.N_LOGEMENT AND SAE_LOGEMENT.N_BATIMENT = SAE_CONTRAT_BAIL.N_BATIMENT AND SAE_LOGEMENT.N_LOGEMENT = SAE_CONTRAT_BAIL.N_LOGEMENT AND SAE_CONTRAT_BAIL.ID_BAIL = SAE_SIGNER.ID_BAIL AND SAE_SIGNER.ID_LOCATAIRE = SAE_LOCATAIRE.ID_LOCATAIRE AND SAE_LOCATAIRE.NOM = '" + part1 + "' AND SAE_LOCATAIRE.PRENOM = '" + part2 +"' AND RÉFÉRENCE NOT LIKE '666%'" ;
				break;
			case 3:
				requete = "select sae_facture.RÉFÉRENCE, sae_facture.REFERENCE_DU_PAIEMENT, sae_facture.DATE_FACTURE, sae_facture.DATE_DE_PAIEMENT, sae_facture.TYPE_DE_PAIEMENT , sae_facture.ID_TYPE_FACTURE ,sae_facture.PRIX ,sae_facture.DESCRIPTION_F from sae_facture , sae_lier , sae_logement where sae_facture.référence = sae_lier.référence and sae_lier.n_batiment = sae_logement.n_batiment and sae_logement.n_batiment = " + Integer.parseInt(textFieldReponse.getText())+ "AND RÉFÉRENCE NOT LIKE '666%'" ;
				break;
			case 4:
				requete = "select sae_facture.RÉFÉRENCE, sae_facture.REFERENCE_DU_PAIEMENT, sae_facture.DATE_FACTURE, sae_facture.DATE_DE_PAIEMENT, sae_facture.TYPE_DE_PAIEMENT , sae_facture.ID_TYPE_FACTURE ,sae_facture.PRIX ,sae_facture.DESCRIPTION_F FROM sae_facture, sae_entreprise where sae_facture.n_siren = sae_entreprise.n_siren  and sae_entreprise.nom = '" + textFieldReponse.getText() + "' AND RÉFÉRENCE NOT LIKE '666%'" ;
				break;
			case 5: 
				switch(textFieldReponse.getText()) {
					case "Charges":
						requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE ID_TYPE_FACTURE = 1 AND RÉFÉRENCE NOT LIKE '666%'";
						break;
					case "Travaux":
						requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE ID_TYPE_FACTURE = 2 AND RÉFÉRENCE NOT LIKE '666%'";
						break;
					case "Fiscale":
						requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE ID_TYPE_FACTURE = 3 AND RÉFÉRENCE NOT LIKE '666%'";
						break;
				}
				break;
			case 6:
				System.out.println(textFieldReponse.getText());
				switch(textFieldReponse.getText()) {
					case "Virement":
						requete ="SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE TYPE_DE_PAIEMENT = 'virement' AND RÉFÉRENCE NOT LIKE '666%'";
						break;
					case "Espèces":
						requete ="SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE TYPE_DE_PAIEMENT = 'liquide' AND RÉFÉRENCE NOT LIKE '666%'";
						break;
					case "Chèque":
						requete ="SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE TYPE_DE_PAIEMENT = 'chèque' AND RÉFÉRENCE NOT LIKE '666%'";
						break;
				}
				break;
			case 7:
				switch(textFieldReponse.getText()) {
					case "Payées":
						requete = "select sae_facture.RÉFÉRENCE, sae_facture.REFERENCE_DU_PAIEMENT, sae_facture.DATE_FACTURE, sae_facture.DATE_DE_PAIEMENT, sae_facture.TYPE_DE_PAIEMENT , sae_facture.ID_TYPE_FACTURE ,sae_facture.PRIX ,sae_facture.DESCRIPTION_F from sae_facture , sae_correspondre where sae_facture.référence = sae_correspondre.référence and sae_correspondre = 1 AND RÉFÉRENCE NOT LIKE '666%'" ;
						break;
					case "Impayées":
					requete = "select sae_facture.RÉFÉRENCE, sae_facture.REFERENCE_DU_PAIEMENT, sae_facture.DATE_FACTURE, sae_facture.DATE_DE_PAIEMENT, sae_facture.TYPE_DE_PAIEMENT , sae_facture.ID_TYPE_FACTURE ,sae_facture.PRIX ,sae_facture.DESCRIPTION_F from sae_facture , sae_correspondre where sae_facture.référence = sae_correspondre.référence and sae_correspondre = 0 AND RÉFÉRENCE NOT LIKE '666%' ";
					break;
				}
				break;
			case 8:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE DESCRIPTION_F = '" + textFieldReponse.getText() + "' AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 9:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE PRIX > " + Integer.parseInt(textFieldReponse.getText()) + "AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 10:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE PRIX < " + Integer.parseInt(textFieldReponse.getText()) + "AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 11:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE AIDE = '" + textFieldReponse.getText() + "' AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 12:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE AIDE > " + Integer.parseInt(textFieldReponse.getText()) +" AND RÉFÉRENCE NOT LIKE '666%'"  ;
				break;
			case 13:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE AIDE < " + Integer.parseInt(textFieldReponse.getText()) +" AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 14:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE PRIX = " + Integer.parseInt(textFieldReponse.getText()) +" AND RÉFÉRENCE NOT LIKE '666%'" ;
				break;
			case 15:
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE AIDE = " + Integer.parseInt(textFieldReponse.getText()) +" AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 16:
				DateFormat dfe = new SimpleDateFormat("dd/MM/yyyy");
				dfe.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtile = null;
				try {
					dateUtile = dfe.parse(textFieldReponse.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Date date2 = new java.sql.Date(dateUtile.getTime());
				requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE DATE_FACTURE = " + date2  +" AND RÉFÉRENCE NOT LIKE '666%'";
				break;
			case 17:
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = null;
				try {
					dateUtil = df.parse(textFieldReponse.getText());
					java.sql.Date date = new java.sql.Date(dateUtil.getTime());
					requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture WHERE DATE_DE_PAIEMENT = " + date  +" AND RÉFÉRENCE NOT LIKE '666%'";
					System.out.println(requete);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
		}
		System.out.println(requete);
		return requete;
	}

	


	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Valider":
			FenetreFacture FenFac;
			try {
				FenFac = new FenetreFacture(toString());
				FenFac.setVisible(true);
				FenFac.toFront();
				this.dispose();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "Retour":
			String requete1 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
			try {
				FenFac = new FenetreFacture(requete1);
				FenFac.setVisible(true);
				FenFac.toFront();
				this.dispose();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
