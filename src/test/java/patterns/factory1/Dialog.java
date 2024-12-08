package patterns.factory1;

abstract class Dialog {
    public void rendering(){
        Button button = createButton();
        button.onClick();
    }
    abstract Button createButton();
}
