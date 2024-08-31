import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> peeps = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);

        String fileInfo = "";

        File workingDirectory = new File(System.getProperty("user.dir"));




        do{
            String personRec = "";
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            String first = SafeInput.getNonZeroLenString(in, "Enter the first name");
            String last = SafeInput.getNonZeroLenString(in, "Enter the last name");
            String title = SafeInput.getNonZeroLenString(in, "Enter the title");
            int YOB = SafeInput.getRangedInt(in, "Enter the year of birth ", 1000, 2025); //SafeInput for bulletproof

            personRec = ID + ", " + first + ", " + last + ", " + title + ", " + YOB;
            peeps.add(personRec);

            System.out.println("\nWhat file do you want to save this to?");
            fileInfo = in.nextLine(); //finding which file user wants
            System.out.println("\nYou want to save the file to " + fileInfo);

            done = SafeInput.getYNConfirm(in, "Is that all?"); //using SafeInput
        }while(!done);
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\",fileInfo); //finding the path to the file
        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            for (String p: peeps){
                writer.write(p, 0, p.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("File Saved");
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}