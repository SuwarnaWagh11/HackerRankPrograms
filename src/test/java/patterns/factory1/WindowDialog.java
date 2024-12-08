package patterns.factory1;

public class WindowDialog extends Dialog{
    @Override
    Button createButton() {
        return new WindowButton();
    }
}
