package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

    @FXML // adnotacja
    private Button buttonHello;

    @FXML
    private Label labelWords;

    @FXML
    private TextField textFieldWords;

    @FXML
    private Button buttonInputText;

    private List<String> words;
    private List<String > randedWords = new ArrayList<>();

    private Random random;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        words = new ArrayList<>();
        words.add("Życie jest piękne");
        words.add("Heheehe");

        random = new Random();

        Utils.createDialog("Witaj!", "Nie zapomnij o koncie premium :)", "");


        buttonHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { // w chandlu będziemy wpisywać akcje na kliknięcie myszką

                String randedWord = words.get(random.nextInt(words.size())); // losujemy wyraz i zapisujemy do radedWords

                while (randedWords.contains(randedWord)){
                       randedWord = words.get(random.nextInt(words.size()));
                    if (randedWords.size() == words.size()){ // jeżeli listy mają taką samą warość przerywamy działanie

                        Utils.createDialog("Błąd", "", "Koniec sentencji :(");

                        return;

                    }
                }

                labelWords.setText(randedWord);
                randedWords.add(randedWord);

            }

        });

        buttonInputText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                words.add(textFieldWords.getText());
                textFieldWords.clear();

                }
        });

        textFieldWords.setOnKeyPressed(new EventHandler<KeyEvent>() { // textFieldWords.setOnKeyPressed(new E -> samo wygeneruje jak to wpiszemy
            @Override // kliknięcie enterem
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    words.add(textFieldWords.getText());
                    textFieldWords.clear();
                }

            }
        });

    }

/*
    public void kliknięcie(MouseEvent event){
        System.out.println("HELLOOOOO!");
    }
*/
}

