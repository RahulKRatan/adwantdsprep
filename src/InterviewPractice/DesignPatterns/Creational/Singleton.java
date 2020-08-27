package InterviewPractice.DesignPatterns.Creational;

import java.io.Serializable;

/**
 * Singleton pattern is a design solution where an application wants to have one and only one instance of any class, in all possible scenarios without any exceptional condition.
 * It’s already threadsafe because java static field/class initialization is thread safe – at JVM level.
 * Static initialization is performed once per class-loader and JVM ensures the single copy of static fields.
 * So even if two threads access above code, only one instance of class will be created by JVM.
 *
 * Eg : Runtime.getRuntime
 */


public class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;

    public Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}