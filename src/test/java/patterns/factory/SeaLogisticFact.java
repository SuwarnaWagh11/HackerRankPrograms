package patterns.factory;

public class SeaLogisticFact extends FactoryLogistic{
    @Override
    Logistic createLogistic() {
        return new Ship();
    }
}
