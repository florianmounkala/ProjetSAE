import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Fenetre_Batiment extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Batiment frame = new Fenetre_Batiment();
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
	public Fenetre_Batiment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("Liste des batiments");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitre, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButtonAjouterBatiment = new JButton("Ajouter un batiment");
		btnNewButtonAjouterBatiment.addActionListener(this);
		panel.add(btnNewButtonAjouterBatiment);
		
		JButton btnNewButtonModifierBat = new JButton("Modifier un batiment");
		btnNewButtonModifierBat.addActionListener(this);
		panel.add(btnNewButtonModifierBat);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JButton btnNewButton_Annuler = new JButton("Retour");
		btnNewButton_Annuler.addActionListener(this);
		panel.add(btnNewButton_Annuler);
		
		JList list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		
		try {
			String requete = "SELECT * FROM SAE_BATIMENT";
			// Établir la connexion à la base de données
            Connection conn = getConnection();
	
            // Créer un objet Statement
            Statement statement = conn.createStatement();

            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Exécuter la requête et récupérer le ResultSet
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                int  id_bat = resultat.getInt("N_BATIMENT");
                int nblogement = resultat.getInt("NB_LOGEMENT");
                String cp = resultat.getString("CODE_POSTAL");
                String nb_etage = resultat.getString("NB_ETAGE");
                String rue = resultat.getString("RUE");
                String ville = resultat.getString("VILLE");
                model.addElement("Le batiment est situé "+rue+" "+cp+" "+ville+" .Il possède " +nblogement +" logement(s) et "+nb_etage +" étage(s). Son ID est : "+id_bat);
            }

            JList<String> liste_facture = new JList<>(model);
    		contentPane.add(liste_facture, BorderLayout.CENTER);
            getContentPane().add(liste_facture);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
			case "Ajouter un batiment" :
				AjouterBatiment Ajouter_bat ;
				Ajouter_bat = new AjouterBatiment();
				Ajouter_bat.setVisible(true);
				Ajouter_bat.toFront();
				this.dispose();
				break;
			case "Modifier un batiment" :
				ModifierBatiment Modifier_bat ;
				Modifier_bat = new ModifierBatiment();
				Modifier_bat.setVisible(true);
				Modifier_bat.toFront();
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
