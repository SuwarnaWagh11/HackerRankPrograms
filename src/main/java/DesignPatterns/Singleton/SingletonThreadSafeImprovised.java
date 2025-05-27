package DesignPatterns.Singleton;

public class SingletonThreadSafeImprovised {

    //The volatile keyword ensures that multiple threads handle the singleton instance correctly.
    private volatile SingletonThreadSafeImprovised instance;

    private SingletonThreadSafeImprovised(){
        throw new IllegalStateException("Private constructor");
    }

    public SingletonThreadSafeImprovised getInstance(){
        SingletonThreadSafeImprovised localRef = instance;
        if(localRef == null){
            synchronized (this){
                localRef = instance;
                if(localRef == null){
                    instance = localRef = new SingletonThreadSafeImprovised();
                }
            }
        }
        return localRef;
    }
}
