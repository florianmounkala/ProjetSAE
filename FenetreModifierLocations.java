import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FenetreModifierLocations extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField AdresseField;
	private JTextField RégimeJuridiqueField;
	private JTextField BalconField;
	private JTextField PériodeConstructionField;
	private JTextField SurfaceField;
	private JTextField NbPieceField;
	private JTextField NbGarageField;
	private JTextField NbJardinField;
	private JTextField NbEtageField;
	private JTextField NbPorteField;
	private JTextField EDLRefField;
	private JTextField BaseLoyerM2Field;
	private JTextField CautionField;
	private JTextField StatutField;
	private Connection conn;
	private JTextField NuméroBatField;
	private JTextField NumLogementField;
	private JTextField ICCField;
	private JTextField ChargesFixesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreModifierLocations frame = new FenetreModifierLocations();
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
	public FenetreModifierLocations() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_8 = new JLabel("N\u00B0 du batiment \u00E0 modifier : ");
		panel.add(lblNewLabel_8);
		
		NuméroBatField = new JTextField();
		panel.add(NuméroBatField);
		NuméroBatField.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("N\u00B0 du logement \u00E0 modifier : ");
		panel.add(lblNewLabel_14);
		
		NumLogementField = new JTextField();
		panel.add(NumLogementField);
		NumLogementField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Localisation : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		AdresseField = new JTextField();
		panel.add(AdresseField);
		AdresseField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("R\u00E9gime juridique : ");
		panel.add(lblNewLabel_1);
		
		RégimeJuridiqueField = new JTextField();
		panel.add(RégimeJuridiqueField);
		RégimeJuridiqueField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de balcon : ");
		panel.add(lblNewLabel_2);
		
		BalconField = new JTextField();
		panel.add(BalconField);
		BalconField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("P\u00E9riode de construction : ");
		panel.add(lblNewLabel_3);
		
		PériodeConstructionField = new JTextField();
		panel.add(PériodeConstructionField);
		PériodeConstructionField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Surface : ");
		panel.add(lblNewLabel_4);
		
		SurfaceField = new JTextField();
		panel.add(SurfaceField);
		SurfaceField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre de pi\u00E8ces : ");
		panel.add(lblNewLabel_5);
		
		NbPieceField = new JTextField();
		panel.add(NbPieceField);
		NbPieceField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre de garage : ");
		panel.add(lblNewLabel_6);
		
		NbGarageField = new JTextField();
		panel.add(NbGarageField);
		NbGarageField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nombre de jardin : ");
		panel.add(lblNewLabel_7);
		
		NbJardinField = new JTextField();
		panel.add(NbJardinField);
		NbJardinField.setColumns(10);
		
		JLabel lblNombreDtages = new JLabel("Nombre d'\u00E9tages : ");
		panel.add(lblNombreDtages);
		
		NbEtageField = new JTextField();
		panel.add(NbEtageField);
		NbEtageField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Num\u00E9ro de porte : ");
		panel.add(lblNewLabel_9);
		
		NbPorteField = new JTextField();
		panel.add(NbPorteField);
		NbPorteField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("R\u00E9f\u00E9rence \u00E9tat des lieux : ");
		panel.add(lblNewLabel_10);
		
		EDLRefField = new JTextField();
		panel.add(EDLRefField);
		EDLRefField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Base loyer au m\u00B2 :");
		panel.add(lblNewLabel_11);
		
		BaseLoyerM2Field = new JTextField();
		panel.add(BaseLoyerM2Field);
		BaseLoyerM2Field.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Charges fixes : ");
		panel.add(lblNewLabel_16);
		
		ChargesFixesField = new JTextField();
		panel.add(ChargesFixesField);
		ChargesFixesField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Caution : ");
		panel.add(lblNewLabel_12);
		
		CautionField = new JTextField();
		panel.add(CautionField);
		CautionField.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("ICC : ");
		panel.add(lblNewLabel_15);
		
		ICCField = new JTextField();
		panel.add(ICCField);
		ICCField.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Statut (actif ou inactif) : ");
		panel.add(lblNewLabel_13);
		
		StatutField = new JTextField();
		panel.add(StatutField);
		StatutField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(this);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel Titre = new JLabel("Modifier un logement");
		panel_1.add(Titre);
		
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
			String requete = "{call MODIFIER_LOGEMENT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
try {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = df.parse(PériodeConstructionField.getText());
				java.sql.Date date = new java.sql.Date(dateUtil.getTime());
				
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setInt(1, Integer.parseInt(NuméroBatField.getText()));
				cstmt.setInt(2, Integer.parseInt(NumLogementField.getText()));
				cstmt.setString(3, AdresseField.getText());
				cstmt.setString(4, RégimeJuridiqueField.getText());
				cstmt.setInt(5, Integer.parseInt(BalconField.getText()));
				cstmt.setDate(6, date);
				cstmt.setInt(7, Integer.parseInt(SurfaceField.getText()));
				cstmt.setInt(8, Integer.parseInt(NbPieceField.getText()));
				cstmt.setInt(9, Integer.parseInt(NbGarageField.getText()));
				cstmt.setInt(10, Integer.parseInt(NbJardinField.getText()));
				cstmt.setString(11, NbEtageField.getText());
				cstmt.setInt(12, Integer.parseInt(NbPorteField.getText()));
				cstmt.setInt(13, Integer.parseInt(EDLRefField.getText()));
				cstmt.setInt(14, Integer.parseInt(BaseLoyerM2Field.getText()));
				cstmt.setInt(15, Integer.parseInt(ChargesFixesField.getText()));
				cstmt.setInt(16, Integer.parseInt(CautionField.getText()));
				cstmt.setInt(17, Integer.parseInt(ICCField.getText()));
				cstmt.execute();
				this.dispose();
				break;
			} catch (SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
	}
}
}
