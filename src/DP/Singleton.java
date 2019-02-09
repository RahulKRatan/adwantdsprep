package DP;

public class Singleton {

    private static Singleton singleton;
    public int value = 10;
    static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void setSingleton(Singleton singleton) {
        Singleton.singleton = singleton;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class testSingleton{

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.getSingleton().getValue());
        singleton.setValue(20);
        System.out.println(singleton.getValue());

    }

}