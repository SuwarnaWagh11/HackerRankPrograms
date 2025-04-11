package DesignPatterns.Singleton;

public class SingletonThreadSafe {
    //this is mutable data member talking across multiple threads, hence marked it as volatile
    private volatile static SingletonThreadSafe INSTANCE;

    private SingletonThreadSafe(){
        throw new IllegalStateException("Private Constuctor");
    }

    /* Using synchronized protection & volatile ensures that when we have done write on the INSTANCE variable here
    * that any other threads that do reads after that write has been done see the new value from write
    * rather than looking at like an old value or something
    * */
    public synchronized static SingletonThreadSafe getInstance() {
        if(INSTANCE == null){
            return new SingletonThreadSafe();
        }
        return INSTANCE;
    }


}
