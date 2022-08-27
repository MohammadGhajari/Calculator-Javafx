import javafx.scene.control.Button;

public class Parent {
    protected Button[][] buttons;
    protected Button zeroBTN;
    protected Button dottBTN;
    protected Button clearBTN;
    protected Button backspaceBTN;
    protected Button calculateBTN;


    public Button getCalculateBTN() {
        return calculateBTN;
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public Button getZeroBTN() {
        return zeroBTN;
    }

    public Button getDottBTN() {
        return dottBTN;
    }

    public Button getClearBTN() {
        return clearBTN;
    }

    public Button getBackspaceBTN() {
        return backspaceBTN;
    }
}
