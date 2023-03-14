/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import it.polito.tdp.model.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Dizionario dizionario=new Dizionario();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonTraduzione"
    private Button buttonTraduzione; // Value injected by FXMLLoader

    @FXML // fx:id="txtInserimento"
    private TextField txtInserimento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessaggio"
    private TextArea txtMessaggio; // Value injected by FXMLLoader

    @FXML
    void doTraduzione(ActionEvent event) {
    	String[] parole=this.txtInserimento.getText().split(" ");
    	boolean flag=false;
    	for (String s:parole) {
    		s.toLowerCase();
    		for (int i=0;i<s.length();i++) {
    			if (!"abcdefghijklmnopqrstuvwxz".contains(""+s.charAt(i)))
    				flag=true;
    		}
    	}
    	//System.out.println("fatto");
    	if(flag) {
    		this.txtMessaggio.setText("è presente un carattere non corretto");
    		this.txtInserimento.clear();}
    	
    	else {
	    	if(parole.length==1) {
	    		LinkedList<String> parolaTradotta=dizionario.traduciParola(parole[0]);
	    		this.txtInserimento.clear();
	    		if (parolaTradotta!=null) {
	    			String testoFinale=("La/e traduzione/i della parola "+parole[0]+" è/sono :\n");
	    			for (String s: parolaTradotta)
	    				testoFinale+=" "+s;
	    			this.txtMessaggio.setText(testoFinale);
	    		}
	    		else
	    			this.txtMessaggio.setText("Parola inesistente");
	    			
	    	}
	    	else if (parole.length==2) {
	    		boolean risultato=dizionario.inserisciParola(parole[0], parole[1]);
	    		this.txtInserimento.clear();
	    		if (risultato)
	    			this.txtMessaggio.setText("Parola inserita correttamente");
	    		else
	    			this.txtMessaggio.setText("Traduzione già esistente");
	    			
	    	}
	    	
	    	else if (parole.length>2) {
	    		this.txtMessaggio.setText("Troppe parole inserite!!");
	    		this.txtInserimento.clear();
	    	}
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonTraduzione != null : "fx:id=\"buttonTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessaggio != null : "fx:id=\"txtMessaggio\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
