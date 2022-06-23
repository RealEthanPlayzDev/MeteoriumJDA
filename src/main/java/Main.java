import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InterruptedException {
        if (args.length < 1) {
            System.out.printf("ERROR: You must provide a token as the first argument.");
            System.exit(1);
        }

        // Creating the initial client builder
        JDABuilder ClientBuilder = JDABuilder.createDefault(args[0]);
        ClientBuilder.addEventListeners(new Main());
        ClientBuilder.setActivity(Activity.playing("no"));
        ClientBuilder.setStatus(OnlineStatus.IDLE);

        // Build the actual client object
        JDA Client = ClientBuilder.build();
        Client.awaitReady();
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.printf("INFO: JDA Client is ready!");
    }

    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        System.out.printf("WARNING: Disconnected from Discord.");
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        System.out.printf("INFO: Slash command interaction received:\nName: %s\nUser: %s", event.getName(), event.getMember().getId());
    }
}
