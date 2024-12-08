package patterns.factory;

public class RoadLogisticFact extends FactoryLogistic{
    @Override
    Logistic createLogistic() {
        return new Truck();
    }
}
