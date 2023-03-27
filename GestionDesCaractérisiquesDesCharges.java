import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class GestionDesCaractérisiquesDesCharges extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static int c = 1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesCaractérisiquesDesCharges frame = new GestionDesCaractérisiquesDesCharges(c);
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
	public GestionDesCaractérisiquesDesCharges(int Batiment) {
		this.c = Batiment ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Visiualisation des caract\u00E9ristiques du batiment " + Batiment);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{85, 0};
		gbl_panel.rowHeights = new int[]{21, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Editer une charge");
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		try {
			String requete = "Select SAE_ASSOCIER.N_LOGEMENT ,SAE_ASSOCIER.REF_CHARGE , SAE_LOGEMENT.SURFACE , SAE_LOGEMENT.NB_PIECES , SAE_LOGEMENT.GARAGE , SAE_ASSOCIER.QUOTITE from SAE_ASSOCIER , SAE_LOGEMENT Where SAE_LOGEMENT.N_LOGEMENT = SAE_ASSOCIER.N_LOGEMENT AND SAE_LOGEMENT.N_BATIMENT = SAE_ASSOCIER.N_BATIMENT AND SAE_ASSOCIER.N_BATIMENT = "+ Batiment +"ORDER BY SAE_ASSOCIER.REF_CHARGE , SAE_ASSOCIER.N_LOGEMENT ";
            Connection conn = getConnection();
	
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
            	int  n_logement = resultat.getInt("N_LOGEMENT");
                String référence_charge = resultat.getString("REF_CHARGE");
                int Surface = resultat.getInt("SURFACE");
                int NB_pièces = resultat.getInt("NB_PIECES");
                int garage = resultat.getInt("GARAGE");
                String quotité= resultat.getString("QUOTITE");
                if (garage == 1) {
                	model.addElement("Logement : "+n_logement+" charge : " + référence_charge + "Quotité : "+ quotité +" Surface : " +Surface + " Garage : oui  Nombre de pièces :" + NB_pièces);       
                }else {
                	model.addElement("Logement : "+n_logement+" charge : " + référence_charge + "Quotité : "+ quotité +" Surface : " +Surface + " Garage : non Nombre de pièces :" + NB_pièces);
                }
                }

            JList<String> liste_facture = new JList<>(model);
    		contentPane.add(liste_facture, BorderLayout.CENTER);
            getContentPane().add(liste_facture);
            
            JTextPane txtpnVoiciLesQuotites = new JTextPane();
            txtpnVoiciLesQuotites.setText("Voici les quotit\u00E9es actuelles pour un batimment donn\u00E9 . Il est possible de les modifier mais pas de les ajouter. L'\u00E9quipe de d\u00E9vellopement de ce logiciel ne prends pas en charge les incoh\u00E9rences dans les donn\u00E9es saisies par l'utilisateur et se d\u00E9doine totalement des erreures dues a la modifications de ces derni\u00E8res !");
            txtpnVoiciLesQuotites.setForeground(new Color(255, 0, 0));
            txtpnVoiciLesQuotites.setEditable(false);
            contentPane.add(txtpnVoiciLesQuotites, BorderLayout.SOUTH);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
			case "Editer une charge" :
				int B = this.c;
				System.out.println(B);
				SaisieDesCaracteristiquesDesCharges Editer_ent ;
				Editer_ent = new SaisieDesCaracteristiquesDesCharges(B);
				Editer_ent.setVisible(true);
				Editer_ent.toFront();
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
