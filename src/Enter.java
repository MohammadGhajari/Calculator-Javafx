import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Enter {
    private Scene scene;
    private boolean unsigned = true;
    private boolean operator_selected = false;
    private boolean dotted = false;
    public static boolean isSelectedMenu = false;
    private double first_operand;
    private String operation;
    public static Pane Root = new Pane();
    private MenuPane menuScene = new MenuPane();
    private Button[][] buttons;
    private TextField resultTXF;

    public Enter() {


        Root.setStyle("-fx-background-color: #202020;");

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


        Root.getChildren().add(menu);


        resultTXF = new TextField();
        resultTXF.setPrefSize(350, 7);
        resultTXF.setLayoutX(50);
        resultTXF.setLayoutY(70);
        resultTXF.setAlignment(Pos.TOP_RIGHT);
        resultTXF.setStyle(" -fx-text-fill: white;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #202020;");

        Root.getChildren().add(resultTXF);


        buttons = new Button[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new Button(i + j + "");
                buttons[i][j].setLayoutX(j * 100 + 2.5);
                buttons[i][j].setPrefWidth(98);
                buttons[i][j].setPrefHeight(62);
                buttons[i][j].setLayoutY(i * 65 + 115 + 95);
                buttons[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
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
                if ((i >= 2 && i <= 4) && (j <= 2)) {
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
                if (i == 5 && j == 1) {
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
        buttons[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
        buttons[5][3].setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttons[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
            }
        });
        buttons[5][3].setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttons[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
            }
        });


        buttons[0][0].setText("%");
        buttons[0][1].setText("CE");
        buttons[0][2].setText("C");
        buttons[0][3].setText("⟵");
        buttons[1][0].setText("1/x");
        buttons[1][1].setText("x²");
        buttons[1][2].setText("√x");
        buttons[1][3].setText("/");
        buttons[2][0].setText("7");
        buttons[2][1].setText("8");
        buttons[2][2].setText("9");
        buttons[2][3].setText("×");
        buttons[3][0].setText("4");
        buttons[3][1].setText("5");
        buttons[3][2].setText("6");
        buttons[3][3].setText("−");
        buttons[4][0].setText("1");
        buttons[4][1].setText("2");
        buttons[4][2].setText("3");
        buttons[4][3].setText("+");
        buttons[5][0].setText("+/-");
        buttons[5][1].setText("0");
        buttons[5][2].setText(".");
        buttons[5][3].setText("=");

        buttons[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    operator_selected = true;
                    first_operand = Double.parseDouble(resultTXF.getText());
                    resultTXF.setText(first_operand / 100 + "");
                    operation = "%";
                }
            }
        });
        buttons[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultTXF.setText("");
            }
        });
        buttons[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultTXF.setText("");
            }
        });
        buttons[0][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = resultTXF.getText();
                if (s.length() >= 1) s = s.substring(0, s.length() - 1);
                resultTXF.setText(s);
            }
        });
        buttons[1][0].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[1][1].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[1][2].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[1][3].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[2][0].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[2][1].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[2][2].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[2][3].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[3][0].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[3][1].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[3][2].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[3][3].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[4][0].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[4][1].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[4][2].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[4][3].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[5][0].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[5][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = resultTXF.getText();
                s += "0";
                resultTXF.setText(s);
            }
        });
        buttons[5][2].setOnAction(new EventHandler<ActionEvent>() {
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
        buttons[5][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (resultTXF.getText().length() > 0) {
                    dotted = false;
                    double second_operand = Double.parseDouble(resultTXF.getText());
                    if (operation == "/") {
                        double result = first_operand / second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation == "-") {
                        double result = first_operand - second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation == "+") {
                        double result = first_operand + second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation == "%") {
                        double result = first_operand * second_operand / 100;
                        resultTXF.setText(remove_zero(result + ""));
                    } else if (operation == "×") {
                        double result = first_operand * second_operand;
                        resultTXF.setText(remove_zero(result + ""));
                    }
                }
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

    public MenuPane getMenuScene() {
        return menuScene;
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public TextField getResultTXF() {
        return resultTXF;
    }
}
