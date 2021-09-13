import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class App {

    public static void main(String[] args) {
        aboutShow();
        String[] profileArray = inputProfile();
        boolean success = writeProfile(profileArray);
        writeSuccess(success);
    }

    public static void aboutShow() {
        System.out.println("Nagy János");
        // Fejrész kiírása
        System.out.println("Jelszavak");
        // Verzió kiírása
        System.out.println("Verzió: 0.0.1");
    }

    public static String input(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String inputStr = scanner.nextLine();
        return inputStr;
    }

    public static String[] inputProfile() {
        String user = input("Felhasználónév: ");
        String pass = input("Jelszó: ");
        String place = input("Hely: ");
        String[] array = { user, pass, place };
        return array;
    }

    public static boolean writeProfile(String[] profileArray) {
        try {
            tryWriteProfile(profileArray);
            return true;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
            return false;
        }
    }

    public static void tryWriteProfile(String[] profileArray) throws IOException {
        Profile profile = new Profile(profileArray);
        FileWriter fileWriter = new FileWriter("pass.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(profile.user);
        if (!profile.isPasswordEmpty()) {
            printWriter.print(profile.getPass());
        }
        printWriter.print(profile.place);
        printWriter.close();
    }

    public static void writeSuccess(boolean success){
        if (success) {
            System.out.println("Ok. A kiírás sikeres.");
        } else {
            System.out.println("Hiba! A kiírás sikertelen");
        }
    }

    public static void getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Felhasználónév: ");
        String user = scanner.nextLine();

    }

    public static void getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jelszó: ");
        String pass = scanner.nextLine();

    }

    public static void getPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hely: ");
        String place = scanner.nextLine();
    }

}
