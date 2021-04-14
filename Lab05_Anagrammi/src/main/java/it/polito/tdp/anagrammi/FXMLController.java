package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model m;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaImm;

    @FXML
    private TextArea txtAnaCorretti;

    @FXML
    private TextArea txtAnaSba;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {

    	String immessa=this.txtParolaImm.getText();
//    	List<String> anagrammi ;
    	Set<String> anagrammi ;
    	if(immessa.length()<6) {
    	anagrammi=m.anagrammi(immessa);
    
    	//Stampa in modo brutto
    	//this.txtAnaCorretti.setText(anagrammi.toString());
    	
    	//stampa corretta
    	for(String s: anagrammi) {
    		if(m.isCorret(s)) {
    			//if(!this.txtAnaCorretti.getText().contains(s))     --> se uso il Set non servono
    			if(this.txtAnaCorretti.getText().equals("")) {
    				this.txtAnaCorretti.appendText(s);} else {
    		this.txtAnaCorretti.appendText("\n"+s);
    		}
    		} else {//if(!this.txtAnaSba.getText().contains(s))    --> se uso il Set non servono
    			this.txtAnaSba.appendText(s+"\n");}
    		}
    	} else {
    		this.txtAnaCorretti.setText("Inserire parola più corta di 6 caratteri");
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {

    	this.txtAnaCorretti.clear();
    	this.txtAnaSba.clear();
    	this.txtParolaImm.clear();
    	
    }
    
    public void setModel(Model model) {
    	this.m=model;
    }

    @FXML
    void initialize() {
        assert txtParolaImm != null : "fx:id=\"txtParolaImm\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnaCorretti != null : "fx:id=\"txtAnaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnaSba != null : "fx:id=\"txtAnaSba\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
