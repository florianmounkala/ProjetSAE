import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AjouterFacturePropriétaire extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldRefp;
	private JTextField textFieldDescription;
	private JTextField textFieldRef;
	private JTextField textFieldDateFacture;
	private JTextField textFieldPrix;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFacturePropriétaire frame = new AjouterFacturePropriétaire();
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
	public AjouterFacturePropriétaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ajouter une facture Propri\u00E9taire");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel_1.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel_2 = new JLabel("R\u00E9f\u00E9rence :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldRef = new JTextField();
		GridBagConstraints gbc_textFieldRef = new GridBagConstraints();
		gbc_textFieldRef.anchor = GridBagConstraints.WEST;
		gbc_textFieldRef.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRef.gridx = 1;
		gbc_textFieldRef.gridy = 1;
		panel_1.add(textFieldRef, gbc_textFieldRef);
		textFieldRef.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom de la Charge :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldRefp = new JTextField();
		GridBagConstraints gbc_textFieldRefp = new GridBagConstraints();
		gbc_textFieldRefp.anchor = GridBagConstraints.WEST;
		gbc_textFieldRefp.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRefp.gridx = 1;
		gbc_textFieldRefp.gridy = 2;
		panel_1.add(textFieldRefp, gbc_textFieldRefp);
		textFieldRefp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date de la facture :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldDateFacture = new JTextField();
		GridBagConstraints gbc_textFieldDateFacture = new GridBagConstraints();
		gbc_textFieldDateFacture.anchor = GridBagConstraints.WEST;
		gbc_textFieldDateFacture.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDateFacture.gridx = 1;
		gbc_textFieldDateFacture.gridy = 3;
		panel_1.add(textFieldDateFacture, gbc_textFieldDateFacture);
		textFieldDateFacture.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Prix :");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 4;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		textFieldPrix = new JTextField();
		GridBagConstraints gbc_textFieldPrix = new GridBagConstraints();
		gbc_textFieldPrix.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrix.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrix.gridx = 1;
		gbc_textFieldPrix.gridy = 4;
		panel_1.add(textFieldPrix, gbc_textFieldPrix);
		textFieldPrix.setColumns(10);
		
		lblNewLabel_6 = new JLabel("N_batiment Affecte :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textFieldDescription = new JTextField();
		GridBagConstraints gbc_textFieldDescription = new GridBagConstraints();
		gbc_textFieldDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescription.gridx = 1;
		gbc_textFieldDescription.gridy = 5;
		panel_1.add(textFieldDescription, gbc_textFieldDescription);
		textFieldDescription.setColumns(10);
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
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "Valider":
			String requete = "{call ajouter_Facture(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = df.parse(textFieldDateFacture.getText());
				java.sql.Date date = new java.sql.Date(dateUtil.getTime());
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setString(1,"666"+textFieldRef.getText());
				cstmt.setString(2, textFieldRefp.getText());
				cstmt.setDate(3, date);
				cstmt.setInt(4,0);
				cstmt.setInt(5, 0);
				cstmt.setDate(6,null);
				cstmt.setString(7,null);
				cstmt.setInt(8,0);
				cstmt.setInt(9,0);
				cstmt.setInt(10, Integer.parseInt(textFieldPrix.getText()));
				cstmt.setInt(11, 3);
				cstmt.setInt(12, 0);
				cstmt.setString(13,textFieldDescription.getText());
				cstmt.execute();
				FenetreFacture FenFac1;
				String requete2 = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
				FenFac1 = new FenetreFacture(requete2);
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
}
