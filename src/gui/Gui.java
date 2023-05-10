package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Hotel;
import model.Konference;
import org.w3c.dom.events.Event;

public class Gui extends Application {

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Konference> lvwKonfListe = new ListView<>();
    private final Button btnOpretKonf = new Button("Opret Konference");
    private final TextField txfStartDato = new TextField();
    private final TextField txfPeriode = new TextField();
    private final TextField txfKonfNavn = new TextField();
    private final TextField txfPrisPrDag = new TextField();
    private final Button btnOpretKonferencen = new Button("Opret Konference");

    private Stage opretKonStage;



    @Override
    public void start(Stage stage) {
        stage.setTitle("Konference bookingssystem");
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
        pane.add(konferenceLabel,0,0);
        pane.add(lvwKonfListe,0,1);

        pane.add(btnOpretKonf,1 ,6);
        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(btnOpretKonf);
        pane.add(hbox5,0,6);


        btnOpretKonf.setOnAction(Event -> createKonferencePopup());

        opretKonStage = new Stage();
        opretKonStage.setTitle("Konference bookingssystem");
        GridPane konPane = new GridPane();
        this.initContentForConferenceBooking(konPane);



        Scene scene = new Scene(konPane);
        opretKonStage.setScene(scene);
        opretKonStage.setResizable(false);
        opretKonStage.hide();
    }
    public void createKonferencePopup() {

        opretKonStage.show();
    }
    private void initContentForConferenceBooking(GridPane pane){
        Label lblStartDato = new Label("Startdato");
        pane.add(lblStartDato,0,2);
        pane.add(txfStartDato,1,2);
        Label lblPeriode = new Label("Periode");
        pane.add(lblPeriode,0,3);
        pane.add(txfPeriode,1,3);
        Label lblKonfNavn = new Label("Konference");
        pane.add(lblKonfNavn,0,4);
        pane.add(txfKonfNavn,1,4);

        Label lblPris = new Label("Pris pr dag");
        pane.add(lblPris,0,5);
        pane.add(txfPrisPrDag,1,5);
        HBox hbox4 = new HBox();

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(lblStartDato, txfStartDato);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,2);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(lblPeriode, txfPeriode);
        hBox2.setSpacing(30);
        pane.add(hBox2,0,3);
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(lblKonfNavn, txfKonfNavn);
        hBox3.setSpacing(10);
        pane.add(hBox3,0,4);
        hbox4.getChildren().addAll(lblPris, txfPrisPrDag);
        pane.add(hbox4,0,5);
        hbox4.setSpacing(12);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(btnOpretKonferencen,0,6);

        btnOpretKonferencen.setOnAction(Event -> clearAndHide());
    }
    private void clearAndHide(){
        txfStartDato.clear();
        txfPeriode.clear();
        txfKonfNavn.clear();
        txfPrisPrDag.clear();
        opretKonStage.hide();
    }
}
