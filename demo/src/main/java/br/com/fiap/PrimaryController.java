package br.com.fiap;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.model.Musica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML TextField textFieldIdTitulo;
    @FXML TextField textFieldIdAlbum;
    @FXML TextField textFieldIdArtista;
    @FXML ChoiceBox<String> choiceBoxNota;
    @FXML Button buttonSalvar;

    private List<Musica> lista = new ArrayList<>();

    public void salvar(){

        String titulo = textFieldIdTitulo.getText();
        String album = textFieldIdAlbum.getText();
        String artista = textFieldIdArtista.getText();
        String nota = choiceBoxNota.getValue();

        Musica musica = new Musica(titulo, album, artista, nota);
        lista.add(musica);

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText("Música cadastrada com sucesso");
        alerta.show();

        System.out.println(musica);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<String>  notas = new  ArrayList<>();
//pra que caralhos serve aquele "e:" perguntar quinta
        notas.add("1");
        notas.add("2");
        notas.add("3");
        notas.add("4");
        notas.add("5");

        choiceBoxNota.getItems().addAll(notas);
        
    }
}
