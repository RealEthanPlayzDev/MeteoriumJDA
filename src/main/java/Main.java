import MeteoriumJDA.MeteoriumClient;
import io.github.cdimascio.dotenv.Dotenv;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LoginException, IOException, InterruptedException {
        /*
        if (args.length < 1) {
            System.out.printf(ANSITerminalColors.RED + "ERROR: You must provide a token as the first argument." + ANSITerminalColors.RESET);
            System.exit(1);
        }
        */

        // dotenv
        Dotenv dotenv = Dotenv.load();
        MeteoriumClient Client = new MeteoriumClient(dotenv.get("TOKEN"));
    }
}
