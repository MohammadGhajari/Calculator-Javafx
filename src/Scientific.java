import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Scientific {
    public static boolean isSelectedMenu = false;
    public static Pane Root = new Pane();
    private MenuPane menuScene = new MenuPane();
    private Scene scene;
    private boolean unsigned = true;
    private boolean operator_selected = false;
    private boolean dotted = false;
    private double first_operand;
    private String operation;
    private boolean functionsBTNSelected = false;
    private boolean trigonometryBTNSelected = false;
    private boolean hyperbolicSelected = false;
    private Button[][] buttons;
    private TextField resultTXF;
    private Button functionBTN;
    private Button trigonometryBTN;
    private Pane functionPane;
    private Pane trigonometryPane;
    private Button[][] functionsbtn;
    private Button[][] trigonometrybtn;
    private Button[][] hyperbolicbtn;
    private Button hypTotri;

    public Scientific() {
        Root.setStyle("-fx-background-color: #202020; -fx-font-size:20; -fx-font-weight:normal;");

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

        buttons = new Button[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {

                buttons[i][j] = new Button(i + j + "");
                buttons[i][j].setLayoutX(j * 80 + 2);
                buttons[i][j].setPrefWidth(78);
                buttons[i][j].setPrefHeight(48);
                buttons[i][j].setLayoutY(i * 50 + 300);
                buttons[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                int finalI = i;
                int finalJ = j;
                buttons[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        buttons[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                    }
                });
                buttons[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        buttons[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                    }
                });
                if ((i >= 2 && i <= 4) && (j >= 1 && j <= 3)) {
                    buttons[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B ;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
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
                if (i == 5 && j == 2) {
                    buttons[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
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

                Root.getChildren().add(buttons[i][j]);
            }
        }
        buttons[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
        buttons[5][4].setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttons[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
            }
        });
        buttons[5][4].setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttons[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
            }
        });


        resultTXF = new TextField();
        resultTXF.setPrefSize(350, 7);
        resultTXF.setLayoutX(50);
        resultTXF.setLayoutY(70);
        resultTXF.setAlignment(Pos.TOP_RIGHT);
        resultTXF.setStyle(" -fx-text-fill: white;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #202020;");
        Root.getChildren().add(resultTXF);

        buttons[0][0].setText("π");
        buttons[0][1].setText("e");
        buttons[0][2].setText("ln");
        buttons[0][3].setText("C");
        buttons[0][4].setText("⟵");
        buttons[1][0].setText("x²");
        buttons[1][1].setText("1/x");
        buttons[1][2].setText("|x|");
        buttons[1][3].setText("n!");
        buttons[1][4].setText("/");
        buttons[2][0].setText("x^y");
        buttons[2][1].setText("7");
        buttons[2][2].setText("8");
        buttons[2][3].setText("9");
        buttons[2][4].setText("×");
        buttons[3][0].setText("10^x");
        buttons[3][1].setText("4");
        buttons[3][2].setText("5");
        buttons[3][3].setText("6");
        buttons[3][4].setText("-");
        buttons[4][0].setText("log");
        buttons[4][1].setText("1");
        buttons[4][2].setText("2");
        buttons[4][3].setText("3");
        buttons[4][4].setText("+");
        buttons[5][0].setText("√x");
        buttons[5][1].setText("+/-");
        buttons[5][2].setText("0");
        buttons[5][3].setText(".");
        buttons[5][4].setText("=");


        buttons[0][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dotted = false;
                resultTXF.setText("");
            }
        });
        buttons[0][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = resultTXF.getText();
                if (s.length() >= 1) s = s.substring(0, s.length() - 1);
                resultTXF.setText(s);
            }
        });
        buttons[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    if (first_operand == 0) {
                        resultTXF.setText("NaN");
                    } else {
                        resultTXF.setText(remove_zero(1 / first_operand + ""));
                    }
                }
            }
        });
        buttons[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    resultTXF.setText(remove_zero(first_operand * first_operand + ""));
                }
            }
        });
        buttons[5][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    if (first_operand < 0) {
                        resultTXF.setText("NaN");
                    } else {
                        resultTXF.setText(remove_zero(Math.sqrt(first_operand) + ""));
                    }
                }
            }
        });
        buttons[1][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    operation = "/";
                }
            }
        });
        buttons[2][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "7";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "7";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[2][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "8";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "8";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[2][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "9";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "9";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[2][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    operation = "×";
                }
            }
        });
        buttons[3][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "4";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "4";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[3][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "5";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "5";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[3][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "6";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "6";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[3][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    operation = "-";
                }
            }
        });
        buttons[4][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "1";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "1";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[4][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "2";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "2";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[4][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator_selected) {
                    operator_selected = false;
                    resultTXF.setText("");
                    String s = resultTXF.getText();
                    s += "3";
                    resultTXF.setText(s);
                } else {
                    String s = resultTXF.getText();
                    s += "3";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[4][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    operation = "+";
                }
            }
        });
        buttons[5][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (unsigned) {
                    String s = resultTXF.getText();
                    s = "-" + s;
                    resultTXF.setText(s);
                    unsigned = false;
                } else {
                    String s = resultTXF.getText();
                    s = s.substring(1, s.length());
                    resultTXF.setText(s);
                    unsigned = true;
                }
            }
        });
        buttons[5][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = resultTXF.getText();
                s += "0";
                resultTXF.setText(s);
            }
        });
        buttons[5][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!dotted) {
                    dotted = true;
                    String s = resultTXF.getText();
                    s += ".";
                    resultTXF.setText(s);
                }
            }
        });
        buttons[5][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    double second_operand = Double.parseDouble(resultTXF.getText());
                    if (operation.equals("/")) {
                        double result = first_operand / second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation.equals("-")) {
                        double result = first_operand - second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation.equals("+")) {
                        double result = first_operand + second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation.equals("%")) {
                        double result = first_operand * second_operand / 100;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation.equals("×")) {
                        double result = first_operand * second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation.equals("x^y")) {
                        double result = Math.pow(first_operand, second_operand);
                        resultTXF.setText(remove_zero(result + ""));
                    }
                }
            }
        });
        buttons[2][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    operation = "x^y";
                }
            }
        });
        buttons[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    if (first_operand <= 0) {
                        resultTXF.setText("NaN");
                    } else {
                        resultTXF.setText(remove_zero(Math.log(first_operand) + ""));
                    }
                }
            }
        });
        buttons[4][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    if (first_operand <= 0) {
                        resultTXF.setText("NaN");
                    } else {
                        resultTXF.setText(remove_zero(Math.log10(first_operand) + ""));
                    }
                }
            }
        });
        buttons[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    resultTXF.setText(Math.abs(first_operand) + "");
                }
            }
        });
        buttons[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator_selected = false;
                resultTXF.setText("");
                String s = resultTXF.getText();
                dotted = true;
                s += Math.PI + "";
                resultTXF.setText(s);
            }
        });
        buttons[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator_selected = false;
                resultTXF.setText("");
                String s = resultTXF.getText();
                dotted = true;
                s += Math.E + "";
                resultTXF.setText(s);
            }
        });
        buttons[1][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0 && !resultTXF.getText().contains(".") && Integer.parseInt(resultTXF.getText()) >= 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    int i, fact = 1;
                    for (i = 1; i <= first_operand; i++) {
                        fact = fact * i;
                    }
                    resultTXF.setText(fact + "");
                }
            }
        });
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        functionBTN = new Button("f(x) Functions  ", new ImageView("down.png"));
        functionBTN.setContentDisplay(ContentDisplay.RIGHT);
        functionBTN.setPrefSize(162, 50);
        functionBTN.setLayoutX(162);
        functionBTN.setLayoutY(248);
        functionBTN.setStyle("-fx-background-color: #202020; -fx-font-size:17; -fx-text-fill: white;");
        functionBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                functionBTN.setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");
            }
        });
        functionBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                functionBTN.setStyle(" -fx-background-radius: 5px; -fx-background-color: #202020;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");
            }
        });

        trigonometryBTN = new Button("Trigonometry  ", new ImageView("down.png"));
        trigonometryBTN.setContentDisplay(ContentDisplay.RIGHT);
        trigonometryBTN.setStyle("-fx-background-color: #202020;-fx-font-size:17;-fx-text-fill: white;");
        trigonometryBTN.setPrefSize(162, 50);
        trigonometryBTN.setLayoutX(0);
        trigonometryBTN.setLayoutY(248);
        trigonometryBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                trigonometryBTN.setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");
            }
        });
        trigonometryBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                trigonometryBTN.setStyle(" -fx-background-radius: 5px; -fx-background-color: #202020;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");
            }
        });

        Root.getChildren().addAll(trigonometryBTN, functionBTN);

        functionPane = new Pane();
        functionPane.setEffect(new DropShadow(10, 0, 0, Color.BLACK));
        functionPane.setPrefSize(240, 120);
        functionPane.setLayoutX(162);
        functionPane.setLayoutY(300);
        functionPane.setStyle("-fx-background-color: #292929; -fx-font-size:20; -fx-font-weight:normal;");

        trigonometryPane = new Pane();
        trigonometryPane.setEffect(new DropShadow(10, 0, 0, Color.BLACK));
        trigonometryPane.setPrefSize(320, 120);
        trigonometryPane.setLayoutX(0);
        trigonometryPane.setLayoutY(300);
        trigonometryPane.setStyle("-fx-background-color: #292929; -fx-font-size:20; -fx-font-weight:normal;");


        functionsbtn = new Button[2][3];
        trigonometrybtn = new Button[2][3];
        hyperbolicbtn = new Button[2][3];

        hypTotri = new Button("hyp");
        hypTotri.setPrefSize(78, 118);
        hypTotri.setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
        hypTotri.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hypTotri.setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
            }
        });
        hypTotri.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hypTotri.setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
            }
        });
        trigonometryPane.getChildren().add(hypTotri);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                functionsbtn[i][j] = new Button();
                functionsbtn[i][j].setPrefSize(78, 58);
                functionsbtn[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                functionsbtn[i][j].setLayoutX(j * 80);
                functionsbtn[i][j].setLayoutY(i * 60);
                int finalI = i;
                int finalJ = j;
                functionsbtn[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        functionsbtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });
                functionsbtn[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        functionsbtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });

                functionPane.getChildren().add(functionsbtn[i][j]);

            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                trigonometrybtn[i][j] = new Button();
                trigonometrybtn[i][j].setPrefSize(78, 58);
                trigonometrybtn[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                trigonometrybtn[i][j].setLayoutX(j * 80 + 80);
                trigonometrybtn[i][j].setLayoutY(i * 60);
                int finalI = i;
                int finalJ = j;
                trigonometrybtn[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        trigonometrybtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });
                trigonometrybtn[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        trigonometrybtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });
                trigonometryPane.getChildren().add(trigonometrybtn[i][j]);


                hyperbolicbtn[i][j] = new Button();
                hyperbolicbtn[i][j].setPrefSize(78, 58);
                hyperbolicbtn[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                hyperbolicbtn[i][j].setLayoutX(j * 80 + 80);
                hyperbolicbtn[i][j].setLayoutY(i * 60);
                hyperbolicbtn[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        hyperbolicbtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });
                hyperbolicbtn[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        hyperbolicbtn[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                    }
                });
            }
        }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ trigonometrybtn and hyperbolicbtn setOnAction and style
        trigonometrybtn[0][0].setText("cos");
        trigonometrybtn[0][1].setText("tan");
        trigonometrybtn[0][2].setText("sec");
        trigonometrybtn[1][0].setText("cot");
        trigonometrybtn[1][1].setText("sin");
        trigonometrybtn[1][2].setText("csc");

        trigonometrybtn[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(Math.cos(first_operand)) <= 0.000001) s = "0.0";
                    else if ((Math.abs(Math.cos(first_operand)) > 10000)) s = "Infinity";
                    else s = Math.cos(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        trigonometrybtn[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(Math.tan(first_operand)) <= 0.000001) s = "0.0";
                    else if (Math.abs(Math.tan(first_operand)) >= 100000) s = "Infinity";
                    else s = Math.tan(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        trigonometrybtn[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(1 / Math.cos(first_operand)) <= 0.000001) s = "0.0";
                    else if (Math.abs(1 / Math.cos(first_operand)) >= 100000) s = "Infinity";
                    else s = 1 / Math.cos(first_operand) + "";

                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        trigonometrybtn[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(1 / Math.tan(first_operand)) <= 0.000001) s = "0.0";
                    else if (Math.abs(1 / Math.tan(first_operand)) >= 100000) s = "Infinity";
                    else s = 1 / Math.tan(first_operand) + "";

                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        trigonometrybtn[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(Math.sin(first_operand)) <= 0.000001) s = "0.0";
                    else if (Math.abs(Math.sin(first_operand)) >= 100000) s = "Infinity";
                    else s = Math.sin(first_operand) + "";

                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        trigonometrybtn[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s;
                    if (Math.abs(1 / Math.sin(first_operand)) <= 0.000001) s = "0.0";
                    else if (Math.abs(1 / Math.sin(first_operand)) >= 100000) s = "Infinity";
                    else s = 1 / Math.sin(first_operand) + "";

                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else if (!s.equals("Infinity")) {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    } else resultTXF.setText("Infinity");
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });

        hyperbolicbtn[0][0].setText("cosh");
        hyperbolicbtn[0][1].setText("tanh");
        hyperbolicbtn[0][2].setText("sech");
        hyperbolicbtn[1][0].setText("coth");
        hyperbolicbtn[1][1].setText("sinh");
        hyperbolicbtn[1][2].setText("csch");

        hyperbolicbtn[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.cosh(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        hyperbolicbtn[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.tanh(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        hyperbolicbtn[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = (1 / Math.cosh(first_operand)) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        hyperbolicbtn[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = (1 / Math.tanh(first_operand)) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        hyperbolicbtn[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.sinh(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });
        hyperbolicbtn[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = (1 / Math.sinh(first_operand)) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(trigonometryPane);
                trigonometryBTNSelected = false;
            }
        });

        hypTotri.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!hyperbolicSelected) {
                    hypTotri.setText("tri");
                    trigonometryPane.getChildren().remove(1, 7);
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 3; j++)
                            trigonometryPane.getChildren().add(hyperbolicbtn[i][j]);
                    hyperbolicSelected = true;
                } else {
                    hypTotri.setText("hyp");
                    trigonometryPane.getChildren().remove(1, 7);
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 3; j++)
                            trigonometryPane.getChildren().add(trigonometrybtn[i][j]);
                    hyperbolicSelected = false;
                }
            }
        });


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++functionsbtn setOnAction and Style
        functionsbtn[0][0].setText("\u2308" + "x" + "\u2309");
        functionsbtn[0][1].setText("rand");
        functionsbtn[0][2].setText("∑");
        functionsbtn[1][0].setText("∛");
        functionsbtn[1][1].setText("\u230A" + "x" + "\u230B");
        functionsbtn[1][2].setText("e^x");


        functionsbtn[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.ceil(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
        functionsbtn[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dotted = false;
                operator_selected = true;
                String s = Math.random() + "";
                if (s.contains("E") && s.length() > 9) {
                    String firstPart = s.substring(0, 6);
                    String secontPart = s.substring(s.indexOf("E"), s.length());
                    resultTXF.setText(firstPart + secontPart);
                } else {
                    if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                    else resultTXF.setText(s.substring(0, s.length()));
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
        functionsbtn[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0 && Double.parseDouble(resultTXF.getText()) >= 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = some(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
        functionsbtn[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.pow(first_operand, 0.333) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
        functionsbtn[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.floor(first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
        functionsbtn[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    String s = Math.pow(2.71828, first_operand) + "";
                    if (s.contains("E") && s.length() > 9) {
                        String firstPart = s.substring(0, 6);
                        String secontPart = s.substring(s.indexOf("E"), s.length());
                        resultTXF.setText(firstPart + secontPart);
                    } else {
                        if (s.length() >= 8) resultTXF.setText(s.substring(0, 8));
                        else resultTXF.setText(s.substring(0, s.length()));
                    }
                }
                Root.getChildren().remove(functionPane);
                functionsBTNSelected = false;
            }
        });
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++trigonometryBTN and functionBTN setOnAction
        functionBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!functionsBTNSelected) {
                    Root.getChildren().remove(trigonometryPane);
                    trigonometryBTNSelected = false;
                    functionsBTNSelected = true;
                    Root.getChildren().add(functionPane);
                } else {
                    functionsBTNSelected = false;
                    Root.getChildren().remove(functionPane);
                }
            }
        });
        trigonometryBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!trigonometryBTNSelected) {
                    Root.getChildren().remove(functionPane);
                    functionsBTNSelected = false;
                    trigonometryBTNSelected = true;
                    Root.getChildren().add(trigonometryPane);
                } else {
                    trigonometryBTNSelected = false;
                    Root.getChildren().remove(trigonometryPane);
                }
            }
        });


        scene = new Scene(Root, 400, 600);
    }

    private String remove_zero(String digit) {
        while (true) {
            if (digit.charAt(digit.length() - 1) == '0' || digit.charAt(digit.length() - 1) == '.') {
                digit = digit.substring(0, digit.length() - 1);
                if (digit.charAt(digit.length() - 1) == '.') {
                    digit = digit.substring(0, digit.length() - 1);
                    break;
                }

            } else break;
        }
        return digit;
    }

    public Scene getScene() {
        return scene;
    }

    private int some(double a) {
        a = (int) a;
        int sum = 0;
        for (int i = 0; i <= a; i++)
            sum += i;
        return sum;
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public TextField getResultTXF() {
        return resultTXF;
    }

    public Button getFunctionBTN() {
        return functionBTN;
    }

    public Button getTrigonometryBTN() {
        return trigonometryBTN;
    }

    public Pane getFunctionPane() {
        return functionPane;
    }

    public Pane getTrigonometryPane() {
        return trigonometryPane;
    }

    public Button[][] getFunctionsbtn() {
        return functionsbtn;
    }

    public Button[][] getTrigonometrybtn() {
        return trigonometrybtn;
    }

    public Button[][] getHyperbolicbtn() {
        return hyperbolicbtn;
    }

    public Button getHypTotri() {
        return hypTotri;
    }
}
