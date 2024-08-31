import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        try {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);

                System.out.printf("%-10s", "ID#");
                System.out.printf("%-10s", "Name");
                System.out.printf("%-15s", "Description");
                System.out.printf("%-10s", "Cost");
                System.out.println("\n===============================================");

                while (inFile.hasNextLine()){
                    line = inFile.nextLine();
                    System.out.println(line);
                }
                inFile.close();
            }
            else{
                System.out.println("You must print a file!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
