package _01_StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("print")){

            if (input.equals("cancel")){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    String element = queue.poll();
                    System.out.println("Canceled " + element);
                }

            } else {
                queue.offer(input);

            }


            input = scanner.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
