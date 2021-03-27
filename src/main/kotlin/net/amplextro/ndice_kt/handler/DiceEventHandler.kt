package net.amplextro.ndice_kt.handler

import net.amplextro.ndice_kt.command.Command
import net.amplextro.ndice_kt.command.HelpCommand
import net.amplextro.ndice_kt.command.RollCommand
import net.amplextro.ndice_kt.command.SystemCommand
import net.dv8tion.jda.api.events.Event
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.internal.JDAImpl

class DiceEventHandler: EventHandler {

    override fun handle(event: Event) {
        JDAImpl.LOG.debug("Event: $event")
        if (event !is GuildMessageReceivedEvent) {
            JDAImpl.LOG.info("Event is not GuildMessageReceivedEvent.")
            return
        } else if (!event.message.contentRaw.startsWith(PREFIX)) {
            JDAImpl.LOG.info("Event is not command: ${event.message.contentRaw}")
            return
        }
        detectCommand(event)?.handle()
    }

    private fun detectCommand(event: GuildMessageReceivedEvent): Command? {
        JDAImpl.LOG.info("Receive command: ${event.message.contentRaw}")
        val rawCommand: String = event.message.contentRaw.substring(2)
        return when {
            HelpCommand.matches(rawCommand) -> HelpCommand(event)
            SystemCommand.matches(rawCommand) -> SystemCommand(event)
            RollCommand.matches(rawCommand) -> RollCommand(event)
            else -> null
        }
    }

    companion object {
        const val PREFIX = "::"
    }
}