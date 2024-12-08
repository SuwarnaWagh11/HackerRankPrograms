package patterns.factory1;

public class WebDialog extends Dialog{
    @Override
    Button createButton() {
        return new WebButton();
    }
}
