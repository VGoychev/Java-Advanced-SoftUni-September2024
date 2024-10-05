package _08_Generics.exercise._07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();
        while (!input.equals("END")){
            String[] command = input.split(" ");
            switch (command[0]){
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    list.swap(index1,index2);
                    break;
                case "Greater":
                    int result = list.count(command[1]);
                    System.out.println(result);
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
