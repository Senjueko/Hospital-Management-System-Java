
// This class for remove patients. Extends HMS Decorator class.
public class RemovePatient extends  HMSDecorator{

    public RemovePatient(HMSComponent hmsComponent) {
        // Constructor
        super(hmsComponent);
    }

    @Override
    public void remove(){
        // Method for remove patient. Also overrides method.
        for (int i = 0; i < HoldData.data_patient.size(); i++){
            if (HoldData.data_patient.get(i)[0].equals(Read.currentID)){
                ConcreteHMS hms = new ConcreteHMS(HoldData.data_patient.get(i)[0], HoldData.data_patient.get(i)[1].split(" ")[0]);
                String[] liste = {"Patient " + hms.getPatientID() + " " + hms.getName() + " removed"};
                write_data.add(liste);
                HoldData.data_patient.remove(i);
            }
        }
        boolean control = true;
        String currentID = "";
        String ID = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < HoldData.data_admission.size(); i++){
            if (HoldData.data_admission.get(i)[1].chars().allMatch(Character::isDigit)){
                currentID = HoldData.data_admission.get(i)[1];
                if (HoldData.data_admission.get(i)[1].equals(Read.currentID)){
                    ID = HoldData.data_admission.get(i)[1];
                    control = false;
                    start = i;
                }
            }
            else if ((HoldData.data_admission.get(i)[1].chars().allMatch(Character::isLetter)) && (!control) && (ID.equals(currentID))){
                    end ++;
            }

        }

        if (!control){
            HoldData.data_admission.subList(start, start + end + 1).clear();
        }


    }
}
