package MeteoriumJDA;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class MeteoriumClient {
    JDABuilder Builder;
    JDA Client;

    public MeteoriumClient(String token) throws LoginException {
        Builder = JDABuilder.createDefault(token);
        Builder.setActivity(Activity.playing("no"));
        Builder.setStatus(OnlineStatus.IDLE);
        Builder.setChunkingFilter(ChunkingFilter.ALL);

        Client = Builder.build();
    }
}
