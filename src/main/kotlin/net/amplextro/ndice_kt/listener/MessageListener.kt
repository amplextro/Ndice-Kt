package net.amplextro.ndice_kt.listener

import net.amplextro.ndice_kt.handler.EventHandler
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.EventListener

class MessageListener(private val handler: EventHandler): EventListener {
    override fun onEvent(event: GenericEvent) {
        if (event is GuildMessageReceivedEvent && !event.author.isBot) {
            handler.handle(event)
        }
    }
}