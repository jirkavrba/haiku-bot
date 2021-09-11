import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

private fun createHaikuEmbed(content: String): MessageEmbed = TODO()

class HaikuMessageListener : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val content = event.message.contentDisplay

        if (content.isHaiku()) {
            event.message.replyEmbeds(createHaikuEmbed(content))
        }
    }

}