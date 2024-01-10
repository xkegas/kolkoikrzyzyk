package com.example.kolkoikrzyzyk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class HelloController {
    @FXML
    private Label infoLabel;
    @FXML
    private Label kolkoWynik;
    @FXML
    private Label krzyzykWynik;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonAgain;
    @FXML
    private Button buttonBot;

    private int kolkow = 0;
    private int krzyzykw = 0;

    private int[] tablica1 = {0,0,0};
    private int[] tablica2 = {0,0,0};
    private int[] tablica3 = {0,0,0};
    private boolean kolkoTurn = true;
    private Stage stage;

    @FXML
    private void onButton1Click()
    {
        if(kolkoTurn)
        {
            button1.setText("●");
            button1.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica1[0] = 1;
        }
        else
        {
            button1.setText("❌");
            button1.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica1[0] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton2Click()
    {
        if(kolkoTurn)
        {
            button2.setText("●");
            button2.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica1[1] = 1;
        }
        else
        {
            button2.setText("❌");
            button2.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica1[1] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton3Click()
    {
        if(kolkoTurn)
        {
            button3.setText("●");
            button3.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica1[2] = 1;
        }
        else
        {
            button3.setText("❌");
            button3.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica1[2] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton4Click()
    {
        if(kolkoTurn)
        {
            button4.setText("●");
            button4.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica2[0] = 1;
        }
        else
        {
            button4.setText("❌");
            button4.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica2[0] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton5Click()
    {
        if(kolkoTurn)
        {
            button5.setText("●");
            button5.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica2[1] = 1;
        }
        else
        {
            button5.setText("❌");
            button5.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica2[1] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton6Click()
    {
        if(kolkoTurn)
        {
            button6.setText("●");
            button6.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica2[2] = 1;
        }
        else
        {
            button6.setText("❌");
            button6.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica2[2] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton7Click()
    {
        if(kolkoTurn)
        {
            button7.setText("●");
            button7.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica3[0] = 1;
        }
        else
        {
            button7.setText("❌");
            button7.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica3[0] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton8Click()
    {
        if(kolkoTurn)
        {
            button8.setText("●");
            button8.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica3[1] = 1;
        }
        else
        {
            button8.setText("❌");
            button8.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica3[1] = 2;
        }
        sprawdzWina();
    }

    @FXML
    private void onButton9Click()
    {
        if(kolkoTurn)
        {
            button9.setText("●");
            button9.setDisable(true);
            infoLabel.setText("Kolej Krzyżyka");
            kolkoTurn = false;
            tablica3[2] = 1;
        }
        else
        {
            button9.setText("❌");
            button9.setDisable(true);
            infoLabel.setText("Kolej Kółka");
            kolkoTurn = true;
            tablica3[2] = 2;
        }
        sprawdzWina();
    }

    private void sprawdzWina()
    {
        //wygrywa kolko poziomo gora
        if(tablica1[0] == 1 && tablica1[1] == 1 && tablica1[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button2.setStyle("-fx-text-fill: lightgreen");
            button3.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
        }
        //wygrywa kolko poziomo srodek
        else if(tablica2[0] == 1 && tablica2[1] == 1 && tablica2[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button4.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button6.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygyrywa kolko poziomo dol
        else if(tablica3[0] == 1 && tablica3[1] == 1 && tablica3[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button7.setStyle("-fx-text-fill: lightgreen");
            button8.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygrywa kolko pionowo lewo
        else if(tablica1[0] == 1 && tablica2[0] == 1 && tablica3[0] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button4.setStyle("-fx-text-fill: lightgreen");
            button7.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygrywa kolko pionowo srodek
        else if(tablica1[1] == 1 && tablica2[1] == 1 && tablica3[1] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button2.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button8.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygrywa kolko pionowo prawo
        else if(tablica1[2] == 1 && tablica2[2] == 1 && tablica3[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button3.setStyle("-fx-text-fill: lightgreen");
            button6.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygrywa kolko na skos od gory
        else if(tablica1[0] == 1 && tablica2[1] == 1 && tablica3[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }
        //wygrywa kolko na skos od dolu
        else if(tablica3[0] == 1 && tablica2[1] == 1 && tablica1[2] == 1)
        {
            infoLabel.setText("Wygrywa Kółko");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button7.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button3.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Kolko");
            zmienTure("Kolko");
            
        }

        //wygrywa krzyzyk poziomo od gory
        else if(tablica1[0] == 2 && tablica1[1] == 2 && tablica1[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button2.setStyle("-fx-text-fill: lightgreen");
            button3.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //wygrywa krzyzyk poziomo od srodka
        else if(tablica2[0] == 2 && tablica2[1] == 2 && tablica2[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button4.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button6.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //wygrywa krzyzyk poziomo od dolu
        else if(tablica3[0] == 2 && tablica3[1] == 2 && tablica3[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button7.setStyle("-fx-text-fill: lightgreen");
            button8.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //wygrywa krzyzyk pionowo od lewej
        else if(tablica1[0] == 2 && tablica2[0] == 2 && tablica3[0] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button4.setStyle("-fx-text-fill: lightgreen");
            button7.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //wygyra krzyzyk pionowo od srodka
        else if(tablica1[1] == 2 && tablica2[1] == 2 && tablica3[1] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button2.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button8.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //wygrywa krzyzyk pionowo po prawej
        else if(tablica1[2] == 2 && tablica2[2] == 2 && tablica3[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button3.setStyle("-fx-text-fill: lightgreen");
            button6.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
        }
        //wygrywa krzyzyk po skosie od lewej gory
        else if(tablica1[0] == 2 && tablica2[1] == 2 && tablica3[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button1.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button9.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
        }
        //wygrywa krzyzyk po skosie od lewego dolu
        else if(tablica3[0] == 2 && tablica2[1] == 2 && tablica1[2] == 2)
        {
            infoLabel.setText("Wygrywa Krzyżyk");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            button7.setStyle("-fx-text-fill: lightgreen");
            button5.setStyle("-fx-text-fill: lightgreen");
            button3.setStyle("-fx-text-fill: lightgreen");
            dodajWynik("Krzyzyk");
            zmienTure("Krzyzyk");
            
        }
        //remis
        else if(tablica1[0] != 0 && tablica1[1] != 0 && tablica1[2] != 0 && tablica2[0] != 0 && tablica2[1] != 0 && tablica2[2] != 0 && tablica3[0] != 0 && tablica3[1] != 0 && tablica3[2] != 0)
        {
            infoLabel.setText("Remis");
            buttonAgain.setVisible(true);
            wylaczPrzyciski();
            Button[] przyciski = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
            for(int i =0; i < przyciski.length; i++)
            {
                Button przycisk = przyciski[i];
                przycisk.setStyle("-fx-text-fill: red");
            }
            zmienTure("Krzyzyk");
        }
    }

    private void zmienTure(String kto)
    {
        Random rand = new Random();
        if(Objects.equals(kto, "Kolko"))
        {
           kolkoTurn = false;
        }
        else if(Objects.equals(kto, "Krzyzyk"))
        {
            kolkoTurn = true;
        }
        else{
            int losowaTura = rand.nextInt(0,2);
            if(losowaTura == 1)
            {
                kolkoTurn = true;
            }
            else {
                kolkoTurn = false;
            }
        }
    }

    private void wylaczPrzyciski()
    {
        Button[] przyciski = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
        for(int i =0; i < przyciski.length; i++)
        {
            Button przycisk = przyciski[i];
            przycisk.setDisable(true);
        }
    }

    private void dodajWynik(String kto)
    {
        if(Objects.equals(kto, "Kolko"))
        {
            kolkow++;
            kolkoWynik.setText(String.valueOf(kolkow));
        }
        else if(Objects.equals(kto, "Krzyzyk"))
        {
            krzyzykw++;
            krzyzykWynik.setText(String.valueOf(krzyzykw));
        }
    }

    @FXML
    private void zagrajPonownie()
    {
        Button[] przyciski = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
        for(int i =0; i < przyciski.length; i++)
        {
            Button przycisk = przyciski[i];
            przycisk.setText("");
            przycisk.setDisable(false);
            przycisk.setStyle("-fx-text-fill: white");
        }
        buttonAgain.setVisible(false);
        if(kolkoTurn)
        {
            infoLabel.setText("Kolej Kółka");
        }
        else
        {
            infoLabel.setText("Kolej Krzyżyka");
        }
        for(int i = 0; i < 3; i++)
        {
            tablica1[i] = 0;
            tablica2[i] = 0;
            tablica3[i] = 0;
        }
    }


    @FXML
    protected void switchTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tlo-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void jasperTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("dawidTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void murzynTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("murzynTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cypekTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("cypekTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void dawidTlo2(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("dawidTlo2.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void juanFlorydaTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("juanFlorydaTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void najmanTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("najmanTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void korwinCukierTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("korwinCukierTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ruletkaTlo(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("ruletkaTlo.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void powrot(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void zagrajZBotem(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bot.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}