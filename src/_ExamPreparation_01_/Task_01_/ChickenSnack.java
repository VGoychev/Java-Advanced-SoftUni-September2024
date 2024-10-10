package _ExamPreparation_01_.Task_01_;

import java.util.*;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> moneyAmount = new ArrayDeque<>();
        ArrayDeque<Integer> foodAmount = new ArrayDeque<>();
        int foodCounter = 0;
        int[] money = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] food = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < money.length; i++) {
            moneyAmount.push(money[i]);
        }
        for (int i = 0; i < food.length; i++) {
            foodAmount.offer(food[i]);
        }

        while (!moneyAmount.isEmpty() && !foodAmount.isEmpty()) {
            int change = 0;
            if (moneyAmount.peek().equals(foodAmount.peek())){
                moneyAmount.pop();
                foodAmount.poll();
                foodCounter++;
            } else if (moneyAmount.peek() < foodAmount.peek()){
                moneyAmount.pop();
                foodAmount.poll();
            } else if (moneyAmount.peek() > foodAmount.peek()) {
                change = moneyAmount.peek() - foodAmount.peek();
                moneyAmount.pop();
                foodAmount.poll();
                if (!moneyAmount.isEmpty()){
                    int currentMoney = moneyAmount.pop();
                    moneyAmount.push(currentMoney + change);
                }
                foodCounter++;
            }


        }

        if (foodCounter == 0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if (foodCounter == 1) {
            System.out.println("Henry ate: " + foodCounter + " food.");
        } else if (foodCounter >= 4){
            System.out.println("Gluttony of the day! Henry ate " + foodCounter + " foods.");
        } else {
            System.out.println("Henry ate: " + foodCounter + " foods.");
        }
    }
}
