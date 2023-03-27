import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.Box;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FenetreModifierFacture extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldRéférence;
	private JTextField textField_refpaiment;
	private JTextField textField_Date_Facture;
	private JTextField textField_Charges_df;
	private JTextField textField_Charges_Régularisé;
	private JTextField textField_Date_paiement;
	private JTextField textField_type_paiement;
	private JTextField textField_M_aide;
	private JTextField textField_prix;
	private JTextField textField_Id_fac;
	private JTextField textField_siren;
	private JTextField textField_description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreModifierFacture frame = new FenetreModifierFacture();
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
	public FenetreModifierFacture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Modifier une facture");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButtonValider = new JButton("Valider");
		btnNewButtonValider.addActionListener(this);
		panel_1.add(btnNewButtonValider);
		
		JButton btnNewButton_Annuler = new JButton("Annuler");
		btnNewButton_Annuler.addActionListener(this);
		panel_1.add(btnNewButton_Annuler);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		
		JLabel lblRéférence = new JLabel("R\u00E9f\u00E9rence de la facture");
		panel_3.add(lblRéférence);
		
		textFieldRéférence = new JTextField();
		panel_3.add(textFieldRéférence);
		textFieldRéférence.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_ref_paiement = new JLabel("R\u00E9f\u00E9rence du paiement :");
		panel_4.add(lblNewLabel_ref_paiement);
		
		textField_refpaiment = new JTextField();
		textField_refpaiment.setColumns(10);
		panel_4.add(textField_refpaiment);
		
		JLabel lblNewLabel_Date_facture = new JLabel("Date Facture :");
		panel_4.add(lblNewLabel_Date_facture);
		
		textField_Date_Facture = new JTextField();
		textField_Date_Facture.setColumns(10);
		panel_4.add(textField_Date_Facture);
		
		JLabel lblNewLabel_Charges = new JLabel("Charges dues :");
		panel_4.add(lblNewLabel_Charges);
		
		textField_Charges_df = new JTextField();
		textField_Charges_df.setColumns(10);
		panel_4.add(textField_Charges_df);
		
		JLabel lblNewLabel_Charges_r = new JLabel("Charges_R\u00E9gularis\u00E9es");
		panel_4.add(lblNewLabel_Charges_r);
		
		Box horizontalBox = Box.createHorizontalBox();
		panel_4.add(horizontalBox);
		
		textField_Charges_Régularisé = new JTextField();
		textField_Charges_Régularisé.setColumns(10);
		panel_4.add(textField_Charges_Régularisé);
		
		JLabel lblNewLabel_Date_de_paiement = new JLabel("Date de paiement");
		panel_4.add(lblNewLabel_Date_de_paiement);
		
		textField_Date_paiement = new JTextField();
		textField_Date_paiement.setColumns(10);
		panel_4.add(textField_Date_paiement);
		
		JLabel lblNewLabel_Type_factures = new JLabel("Type de paiement");
		panel_4.add(lblNewLabel_Type_factures);
		
		textField_type_paiement = new JTextField();
		textField_type_paiement.setColumns(10);
		panel_4.add(textField_type_paiement);
		
		JLabel lblNewLabel_Montant_aide = new JLabel("Montant de l'aide");
		panel_4.add(lblNewLabel_Montant_aide);
		
		textField_M_aide = new JTextField();
		textField_M_aide.setColumns(10);
		panel_4.add(textField_M_aide);
		
		JLabel lblNewLabel_Prix = new JLabel("Prix / total facture :");
		panel_4.add(lblNewLabel_Prix);
		
		textField_prix = new JTextField();
		textField_prix.setColumns(10);
		panel_4.add(textField_prix);
		
		JLabel lblNewLabel_Id_type_facture = new JLabel("Id_type_facture");
		panel_4.add(lblNewLabel_Id_type_facture);
		
		textField_Id_fac = new JTextField();
		textField_Id_fac.setColumns(10);
		panel_4.add(textField_Id_fac);
		
		JLabel lblNewLabel_Siren = new JLabel("Siren");
		panel_4.add(lblNewLabel_Siren);
		
		textField_siren = new JTextField();
		panel_4.add(textField_siren);
		textField_siren.setColumns(10);
		
		JLabel lblNewLabel_Description = new JLabel("Description :");
		panel_4.add(lblNewLabel_Description);
		
		textField_description = new JTextField();
		panel_4.add(textField_description);
		textField_description.setColumns(10);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Annuler":
			String requete11 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
			try {
				FenetreFacture FenFac1;
				FenFac1 = new FenetreFacture(requete11);
				FenFac1.setVisible(true);
				FenFac1.toFront();
				this.dispose();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "Valider":
			String requete = "{call MODIFIER_FACTURE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = df.parse(textField_Date_Facture.getText());
				java.sql.Date date = new java.sql.Date(dateUtil.getTime());
				java.util.Date dateUtil2 = df.parse(textField_Date_paiement.getText());
				java.sql.Date date2 = new java.sql.Date(dateUtil2.getTime());
				int x = 0 ; 
				switch(textField_Id_fac.getText()) {
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
				System.out.println(x);
				int y = 0 ;
				if (textField_M_aide.getText() != "0") {
					y = 1;
				}
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setString(1, textFieldRéférence.getText());
				cstmt.setString(2, textField_refpaiment.getText());
				cstmt.setDate(3, date);
				cstmt.setInt(4, Integer.parseInt(textField_Charges_df.getText()));
				cstmt.setInt(5, Integer.parseInt(textField_Charges_Régularisé.getText()));
				cstmt.setDate(6,date2);
				cstmt.setString(7,textField_type_paiement.getText());
				cstmt.setInt(8,y);
				cstmt.setInt(9, Integer.parseInt(textField_M_aide.getText()));
				cstmt.setInt(10, Integer.parseInt(textField_prix.getText()));
				cstmt.setInt(11, x);
				cstmt.setInt(12, Integer.parseInt(textField_siren.getText()));
				cstmt.setString(13,textField_description.getText());

				cstmt.execute();
				String requete1 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
				FenetreFacture FenFac;
				FenFac = new FenetreFacture(requete1);
				FenFac.setVisible(true);
				FenFac.toFront();
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
