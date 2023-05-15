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

    private final ListView<Hotel> lvwHotellerHovedMenu = new ListView<>();
    private final ListView<Hotel> lvwHotellerTilmeldingsVindue = new ListView<>();
    private final ListView<Konference> lvwKonfListeHovedMenu = new ListView<>();
    private final ListView<Konference> lvwKonflisteOpretUdflugt = new ListView<>();
    private final ListView<Konference> lvwKonflisteTilmeldingsVindue = new ListView<>();
    private final ListView<Person> lvwPersonerHovedMenu = new ListView<>();
    private final ListView<Person> lvwDeltagerTilmeldVindue = new ListView<>();
    private final ListView<TilKøb> lvwGetTilkøbTilmeldVindue = new ListView<>();
    private final ListView<TilKøb> lvwTilkøbHotelVindue = new ListView<>();
    private final ListView<UdFlugt> lvwGetUdflugtForKonfTilmeldVindue = new ListView<>();
    private final Button btnOpretKonfHovedMenu = new Button("Opret Konference");
    private final TextField txfStartDatoOpretKonfVindue = new TextField();
    private final TextField txfPeriodeOpretKonfVindue = new TextField();
    private final TextField txfKonfNavnOpretKonfVindue = new TextField();
    private final TextField txfPrisPrDagOpretKonfVindue = new TextField();
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

    CheckBox cbShowLedsager = new CheckBox("Tilføj ledsager?");
    private final TextField txfFirma = new TextField();
    private final TextField txfPlaceringKonferenceVindue = new TextField();
    private final Button btnOpretUdflugtHovedMenu = new Button("Opret udflugt");
    private final TextField txfUdflugtNavnUdflugtVindue = new TextField();
    private final Button btnOpretUdflugtUdflugtVindue = new Button("Opret udflugt");
    private final Button btnOpretTildmeldingHovedMenu = new Button("Opret tilmelding");
    private final Button btnOpretTilmeldingTilmeldVindue = new Button("Opret tilmelding");
    private final TextField txfPeriodeTilmdeldingVindue = new TextField();



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
        lvwHotellerHovedMenu.getItems().addAll(Controller.getHoteller());
        lvwKonfListeHovedMenu.getItems().addAll(Controller.getKonferencer());
        lvwPersonerHovedMenu.getItems().addAll(Controller.getDeltagere());

        pane.add(btnOpretKonfHovedMenu,1 ,5);
        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(btnOpretKonfHovedMenu);
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
        pane.add(lvwKonfListeHovedMenu,0,1);

        Label hotelLabel = new Label("Hotel");
        pane.add(hotelLabel,3,0);
        pane.add(lvwHotellerHovedMenu,3,1);

        Label deltagerLabel = new Label("Deltager");
        pane.add(deltagerLabel,5,0);
        pane.add(lvwPersonerHovedMenu,5,1);

        HBox hbox8 = new HBox();
        hbox8.getChildren().addAll(btnOpretUdflugtHovedMenu);
        pane.add(hbox8,7,5);

        HBox hbox9 = new HBox();
        hbox9.getChildren().addAll(btnOpretTildmeldingHovedMenu);
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

        btnOpretKonfHovedMenu.setOnAction(Event -> createKonferencePopup());

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

        btnOpretUdflugtHovedMenu.setOnAction(Event -> createUdflugtPopup());

        //----------------Tilmelding popup----------
        opretTilmeldingStage = new Stage();
        opretTilmeldingStage.setTitle("Opret Tilmedling");
        GridPane tilmeldingsPane = new GridPane();
        this.initContentTilmelding(tilmeldingsPane);

        Scene tilmedlingsScene = new Scene(tilmeldingsPane);
        opretTilmeldingStage.setScene(tilmedlingsScene);
        opretTilmeldingStage.setResizable(false);
        opretTilmeldingStage.hide();

        btnOpretTildmeldingHovedMenu.setOnAction(Event -> createTilmeldingPopup());
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
        pane.add(txfStartDatoOpretKonfVindue,1,2);
        Label lblPeriode = new Label("Periode");
        pane.add(lblPeriode,0,3);
        pane.add(txfPeriodeOpretKonfVindue,1,3);
        Label lblKonfNavn = new Label("Konference");
        pane.add(lblKonfNavn,0,4);
        pane.add(txfKonfNavnOpretKonfVindue,1,4);

        Label lblPris = new Label("Pris pr dag");
        pane.add(lblPris,0,5);
        pane.add(txfPrisPrDagOpretKonfVindue,1,5);
        HBox hbox4 = new HBox();

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(lblStartDato, txfStartDatoOpretKonfVindue);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,2);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(lblPeriode, txfPeriodeOpretKonfVindue);
        hBox2.setSpacing(30);
        pane.add(hBox2,0,3);
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(lblKonfNavn, txfKonfNavnOpretKonfVindue);
        hBox3.setSpacing(10);
        pane.add(hBox3,0,4);
        hbox4.getChildren().addAll(lblPris, txfPrisPrDagOpretKonfVindue);
        pane.add(hbox4,0,5);
        hbox4.setSpacing(12);
        Label lblPlacering = new Label("Placering:");
        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(lblPlacering, txfPlaceringKonferenceVindue);
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
        lvwTilkøbHotelVindue.getItems().addAll(Controller.getAllTilkøb());
        pane.add(lvwTilkøbHotelVindue,1,1);
        lvwTilkøbHotelVindue.setMaxHeight(200);

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
        hbox1.getChildren().addAll(lblNavnPåUdflugt, txfUdflugtNavnUdflugtVindue);
        hbox1.setSpacing(10);
        pane.add(hbox1,0,1);


        lvwKonflisteOpretUdflugt.getItems().addAll(Controller.getKonferencer());
        pane.add(lvwKonflisteOpretUdflugt,1,1);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(btnOpretUdflugtUdflugtVindue,0,2);

        btnOpretUdflugtUdflugtVindue.setOnAction(Event -> opretUdflugtMetode());
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

        lvwKonflisteTilmeldingsVindue.getItems().addAll(Controller.getKonferencer());
        pane.add(lvwKonflisteTilmeldingsVindue,0,1);


        lvwHotellerTilmeldingsVindue.getItems().addAll(Controller.getHoteller());
        pane.add(lvwHotellerTilmeldingsVindue,1,1);
        pane.add(lvwGetTilkøbTilmeldVindue,2,1);

        lvwKonflisteTilmeldingsVindue.setOnMouseClicked(Event -> getSelectedHotel());

        pane.add(txfPeriodeTilmdeldingVindue,3,1);

        pane.add(lvwGetUdflugtForKonfTilmeldVindue,4,1);
        lvwKonflisteTilmeldingsVindue.setOnMouseClicked(Event -> getLvwGetUdflugtForKonf());

        lvwDeltagerTilmeldVindue.getItems().addAll(Controller.getDeltagere());
        pane.add(lvwDeltagerTilmeldVindue,5,1);


        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(btnOpretTilmeldingTilmeldVindue,0,3);
    }
    private void opretKonference(){

        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate date = LocalDate.parse(txfStartDatoOpretKonfVindue.getText(),dateFormat);
        int periode = Integer.parseInt(txfPeriodeOpretKonfVindue.getText());
        float prisPerDag = Float.parseFloat(txfPrisPrDagOpretKonfVindue.getText());

        Konference konference = Controller.createKonference(txfKonfNavnOpretKonfVindue.getText(), txfPlaceringKonferenceVindue.getText(),date,periode,prisPerDag);
        lvwKonfListeHovedMenu.getItems().add(konference);
        lvwKonflisteOpretUdflugt.getItems().add(konference);
        lvwKonflisteTilmeldingsVindue.getItems().add(konference);

        txfStartDatoOpretKonfVindue.clear();
        txfPeriodeOpretKonfVindue.clear();
        txfKonfNavnOpretKonfVindue.clear();
        txfPrisPrDagOpretKonfVindue.clear();
        opretKonStage.hide();
    }
    private void opretHotel(){
        Hotel hotel = Controller.createHotel(txfHotelNavn.getText());
        lvwHotellerHovedMenu.getItems().add(hotel);
        hotel.addTilkøb(lvwTilkøbHotelVindue.getSelectionModel().getSelectedItem());

        txfHotelNavn.clear();
        opretHotelStage.hide();
    }
    private void opretDeltager(){
        Deltager deltager = Controller.createDeltager(txfDeltagerNavn.getText(),txftlf.getText(),txfFirma.getText());
        Storage.addPerson(deltager);
        lvwPersonerHovedMenu.getItems().add(deltager);

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
        LocalDate dato = lvwKonfListeHovedMenu.getSelectionModel().getSelectedItem().getStartDato();
        Controller.createUdflugt(lvwKonfListeHovedMenu.getSelectionModel().getSelectedItem(), txfUdflugtNavnUdflugtVindue.getText(),dato,69);

        txfUdflugtNavnUdflugtVindue.clear();
        opretUdlugtStage.hide();
    }
    private void getSelectedHotel(){

    }
    private void getLvwGetUdflugtForKonf(){
        lvwGetUdflugtForKonfTilmeldVindue.getItems().addAll(Controller.getUdflugter(lvwKonflisteTilmeldingsVindue.getSelectionModel().getSelectedItem()));
    }
}
