import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// This class for holding datas.
public class HoldData {

    public static List<String[]> data_patient; // List for hold patient's datas.
    public static List<String[]> data_admission; // List for hold amissions.
    public static List<String[]> data_input; // List for hold input datas.

    public static String[] readfile(String path) {
        // Method for read txt file
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> main(String[] args) throws IOException {
        readtxt1();
        readtxt2();
        // This method for keep data in the list
        String[] lines = readfile(args[0]);
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split(" "));

            newlist.addAll(newlist2);
        }
        data_input =  newlist;
        return null;
    }

    public static void readtxt1(){
        // Method for read txt file
        String[] lines = readfile("patient.txt");
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data_patient =  newlist;
    }

    public static void readtxt2(){
        // Method for read txt file
        String[] lines = readfile("admission.txt");
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data_admission =  newlist;
    }
}
