package InterviewPractice.DesignPatterns.Creational;

/**
 * https://www.youtube.com/watch?v=k4EkJgY9P4c
 * Builder pattern aims to “Separate the construction of a complex object from its representation so that the same construction process can create different representations.”
 *
 * One way it to create more constructors, and another is to loose the immutability and introduce setter methods. You choose any of both options, you loose something, right?
 * Here, builder pattern will help you to consume additional attributes while retaining the immutability of Use class.
 *
 * Please note that above created user object does not have any setter method, so it’s state can not be changed once it has been built. This provides the desired immutability.
 *
 * Sometimes developers may forget to add support for a new attribute to the builder when they add that attribute to the User class.
 * To minimize this, we should enclose the builders inside the class (as in above example)
 * that they build so that it’s more obvious to the developer that there is a relevant builder that needs to be updated too.
 *
 * Eg : StringBuilder, StringBuffer etc
 *
 */

public class Builder {

    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private Builder(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally constructed User object
        public Builder build() {
            Builder user =  new Builder(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(Builder user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }

    public static void main(String[] args) {
        Builder user1 = new Builder.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);

        Builder user2 = new Builder.UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);

        Builder user3 = new Builder.UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);
    }
}
