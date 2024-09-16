package _03_SetsAndDictionaries.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (true){
            String input = scanner.nextLine();
            if (input.equals("PARTY")){
                break;
            } else {
                if (!input.isEmpty() && Character.isDigit(input.charAt(0))) {
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
        }
        while (true){
            String input = scanner.nextLine();
            if (input.equals("END")){
                break;
            }
            if (vipGuests.contains(input)){
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
        }

        int notComing = vipGuests.size() + regularGuests.size();

        System.out.println(notComing);
        for (Object o : vipGuests){
            System.out.println(o);
        }
        for (Object o : regularGuests){
            System.out.println(o);
        }
    }
}
