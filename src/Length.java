import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Length extends Parent {

    private Scene scene;
    private boolean dotted = false;
    public static boolean isSelectedMenu = false;
    public static Pane Root = new Pane();
    private ComboBox<String> fromCombo = new ComboBox<>();
    private ComboBox<String> toCombo = new ComboBox<>();
    protected TextField inputTXF;
    protected Label resultLBL;

    public Length() {
        Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:bold;");

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
                    Root.getChildren().add(MenuPane.scrollPane);
                    isSelectedMenu = true;
                } else {
                    Root.getChildren().remove(MenuPane.scrollPane);
                    isSelectedMenu = false;
                }
            }
        });
        Root.getChildren().add(menu);

        String[] units = {"Nanometers", "Microns", "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"};
        fromCombo = new ComboBox(FXCollections.observableArrayList(units));
        fromCombo.setPrefSize(165, 50);
        fromCombo.setLayoutX(5);
        fromCombo.setLayoutY(100);
        fromCombo.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#2193b0, #6dd5ed); -fx-text-fill: -fx-text-base-color;");
        toCombo = new ComboBox(FXCollections.observableArrayList(units));
        toCombo.setPrefSize(165, 50);
        toCombo.setLayoutX(5);
        toCombo.setLayoutY(165);
        toCombo.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#2193b0, #6dd5ed);");

        inputTXF = new TextField();
        inputTXF.setPrefSize(220, 50);
        inputTXF.setLayoutX(175);
        inputTXF.setLayoutY(100);
        inputTXF.setAlignment(Pos.CENTER_RIGHT);
        inputTXF.setStyle("-fx-text-fill: black;" + " -fx-font-size: 20;" + " -fx-font-family: tahoma; " + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: linear-gradient(#2193b0, #6dd5ed);");

        resultLBL = new Label();
        resultLBL.setPrefSize(220, 50);
        resultLBL.setLayoutY(165);
        resultLBL.setLayoutX(175);
        resultLBL.setAlignment(Pos.CENTER_RIGHT);
        resultLBL.setStyle("-fx-text-fill: black;" + " -fx-font-size: 20;" + " -fx-font-family: tahoma; " + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: linear-gradient(#2193b0, #6dd5ed);");

        Root.getChildren().addAll(resultLBL, inputTXF, fromCombo, toCombo);


        buttons = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(130, 55);
                buttons[i][j].setLayoutX(j * 133 + 1.5);
                buttons[i][j].setLayoutY(i * 60 + 360);
                buttons[i][j].setText(-3 * i + j + 7 + "");
                buttons[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String s = inputTXF.getText();
                        inputTXF.setText(s + (-3 * finalI + finalJ + 7));
                    }
                });
                Root.getChildren().add(buttons[i][j]);
                buttons[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        buttons[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                    }
                });
                buttons[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        buttons[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                    }
                });
            }
        }

        zeroBTN = new Button("0");
        zeroBTN.setPrefSize(130, 55);
        zeroBTN.setLayoutX(133);
        zeroBTN.setLayoutY(540);
        zeroBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
        zeroBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                zeroBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        zeroBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                zeroBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        zeroBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputTXF.setText("0");
            }
        });

        calculateBTN = new Button("=");
        calculateBTN.setPrefSize(130, 55);
        calculateBTN.setLayoutY(540);
        calculateBTN.setLayoutX(2 * 133);
        calculateBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
        calculateBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                calculateBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        calculateBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                calculateBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        calculateBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (inputTXF.getText().length() > 0 && fromCombo.getValue() != null && toCombo.getValue() != null) {
                    String from = fromCombo.getValue();
                    String to = toCombo.getValue();
                    String value = inputTXF.getText();
                    double result = calculate(from, to, value);
                    String s = result + "";
                    System.out.println(s);
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultLBL.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultLBL.setText(s.substring(0, 9));
                        else resultLBL.setText(s.substring(0, s.length()));
                    }
                }
            }
        });

        dottBTN = new Button(".");
        dottBTN.setLayoutY(540);
        dottBTN.setLayoutX(0);
        dottBTN.setPrefSize(130, 55);
        dottBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
        dottBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dottBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        dottBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dottBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        dottBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!dotted) {
                    dotted = true;
                    String s = inputTXF.getText();
                    s += ".";
                    inputTXF.setText(s);
                }
            }
        });

        clearBTN = new Button("C");
        clearBTN.setPrefSize(130, 55);
        clearBTN.setLayoutX(133);
        clearBTN.setLayoutY(300);
        clearBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
        clearBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clearBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        clearBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clearBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        clearBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputTXF.setText("");
                resultLBL.setText("");
            }
        });

        backspaceBTN = new Button("⟵");
        backspaceBTN.setPrefSize(130, 55);
        backspaceBTN.setLayoutX(2 * 133);
        backspaceBTN.setLayoutY(300);
        backspaceBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
        backspaceBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                backspaceBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        backspaceBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                backspaceBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
            }
        });
        backspaceBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = inputTXF.getText();
                if (s.length() > 0) {
                    s = s.substring(0, s.length() - 1);
                    inputTXF.setText(s);
                }
            }
        });

        Root.getChildren().addAll(zeroBTN, dottBTN, clearBTN, backspaceBTN, calculateBTN);
        MenuPane.menuVBX.setStyle(" -fx-background-color: linear-gradient(#0F2027, #2B5263);" + " -fx-text-fill: white;" + " -fx-font-size: 18; -fx-font-weight: normal;");
        scene = new Scene(Root, 400, 600);
    }

    public Scene getScene() {
        return scene;
    }

    private double calculate(String from, String to, String value) {

        double fromU = 0, toU = 0;
        if (from.equals("Nanometers")) fromU = Math.pow(10, -9);
        if (from.equals("Microns")) fromU = Math.pow(10, -6);
        if (from.equals("Millimeters")) fromU = Math.pow(10, -3);
        if (from.equals("Centimeters")) fromU = Math.pow(10, -2);
        if (from.equals("Inches")) fromU = 0.0254;
        if (from.equals("Feet")) fromU = 0.3048;
        if (from.equals("Yards")) fromU = 0.9144;
        if (from.equals("Meters")) fromU = 1;
        if (from.equals("Kilometers")) fromU = Math.pow(10, 3);
        if (from.equals("Miles")) fromU = 1609.344;

        if (to.equals("Nanometers")) toU = Math.pow(10, -9);
        if (to.equals("Microns")) toU = Math.pow(10, -6);
        if (to.equals("Millimeters")) toU = Math.pow(10, -3);
        if (to.equals("Centimeters")) toU = Math.pow(10, -2);
        if (to.equals("Inches")) toU = 0.0254;
        if (to.equals("Feet")) toU = 0.3048;
        if (to.equals("Yards")) toU = 0.9144;
        if (to.equals("Meters")) toU = 1;
        if (to.equals("Kilometers")) toU = Math.pow(10, 3);
        if (to.equals("Miles")) toU = 1609.344;

        double valueD = Double.parseDouble(value);
        double result;

        result = fromU / toU;
        if (to == "Nanometers") return Math.floor(result + 1) * valueD;
        return result * valueD;

    }


}