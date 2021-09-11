import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity

fun main(args: Array<String>) {
    // Require the caller to provide a bot token as the first parameter
    val token = args.firstOrNull() ?: throw IllegalArgumentException(
        """
        Please provide a Discord gateway token as the first program argument!
        You can obtain your bot token at https://discord.com/developers/applications
        """.trimIndent()
    )

    val jda = JDABuilder.createDefault(token)
        .setActivity(Activity.watching("for your accidental haikus"))
        .build()

    jda.awaitReady()
}