import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// This class for order datas alphabetic and write to txt files. Extends HMS Decorator class.
public class Order extends HMSDecorator{

    public Order(HMSComponent hmsComponent) {
        // Constructor
        super(hmsComponent);
    }

    public void orderpatients() {
        // Method for order data.
        List<String> liste = new ArrayList<>();
        for (String[] string : HoldData.data_patient) {
            liste.add(string[1].split(" ")[0]);
        }
        Collections.sort(liste);
        for (int i = 0; i < liste.size(); i++) {
            for (String[] string : HoldData.data_patient) {
                if (liste.get(i).equals(string[1].split(" ")[0])) {
                    write_data.add(string);
                }
            }
        }
    }

    public void orderdatas(){
        // Method for order datas.
        List<String> liste = new ArrayList<>();
        for (String[] string : HoldData.data_patient) {
            liste.add(string[1].split(" ")[0]);
        }
        List<Integer> liste1 = new ArrayList<>();
        List<String[]> liste2 = new ArrayList<>();
        for (String[] string : HoldData.data_patient){
            liste1.add(Integer.valueOf(string[0]));
        }
        Collections.sort(liste1);
        for (int i = 0; i < liste.size(); i++){
            for (String[] string : HoldData.data_patient){
                if (liste1.get(i).equals(Integer.valueOf(string[0]))){
                    liste2.add(string);
                }
            }
        }
        HoldData.data_patient = liste2;

        List<Integer> liste3 = new ArrayList<>();
        List<String[]> liste4 = new ArrayList<>();
        boolean control;
        int ID = 0;
        int currentID = 0;
        for (String[] string : HoldData.data_admission){
            if (string[0].chars().allMatch(Character::isDigit)){
                liste3.add(Integer.valueOf(string[0]));
            }
        }
        Collections.sort(liste3);
        for (Integer integer : liste3) {
            control = true;
            for (String[] string : HoldData.data_admission) {
                if (string[0].chars().allMatch(Character::isDigit)) {
                    currentID = Integer.parseInt(string[0]);
                    if (Integer.valueOf(string[0]).equals(integer)){
                        liste4.add(string);
                        control = false;
                        ID = currentID;
                    }
                }
                else if ((string[0].chars().allMatch(Character::isLetter) && (!control)) && (ID == currentID)) {
                    liste4.add(string);
                }
            }
        }
        HoldData.data_admission = liste4;
    }



    public void write() throws IOException {
        // Method for write to text files.
        FileWriter writer = new FileWriter("output.txt");
        for (String[] strings : write_data){
            writer.write(Arrays.toString(strings).replace("[","")
                    .replace("]","").replace(",","")+ System.lineSeparator());
        }
        writer.close();

        FileWriter writer1 = new FileWriter("patient.txt");
        for (String[] strings : HoldData.data_patient){
            String line = "";
            for (int i = 0; i < strings.length ; i ++){
                line = line + strings[i] + "\t";
            }
            writer1.write(line + System.lineSeparator());

        }
        writer1.close();

        FileWriter writer2 = new FileWriter("admission.txt");
        for (String[] strings : HoldData.data_admission){
            writer2.write((strings[0] + "\t" + strings[1]).replace("[","")
                    .replace("]","").replace(",","")+ System.lineSeparator());
        }
        writer2.close();

    }
}
