import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class SaisieDesCaracteristiquesDesCharges extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldref;
	private JTextField textField_nlog;
	private JTextField textField_quotite;
	public static int x;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaisieDesCaracteristiquesDesCharges frame = new SaisieDesCaracteristiquesDesCharges(x);
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
	public SaisieDesCaracteristiquesDesCharges(int Batiment) {
		x = Batiment;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informations a saisir :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("R\u00E9f\u00E9rence de la charge :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldref = new JTextField();
		GridBagConstraints gbc_textFieldref = new GridBagConstraints();
		gbc_textFieldref.anchor = GridBagConstraints.WEST;
		gbc_textFieldref.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldref.gridx = 4;
		gbc_textFieldref.gridy = 2;
		contentPane.add(textFieldref, gbc_textFieldref);
		textFieldref.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("N_logement");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 3;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_nlog = new JTextField();
		GridBagConstraints gbc_textField_nlog = new GridBagConstraints();
		gbc_textField_nlog.anchor = GridBagConstraints.WEST;
		gbc_textField_nlog.insets = new Insets(0, 0, 5, 0);
		gbc_textField_nlog.gridx = 4;
		gbc_textField_nlog.gridy = 3;
		contentPane.add(textField_nlog, gbc_textField_nlog);
		textField_nlog.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Informations a modifier :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Nouvelle quotit\u00E9 :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_quotite = new JTextField();
		GridBagConstraints gbc_textField_quotite = new GridBagConstraints();
		gbc_textField_quotite.anchor = GridBagConstraints.WEST;
		gbc_textField_quotite.insets = new Insets(0, 0, 5, 0);
		gbc_textField_quotite.gridx = 4;
		gbc_textField_quotite.gridy = 6;
		contentPane.add(textField_quotite, gbc_textField_quotite);
		textField_quotite.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 8;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Annuler":
			GestionDesCaractérisiquesDesCharges FenFac1;
			FenFac1 = new GestionDesCaractérisiquesDesCharges(x);
			FenFac1.setVisible(true);
			FenFac1.toFront();
			this.dispose();
			break;
		case "Valider":
			String requete = "{call MODIFIER_QUOTITE(?, ?, ?, ?)}";
			try {
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setInt(1, Integer.valueOf(textFieldref.getText()));
				cstmt.setInt(2, Integer.valueOf(textField_nlog.getText()));
				cstmt.setInt(3, x);
				cstmt.setString(4, textField_quotite.getText());
				cstmt.execute();
				GestionDesCaractérisiquesDesCharges FenFac2;
				FenFac2 = new GestionDesCaractérisiquesDesCharges(x);
				FenFac2.setVisible(true);
				FenFac2.toFront();
				this.dispose();
				break;
			} catch (SQLException e1) {
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
