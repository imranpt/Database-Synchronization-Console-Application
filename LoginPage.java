

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class LoginPage {
    private static final String userId = "2234869";
    private static final String userPassword = "@beta";

    static void loginPage(){                          // This is a method off login page which contains the code for log in to the database dashboard.
        boolean loginSuccess = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The LoginId: ");
            String loginId = sc.nextLine();
            System.out.println("Enter The LoginPassword: ");
            String loginPassword = sc.nextLine();
            if (Objects.equals(userId, loginId) && Objects.equals(userPassword, loginPassword)){     // This line Check if the password is  correct.
                System.out.println("Login is Successful! ");
                System.out.println("      Welcome Admin!      ");
                loginSuccess = true;
            } else{
                System.out.println("UserName and Password is not Correct. Try Again! ");

            }
        }while (!loginSuccess);
    }
    static Scanner sc = new Scanner(System.in);
    static void dashboard(){                    //This method is for the dashboard which contains the options to compare databases and alert admin , display information of database etc.
        System.out.println("     Welcome to Pentagon.    ");
        System.out.println("    1. Display Realtime Info.   ");
        System.out.println("    2. View Status of the Processes.   ");
        System.out.println("    3. Access Database Synchronization.   ");
        System.out.println("    4. Exit the Dashboard.   ");

        System.out.println("   Please Select an Option to navigate Through:    ");
        int dashboardInput = sc.nextInt();
        switch(dashboardInput){
            case 1:
                System.out.println("       REALTIME INFO.\n   ");
                System.out.println("   Health\t---\t" + randomGenerator1() + "%\n");
                System.out.println("   Threats\t---\t" + randomGenerator2() + "%\n" );
                System.out.println("   Data Backup\t---\t" + randomGenerator1() + "%\n" );      //random generator in these lines are a method to create random values.
                System.out.println("   Storage\t---\t" + randomGenerator3() + "%\n" );
                System.out.println("       SYSTEM OVERVIEW.\n   ");
                System.out.println("   Connection Status: Online\n");
                System.out.println("   Server Load:" + randomGenerator3() + "%\n");
                System.out.println("   Cpu and Memory Usage:" + randomGenerator3() + "%\n");
                System.out.println("  Press 9 to go back to main menu");
                int innerDashboardInput = sc.nextInt();
                if (innerDashboardInput == 9){
                    dashboard();
                }
                break;
            case 2:
                int value = 10;
                System.out.println("   STATUS OF PROCESSES   ");
                System.out.println("  Data Verification Status:  ");
                for(int i = 1; i <= 9; i++){
                    percentGenerator(i , value);
                }
                System.out.println("   Threat Check Status:   ");
                for(int i = 1; i <= 7; i++){
                    percentGenerator(i , value);
                }
                System.out.println("  Press 9 to go back to main menu");
                int innerDashboardInput1 = sc.nextInt();
                if (innerDashboardInput1 == 9){
                    dashboard();
                }
                break;
            case 3:
                DatabaseSynchronization.main();
                break;
            case 4:
                System.out.println(" Exiting the Dashboard..  ");
                break;
        }
    }
    public static void percentGenerator(int num, int den ){
        double percent = ((double)num / den )*100;
        System.out.printf("  Process Percent: %.2f%%%n " , percent);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(" Error: " + e.getMessage());
        }

    }
    static int randomGenerator1(){
        return r.nextInt(11) + 90;
    }
    static int randomGenerator2(){
        return r.nextInt(10);
    }
    static int randomGenerator4(){
        return r.nextInt(5);
    }
    static int randomGenerator3(){
        return r.nextInt(50) + 10;
    }
    static void analysis(){
        System.out.println("   1. Graph Analysis   ");
        System.out.println("   2. Comparison Analysis    ");
        System.out.println("   3. Exit   ");
        System.out.println("   Please select an option to Continue:   ");
        int analysisInput = sc.nextInt();
        switch (analysisInput){
            case 1:
                System.out.println("  ANALYSIS WITH A SINGLE METRIC   ");
                System.out.println("  Latency:\t " + randomGenerator3() + "m/s");
                System.out.println("  Processing Time:\t "+ randomGenerator2() + "s");
                System.out.println("  Cpu Speed:\t  " + randomGenerator4() + "GHz");
                System.out.println("  Memory Utilized:\t " + randomGenerator3() + "%");
                System.out.println("  DiskSpace Used:\t " + randomGenerator3() + "%");
                System.out.println("  Press 9 to go back to main menu");
                int innerAnalysisInput = sc.nextInt();
                if (innerAnalysisInput == 9){
                    analysis();
                }
                break;

            case 2:
                System.out.println("  COMPARED METRICS ANALYSIS   ");
                System.out.println("  Year 2022\t\tYear 2023  ");
                System.out.println("  Latency: " + randomGenerator3() + "m/s\t" + "Latency: " + randomGenerator3() + "m/s");
                System.out.println("  Processing Time " + randomGenerator2() + "s\t" + "Processing Time: " + randomGenerator2() + "s");
                System.out.println("  Cpu Speed " + randomGenerator4() + "GHz\t" + "Cpu Speed: " + randomGenerator4() + "GHz");
                System.out.println("  Memory Utilized: " + randomGenerator3() + "%\t" + "Memory Utilized: " + randomGenerator3() + "%");
                System.out.println("  DiskSpace Used: " + randomGenerator3() + "%\t" + "DiskSpace Used: " + randomGenerator3() + "%");
                System.out.println("  Press 9 to go back to main menu");
                int innerAnalysisInput1 = sc.nextInt();
                if (innerAnalysisInput1 == 9){
                    analysis();
                }
                break;
            case 3:
                System.out.println("Exiting....");
                break;
        }

    }
    static void alert(){
        System.out.println("   ALERTS\t\tDATE\t\tTIME  ");
        System.out.println("   Custom Metric Error\t12-12-2023\t13:05  ");
        System.out.println("   Error Log Entry\t12-12-2023\t2:56  ");
        System.out.println("   Low Disk Space Storage\t13-12-2023\t4:25 ");
        System.out.println("   Runtime Error\t13-12-2023\t11:11 ");
    }

    private static int adminId = 2234869;
    private static String role = "Administrator";
    private static String adminEmail = "2234869@admin.com";
     static void adminProfile(){
        Scanner s = new Scanner(System.in);
        char adminProfileInput;
        System.out.println("      ADMIN PROFILE      ");
        System.out.println("   Admin Id = " + adminId);
        System.out.println("   Role : " + role);
        System.out.println("   Email : " + adminEmail);
        System.out.println("   Click x to edit your Profile or click i to exit   ");
        adminProfileInput = s.next().charAt(0);
        switch (adminProfileInput){
            case 'x':
                editProfile();
                break;
            case 'i':
                System.out.println("   Moving to main Dashboard...   ");
                break;
            default:
                System.out.println(" Invalid Choice.Please Try Again!  ");
                break;
        }
     }
     static void editProfile(){
         Scanner s = new Scanner(System.in);
         System.out.println(" Select the one that you would like to edit or choose 4 to exit:  ");
         System.out.println("   1. Admin Id   ");
         System.out.println("   2. Role   ");
         System.out.println("   3. Email   ");
         System.out.println("   4. Exit   ");
         int editProfileChoice = s.nextInt();
         switch (editProfileChoice){
             case 1:
                 System.out.println(" Enter the new Admin Id to Update  ");
                 adminId = s.nextInt();
                 break;
             case 2:
                 System.out.println(" Enter the new Role to Update  ");
                 role = s.next();
                 break;
             case 3:
                 System.out.println(" Enter the Email to Update  ");
                 adminEmail = s.next();
                 break;
             case 4:
                 System.out.println(" Exiting...  ");
                 break;
             default:
                 System.out.println(" Invalid Choice.Please Try Again!  ");
                 break;
         }
     }
    static void settings(){
        Scanner s = new Scanner(System.in);
        System.out.println("       Settings Menu   ");
        System.out.println("   1. View Connection Settings   ");
        System.out.println("   2. Set User Preferences   ");
        System.out.println("   3. Manage Updates   ");
        System.out.println("   4. View Info about the Data Privacy and Compliance   ");
        System.out.println("   5. Exit  ");
        System.out.println("   Type a number to select that option:   ");
        int userSettingsInput = s.nextInt();
        switch (userSettingsInput) {
            case 1:
                System.out.println(" Database Server Address is " + generateIpv4());
                System.out.println(" Port Number is 8080 ");
                System.out.println(" Database Name: Admin_Pentagon ");
                System.out.println(" AdminId: 2234869 ");
                System.out.println(" Press 9 to go back to the main menu ");
                int insideSettingsInput = sc.nextInt();
                if (insideSettingsInput == 9){
                    settings();
                }
                break;
            case 2:
                System.out.println(" 1. Change Language Preference ");
                System.out.println(" 2. Change Theme of Screen ");
                System.out.println(" Select one option to continue: ");
                System.out.println(" Press 9 to go back to the main menu ");
                int insideSettingsInput2 = sc.nextInt();
                if (insideSettingsInput2 == 9){
                    settings();
                }
                int userPreferenceInput = s.nextInt();
                if (userPreferenceInput == 1){
                    System.out.println(" 1. English ");
                    System.out.println(" 2. Spanish ");
                    System.out.println(" 3. Italian ");
                    System.out.println(" Choose One to Apply ");
                    int languageInput = s.nextInt();
                    if (languageInput == 1){
                        System.out.println(" Language Has Been Changed to English ");
                    } else if (languageInput == 2) {
                        System.out.println(" Language Has Been Changed to Spanish ");
                    } else if (languageInput == 3) {
                        System.out.println(" Language Has Been Changed to Italian ");
                    }
                } else if (userPreferenceInput == 2) {
                    System.out.println(" 1. Dark Theme ");
                    System.out.println(" 2. Light Theme ");
                    System.out.println(" Choose one: ");
                    int themeInput = s.nextInt();
                    if (themeInput == 1){
                        System.out.println(" Dark Mode has been applied ");
                    } else if (themeInput == 2) {
                        System.out.println(" Light Mode has been applied ");
                    }
                }
                break;
            case 3:
                char updateMenuInput;
                System.out.println(" 1. Info about the Current Version ");
                System.out.println(" 2. Update the System ");
                System.out.println(" Press a number to continue ");
                int updatesInput = s.nextInt();
                if (updatesInput == 1){
                    System.out.println(" The Current Updated Version of the Admin_Pentagon is: 28.0.145 ");
                    System.out.println(" The Current Updated Security Version of the Admin_Pentagon is: 29.b5.265p ");
                } else if (updatesInput == 2) {
                    System.out.println(" Press x to update to Newer available Versions or click i to exit ");
                    updateMenuInput = s.next().charAt(0);
                    if (updateMenuInput == 'x'){
                        int value = 10;
                        System.out.println(" Starting Update.... ");
                        for (int i = 0; i<=1; i++){
                            percentGenerator(i , value);
                        }
                        System.out.println(" Update Completed ");
                    } else if (updateMenuInput == 'i') {
                        System.out.println(" Moving to the Main Dashboard Menu.... ");
                        break;
                    }
                break;

                }
            case 4:
                System.out.println("           DATA PRIVACY AND COMPLIANCE            ");
                System.out.println("   The Company is fully compliant with General Data Protection Regulations (GDPR)   ");
                System.out.println("   To learn More about the compliance with GDPR you can view our privacy policy ");
                System.out.println("   which has been updated on Date [26-11-2023] ");
                break;
            case 5:
                break;
            default:
                System.out.println(" Invalid Choice.Please Try Again!  ");
                break;
        }
    }
    static Random r = new Random();
    private static String generateIpv4(){
        StringBuilder ipv4 = new StringBuilder();
        for (int i = 0; i < 4; i++){
            ipv4.append(r.nextInt(256));
            if (i < 3){
                ipv4.append(".");
            }
        }return ipv4.toString();
    }
    static void logout(){
        System.out.println("   You are now logging off...   ");
        System.out.println("   Have a Nice Day!    ");
        System.exit(0);
    }

    static void dashboardMenu(){

            System.out.println("   Dashboard Menu   ");
            System.out.println("   1. Dashboard   ");
            System.out.println("   2. Analysis   ");
            System.out.println("   3. Alert   ");
            System.out.println("   4. Admin Profile  ");
            System.out.println("   5. Settings   ");
            System.out.println("   6. Logout   ");


            System.out.println("   Please Choose a Specific Number to navigate through the Panels or Logout.   ");

    }

    public static void main(String []ar){
        loginPage();
        int userMenuInput;
        do {
            dashboardMenu();
            Scanner scanner = new Scanner(System.in);
            userMenuInput = scanner.nextInt();

            switch (userMenuInput) {
                case 1:
                    dashboard();
                    break;
                case 2:
                    analysis();
                    break;
                case 3:
                    alert();
                    break;
                case 4:
                    adminProfile();
                    break;
                case 5:
                    settings();
                    break;
                case 6:
                    logout();
                    break;
                default:
                    System.out.println(" Invalid Choice.Please Try Again!  ");
                    break;
            }

        } while (userMenuInput != 6);


    }
}
