import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAjouterLocations extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField TypeLogementField;
	private JTextField NuméroBatField;
	private JTextField SurfaceField;
	private JTextField PériodeConstructionField;
	private JLabel NuméroBatLabel;
	private JTextField ICCField;
	private JTextField AdresseField;
	private JTextField NumLogementField;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterLocations frame = new FenetreAjouterLocations();
					frame.setVisible(true);
					frame.setSize(600, 400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreAjouterLocations() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel AjouterLogement = new JLabel("Ajouter un logement");
		AjouterLogement.setVerticalAlignment(SwingConstants.TOP);
		AjouterLogement.setHorizontalAlignment(SwingConstants.CENTER);
		AjouterLogement.setOpaque(true);
		AjouterLogement.setMinimumSize(new Dimension(122, 37));
		AjouterLogement.setIconTextGap(5);
		AjouterLogement.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		AjouterLogement.setAlignmentX(Component.RIGHT_ALIGNMENT);
		AjouterLogement.setBackground(Color.CYAN);
		AjouterLogement.setBounds(new Rectangle(0, 0, 20, 13));
		AjouterLogement.setForeground(Color.RED);
		AjouterLogement.setHorizontalTextPosition(SwingConstants.CENTER);
		AjouterLogement.setPreferredSize(new Dimension(180, 50));
		AjouterLogement.setSize(new Dimension(180, 100));
		AjouterLogement.setMaximumSize(new Dimension(300, 100));
		AjouterLogement.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		panel.add(AjouterLogement);
		
		NuméroBatLabel = new JLabel("Num\u00E9ro du batiment (si appartement) : ");
		panel.add(NuméroBatLabel);
		
		NuméroBatField = new JTextField();
		NuméroBatField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(NuméroBatField);
		NuméroBatField.setColumns(10);
		
		JLabel TypeLogementLabel = new JLabel("Type de logement : ");
		TypeLogementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(TypeLogementLabel);
		
		TypeLogementField = new JTextField();
		TypeLogementField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(TypeLogementField);
		TypeLogementField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(20, 20));
		panel_1.setBackground(Color.CYAN);
		panel_1.setMaximumSize(new Dimension(32765, 32765));
		panel_1.setLocation(new Point(6, 5));
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblAdresse_1 = new JLabel("Adresse :    ");
		lblAdresse_1.setOpaque(true);
		lblAdresse_1.setBackground(Color.WHITE);
		panel_7.add(lblAdresse_1);
		
		AdresseField = new JTextField();
		AdresseField.setColumns(10);
		AdresseField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(AdresseField);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblICC_1 = new JLabel("ICC :");
		lblICC_1.setPreferredSize(new Dimension(31, 14));
		lblICC_1.setOpaque(true);
		lblICC_1.setMaximumSize(new Dimension(50, 30));
		lblICC_1.setBackground(Color.WHITE);
		panel_6.add(lblICC_1);
		
		ICCField = new JTextField();
		ICCField.setColumns(10);
		ICCField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.add(ICCField);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		JLabel lblNumroDuLogement_1 = new JLabel("Num\u00E9ro du logement :");
		lblNumroDuLogement_1.setOpaque(true);
		lblNumroDuLogement_1.setBackground(Color.WHITE);
		panel_8.add(lblNumroDuLogement_1);
		
		NumLogementField = new JTextField();
		NumLogementField.setColumns(10);
		NumLogementField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.add(NumLogementField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		contentPane.add(panel_4);
		
		JLabel lblSurface = new JLabel("Surface :");
		lblSurface.setSize(new Dimension(200, 50));
		lblSurface.setPreferredSize(new Dimension(150, 40));
		lblSurface.setOpaque(true);
		lblSurface.setMinimumSize(new Dimension(190, 14));
		lblSurface.setMaximumSize(new Dimension(200, 70));
		lblSurface.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblSurface);
		
		SurfaceField = new JTextField();
		panel_4.add(SurfaceField);
		SurfaceField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		contentPane.add(panel_5);
		
		JLabel lblPriode = new JLabel("P\u00E9riode de construction :");
		lblPriode.setSize(new Dimension(200, 50));
		lblPriode.setPreferredSize(new Dimension(150, 40));
		lblPriode.setOpaque(true);
		lblPriode.setMinimumSize(new Dimension(190, 14));
		lblPriode.setMaximumSize(new Dimension(200, 70));
		lblPriode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblPriode);
		
		PériodeConstructionField = new JTextField();
		panel_5.add(PériodeConstructionField);
		PériodeConstructionField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setPreferredSize(new Dimension(120, 40));
		btnNewButton.setMaximumSize(new Dimension(125, 48));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		contentPane.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setPreferredSize(new Dimension(125, 30));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.add(btnNewButton_1);
		
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
		case "VALIDER":
			
            String sql = "insert into sae_logement(n_batiment, n_logement, localisation, typelogement, régime_juridique, balcon, période_de_construction, surface, nb_pièces, garage, jardin, étage, porte, réf_edl, base_loyer_m, charges_fixes, icc, statut) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);  // désactive la tolérance aux valeurs incorrectes
				java.util.Date dateUtil = df.parse(PériodeConstructionField.getText());
				java.sql.Date date = new java.sql.Date(dateUtil.getTime());
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(NuméroBatField.getText()));
				pstmt.setInt(2, Integer.parseInt(NumLogementField.getText()));
				pstmt.setString(3, AdresseField.getText());
				pstmt.setString(4, TypeLogementField.getText());
				pstmt.setNull(5, Types.VARCHAR);
				pstmt.setNull(6, Types.INTEGER);
				pstmt.setDate(7, date);
				pstmt.setInt(8, Integer.parseInt(SurfaceField.getText()));
				pstmt.setNull(9, Types.INTEGER);
				pstmt.setNull(10, Types.INTEGER);
				pstmt.setNull(11, Types.INTEGER);
				pstmt.setNull(12, Types.INTEGER);
				pstmt.setNull(13, Types.INTEGER);
				pstmt.setNull(14, Types.INTEGER);
				pstmt.setNull(15, Types.INTEGER);
				pstmt.setNull(16, Types.INTEGER);
				pstmt.setInt(17, Integer.parseInt(ICCField.getText()));
				pstmt.setString(18, "actif");
				pstmt.executeUpdate();
				this.dispose();
				break;
			} catch (SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}
	}
}
