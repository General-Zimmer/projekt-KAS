package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Hotel;
import model.Konference;

public class Gui extends Application {

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Konference> lvwKonfListe = new ListView<>();
    private final Button btnOpretKonf = new Button("Opret Konference");
    private final TextField txfStartDato = new TextField();
    private final TextField txfPeriode = new TextField();
    private final TextField txfKonfNavn = new TextField();



    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS-iing!");
        GridPane pane = new GridPane();
        this.initContent(pane);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    private void initContent(GridPane pane) {
        Label konferenceLabel = new Label("Konference");
        pane.add(konferenceLabel,1,0);
        pane.add(lvwKonfListe,1,1);
        pane.add(txfStartDato,1,2);
        pane.add(txfPeriode,1,3);
        pane.add(txfKonfNavn,1,4);
        pane.add(btnOpretKonf,1 ,5);



    }



}
