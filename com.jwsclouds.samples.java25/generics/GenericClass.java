package generics;

public class GenericClass<T> {

    T value;

    void display(T value){
        System.out.println("Value=>"+value);
    }

    public static void main(String[] args) {
        GenericClass<String> string = new GenericClass<>();
        string.display("One Hundered");

        GenericClass<Integer> integer = new GenericClass<>();
        integer.display(10);
    }
}
