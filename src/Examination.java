import java.util.Arrays;
import java.util.HashMap;

// This class for create and add admissions to system. Extends HMS Decorator class.
public class Examination extends HMSDecorator {

    private String ex_number; // Examination number to create admission.
    private String ex_type; // Examination type (Inpatient or Outpatient).
    private HashMap<String, Integer> price = new HashMap<String, Integer>(); // Hashmap for prices.

    // Getters and Setters
    public String getEx_number() { return ex_number; }
    public void setEx_number(String ex_number) { this.ex_number = ex_number; }
    public String getEx_type() { return ex_type; }
    public void setEx_type(String ex_type) { this.ex_type = ex_type; }


    public Examination(HMSComponent hmsComponent, String ex_number) {
        // Constructor with examination number and parent class's object
        super(hmsComponent);
        this.ex_number = ex_number;
    }

    public Examination(HMSComponent hmsComponent, String ex_number, String ex_type) {
        // // Constructor with examination number, parent class's object and examination type.
        super(hmsComponent);
        this.ex_number = ex_number;
        this.ex_type = ex_type;
    }

    public void price() {
        // Method for determine examination prices.
        price.put("Inpatient", 10); price.put("Outpatient", 15); price.put("imaging", 10);
        price.put("measurements", 5); price.put("doctorvisit", 15); price.put("tests", 7);
    }

    public void admission(String id){
        // This method for calculate prices and write them to output data.
        int total = 0;
        price();
        boolean control = true;
        String ID = "";
        String currentID = "";
        for (String[] strings : HoldData.data_admission) {
            if (strings[0].chars().allMatch(Character::isDigit)) {
                currentID = strings[0];
                if (strings[0].equals(id)) {
                    control = false;
                    ID = currentID;
                }
            }
            else if ((strings[0].chars().allMatch(Character::isLetter) && (!control)) && (ID.equals(currentID))) {
                if (strings[1].split(" ").length == 1){
                    String[] liste = {"\t"+ Arrays.toString(strings).replace("[","")
                            .replace("]","").replace(",","") + " " +
                            (price.get(strings[0]) + price.get(strings[1].split(" ")[0])) + "$"};
                    write_data.add(liste);
                    total = total + price.get(strings[0]) + price.get(strings[1].split(" ")[0]);
                }
                if (strings[1].split(" ").length == 2){
                    String[] liste = {"\t"+ Arrays.toString(strings).replace("[","")
                            .replace("]","").replace(",","") + " " +
                            (price.get(strings[0]) + price.get(strings[1].split(" ")[0]) + price.get(strings[1].split(" ")[1])) + "$"};
                    write_data.add(liste);
                    total = total + price.get(strings[0]) + price.get(strings[1].split(" ")[0]) + price.get(strings[1].split(" ")[1]);
                }
                if (strings[1].split(" ").length == 3){
                    String[] liste = {"\t"+ Arrays.toString(strings).replace("[","")
                            .replace("]","").replace(",","") + " " +
                            (price.get(strings[0]) + price.get(strings[1].split(" ")[0]) +
                                    price.get(strings[1].split(" ")[1]) + price.get(strings[1].split(" ")[2])) + "$"};
                    write_data.add(liste);
                    total = total + price.get(strings[0]) + price.get(strings[1].split(" ")[0]) +
                            price.get(strings[1].split(" ")[1]) + price.get(strings[1].split(" ")[2]);
                }
            }
        }
        String[] liste1 = {"\t" + "Total: " + total + "$"};
        write_data.add(liste1);

    }


}
