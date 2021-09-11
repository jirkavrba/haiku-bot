import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class HaikuMessageListener : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        println(event.message.contentDisplay)
    }

}