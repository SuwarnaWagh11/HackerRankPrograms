package patterns.factory1;

public class TestButton {
    public static void main(String[] args) {
        Dialog dialog = new WebDialog();
        dialog.rendering();

        Dialog dialog1 = new WindowDialog();
        dialog1.rendering();
    }
}