import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.AbstractListModel;

public class test extends JFrame implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                test frame = new test();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	private JComboBox<?> comboBox ;
	private String[][] tableau;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> listTravaux = new JList<>(model);
	
   
	@SuppressWarnings("unchecked")
	public test() throws SQLException {
        setTitle("Fenêtre des documents");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelFiltre = new JPanel();
        mainPanel.add(panelFiltre);
        

        JLabel labelSelection = new JLabel("Veuillez s\u00E9lectionner un logement :");
        panelFiltre.add(labelSelection);

        JSplitPane splitPane = new JSplitPane();
        panelFiltre.add(splitPane);

        JButton btnResearch = new JButton("Rechercher");
        btnResearch.addActionListener(this);
        splitPane.setRightComponent(btnResearch);
        
        String [] tableau1 = logement_combobox();
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(tableau1));
        splitPane.setLeftComponent(comboBox);

        JPanel panelList = new JPanel();
        mainPanel.add(panelList);
                panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
                
                JLabel lblNewLabel = new JLabel("Diagnostics");
                lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
                panelList.add(lblNewLabel);
                
                
                listTravaux.setModel(new AbstractListModel() {
                	String[] values = new String[] {};
                	public int getSize() {
                		return values.length;
                	}
                	public Object getElementAt(int index) {
                		return values[index];
                	}
                });
                panelList.add(listTravaux);
                
                JLabel lblNewLabel_1 = new JLabel("Travaux");
                lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
                lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelList.add(lblNewLabel_1);
                panelList.add(listTravaux);

        btnResearch.addActionListener(this);
        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
     //Menu déroulant, sélection du logement   
    //Récupère les logement existant dans la base de donnée.
    public String[] logement_combobox() {
        String [] tableau1 = null;
        try {
            // Establish connection to the database
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            
            String bSql = "SELECT COUNT(*) FROM SAE_LOGEMENT";
            ResultSet result2 = statement.executeQuery(bSql);
            result2.next();
            int count = result2.getInt(1);
            String rSql = "SELECT N_BATIMENT, N_LOGEMENT, LOCALISATION FROM SAE_LOGEMENT";
            ResultSet result = statement.executeQuery(rSql);

            tableau1 = new String[count];
            tableau = new String[count][3];
            int i = 0;
            while (result.next()) {
                String n_batiment = result.getString("N_BATIMENT");
                String n_logement = result.getString("N_LOGEMENT");
                String localisation = result.getString("LOCALISATION");
                tableau[i][0] =  n_batiment;
                tableau[i][1] =  n_logement;
                tableau[i][2] =  localisation;
                tableau1[i]="N° Batiment : " + n_batiment +" " + "N°Logement : " + n_logement + " Adresse : " + localisation ;
                i++;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableau1;
    }
    
    
    //Récupération des documents liés a un logement.
    //Fonction de connexion à la BDD
    private static Connection getConnection() throws SQLException {
    	// Connexion à la base de données
    	CictOracleDataSource bd = new CictOracleDataSource();
    	Connection cn = bd.getConnection();
		return cn;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		
		case"Rechercher":
			if(comboBox.getModel().getSelectedItem() != null) {
				//Batiment
				int bat = Integer.parseInt(tableau[comboBox.getSelectedIndex()][0])   ; 
				//System.out.println(bat);
				//Logement
				int log = Integer.parseInt(tableau[comboBox.getSelectedIndex()][1]);
	            //System.out.println(log);
				try {
                    // Connexion BDD
                    Connection conn = getConnection();
                    String sql_travaux = "{ ? = call GET_TRAVAUX_LOGEMENT(?, ?)}";
                    CallableStatement statement = conn.prepareCall(sql_travaux);
                    statement.registerOutParameter(1, Types.REF_CURSOR);
                    statement.setInt(2, log); //Paramètre Requête, numéro de logement
                    statement.setInt(3, bat); //Paramètre Batiment
                    statement.executeQuery(); // Execution de la requête
                    ResultSet result = (ResultSet) statement.getObject(1);
                    System.out.println(result);
                    
                    while(result.next()) { 
                    	
                    	String ref = result.getString("RÉFÉRENCE"); String
                    	date_facture = result.getString("DATE_FACTURE"); int prix = result.getInt("PRIX");
                    	String ref_paiement = result.getString("RÉFÉRENCE_DU_PAIEMENT"); 
                    	Date date_paiement = result.getDate("DATE_DE_PAIEMENT"); 
                    	String type_paiement = result.getString("TYPE_DE_PAIEMENT"); 
                    	int num_siren = result.getInt("N_SIREN"); String nom_travaux = result.getString("NOM"); 
                    	String addr_travaux= result.getString("ADRESSE"); 
                    	String addr_email = result.getString("ADRESSE_MAIL"); 
					  	int num_phone= result.getInt("TÉL");
					  	
					  	model.addElement("Référence facture : " + ref +" " + date_facture + "prix : "+prix + "Type de paiement : " + type_paiement 
							  + "Date de paiement : " + date_paiement + "SIREN : " + num_siren + "Nom entreprise : " + nom_travaux + "Adresse_entreprise : " + addr_travaux +
							  "Adresse e-mail : " + addr_email + "Téléphone : " + num_phone); }
                    
                    //Fermeture de la connexion
                    result.close();
                    statement.close();
                    conn.close();
                    break;
                }				

				
				 catch (Exception e1) {
			            e1.printStackTrace();
			        }
				
			}
		}
    }
}