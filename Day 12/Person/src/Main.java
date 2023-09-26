public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 25);
        System.out.println(alice.getName() + " is " + alice.getAge() + " years old.");

        Person bob = new Person("Bob", 30);
        System.out.println(bob.getName() + " is " + bob.getAge() + " years old.");
    }
}
