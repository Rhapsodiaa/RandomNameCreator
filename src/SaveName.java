import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveName {
    public static void saveNameToFile(String nameToSave) throws IOException {
        String fileName = "savedNames.txt";

        FileWriter fw = new FileWriter(fileName,true);
        BufferedWriter bf = new BufferedWriter(fw);

        try{
            bf.write("\n" + nameToSave + "\n");
            bf.close();
        }catch (IOException e){
            System.out.println("Nie mozna zapisac");
        }

    }
}
