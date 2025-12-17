import java.io.*;
import java.util.Scanner;

public class DatabaseSynchronization {
    public static String filename;  //This line is used to access filename globally
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String database = "pentagon.txt";
        String databaseData = "Name: admin_pentagon, AdminId: 2234869, Role: Admin";
        createDatabaseAfterProgramRun(database, databaseData);
        System.out.println(" 1. Create a Modified Database ");
        System.out.println(" 2. Compare Databases and show Alert  ");
        System.out.println(" 3. Exit to the Dashboard  ");
        System.out.println(" Select an Option to Continue  ");
        int databaseSyncInput = sc.nextInt();
        sc.nextLine(); // consume the newline
        switch (databaseSyncInput) {
            case 1:
                filename = userCreateFileAndData();
                break;
            case 2:
                if (filename == null) {
                    System.out.println("No modified database created yet. Please select option 1 first.");
                } else {
                    compareFiles(database , filename );
                }
                break;
            case 3:
                System.out.println("Exiting..");
                break;
        }

    }

    private static String userCreateFileAndData(){           // This  method prompts the user to create file with user inputted name and data.
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(" Enter the filename with extension to create: ");
            String fileName = sc.nextLine();
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println(" Modified Database has been created with name " + file.getName());
                System.out.println(" Write the content that you need to write to the modified database: ");
                String fileContent = sc.nextLine();
                writeFile(fileName , fileContent);
            }else {
                System.out.println(" File already exists");
            }
            return fileName;
        }catch (IOException e) {
            System.out.println( " Error in Creating Modified Database");
            throw new RuntimeException(e);
        }

    }
    private static void compareFiles(String existingDatabase, String modifiedDatabase){       // this method compares the user created file and auto created file to check if they are identical.
        try (BufferedReader br1 = new BufferedReader(new FileReader(existingDatabase));      // in this line buffered reader is used to read the files in an efficient way by reading line as a whole part.
             BufferedReader br2 = new BufferedReader(new FileReader(modifiedDatabase))) {    //BufferedReader (Java Platform SE 8 ) (2023). https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html#:~:text=Class%20BufferedReader&text=Reads%20text%20from%20a%20character,large%20enough%20for%20most%20purposes.
            int lineNum = 1;
            String l1, l2;

            while ((l1 = br1.readLine()) != null && (l2 = br2.readLine()) != null) {
                if (!l1.equals(l2)) {
                    System.out.println("Data's in the databases differ at line: " + lineNum);
                    System.out.println("         REFERENCE         ");
                    System.out.println("Content in Existing Database: " + l1);
                    System.out.println("Content in Modified Database: " + l2);
                    System.out.println(" CRITICAL ALERT: Database has been Modified");
                    return;
                }
                lineNum++;
            }

            System.out.println("Data's in the databases are identical. ");
        } catch (IOException e) {
            System.out.println("An error occurred during file comparison: " + e.getMessage());
        }
    }
    private static void createDatabaseAfterProgramRun(String database, String databaseData) {
        try (PrintWriter w = new PrintWriter(database)) {
            w.println(databaseData);
        } catch (IOException e) {
            System.out.println("File has not been created: " + e.getMessage());
        }
    }
    private static void writeFile(String fileName, String fileContent){
        try (BufferedWriter brw = new BufferedWriter(new FileWriter(fileName))) {
            brw.write(fileContent);
        } catch (IOException e) {
            System.out.println("Error in writing to the File: " + fileName + e.getMessage());
        }
    }
}
// References :
//Java read files (no date). https://www.w3schools.com/java/java_files_read.asp.
//BufferedWriter (Java Platform SE 8 ) (2023). https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html#:~:text=Class%20BufferedWriter&text=Writes%20text%20to%20a%20character,large%20enough%20for%20most%20purposes.