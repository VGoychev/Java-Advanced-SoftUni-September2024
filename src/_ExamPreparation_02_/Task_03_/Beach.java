package _ExamPreparation_02_.Task_03_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Beach {

    private String name;
    private List<Surfer> surfers;
    private int surfboardsForRent;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfers = new ArrayList<>();
        this.surfboardsForRent = surfboardsForRent;
    }

    public String addSurfer(Surfer surfer) {

        if (surfers.stream().anyMatch(s -> s.getName().equals(surfer.getName()))) {
            throw new RuntimeException("This surfer already exists!");
        }

        if (!surfer.getOwnsASurfBoard()) {
            if (this.surfboardsForRent > 0) {
                if (surfer.getMoney() >= 50) {
                    this.surfboardsForRent--;
                } else {
                    return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
                }
            } else {
                return "There are no free surfboards.";
            }
        }
        surfers.add(surfer);

        return String.format("Surfer %s added.", surfer.getName());
    }

    public Surfer getSurfer(String name) {
        return surfers.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean removeSurfer(String name) {
        Surfer surfer = this.getSurfer(name);
        surfers.remove(surfer);
        return surfer != null;
    }

    public int getCount() {
        return surfers.size();
    }

    public String getMostExperiencedSurfer() {

        Surfer mostExperiencedSurfer = surfers.stream().max(Comparator.comparing(Surfer::getExperience)).orElse(null);

        if (mostExperiencedSurfer != null) {
            return String.format("%s is most experienced surfer with %d years experience.", mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
        }
        return "There are no surfers.";
    }

    public String getSurfersWithPersonalSurfboards() {

        List<Surfer> surfersWithBoards = new ArrayList<>(surfers.stream().filter(Surfer::getOwnsASurfBoard).toList());
        List<String> surfersNames = surfersWithBoards.stream().map(Surfer::getName).toList();

        return !surfersNames.isEmpty()
                ? "Surfers who have their own surfboards: " + String.join(", ", surfersNames.toString().replaceAll("[\\[\\]]", ""))
                : "There are no surfers.";
    }

    public String getReport() {

        Beach beach = new Beach(getName(), getSurfboardsForRent());
        StringBuilder build = new StringBuilder();

        if (surfers.isEmpty()) {
            build.append(System.lineSeparator()).append("There are no surfers on ").append(beach.getName()).append(" beach.");
        } else {
            build.append("Beach ").append(beach.getName()).append(" was visited by the following surfers:");
            build.append(System.lineSeparator());
            for (int i = 0; i < surfers.size(); i++) {
                build.append(i + 1).append(". ").append(surfers.get(i).getName())
                        .append(" with ").append(surfers.get(i).getExperience() > 0
                                ? surfers.get(i).getExperience() + " years experience."
                                : "no experience.").append(System.lineSeparator());
            }
        }
        return build.toString().trim();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Surfer> getSurfers() {
        return surfers;
    }

    public void setSurfers(List<Surfer> surfers) {
        this.surfers = surfers;
    }

    public int getSurfboardsForRent() {
        return surfboardsForRent;
    }

    public void setSurfboardsForRent(int surfboardsForRent) {
        if (surfboardsForRent <= 0) {
            surfboardsForRent = 0;
        }
        this.surfboardsForRent = surfboardsForRent;
    }
}
