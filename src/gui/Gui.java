package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS-iing!");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final String throwText = "thrown ";
    private final Button btnThrow = new Button(" Throw ");
    private final Background bg = new Background(new BackgroundFill(
            Paint.valueOf("#00BCE3"), CornerRadii.EMPTY, Insets.EMPTY)
    );

    private final ArrayList<String> namesOfResults = new ArrayList<>(List.of("1s", "2s", "3s", "4s", "5s", "6s",
            "One Pair", "Two Pairs", "Three-same", "Four-same", "Full House", "Small Straight",
            "Large Straight", "Chance", "Yatzy"));

    private void initContent(GridPane pane) {


    }



}
