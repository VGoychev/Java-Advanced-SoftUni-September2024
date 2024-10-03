package _08_Generics.lab._01_JarOfT;


public class Main {
    public static void main(String[] args) {
        Jar<Integer> numbers = new Jar<>();

        numbers.add(13);
        numbers.add(15);
        System.out.println(numbers.remove());

        Jar<String> stringJar = new Jar<>();
        stringJar.add("Hey");
        stringJar.add("Buddy");
        System.out.println(stringJar.remove());

    }

}

