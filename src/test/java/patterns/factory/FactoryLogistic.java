package patterns.factory;

import groovy.util.logging.Log;

public abstract class FactoryLogistic {

    public void someOperation(){
        Logistic logistic = createLogistic();
        logistic.delivery();
    }

    abstract Logistic createLogistic();
}
