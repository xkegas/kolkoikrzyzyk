package com.example.kolkoikrzyzyk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Bot {
    @FXML
    private Label kolkoWynik;
    @FXML
    private Label krzyzykWynik;
    @FXML
    private Label infoLabel;
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
    private boolean wygrana = false;

    private int kolkow = 0;
    private int krzyzykw = 0;

    private int[] tablica1 = {0,0,0};
    private int[] tablica2 = {0,0,0};
    private int[] tablica3 = {0,0,0};
    private Stage stage;

    @FXML
    private void onButton1Click()
    {
            button1.setText("●");
            button1.setDisable(true);
            
            tablica1[0] = 1;
            sprawdzWina();
            ruchBot();
    }

    @FXML
    private void onButton2Click()
    {
            button2.setText("●");
            button2.setDisable(true);
            
            tablica1[1] = 1;
            sprawdzWina();
            ruchBot();
    }

    @FXML
    private void onButton3Click()
    {
            button3.setText("●");
            button3.setDisable(true);
            
            tablica1[2] = 1;


        sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton4Click()
    {
            button4.setText("●");
            button4.setDisable(true);
            
            tablica2[0] = 1;


        sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton5Click()
    {
            button5.setText("●");
            button5.setDisable(true);
            
            tablica2[1] = 1;


        sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton6Click()
    {
            button6.setText("●");
            button6.setDisable(true);
            
            tablica2[2] = 1;

        sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton7Click()
    {
            button7.setText("●");
            button7.setDisable(true);
            
            tablica3[0] = 1;


       sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton8Click()
    {
            button8.setText("●");
            button8.setDisable(true);
            
            tablica3[1] = 1;


        sprawdzWina();
        ruchBot();
    }

    @FXML
    private void onButton9Click()
    {
            button9.setText("●");
            button9.setDisable(true);
            
            tablica3[2] = 1;

        sprawdzWina();
        ruchBot();
    }

    private void ruchBot()
    {
        if(!wygrana) {
            Random rand = new Random();
            Button[] przyciski = {button1, button2, button3, button4, button5, button6, button7, button8, button9};

            int los = rand.nextInt(przyciski.length);
            Button przycisk = przyciski[los];
            while (przycisk.isDisabled()) {
                los = rand.nextInt(przyciski.length);
                przycisk = przyciski[los];
            }
            przycisk.setText("❌");
            przycisk.setDisable(true);

            if (Objects.equals(przycisk.getId(), "button1")) {
                tablica1[0] = 2;
            } else if (Objects.equals(przycisk.getId(), "button2")) {
                tablica1[1] = 2;
            } else if (Objects.equals(przycisk.getId(), "button3")) {
                tablica1[2] = 2;
            } else if (Objects.equals(przycisk.getId(), "button4")) {
                tablica2[0] = 2;
            } else if (Objects.equals(przycisk.getId(), "button5")) {
                tablica2[1] = 2;
            } else if (Objects.equals(przycisk.getId(), "button6")) {
                tablica2[2] = 2;
            } else if (Objects.equals(przycisk.getId(), "button7")) {
                tablica3[0] = 2;
            } else if (Objects.equals(przycisk.getId(), "button8")) {
                tablica3[1] = 2;
            } else if (Objects.equals(przycisk.getId(), "button9")) {
                tablica3[2] = 2;
            }
            sprawdzWina();
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
        for(int i = 0; i < 3; i++)
        {
            tablica1[i] = 0;
            tablica2[i] = 0;
            tablica3[i] = 0;
        }
        wygrana = false;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Gracz");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            dodajWynik("Bot");
            wygrana = true;
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
            wygrana = true;
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
        if(Objects.equals(kto, "Gracz"))
        {
            kolkow++;
            kolkoWynik.setText(String.valueOf(kolkow));
        }
        else if(Objects.equals(kto, "Bot"))
        {
            krzyzykw++;
            krzyzykWynik.setText(String.valueOf(krzyzykw));
        }
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
}
