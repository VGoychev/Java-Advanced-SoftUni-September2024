package _ExamPreparation_02_.Task_01_;


import java.util.*;
import java.util.stream.Collectors;


public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> contestants = new ArrayDeque<>();
        ArrayDeque<Integer> piePieces = new ArrayDeque<>();

        int[] contestant = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] pie = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < contestant.length; i++) {
            contestants.offer(contestant[i]);
        }
        for (int i = 0; i < pie.length; i++) {
            piePieces.push(pie[i]);
        }
        while (!contestants.isEmpty() && !piePieces.isEmpty()){
            if (contestants.peek() >= piePieces.peek()){
                int currentContestant = contestants.peek() - piePieces.peek();
                piePieces.pop();
                if (currentContestant == 0){
                    contestants.poll();
                } else {
                    contestants.poll();
                    contestants.offer(currentContestant);
                }
            } else {
                int currentPie = piePieces.peek() - contestants.peek();
                if (currentPie == 1 && piePieces.size() > 1){
                    piePieces.pop();
                    int nextPie = piePieces.pop();
                    piePieces.push(nextPie + currentPie);
                } else {
                    piePieces.pop();
                    piePieces.push(currentPie);
                }
                contestants.poll();
            }

        }
        if (piePieces.isEmpty() && !contestants.isEmpty()){
            System.out.println("We will have to wait for more pies to be baked!");
            String result = contestants.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Contestants left: " + result);
        } else if (piePieces.isEmpty() && contestants.isEmpty()){
            System.out.println("We have a champion!");
        } else {
            List<Integer> reversedList = new ArrayList<>(piePieces);
            Collections.reverse(reversedList);

            System.out.println("Our contestants need to rest!");
            String result = reversedList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Pies left: " + result);
        }
    }
}
