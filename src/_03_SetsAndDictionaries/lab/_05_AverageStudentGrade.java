    package _03_SetsAndDictionaries.lab;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    import java.util.TreeMap;

    public class _05_AverageStudentGrade {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TreeMap<String, List<Double>> students = new TreeMap<>();
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                String student = input[0];
                double grade = Double.parseDouble(input[1]);
                if (!students.containsKey(student)){
                    List<Double> grades = new ArrayList<>();
                    grades.add(grade);
                    students.put(student, grades);
                } else {
                    students.get(student).add(grade);
                }

            }
            students.entrySet().forEach(entry -> {
                System.out.printf("%s -> ",entry.getKey());
                double grades = 0;
                int counter = 0;
                for (int i = 0; i < entry.getValue().size(); i++) {
                    grades += entry.getValue().get(i);
                    counter++;
                    System.out.printf("%.2f ",entry.getValue().get(i));
                }
                double averageGrade = grades / counter;
                System.out.printf("(avg: %.2f)%n",averageGrade);
                ;
            });
        }
    }
