import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Main extends Application {
    public static Enter MainScene = new Enter();
    public static Length length = new Length();
    public static Volume volume = new Volume();
    public static Weight weight = new Weight();
    public static Stage primaryStage = new Stage();
    public static Temperature temperature = new Temperature();
    public static Energy energy = new Energy();
    public static Area area = new Area();
    public static Speed speed = new Speed();
    public static DateCalculator dateCalculator = new DateCalculator();
    public static Time time = new Time();
    public static Power power = new Power();
    public static Data data = new Data();
    public static Presure presure = new Presure();
    public static Angle angle = new Angle();
    public static Scientific scientific = new Scientific();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(MainScene.getScene());
        primaryStage.show();
    }


}
