package DesignPatterns.Singleton;

//Single-threaded version
public class Singleton {
    private static Singleton INSTANCE;

    private Singleton(){
        if (INSTANCE != null){
            throw new IllegalStateException("Private Constructor");
        }
    }

    /*Lazy initialization
    * Instance of this class will not get created untill getInstance() gets called
    * Problem - What if there are 2 threads getting into the getInstance() at the same time??
    * what if 1st thread is busy with singleton constructor at line 22 while 2nd thread is determining the INSTANCE is NULL like 21
    * you might call singleton constructor twice.
    * solution - we need 2 keywords synchronized & volatile --> checkout the implementation in 'SingletonThreadSafe' class
    * */
    public static Singleton getInstance() {
        if(INSTANCE == null){
            return new Singleton();
        }
        return INSTANCE;
    }


}
