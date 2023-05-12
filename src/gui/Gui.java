package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Person;
import storage.Storage;

public class Gui extends Application {

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Konference> lvwKonfListe = new ListView<>();
    private final ListView<Person> lvwPersoner = new ListView<>();
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
    private final TextField txfDeltagerNavn = new TextField();
    private final TextField txftlf = new TextField();

    private final Button btnOpretDeltager2 = new Button("Opret deltager");
    private final TextField txfLedsagerNavn = new TextField();
    private final CheckBox wifi = new CheckBox("Wifi");
    private final CheckBox morgenmad = new CheckBox("Morgenmad");
    private final CheckBox andet = new CheckBox("Andet");
    CheckBox cbShowLedsager = new CheckBox("Tilføj ledsager?");
    private final TextField txfFirma = new TextField();


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

        btnOpretKonferencen.setOnAction(Event -> opretKonference());


    }
    public void initContentCreateHotel(GridPane pane){
        Label hotelNavn = new Label("Hotel Navn");
        pane.add(hotelNavn,0,2);
        pane.add(txfHotelNavn,1,2);


        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(hotelNavn, txfHotelNavn);
        hbox1.setSpacing(22);
        pane.add(hbox1,0,2);
        HBox hBox2 = new HBox();


        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(wifi,morgenmad,andet);
        hbox3.setSpacing(15);
        pane.add(hbox3,0,4);


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
    private void opretKonference(){

        txfStartDato.clear();
        txfPeriode.clear();
        txfKonfNavn.clear();
        txfPrisPrDag.clear();
        opretKonStage.hide();
    }
    private void opretHotel(){
        Hotel hotel = Controller.createHotel(txfHotelNavn.getText());
        lvwHoteller.getItems().add(hotel);

        if (wifi.isSelected()){
            Controller.createTilkøb(hotel,"wifi",50);
        }
        if(morgenmad.isSelected()){
            Controller.createTilkøb(hotel,"Morgenmad", 100);
        }
        if(andet.isSelected()){
            Controller.createTilkøb(hotel,"Andet", 150);
        }
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
}
