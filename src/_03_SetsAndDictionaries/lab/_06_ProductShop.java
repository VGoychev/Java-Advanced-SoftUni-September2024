package _03_SetsAndDictionaries.lab;

import java.util.*;

public class _06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!shops.containsKey(shop)){
                Map<String, Double> products = new LinkedHashMap<>();
                products.put(product, price);
                shops.put(shop, products);
            } else {
                shops.get(shop).put(product,price);
            }

            input = scanner.nextLine();
        }
        shops.entrySet().forEach(entry -> {
            System.out.printf("%s->%n", entry.getKey());
            entry.getValue().entrySet().forEach(entry2 -> {
                System.out.printf("Product: %s, Price: %.1f%n", entry2.getKey(), entry2.getValue());
            });
        });
    }
}
