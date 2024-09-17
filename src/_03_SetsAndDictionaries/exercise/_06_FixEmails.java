package _03_SetsAndDictionaries.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")){
                break;
            }
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                emails.put(name, email);
            }
        }
        emails.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        });
    }
}
