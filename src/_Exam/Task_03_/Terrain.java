package _Exam.Task_03_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public String addTank(Tank tank) {
        for (Tank currentTank : tanks){
            if (currentTank.getBrand().equals(tank.getBrand()) &&
            currentTank.getModel().equals(tank.getModel())){
                return "Tank with this brand and model already exists!";
            }
        }
        if (getType().equals("Swamp") && tank.getWeight() > 14000){
            return "This " + tank.getBrand() + " is too heavy for this terrain!";
        }
        tanks.add(tank);
        return "Tank " + tank.getBrand() + " " + tank.getModel() + " added.";
    }
    public boolean removeTank(String brand, String model){
        Iterator<Tank> iterator = tanks.iterator();

        while (iterator.hasNext()) {
            Tank currentTank = iterator.next();


            if (currentTank.getBrand().equals(brand) && currentTank.getModel().equals(model)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> tanksBigger = new ArrayList<>(tanks.stream().filter(tank -> tank.getBarrelCaliber() > barrelCaliber).toList());
        List<String> tanksBiggerCaliberBrand = tanksBigger.stream().map(Tank::getBrand).toList();

        return !tanksBiggerCaliberBrand.isEmpty() ?
                "Tanks with caliber more than "+ barrelCaliber + "mm: "
                + String.join(", ", tanksBiggerCaliberBrand.toString().replaceAll("[\\[\\]]", "")) :
                "There are no tanks with the specified caliber.";
    }
    public Tank getTankByBrandAndModel(String brand, String model){
        for (Tank tank : tanks){
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)){
                return tank;
            }
        }
        return null;
    }
    public String getTheMostArmoredTank(){
        Tank mostArmoredTank = tanks.stream().max(Comparator.comparing(Tank::getArmor)).orElse(null);

        if (mostArmoredTank != null){
            return mostArmoredTank.getBrand() + " " + mostArmoredTank.getModel() +
                    " is the most armored tank with " + mostArmoredTank.getArmor() + "mm. armor thickness.";
        }

        return null;
    }
    public int getCount(){
        return tanks.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        if (tanks.isEmpty()){
            sb.append(System.lineSeparator()).append("There are no tanks in the ")
                    .append(getType().toLowerCase()).append(".");
        } else {
            sb.append("Tanks located in the ").append(getType().toLowerCase()).append(":")
                    .append(System.lineSeparator());
            for (int i = 0; i < getCount(); i++) {
                sb.append("-- ").append(tanks.get(i).getBrand()).append(" ").append(tanks.get(i).getModel())
                        .append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
