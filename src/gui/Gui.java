package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Hotel;
import model.Konference;
import model.Person;

public class Gui extends Application {

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Konference> lvwKonfListe = new ListView<>();
    private final ListView<Person> lvwPersoner = new ListView<Person>();
    private final Button btnOpretKonf = new Button("Opret Konference");
    private final TextField txfStartDato = new TextField();
    private final TextField txfPeriode = new TextField();
    private final TextField txfKonfNavn = new TextField();
    private final TextField txfPrisPrDag = new TextField();
    private final Button btnOpretKonferencen = new Button("Opret Konference");
    private final Button btnOpretHotel = new Button("Opret hotel");
    private final Button btnOpretDeltager = new Button("Opret Deltager");
    private Stage opretKonStage;
    private Stage opretHotelStage;
    private final TextField txfHotelNavn = new TextField();
    private final TextField txfPlacering = new TextField();
    private final Button btnOpretHotel2 = new Button("Opret Hotel");
    private Stage opretPersonStage;
    private final TextField txfDeltagerNavn = new TextField();
    private final TextField txftlf = new TextField();

    private final Button btnOpretDeltager2 = new Button("Opret deltager");
    private final CheckBox wifi = new CheckBox("Wifi");
    private final CheckBox morgenmad = new CheckBox("Morgenmad");
    private final CheckBox andet = new CheckBox("Andet");


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


        pane.add(btnOpretKonf,1 ,5);
        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(btnOpretKonf);
        pane.add(hbox5,0,5);

        pane.add(btnOpretHotel,1 ,5);
        HBox hbox7 = new HBox();
        hbox7.getChildren().addAll(btnOpretHotel);
        pane.add(hbox7,3,5);

        pane.add(btnOpretDeltager,1 ,5);
        HBox hbox6 = new HBox();
        hbox6.getChildren().addAll(btnOpretDeltager);
        pane.add(hbox6,5,5);


        Label konferenceLabel = new Label("Konference");
        pane.add(konferenceLabel,0,0);
        pane.add(lvwKonfListe,0,1);

        Label hotelLabel = new Label("Hotel");
        pane.add(hotelLabel,3,0);
        pane.add(lvwHoteller,3,1);

        Label deltagerLabel = new Label("Deltager");
        pane.add(deltagerLabel,5,0);
        pane.add(lvwPersoner,5,1);



//----------------konference popup-----------


        opretKonStage = new Stage();
        opretKonStage.setTitle("Konference bookingssystem");
        GridPane konPane = new GridPane();
        this.initContentForConferenceBooking(konPane);

        Scene konScene = new Scene(konPane);
        opretKonStage.setScene(konScene);
        opretKonStage.setResizable(false);
        opretKonStage.hide();

        btnOpretKonf.setOnAction(Event -> createKonferencePopup());

//------------Hotel popup-----------------------

        opretHotelStage = new Stage();
        opretHotelStage.setTitle("Hotel oprettelse");
        GridPane hotelPane = new GridPane();
        this.initContentCreateHotel(hotelPane);

        Scene hotelScene = new Scene(hotelPane);
        opretHotelStage.setScene(hotelScene);
        opretHotelStage.setResizable(false);
        opretHotelStage.hide();

        btnOpretHotel.setOnAction(Event -> createHotelPopup());

//-----------------Deltager popup------------
        opretPersonStage = new Stage();
        opretPersonStage.setTitle("Deltager oprettelse");
        GridPane deltagerPane = new GridPane();
        this.initcontentDeltager(deltagerPane);

        Scene deltagerScene = new Scene(deltagerPane);
        opretPersonStage.setScene(deltagerScene);
        opretPersonStage.setResizable(false);
        opretPersonStage.hide();

        btnOpretDeltager.setOnAction(Event -> createDeltagerPopup());
    }
    public void createKonferencePopup() {

        opretKonStage.show();
    }

    public void createHotelPopup(){
        opretHotelStage.show();

    }
    public void createDeltagerPopup(){
        opretPersonStage.show();
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

        opretKonStage.setAlwaysOnTop(true);
    }
    public void initContentCreateHotel(GridPane pane){
        Label hotelNavn = new Label("Hotel Navn");
        pane.add(hotelNavn,0,2);
        pane.add(txfHotelNavn,1,2);
        Label hotelPlacering = new Label("Placering");
        pane.add(hotelPlacering,0,3);
        pane.add(txfPlacering,1,3);


        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(hotelNavn, txfHotelNavn);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,2);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(hotelPlacering, txfPlacering);
        hBox2.setSpacing(33);
        pane.add(hBox2,0,3);


        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(wifi,morgenmad,andet);
        pane.add(hbox3,0,5);


        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(btnOpretHotel2,0,6);

        opretHotelStage.setAlwaysOnTop(true);
        btnOpretHotel2.setOnAction(Event -> clearAndHideHotel());
    }

    public void initcontentDeltager(GridPane pane){
        Label lblDeltagerNavn = new Label("Deltager Navn:");
        pane.add(lblDeltagerNavn,0,2);
        pane.add(txfDeltagerNavn,1,2);
        Label tlf = new Label("Telefon nr:");
        pane.add(tlf,0,3);
        pane.add(txftlf,1,3);

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(lblDeltagerNavn, txfDeltagerNavn);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,2);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(tlf, txftlf);
        hBox2.setSpacing(45);
        pane.add(hBox2,0,3);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        opretPersonStage.setAlwaysOnTop(true);

        pane.add(btnOpretDeltager2,0,5);
        btnOpretDeltager2.setOnAction((Event -> clearAndHideDeltager()));
    }
    private void clearAndHide(){
        txfStartDato.clear();
        txfPeriode.clear();
        txfKonfNavn.clear();
        txfPrisPrDag.clear();
        opretKonStage.hide();
    }
    private void clearAndHideHotel(){
        txfHotelNavn.clear();
        txfPlacering.clear();
        opretHotelStage.hide();
        wifi.setSelected(false);
        morgenmad.setSelected(false);
        andet.setSelected(false);
    }
    private void clearAndHideDeltager(){
        txfDeltagerNavn.clear();
        txftlf.clear();
        opretPersonStage.hide();
    }
}
