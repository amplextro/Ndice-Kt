package net.amplextro.ndice_kt.command

import net.amplextro.ndice_kt.GameSystemManager
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

/**
 *  *DiceRoll*
 * usage: `::<dice roll command>`
 * > ダイスを転がすコマンド
 * > dice roll command: 現在のダイスシステム ${GameSystemManager.currentSystem.id} に対応するダイスコマンド。
 * > https://docs.bcdice.org/ を参照
 */
class RollCommand(override val event: GuildMessageReceivedEvent) : Command {
    override fun handle() {
        TODO("Implement dice roll")
    }
    companion object {
        fun matches(rawCommand: String): Boolean {
            return true
        }
        val HELP_MESSAGE = """
            - *DiceRoll*
            usage: `::<dice roll command>`
            > ダイスを転がすコマンド
            > dice roll command: 現在のダイスシステム ${GameSystemManager.currentSystem.id} に対応するダイスコマンド。
            > https://docs.bcdice.org/ を参照
        """.trimIndent()
    }
}