import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        File fileDirectory = new File("Users");
        fileDirectory.mkdirs();

        String name = "login";
        String password = "password";

        File allUsers = new File("AllUsers");
        allUsers.createNewFile();
        Files.write(Paths.get("AllUsers"), "Login,Password".getBytes());

        File user;

        for (int i = 0; i < 100; i++) {
            String fullName = name + i;
            String fullPassword = password + i;

            user = new File("Users/" + fullName);
            user.createNewFile();

            Files.write(Paths.get("Users/" + fullName), fullPassword.getBytes());
            Files.write(Paths.get("AllUsers"), ("\n" + fullName + "," + fullPassword).getBytes(), StandardOpenOption.APPEND);
        }
    }
}
