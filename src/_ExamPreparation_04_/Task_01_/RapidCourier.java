package _ExamPreparation_04_.Task_01_;

import java.util.*;
import java.util.stream.Collectors;

public class RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packages = new ArrayDeque<>();
        ArrayDeque<Integer> couriers = new ArrayDeque<>();

        int[] packageWeight = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] courierCapacity = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int totalWeight = 0;
        for (int i = 0; i < packageWeight.length; i++) {
            packages.push(packageWeight[i]);
        }
        for (int i = 0; i < courierCapacity.length; i++) {
            couriers.offer(courierCapacity[i]);
        }

        while (!packages.isEmpty() && !couriers.isEmpty()){
            int currentPackage = packages.pop();
            int currentCourier = couriers.poll();

            if (currentCourier >= currentPackage){
                if (currentCourier > currentPackage){
                    currentCourier = currentCourier - (currentPackage * 2);
                    if (currentCourier > 0){
                        couriers.offer(currentCourier);
                    }
                }
                totalWeight += currentPackage;
            } else {
                currentPackage = currentPackage - currentCourier;
                packages.push(currentPackage);
                totalWeight += currentCourier;
            }
        }
        System.out.println("Total weight: " + totalWeight + " kg");
        if (packages.isEmpty() && couriers.isEmpty()){
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (couriers.isEmpty()){
            List<Integer> reversed = new ArrayList<>(packages);
            Collections.reverse(reversed);
            System.out.println("Unfortunately, there are no more available couriers to deliver the following packages: "
                    + reversed.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Couriers are still on duty: "
                    + couriers.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")) + " but there are no more packages to deliver.");
        }
    }
}
