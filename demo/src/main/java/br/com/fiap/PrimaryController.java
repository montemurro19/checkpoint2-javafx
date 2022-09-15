package br.com.fiap;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML TextField textFieldIdTitulo;
    @FXML TextField textFieldIdAlbum;
    @FXML TextField textFieldIdArtista;
    @FXML TextField textFieldIdGenero;
    @FXML ChoiceBox<String> choiceBoxNota;
    @FXML CheckBox checkBoxFavorito;
    @FXML Button buttonSalvar;

    @FXML Button buttonOrdenarNota;
    @FXML Button buttonOrdenarCategoria;
    @FXML Button buttonOrdenarArtista;
    @FXML ListView<Musica> listView;

    @FXML ListView<Musica> listView2;

    private List<Musica> lista = new ArrayList<>();
    private List<Musica> listaFav = new ArrayList<>();

    public void salvar(){

        if(checkBoxFavorito.isSelected()){
            var musica = setarFormulario();
            lista.add(musica);  
            listaFav.add(musica);
    
            alerta("Música cadastrada com sucesso");  
    
            limparFormulario();
            
            listView.getItems().add(musica);
            listView2.getItems().add(musica);
        }else{
            var musica = setarFormulario();
            lista.add(musica); 
    
            alerta("Música cadastrada com sucesso");  
    
            limparFormulario();
            
            listView.getItems().add(musica);
        }               
    }
    
    private void alerta(String mensagem){
        
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText(mensagem);
        alerta.show();

    }
    
    private void limparFormulario(){
        
        textFieldIdTitulo.setText("");
        textFieldIdAlbum.setText("");
        textFieldIdArtista.setText("");
        textFieldIdGenero.setText("");
        choiceBoxNota.setValue("");
        
    }
    
    private Musica setarFormulario(){
        
        String titulo = textFieldIdTitulo.getText();
        String album = textFieldIdAlbum.getText();
        String artista = textFieldIdArtista.getText();
        String genero = textFieldIdGenero.getText();
        String nota = choiceBoxNota.getValue();
    
        Musica musica = new Musica(titulo, album, artista, genero, nota);

        return musica;

    }

    public void ordenarPorNota(){
        lista.sort((o1,o2) -> { return Integer.compare(Integer.valueOf(o1.getNota()),Integer.valueOf(o2.getNota())); });
        atualizarLista();
    }

    public void ordenarPorCategoria(){
        lista.sort((o1, o2) -> o1.getGenero().compareTo(o2.getGenero()));
        atualizarLista();        
    }

    public void ordenarPorArtista(){
        lista.sort((o1, o2) -> o1.getArtista().compareTo(o2.getArtista()));
        atualizarLista();        
    }

    public void atualizarLista(){

        listView.getItems().clear();
        listView.getItems().addAll(lista);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<String>  notas = new  ArrayList<>();
        notas.add("1");
        notas.add("2");
        notas.add("3");
        notas.add("4");
        notas.add("5");

        choiceBoxNota.getItems().addAll(notas);
        
    }
}
