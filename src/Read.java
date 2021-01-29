import java.io.IOException;
import java.util.Arrays;

// This class for read input to call correct operations.
public class Read {

    protected static String currentID = ""; // ID for make operations.

    public static void main(String[] args) throws IOException {
        // Main method
        HoldData.main(args);
        Read read = new Read();
        read.readinput();
        Order order = new Order(null);
        order.orderdatas();
        order.write();
    }

    public void readinput(){
        // Method for read operations. It reads input list and calls correct operations.
        for (String[] strings : HoldData.data_input){
            if (strings[0].equals("AddPatient")){
                HMSComponent hms = new ConcreteHMS(strings[1],strings[2], strings[3],
                        String.valueOf(Arrays.asList(strings).subList(5, strings.length)).replace("[","")
                                .replace("]","").replace(",",""),strings[4]);
                hms.newPatient();
            }

            if (strings[0].equals("RemovePatient")){
                HMSComponent hms = new ConcreteHMS(strings[1]);
                currentID = ((ConcreteHMS) hms).getPatientID();
                HMSComponent removePatient = new RemovePatient(hms);
                removePatient.remove();
            }

            if (strings[0].equals("CreateAdmission")){
                HMSComponent hms = new ConcreteHMS(strings[2]);
                currentID = ((ConcreteHMS) hms).getPatientID();
                String[] liste = {"Admission " + strings[1] + " created"};
                String[] liste1 = new String[2]; liste1[0] = strings[1]; liste1[1] = ((ConcreteHMS) hms).getPatientID();
                HMSDecorator.write_data.add(liste);
                HoldData.data_admission.add(liste1);

            }

            if (strings[0].equals("AddExamination")){
                currentID = strings[1];
                HMSComponent hms = new Examination(null, strings[1], strings[2]);
                String[] liste = {((Examination) hms).getEx_type() + " examination added to admission " + ((Examination) hms).getEx_number()};
                String[] liste1 = {strings[2] , String.valueOf(Arrays.asList(strings).subList(3, strings.length)).replace("[","")
                        .replace("]","").replace(",","")};
                HMSDecorator.write_data.add(liste);
                HoldData.data_admission.add(liste1);
            }

            if (strings[0].equals("TotalCost")){
                currentID = strings[1];
                HMSComponent hms = new Examination(null, strings[1]);
                String[] liste = {"Total cost for admission "+ ((Examination) hms).getEx_number()};
                HMSDecorator.write_data.add(liste);
                ((Examination) hms).admission(currentID);
            }

            if (strings[0].equals("ListPatients")){
                HMSComponent hms = new Order(null);
                String[] liste = {"Patient List:"};
                HMSDecorator.write_data.add(liste);
                ((Order) hms).orderpatients();
            }

        }
    }
}
