package patterns.factory1;

public class WindowButton implements Button{
    @Override
    public void onClick() {
        System.out.println("on Window pop up");
    }
}
