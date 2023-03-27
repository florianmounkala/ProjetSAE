import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class FenetreAjouterFacture extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldCharges_regularise;
	private JTextField textFieldMontantaide;
	private JTextField textFieldSiren;
	private JTextField txfCharges_dues;
	private JTextField textField_DatePaiement;
	private JTextField textField_Date_fac;
	private JTextField textField_reference_paiement;
	private JTextField textPrixFacture;
	private JTextField textField_Reference;
	private JTextField textFieldTypeFacture;
	private JTextField textFieldTypePaiement;
	private JTextField txtAide;
	private JTextField textFieldDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterFacture frame = new FenetreAjouterFacture();
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
	public FenetreAjouterFacture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitreAjouterFac = new JLabel("Ajouter une nouvelle facture");
		lblTitreAjouterFac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitreAjouterFac.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitreAjouterFac, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblReferencefacture = new JLabel("R\u00E9f\u00E9rence :");
		
		JLabel lblReference_paiement = new JLabel("R\u00E9f\u00E9rence du paiement :");
		
		textField_reference_paiement = new JTextField();
		textField_reference_paiement.setColumns(10);
		
		JLabel lblNewLabel_Fate_fac = new JLabel(" Date de la facture :");
		
		JLabel lblCharges_dues = new JLabel("Charges dues :");
		
		txfCharges_dues = new JTextField();
		txfCharges_dues.setColumns(10);
		
		JLabel lblChargesRégularise = new JLabel("Charges r\u00E9gularis\u00E9es :");
		
		JLabel lblDate_Paiement = new JLabel("Date de paiement :");
		
		JLabel lblTypePaiement = new JLabel("Type de paiement :");
		
		JLabel lblAide = new JLabel("Aide (oui ou non) :");
		
		JLabel lblMontant_aide = new JLabel("Montant de l'aide :");
		
		textFieldMontantaide = new JTextField();
		textFieldMontantaide.setColumns(10);
		
		JLabel lblPrixFacture = new JLabel("Montant de la facture :");
		
		JLabel lblType_de_facture = new JLabel("Type de facture");
		
		JLabel lblNewLabel_12 = new JLabel("N\u00B0Siren de l'entreprise :");
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setToolTipText("");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(lblReferencefacture);
		
		textField_Reference = new JTextField();
		textField_Reference.setColumns(10);
		panel.add(textField_Reference);
		panel.add(lblReference_paiement);
		panel.add(textField_reference_paiement);
		panel.add(lblNewLabel_Fate_fac);
		
		textField_Date_fac = new JTextField();
		textField_Date_fac.setColumns(10);
		panel.add(textField_Date_fac);
		panel.add(lblCharges_dues);
		panel.add(txfCharges_dues);
		panel.add(lblChargesRégularise);
		
		textFieldCharges_regularise = new JTextField();
		textFieldCharges_regularise.setColumns(10);
		panel.add(textFieldCharges_regularise);
		panel.add(lblDate_Paiement);
		
		textField_DatePaiement = new JTextField();
		textField_DatePaiement.setColumns(10);
		panel.add(textField_DatePaiement);
		panel.add(lblTypePaiement);
		
		textFieldTypePaiement = new JTextField();
		textFieldTypePaiement.setText("Virement");
		panel.add(textFieldTypePaiement);
		textFieldTypePaiement.setColumns(10);
		panel.add(lblAide);
		
		txtAide = new JTextField();
		panel.add(txtAide);
		txtAide.setColumns(10);
		panel.add(lblMontant_aide);
		panel.add(textFieldMontantaide);
		panel.add(lblPrixFacture);
		
		textPrixFacture = new JTextField();
		textPrixFacture.setColumns(10);
		panel.add(textPrixFacture);
		panel.add(lblType_de_facture);
		
		textFieldTypeFacture = new JTextField();
		textFieldTypeFacture.setText("Charges");
		panel.add(textFieldTypeFacture);
		textFieldTypeFacture.setColumns(10);
		panel.add(lblNewLabel_12);
		
		textFieldSiren = new JTextField();
		textFieldSiren.setColumns(10);
		panel.add(textFieldSiren);
		panel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		panel.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButtonValider = new JButton("Valider");
		btnNewButtonValider.addActionListener(this);
		panel_1.add(btnNewButtonValider);
		
		JButton btnNewButtonAnnuler = new JButton("Annuler");
		btnNewButtonAnnuler.addActionListener(this);
		panel_1.add(btnNewButtonAnnuler);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Annuler":
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
		case "Valider":
			String requete = "{call ajouter_Facture(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = df.parse(textField_Date_fac.getText());
				java.sql.Date date = new java.sql.Date(dateUtil.getTime());
				java.util.Date dateUtil2 = df.parse(textField_DatePaiement.getText());
				java.sql.Date date2 = new java.sql.Date(dateUtil2.getTime());
				int x = 0 ; 
				switch(textFieldTypeFacture.getText()) {
				case "Charges" :
					x =1;
					break;
				case "Travaux":
					x = 2 ;
					break;
				case"Fiscale":
					x = 3;
					break;
			}
				int y = 0 ;
				if (textFieldMontantaide.getText() != "0") {
					y = 1;
				}
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setString(1, textField_Reference.getText());
				cstmt.setString(2, textField_reference_paiement.getText());
				cstmt.setDate(3, date);
				cstmt.setInt(4, Integer.valueOf(txfCharges_dues.getText()));
				cstmt.setInt(5, Integer.valueOf(textFieldCharges_regularise.getText()));
				cstmt.setDate(6,date2);
				cstmt.setString(7,textFieldTypePaiement.getText());
				cstmt.setInt(8,y);
				cstmt.setInt(9, Integer.parseInt(textFieldMontantaide.getText()));
				cstmt.setInt(10, Integer.parseInt(textPrixFacture.getText()));
				cstmt.setInt(11, x);
				cstmt.setInt(12, Integer.parseInt(textFieldSiren.getText()));
				cstmt.setString(13,textFieldDescription.getText());

				cstmt.execute();
				String requete11 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
				FenetreFacture FenFac1;
				FenFac1 = new FenetreFacture(requete11);
				FenFac1.setVisible(true);
				FenFac1.toFront();
				this.dispose();
				break;
			} catch (SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private static Connection getConnection() throws SQLException {
    	// Connexion à la base de données
    	CictOracleDataSource bd = new CictOracleDataSource();
    	Connection cn = bd.getConnection();
		return cn;
    }

	
}
