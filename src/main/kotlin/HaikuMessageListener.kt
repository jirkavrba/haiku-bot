import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Instant

private fun createHaikuEmbed(content: String, name: String): MessageEmbed {
    val lines = content.haikuLines() ?: throw IllegalArgumentException("Expected $content to be a haiku!")

    return EmbedBuilder()
        .setColor(0xFEE75C)
        .setTitle("An accidental haiku")
        .setDescription(lines.joinToString("\n") { "_${it}_" })
        .setFooter(" — $name")
        .setTimestamp(Instant.now())
        .build()
}

class HaikuMessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val content = event.message.contentDisplay

        if (content.isHaiku()) {
            val embed = createHaikuEmbed(content, event.author.name)
            event.message.replyEmbeds(embed).queue()
        }
    }
}