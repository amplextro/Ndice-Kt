package net.amplextro.ndice_kt.command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

/**
 * ガイドメッセージを表示するコマンド
 */
class HelpCommand(override val event: GuildMessageReceivedEvent) : Command {
    override fun handle() {
        event.channel.sendMessage(helpMessage).queue()
    }
    companion object {
        fun matches(rawCommand: String): Boolean {
            return rawCommand.startsWith("help") || rawCommand.trim() == "h"
        }

        val helpMessage = """
NdiceKt
${SystemCommand.HELP_MESSAGE}
${RollCommand.HELP_MESSAGE}
- *Help*
usage: `::help`
> このガイドを表示する
"""
    }
}