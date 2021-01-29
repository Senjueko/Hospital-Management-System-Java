import java.util.ArrayList;
import java.util.List;

// Our abstract decorator class to decorate operations. Implements Interface.
public abstract class HMSDecorator implements HMSComponent {

    protected HMSComponent hmsComponent; // Interface referenced object.
    public static List<String[]> write_data = new ArrayList<>(); // List for hold writing datas.

    public HMSDecorator(HMSComponent hmsComponent) {
        // Constructor
        this.hmsComponent = hmsComponent;
    }

    @Override
    public void newPatient() {
        // Overriding method.
         hmsComponent.newPatient();
    }

    @Override
    public void remove() {
        // Overriding method.
        hmsComponent.remove();
    }
}
