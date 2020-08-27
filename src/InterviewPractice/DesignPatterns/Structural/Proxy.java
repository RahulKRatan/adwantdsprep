package InterviewPractice.DesignPatterns.Structural;

/**
 * According to GoF definition of proxy design pattern, a proxy object provide a surrogate or placeholder for another object to control access to it.
 * A proxy is basically a substitute for an intended object which we create due to many reasons
 * e.g. security reasons or cost associated with creating fully initialized original object.
 *
 * Eg : AOP, Hibernate returns an object which a proxy (by dynamically constructed by Hibernate by extending the domain class) to the underlying entity class.
 *
 */

public class Proxy {
    public static void main(String[] args)
    {
        RealObject proxy = new RealObjectProxy();
        proxy.doSomething();
    }
}

interface RealObject {
    public void doSomething();
}

class RealObjectImpl implements RealObject {

    @Override
    public void doSomething() {
        System.out.println("Performing work in real object");
    }

}

class RealObjectProxy extends RealObjectImpl {
    @Override
    public void doSomething()
    {
        //Perform additional logic and security
        //Even we can block the operation execution
        System.out.println("Delegating work on real object");
        super.doSomething();
    }
}