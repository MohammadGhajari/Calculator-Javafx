import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DateCalculator {


    public static boolean isSelectedMenu = false;
    public static Pane Root = new Pane();
    private MenuPane menuScene = new MenuPane();
    private Scene scene;
    private DatePicker fromDatePicker;
    private DatePicker toDatePicker;
    private Label fromLBL;
    private Label toLBL;
    private Label result;
    private Button calculate;

    public DateCalculator() {
        Root.setStyle("-fx-background-color: #202020; -fx-font-size:20; -fx-font-weight:bold;");

        Button menu = new Button();
        menu.setGraphic(new ImageView("menu.png"));
        menu.setLayoutY(0);
        menu.setLayoutX(0);
        menu.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#0F2027, #2B5263);" + " -fx-text-fill: white;");
        menu.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#12c2e9, #2B5263);");
            }
        });
        menu.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#0F2027, #2B5263);");
            }
        });
        menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!isSelectedMenu) {
                    Root.getChildren().add(menuScene.getScrollPane());
                    isSelectedMenu = true;
                } else {
                    Root.getChildren().remove(menuScene.getScrollPane());
                    isSelectedMenu = false;
                }
            }
        });
        Root.getChildren().add(menu);


        fromDatePicker = new DatePicker();
        fromDatePicker.setLayoutX(20);
        fromDatePicker.setLayoutY(110);
        fromDatePicker.setPrefSize(350, 60);
        fromDatePicker.setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #3B3B3B;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");

        toDatePicker = new DatePicker();
        toDatePicker.setLayoutX(20);
        toDatePicker.setLayoutY(230);
        toDatePicker.setPrefSize(350, 60);
        toDatePicker.setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #3B3B3B;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");

        fromLBL = new Label("from:");
        fromLBL.setLayoutY(80);
        fromLBL.setLayoutX(20);
        fromLBL.setTextFill(Color.WHITE);

        toLBL = new Label("to:");
        toLBL.setLayoutY(200);
        toLBL.setLayoutX(20);
        toLBL.setTextFill(Color.WHITE);

        result = new Label(" Difference: ");
        result.setLayoutY(420);
        result.setLayoutX(20);
        result.setPrefSize(200, 40);
        result.setStyle("-fx-background-color: #323232; -fx-font-size:15; -fx-text-fill: white;");

        calculate = new Button("Calculate");
        calculate.setLayoutX(20);
        calculate.setLayoutY(350);
        calculate.setPrefSize(150, 40);
        calculate.setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
        calculate.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                calculate.setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
            }
        });
        calculate.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                calculate.setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
            }
        });
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String from = String.valueOf(fromDatePicker.getValue());
                String to = String.valueOf(toDatePicker.getValue());
                if (from.length() > 0 && to.length() > 0) {
                    int days = calculate(from, to);
                    result.setText(" Difference:   " + days + " Days");
                }
            }
        });
        Root.getChildren().addAll(fromDatePicker, toDatePicker, fromLBL, toLBL, calculate, result);
        menuScene.getMenuVBX().setStyle(" -fx-background-color: linear-gradient(#0F2027, #2B5263);" + " -fx-text-fill: white;" + " -fx-font-size: 18; -fx-font-weight: normal;");

        scene = new Scene(Root, 400, 600);
    }

    public Scene getScene() {
        return scene;
    }

    private int calculate(String from, String to) {
        int years_diferenc = Math.abs(Integer.parseInt(from.substring(0, 4)) - Integer.parseInt(to.substring(0, 4)));
        int month_diferenc = Math.abs(Integer.parseInt(from.substring(5, 7)) - Integer.parseInt(to.substring(5, 7)));
        int day_diferenc = Math.abs(Integer.parseInt(from.substring(8, 10)) - Integer.parseInt(to.substring(8, 10)));

        return years_diferenc * 365 + month_diferenc * 30 + day_diferenc;

    }

    public DatePicker getFromDatePicker() {
        return fromDatePicker;
    }

    public DatePicker getToDatePicker() {
        return toDatePicker;
    }

    public Label getFromLBL() {
        return fromLBL;
    }

    public Label getToLBL() {
        return toLBL;
    }

    public Label getResult() {
        return result;
    }

    public Button getCalculate() {
        return calculate;
    }
}
