package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gui extends Application {

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Hotel> lvwHoteller2 = new ListView<>();
    private final ListView<Konference> lvwKonfListe = new ListView<>();
    private final ListView<Konference> lvwKonfliste2 = new ListView<>();
    private final ListView<Konference> lvwKonfliste3 = new ListView<>();
    private final ListView<Person> lvwPersoner = new ListView<>();
    private final ListView<Person> lvwDeltagerTilmeld = new ListView<>();
    private final ListView<TilKøb> lvwGetTilkøb = new ListView<>();
    private final ListView<TilKøb> lvwGetAllTilkøb = new ListView<>();
    private final ListView<UdFlugt> lvwGetUdflugtForKonf = new ListView<>();
    private final Button btnOpretKonf = new Button("Opret Konference");
    private final TextField txfStartDato = new TextField();
    private final TextField txfPeriode = new TextField();
    private final TextField txfKonfNavn = new TextField();
    private final TextField txfPrisPrDag = new TextField();
    private final Button btnOpretKonferencen = new Button("Opret Konference");
    private final Button btnOpretHotel = new Button("Opret hotel");
    private final Button btnOpretDeltager = new Button("Opret Deltager");
    private final TextField txfHotelNavn = new TextField();
    private final Button btnOpretHotel2 = new Button("Opret Hotel");
    private Stage opretPersonStage;
    private Stage opretKonStage;
    private Stage opretHotelStage;
    private Stage opretUdlugtStage;
    private Stage opretTilmeldingStage;
    private final TextField txfDeltagerNavn = new TextField();
    private final TextField txftlf = new TextField();

    private final Button btnOpretDeltager2 = new Button("Opret deltager");
    private final TextField txfLedsagerNavn = new TextField();
    private final CheckBox wifi = new CheckBox("Wifi");
    private final CheckBox morgenmad = new CheckBox("Morgenmad");
    private final CheckBox andet = new CheckBox("Andet");
    CheckBox cbShowLedsager = new CheckBox("Tilføj ledsager?");
    private final TextField txfFirma = new TextField();
    private final TextField txfPlacering = new TextField();
    private final Button btnOpretUdflugt = new Button("Opret udflugt");
    private final TextField txfUdflugtNavn = new TextField();
    private final Button btnOpretUdflugt2 = new Button("Opret udflugt");
    private final Button btnOpretTildmelding = new Button("Opret tilmelding");
    private final Button btnOpretTilmelding2 = new Button("Opret tilmelding");
    private final TextField txfPeriodeTilmdelding = new TextField();



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

        //-----------initcontent-------
        lvwHoteller.getItems().addAll(Controller.getHoteller());
        lvwKonfListe.getItems().addAll(Controller.getKonferencer());
        lvwPersoner.getItems().addAll(Controller.getDeltagere());

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

        HBox hbox8 = new HBox();
        hbox8.getChildren().addAll(btnOpretUdflugt);
        pane.add(hbox8,7,5);

        HBox hbox9 = new HBox();
        hbox9.getChildren().addAll(btnOpretTildmelding);
        pane.add(hbox9,9,5);



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

        //----------------Udflugt popup--------------

        opretUdlugtStage = new Stage();
        opretUdlugtStage.setTitle("Opret udflugt");
        GridPane udflugtPane = new GridPane();
        this.initContentUdflugt(udflugtPane);

        Scene udflugtScene = new Scene(udflugtPane);
        opretUdlugtStage.setScene(udflugtScene);
        opretUdlugtStage.setResizable(false);
        opretUdlugtStage.hide();

        btnOpretUdflugt.setOnAction(Event -> createUdflugtPopup());

        //----------------Tilmelding popup----------
        opretTilmeldingStage = new Stage();
        opretTilmeldingStage.setTitle("Opret Tilmedling");
        GridPane tilmeldingsPane = new GridPane();
        this.initContentTilmelding(tilmeldingsPane);

        Scene tilmedlingsScene = new Scene(tilmeldingsPane);
        opretTilmeldingStage.setScene(tilmedlingsScene);
        opretTilmeldingStage.setResizable(false);
        opretTilmeldingStage.hide();

        btnOpretTildmelding.setOnAction(Event -> createTilmeldingPopup());
    }
    public void createKonferencePopup() {

        opretKonStage.show();
    }

    public void createHotelPopup(){
        opretHotelStage.show();
    }
    public void createUdflugtPopup(){
        opretUdlugtStage.show();
    }
    public void createDeltagerPopup(){
        opretPersonStage.show();
    }
    public void createTilmeldingPopup(){
        opretTilmeldingStage.show();
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
        Label lblPlacering = new Label("Placering:");
        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(lblPlacering,txfPlacering);
        hbox5.setSpacing(10);
        pane.add(hbox5,0,6);


        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(btnOpretKonferencen,0,7);

        btnOpretKonferencen.setOnAction(Event -> opretKonference());

    }
    public void initContentCreateHotel(GridPane pane){
        Label hotelNavn = new Label("Hotel Navn");
        pane.add(hotelNavn,0,2);
        pane.add(txfHotelNavn,1,2);


        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(hotelNavn, txfHotelNavn);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,1);
        HBox hBox2 = new HBox();


        Label lbltilkøb = new Label("Vælg tilkøb");
        pane.add(lbltilkøb,1,0);
        lvwGetAllTilkøb.getItems().addAll(Controller.getAllTilkøb());
        pane.add(lvwGetAllTilkøb,1,1);
        lvwGetAllTilkøb.setMaxHeight(200);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(btnOpretHotel2,0,5);

        opretHotelStage.setAlwaysOnTop(true);
        btnOpretHotel2.setOnAction(Event -> opretHotel());


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

        Label lblFirma = new Label("Firma:");
        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(lblFirma,txfFirma);
        hBox4.setSpacing(75);
        pane.add(hBox4,0,4);

        cbShowLedsager.setOnAction(Event -> enableLedsager());

        txfLedsagerNavn.setDisable(true);
        pane.add(cbShowLedsager,0,5);
        Label lblledsager = new Label("Ledsager navn:");
        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(lblledsager, txfLedsagerNavn);
        hbox3.setSpacing(25);
        pane.add(hbox3, 0, 6);

        pane.add(btnOpretDeltager2,0,7);
        btnOpretDeltager2.setOnAction((Event -> opretDeltager()));
    }

    private void initContentUdflugt(GridPane pane){
        Label lblNavnPåUdflugt = new Label("Navn");
        pane.add(lblNavnPåUdflugt,0,1);
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(lblNavnPåUdflugt, txfUdflugtNavn);
        hbox1.setSpacing(10);
        pane.add(hbox1,0,1);


        lvwKonfliste2.getItems().addAll(Controller.getKonferencer());
        pane.add(lvwKonfliste2,1,1);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(btnOpretUdflugt2,0,2);

        btnOpretUdflugt2.setOnAction(Event -> opretUdflugtMetode());
    }
    private void initContentTilmelding(GridPane pane){
        Label lblKonf = new Label("Konference");
        Label lblHotel = new Label("Hotel");
        Label lblTilkøb = new Label("Tilkøb");
        Label lblAntalDage = new Label("Dage");
        Label lblUdflugt = new Label("Udflugt");
        Label lblDeltager = new Label("Deltager");

        pane.add(lblKonf,0,0);
        pane.add(lblHotel,1,0);
        pane.add(lblTilkøb,2,0);
        pane.add(lblAntalDage,3,0);
        pane.add(lblUdflugt,4,0);
        pane.add(lblDeltager,5,0);

        lvwKonfliste3.getItems().addAll(Controller.getKonferencer());
        pane.add(lvwKonfliste3,0,1);


        lvwHoteller2.getItems().addAll(Controller.getHoteller());
        pane.add(lvwHoteller2,1,1);
        pane.add(lvwGetTilkøb,2,1);
        lvwKonfliste3.onKeyPressedProperty().set(Event -> getSelectedHotel());

        pane.add(txfPeriodeTilmdelding,3,1);

        pane.add(lvwGetUdflugtForKonf,4,1);
        lvwKonfliste3.onKeyPressedProperty().set(Event -> getLvwGetUdflugtForKonf());

        lvwDeltagerTilmeld.getItems().addAll(Controller.getDeltagere());
        pane.add(lvwDeltagerTilmeld,5,1);


        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(btnOpretTilmelding2,0,3);
    }
    private void opretKonference(){

        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate date = LocalDate.parse(txfStartDato.getText(),dateFormat);
        int periode = Integer.parseInt(txfPeriode.getText());
        float prisPerDag = Float.parseFloat(txfPrisPrDag.getText());

        Konference konference = Controller.createKonference(txfKonfNavn.getText(),txfPlacering.getText(),date,periode,prisPerDag);
        lvwKonfListe.getItems().add(konference);
        lvwKonfliste2.getItems().add(konference);

        txfStartDato.clear();
        txfPeriode.clear();
        txfKonfNavn.clear();
        txfPrisPrDag.clear();
        opretKonStage.hide();
    }
    private void opretHotel(){
        Hotel hotel = Controller.createHotel(txfHotelNavn.getText());
        lvwHoteller.getItems().add(hotel);
        hotel.addTilkøb(lvwGetAllTilkøb.getSelectionModel().getSelectedItem());

        txfHotelNavn.clear();
        opretHotelStage.hide();
        wifi.setSelected(false);
        morgenmad.setSelected(false);
        andet.setSelected(false);
    }
    private void opretDeltager(){
        Deltager deltager = Controller.createDeltager(txfDeltagerNavn.getText(),txftlf.getText(),txfFirma.getText());
        Storage.addPerson(deltager);
        lvwPersoner.getItems().add(deltager);

        txfDeltagerNavn.clear();
        txftlf.clear();
        txfFirma.clear();
        opretPersonStage.hide();
    }

    private void enableLedsager(){
        if(!cbShowLedsager.isSelected()){
            //-----Ledsager----
            txfLedsagerNavn.setDisable(true);

        }else{
            txfLedsagerNavn.setDisable(false);
        }
    }
    private void opretUdflugtMetode(){
        LocalDate dato = lvwKonfListe.getSelectionModel().getSelectedItem().getStartDato();
        Controller.createUdflugt(lvwKonfListe.getSelectionModel().getSelectedItem(), txfUdflugtNavn.getText(),dato,69);

        txfUdflugtNavn.clear();
        opretUdlugtStage.hide();
    }
    private void getSelectedHotel(){
        lvwGetTilkøb.getItems().addAll(Controller.getTilkøb(lvwHoteller2.getSelectionModel().getSelectedItem()));
    }
    private void getLvwGetUdflugtForKonf(){
        lvwGetUdflugtForKonf.getItems().addAll(Controller.getUdflugter(lvwKonfliste3.getSelectionModel().getSelectedItem()));
    }
}
