import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MenuPane {


    public static VBox menuVBX;
    private static Button[] buttons = new Button[17];
    public static ScrollPane scrollPane = new ScrollPane();
    private static Label CalculatorLBL = new Label("  Calculator");
    private static Label ConvertorLBL = new Label("  Convertor");
    private Button menuBTN;

    public MenuPane() {
        menuVBX = new VBox();

        menuBTN = new Button();
        menuBTN.setGraphic(new ImageView("menu.png"));
        menuBTN.setLayoutY(0);
        menuBTN.setLayoutX(0);
        menuBTN.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#0F2027, #2B5263);" + " -fx-text-fill: white;");
        menuBTN.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuBTN.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#12c2e9, #2B5263);");
            }
        });
        menuBTN.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuBTN.setStyle(" -fx-focus-color: white;" + " -fx-background-color: linear-gradient(#0F2027, #2B5263);");
            }
        });
        menuBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!Enter.isSelectedMenu) {
                    Enter.Root.getChildren().add(getScrollPane());
                    Enter.isSelectedMenu = true;
                } else {
                    Enter.Root.getChildren().remove(getScrollPane());
                    Enter.isSelectedMenu = false;
                }
            }
        });

        CalculatorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: white; " + "-fx-background-color: linear-gradient(#141E30, #243B55);");
        CalculatorLBL.setPrefSize(300, 50);

        ConvertorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: white; " + "-fx-background-color: linear-gradient(#141E30, #243B55);");
        ConvertorLBL.setPrefSize(300, 50);

        Button DarkModBTN = new Button("Light");
        DarkModBTN.setEffect(new DropShadow(20, 0, 0, Color.WHITE));
        DarkModBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: white;" + " -fx-text-fill: black;" + " -fx-font-size: 16;");
        DarkModBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent[] objects = {Main.angle, Main.area, Main.data, Main.energy, Main.length, Main.power, Main.presure, Main.speed, Main.temperature, Main.time, Main.volume, Main.weight};

                if (DarkMod.selected) {
                    //light mode
                    DarkModBTN.setEffect(new DropShadow(20, 0, 0, Color.BLACK));
                    DarkModBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: black;" + " -fx-text-fill: white;" + " -fx-font-size: 16;");
                    DarkModBTN.setText("Dark");
                    DarkMod.selected = false;
                    Length.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Angle.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Area.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Data.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Energy.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Power.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Presure.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Speed.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Temperature.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Time.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Volume.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    Weight.Root.setStyle("-fx-background-color: #E1E8E1; -fx-font-size:13; -fx-font-weight:normal;");
                    for (int K = 0; K < 12; K++) {
                        objects[K].getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                        objects[K].getBackspaceBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getBackspaceBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                        objects[K].getClearBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getClearBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                        objects[K].getDottBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getDottBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                        objects[K].getCalculateBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getCalculateBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                objects[K].getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                int finalI = i;
                                int finalJ = j;
                                objects[K].getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.length.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                                objects[K].getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.length.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                        }
                        objects[K].getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                        objects[K].getZeroBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getZeroBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #F9FAF3;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            }
                        });

                    }

                    for (int i = 0; i < 17; i++) {
                        buttons[i].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFF9FA;" + " -fx-text-fill: black;");
                        int finalI = i;
                        buttons[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #FFF9FA;" + " -fx-text-fill: black;");

                            }
                        });
                        buttons[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #EEF9FA;" + " -fx-text-fill: black;");

                            }
                        });
                        buttons[i].setEffect(new DropShadow(5, 0, 0, Color.BLACK));

                    }
                    buttons[0].setGraphic(new ImageView("calculator-dark.png"));
                    buttons[1].setGraphic(new ImageView("scientific-dark.png"));
                    buttons[3].setGraphic(new ImageView("date-dark.png"));
                    buttons[4].setGraphic(new ImageView("volume-dark.png"));
                    buttons[5].setGraphic(new ImageView("length-dark.png"));
                    buttons[6].setGraphic(new ImageView("weight-dark.png"));
                    buttons[7].setGraphic(new ImageView("temperature-dark.png"));
                    buttons[8].setGraphic(new ImageView("energy-dark.png"));
                    buttons[9].setGraphic(new ImageView("area-dark.png"));
                    buttons[10].setGraphic(new ImageView("speed-dark.png"));
                    buttons[11].setGraphic(new ImageView("time-dark.png"));
                    buttons[12].setGraphic(new ImageView("power-dark.png"));
                    buttons[13].setGraphic(new ImageView("data-dark.png"));
                    buttons[14].setGraphic(new ImageView("presure-dark.png"));
                    buttons[15].setGraphic(new ImageView("angle-dark.png"));
                    CalculatorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: black; " + "-fx-background-color: linear-gradient(#858182, #FFF9FA);");
                    ConvertorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: black; " + "-fx-background-color: linear-gradient(#858182, #FFF9FA);");
                    menuVBX.setStyle(" -fx-background-color: #FFF9FA;" + " -fx-text-fill: white;" + " -fx-font-size: 18;");

                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 5; j++) {
                            Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            int finalI = i;
                            int finalJ = j;
                            Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.scientific.getButtons()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));

                            if ((i >= 2 && i <= 4) && (j >= 1 && j <= 3)) {
                                Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                            if (i == 5 && j == 2) {
                                Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                        }
                    }
                    Scientific.Root.setStyle("-fx-background-color: #F6F7F0; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.scientific.getFunctionPane().setStyle("-fx-background-color: #ffffff; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.scientific.getTrigonometryPane().setStyle("-fx-background-color: #ffffff; -fx-font-size:20; -fx-font-weight:normal;");
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 3; j++) {
                            int finalI = i;
                            int finalJ = j;
                            Main.scientific.getFunctionsbtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");
                            Main.scientific.getFunctionsbtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getFunctionsbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getFunctionsbtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getFunctionsbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #FFFFFF;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getTrigonometrybtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");
                            Main.scientific.getTrigonometrybtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getTrigonometrybtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getTrigonometrybtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getTrigonometrybtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #FFFFFF;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getFunctionsbtn()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));
                            Main.scientific.getTrigonometrybtn()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));
                            Main.scientific.getHyperbolicbtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");
                            Main.scientific.getHyperbolicbtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getHyperbolicbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getHyperbolicbtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getHyperbolicbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #FFFFFF;-fx-font-size:17;-fx-text-fill: black;");

                                }
                            });
                            Main.scientific.getHyperbolicbtn()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));


                        }
                    }
                    Main.scientific.getFunctionBTN().setStyle("-fx-background-color: #ECEDE7; -fx-font-size:17; -fx-text-fill: black;");
                    Main.scientific.getFunctionBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getFunctionBTN().setStyle("-fx-background-color: #ECEDE7; -fx-font-size:17; -fx-text-fill: black;");

                        }
                    });
                    Main.scientific.getFunctionBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getFunctionBTN().setStyle("-fx-background-color: #F6F7F0; -fx-font-size:17; -fx-text-fill: black;");

                        }
                    });
                    Main.scientific.getTrigonometryBTN().setStyle("-fx-background-color: #ECEDE7; -fx-font-size:17; -fx-text-fill: black;");
                    Main.scientific.getTrigonometryBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getTrigonometryBTN().setStyle("-fx-background-color: #ECEDE7; -fx-font-size:17; -fx-text-fill: black;");

                        }
                    });
                    Main.scientific.getTrigonometryBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getTrigonometryBTN().setStyle("-fx-background-color: #F6F7F0; -fx-font-size:17; -fx-text-fill: black;");

                        }
                    });
                    Main.scientific.getFunctionBTN().setEffect(new DropShadow(2, 0, 0, Color.BLACK));
                    Main.scientific.getTrigonometryBTN().setEffect(new DropShadow(2, 0, 0, Color.BLACK));

                    Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");
                    Main.scientific.getHypTotri().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #E1E8E1;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.scientific.getHypTotri().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #ffffff;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.scientific.getHypTotri().setEffect(new DropShadow(2, 0, 0, Color.BLACK));

                    Main.scientific.getResultTXF().setStyle(" -fx-text-fill: black;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #ffffff;");

                    Enter.Root.setStyle("-fx-background-color: #F6F7F0; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.MainScene.getResultTXF().setStyle(" -fx-text-fill: black;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #ffffff;");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 4; j++) {
                            Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                            int finalI = i;
                            int finalJ = j;
                            Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.MainScene.getButtons()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));

                            if ((i >= 2 && i <= 4) && (j >= 0 && j <= 2)) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                            if (i == 5 && j == 1) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #ECEDE7;" + " -fx-text-fill: black;" + " -fx-font-size: 20;");
                                    }
                                });
                            }

                        }
                    }

                    DateCalculator.Root.setStyle("-fx-background-color: #F6F7F0; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.dateCalculator.getFromDatePicker().setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #E1E8E1;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");
                    Main.dateCalculator.getToDatePicker().setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #E1E8E1;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");
                    Main.dateCalculator.getResult().setStyle("-fx-background-color: #E1E8E1; -fx-font-size:15; -fx-text-fill: black;");
                    Main.dateCalculator.getFromLBL().setStyle("-fx-text-fill: black;");
                    Main.dateCalculator.getToLBL().setStyle("-fx-text-fill: black;");
                    Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #E1E8E1;" + " -fx-text-fill: black;" + "-fx-background-radius: 5 5 5 5");
                    Main.dateCalculator.getCalculate().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #FFFFFF;" + " -fx-text-fill: black;" + "-fx-background-radius: 5 5 5 5");
                        }
                    });
                    Main.dateCalculator.getCalculate().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #E1E8E1;" + " -fx-text-fill: black;" + "-fx-background-radius: 5 5 5 5");
                        }
                    });


                } else {
                    //dark mod
                    DarkModBTN.setEffect(new DropShadow(20, 0, 0, Color.WHITE));
                    DarkModBTN.setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: white;" + " -fx-text-fill: black;" + " -fx-font-size: 16;");
                    DarkModBTN.setText("Light");
                    DarkMod.selected = true;
                    Length.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Angle.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Area.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Data.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Energy.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Power.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Presure.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Speed.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Temperature.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Time.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Volume.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    Weight.Root.setStyle("-fx-background-color: #202020; -fx-font-size:13; -fx-font-weight:normal;");
                    for (int K = 0; K < 12; K++) {
                        objects[K].getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                        objects[K].getBackspaceBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getBackspaceBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getBackspaceBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                        objects[K].getClearBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getClearBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getClearBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                        objects[K].getDottBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getDottBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getDottBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });

                        objects[K].getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                        objects[K].getCalculateBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #white;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getCalculateBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getCalculateBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #white;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                objects[K].getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                int finalI = i;
                                int finalJ = j;
                                objects[K].getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.length.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                objects[K].getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.length.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                        }
                        objects[K].getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                        objects[K].getZeroBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });
                        objects[K].getZeroBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Main.length.getZeroBTN().setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            }
                        });

                    }

                    for (int i = 0; i < 17; i++) {
                        buttons[i].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #16222A;" + " -fx-text-fill: white;");
                        int finalI = i;
                        buttons[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #2C3E50;" + " -fx-text-fill: white;");
                            }
                        });
                        buttons[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #16222A;" + " -fx-text-fill: white;");
                            }
                        });
                        buttons[i].setEffect(new DropShadow(5, 0, 0, Color.WHITE));

                    }
                    buttons[0].setGraphic(new ImageView("calculator.png"));
                    buttons[1].setGraphic(new ImageView("beaker.png"));
                    buttons[3].setGraphic(new ImageView("calendar.png"));
                    buttons[4].setGraphic(new ImageView("volume.png"));
                    buttons[5].setGraphic(new ImageView("length.png"));
                    buttons[6].setGraphic(new ImageView("weight.png"));
                    buttons[7].setGraphic(new ImageView("temprature.png"));
                    buttons[8].setGraphic(new ImageView("energy.png"));
                    buttons[9].setGraphic(new ImageView("area.png"));
                    buttons[10].setGraphic(new ImageView("speed.png"));
                    buttons[11].setGraphic(new ImageView("time.png"));
                    buttons[12].setGraphic(new ImageView("power.png"));
                    buttons[13].setGraphic(new ImageView("data.png"));
                    buttons[14].setGraphic(new ImageView("presure.png"));
                    buttons[15].setGraphic(new ImageView("angle.png"));
                    CalculatorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: white; " + "-fx-background-color: linear-gradient(#141E30, #243B55);");
                    ConvertorLBL.setStyle(" -fx-font-weight: bold; " + " -fx-Text-fill: white; " + "-fx-background-color: linear-gradient(#141E30, #243B55);");
                    menuVBX.setStyle(" -fx-background-color: #243B55;" + " -fx-text-fill: white;" + " -fx-font-size: 18;");

                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 5; j++) {
                            Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            int finalI = i;
                            int finalJ = j;
                            Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });

                            if ((i >= 2 && i <= 4) && (j >= 1 && j <= 3)) {
                                Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                            if (i == 5 && j == 2) {
                                Main.scientific.getButtons()[i][j].setStyle(" -fx-background-radius: 5px; -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.scientific.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.scientific.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.scientific.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                        }
                    }
                    Main.scientific.getButtons()[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                    Main.scientific.getButtons()[5][4].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getButtons()[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.scientific.getButtons()[5][4].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getButtons()[5][4].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });

                    Scientific.Root.setStyle("-fx-background-color: #202020; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.scientific.getFunctionPane().setStyle("-fx-background-color: #292929; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.scientific.getTrigonometryPane().setStyle("-fx-background-color: #292929; -fx-font-size:20; -fx-font-weight:normal;");
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 3; j++) {
                            int finalI = i;
                            int finalJ = j;
                            Main.scientific.getFunctionsbtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                            Main.scientific.getFunctionsbtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getFunctionsbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });
                            Main.scientific.getFunctionsbtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getFunctionsbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });
                            Main.scientific.getTrigonometrybtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                            Main.scientific.getTrigonometrybtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getTrigonometrybtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });
                            Main.scientific.getTrigonometrybtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getTrigonometrybtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });
                            Main.scientific.getFunctionsbtn()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));
                            Main.scientific.getTrigonometrybtn()[i][j].setEffect(new DropShadow(2, 0, 0, Color.BLACK));
                            Main.scientific.getHyperbolicbtn()[i][j].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");
                            Main.scientific.getHyperbolicbtn()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getHyperbolicbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #424242;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });
                            Main.scientific.getHyperbolicbtn()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.scientific.getHyperbolicbtn()[finalI][finalJ].setStyle("-fx-background-radius: 5px; -fx-background-color: #323232;-fx-font-size:17;-fx-text-fill: white;");

                                }
                            });


                        }
                    }
                    Main.scientific.getFunctionBTN().setStyle("-fx-background-color: #202020; -fx-font-size:17; -fx-text-fill: white;");
                    Main.scientific.getFunctionBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getFunctionBTN().setStyle("-fx-background-color: #202020; -fx-font-size:17; -fx-text-fill: white;");

                        }
                    });
                    Main.scientific.getFunctionBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getFunctionBTN().setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");

                        }
                    });
                    Main.scientific.getTrigonometryBTN().setStyle("-fx-background-color: #202020; -fx-font-size:17; -fx-text-fill: white;");
                    Main.scientific.getTrigonometryBTN().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getTrigonometryBTN().setStyle("-fx-background-color: #202020; -fx-font-size:17; -fx-text-fill: white;");

                        }
                    });
                    Main.scientific.getTrigonometryBTN().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getTrigonometryBTN().setStyle(" -fx-background-radius: 5px; -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 17;");

                        }
                    });

                    Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                    Main.scientific.getHypTotri().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.scientific.getHypTotri().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.scientific.getHypTotri().setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.scientific.getHypTotri().setEffect(new DropShadow(2, 0, 0, Color.BLACK));

                    Main.scientific.getResultTXF().setStyle(" -fx-text-fill: white;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #202020;");

                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 4; j++) {
                            Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            int finalI = i;
                            int finalJ = j;
                            Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });

                            if ((i >= 2 && i <= 4) && (j <= 2)) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                            if (i == 5 && j == 1) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                        }
                    }
                    Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                    Main.MainScene.getButtons()[5][3].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.MainScene.getButtons()[5][3].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });

                    Enter.Root.setStyle("-fx-background-color: #202020;");
                    Main.MainScene.getResultTXF().setStyle(" -fx-text-fill: white;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #202020;");


                    Enter.Root.setStyle("-fx-background-color: #202020; -fx-font-size:20; -fx-font-weight:normal;");
                    Main.MainScene.getResultTXF().setStyle(" -fx-text-fill: white;" + " -fx-font-family: tahoma; " + " -fx-font-size: 30;" + " -fx-color: blue; -fx-font-weight: normal;" + " -fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: -fx-control-inner-background ;" + " -fx-background-color: #202020;");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 4; j++) {
                            Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                            int finalI = i;
                            int finalJ = j;
                            Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });
                            Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                }
                            });

                            if ((i >= 2 && i <= 4) && (j >= 0 && j <= 2)) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }
                            if (i == 5 && j == 1) {
                                Main.MainScene.getButtons()[i][j].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                Main.MainScene.getButtons()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                                Main.MainScene.getButtons()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        Main.MainScene.getButtons()[finalI][finalJ].setStyle(" -fx-background-radius: 5px;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + " -fx-font-size: 20;");
                                    }
                                });
                            }

                        }
                    }
                    Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                    Main.MainScene.getButtons()[5][3].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #27EBF2;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });
                    Main.MainScene.getButtons()[5][3].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.MainScene.getButtons()[5][3].setStyle("-fx-background-radius: 5px; -fx-background-color: #29F7FF;-fx-font-size:17;-fx-text-fill: black;");
                        }
                    });

                    DateCalculator.Root.setStyle("-fx-background-color: #202020; -fx-font-size:20; -fx-font-weight:bold;");
                    Main.dateCalculator.getFromDatePicker().setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #3B3B3B;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");
                    Main.dateCalculator.getToDatePicker().setStyle("-fx-padding: 1em 1em 1em 1em; " + "-fx-background-color: #3B3B3B;" + "-fx-background-insets: 0 0 0 0, 0 0 1 0; -fx-text-fill: white;" + "-fx-background-radius: 5;");
                    Main.dateCalculator.getResult().setStyle("-fx-background-color: #323232; -fx-font-size:15; -fx-text-fill: white;");
                    Main.dateCalculator.getFromLBL().setStyle("-fx-text-fill: white;");
                    Main.dateCalculator.getToLBL().setStyle("-fx-text-fill: white;");
                    Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
                    Main.dateCalculator.getCalculate().setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #3B3B3B;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
                        }
                    });
                    Main.dateCalculator.getCalculate().setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Main.dateCalculator.getCalculate().setStyle("-fx-font-size: 15;" + " -fx-focus-color: white;" + " -fx-background-color: #323232;" + " -fx-text-fill: white;" + "-fx-background-radius: 5 5 5 5");
                        }
                    });


                }
            }
        });

        HBox DarkMod_and_MenuBTN = new HBox(menuBTN, DarkModBTN);
        DarkMod_and_MenuBTN.setSpacing(172);
        menuVBX.getChildren().add(DarkMod_and_MenuBTN);

        menuVBX.setPrefSize(300, 1042);
        menuVBX.setStyle(" -fx-background-color: #243B55;" + " -fx-text-fill: white;" + " -fx-font-size: 18; -fx-font-weight: normal;");
        menuVBX.setSpacing(2);
        menuVBX.getChildren().add(CalculatorLBL);
        for (int i = 0; i < 17; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefSize(300, 58);
            buttons[i].setAlignment(Pos.CENTER_LEFT);
            buttons[i].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #16222A;" + " -fx-text-fill: white;");
            final int finalI = i;

            buttons[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #2C3E50;" + " -fx-text-fill: white;");
                }
            });
            buttons[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    buttons[finalI].setStyle(" -fx-background-radius: 0px;" + " -fx-focus-color: white;" + " -fx-background-color: #16222A;" + " -fx-text-fill: white;");
                }
            });

            if (i == 0) {
                buttons[i].setText("     Standard");
                buttons[i].setGraphic(new ImageView("calculator.png"));
            } else if (i == 1) {
                buttons[i].setText("     Scientific");
                buttons[i].setGraphic(new ImageView("beaker.png"));
            } else if (i == 2) {
                buttons[i].setText("     Programmer");
                buttons[i].setGraphic(new ImageView("programmer.png"));
            } else if (i == 3) {
                buttons[i].setText("     Date Calculation");
                buttons[i].setGraphic(new ImageView("calendar.png"));
            } else if (i == 4) {
                buttons[i].setText("     Volume");
                buttons[i].setGraphic(new ImageView("volume.png"));
            } else if (i == 5) {
                buttons[i].setText("     Length");
                buttons[i].setGraphic(new ImageView("length.png"));
            } else if (i == 6) {
                buttons[i].setText("     Weight and Mass");
                buttons[i].setGraphic(new ImageView("weight.png"));
            } else if (i == 7) {
                buttons[i].setText("     Temperature");
                buttons[i].setGraphic(new ImageView("temprature.png"));
            } else if (i == 8) {
                buttons[i].setText("     Energy");
                buttons[i].setGraphic(new ImageView("energy.png"));
            } else if (i == 9) {
                buttons[i].setText("     Area");
                buttons[i].setGraphic(new ImageView("area.png"));
            } else if (i == 10) {
                buttons[i].setText("     Speed");
                buttons[i].setGraphic(new ImageView("speed.png"));
            } else if (i == 11) {
                buttons[i].setText("     Time");
                buttons[i].setGraphic(new ImageView("time.png"));
            } else if (i == 12) {
                buttons[i].setText("     Power");
                buttons[i].setGraphic(new ImageView("power.png"));
            } else if (i == 13) {
                buttons[i].setText("     Data");
                buttons[i].setGraphic(new ImageView("Data.png"));
            } else if (i == 14) {
                buttons[i].setText("     Presure");
                buttons[i].setGraphic(new ImageView("presure.png"));
            } else if (i == 15) {
                buttons[i].setText("     Angle");
                buttons[i].setGraphic(new ImageView("angle.png"));
            } else {
                buttons[i].setText("     Setting");
                buttons[i].setGraphic(new ImageView("settings.png"));
            }


            if (i == 4) menuVBX.getChildren().add(ConvertorLBL);
            menuVBX.getChildren().add(buttons[i]);
        }
        menuVBX.getChildren().remove(buttons[2]);
        menuVBX.getChildren().remove(buttons[16]);


        buttons[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.length.getScene());
            }
        });
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.MainScene.getScene());
            }
        });
        buttons[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.volume.getScene());
            }
        });
        buttons[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.weight.getScene());
            }
        });
        buttons[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.temperature.getScene());
            }
        });
        buttons[8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.energy.getScene());

            }
        });
        buttons[9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.area.getScene());
            }
        });
        buttons[10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.speed.getScene());
            }
        });
        buttons[11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.time.getScene());
            }
        });
        buttons[12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.power.getScene());
            }
        });
        buttons[13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.data.getScene());
            }
        });
        buttons[14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.presure.getScene());
            }
        });
        buttons[15].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.angle.getScene());
            }
        });
        buttons[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.dateCalculator.getScene());
            }
        });
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.primaryStage.setScene(Main.scientific.getScene());
            }
        });


        scrollPane.setContent(menuVBX);
        scrollPane.setPrefSize(300, 600);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutY(0);
        scrollPane.setLayoutX(0);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public VBox getMenuVBX() {
        return menuVBX;
    }
}
