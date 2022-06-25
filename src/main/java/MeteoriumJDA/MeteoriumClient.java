package MeteoriumJDA;

import MeteoriumJDA.utils.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.ChunkingFilter;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class MeteoriumClient {
    JDABuilder Builder;
    JDA Client;
    Logger logger;

    public MeteoriumClient(String token) throws LoginException, IOException, InterruptedException {
        // Logger
        logger = new Logger("MeteoriumRunLog");

        // Make the JDA builder and build the client
        logger.log("Creating JDA client object.");
        Builder = JDABuilder.createDefault(token);
        Builder.setActivity(Activity.playing("no"));
        Builder.setStatus(OnlineStatus.IDLE);
        Builder.setChunkingFilter(ChunkingFilter.ALL);
        Client = Builder.build();
        Client.awaitReady();
        logger.info("JDA Client ready!");
    }
}
