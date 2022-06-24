import MeteoriumJDA.MeteoriumClient;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        if (args.length < 1) {
            System.out.printf("ERROR: You must provide a token as the first argument.");
            System.exit(1);
        }

        MeteoriumClient Client = new MeteoriumClient(args[0]);
    }
}
