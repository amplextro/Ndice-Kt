package net.amplextro.ndice_kt.command

import net.amplextro.ndice_kt.GameSystem
import net.amplextro.ndice_kt.GameSystemManager
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

/**
 * *GameSystem*
 * usage: `::system [-c | --change <id | alias>] [-h | --help] [-l | --list]`
 * > ゲームシステムに関するコマンド
 * > -c, --change: ゲームシステムを変更する
 * > -l, --list: 利用可能なゲームシステムのリストを表示
 * > -h, --help: このメッセージを表示
 */
class SystemCommand(override val event: GuildMessageReceivedEvent) : Command {
    override fun handle() {
        val commandArgs: List<String> = event.message.contentRaw.split(' ').drop(1)
        if (commandArgs.isEmpty()) {
            // No arguments
            event.channel.sendMessage("現在のゲームシステム：${GameSystemManager.currentSystem.id}").queue()
            return
        }
        when(commandArgs[0]) {
            "-c", "--change" -> {
                if (commandArgs.size <= 1) {
                    // No system specified
                    event.channel.sendMessage("HELP_MESSAGE").queue()
                    return
                }
                val arg: String = commandArgs[1]
                val newSystem: GameSystem? = GameSystem.values().find {
                    it.isAlias(arg.toLowerCase())
                }
                if (newSystem == null) {
                    event.channel.sendMessage("対応していないシステム：$arg").queue()
                } else {
                    GameSystemManager.currentSystem = newSystem
                    event.channel.sendMessage("ゲームシステムを変更しました：${newSystem.id}").queue()
                }
            }
            "-l", "--list" -> {
                val systemList = GameSystem.values()
                    .map { system -> system.id }
                    .reduce { acc, s -> "$acc, $s" }
                event.channel.sendMessage("""
                    対応しているゲームシステムのリスト：
                    $systemList
                """.trimIndent()).queue()
            }
            else -> {
                event.channel.sendMessage(HELP_MESSAGE).queue()
            }
        }
    }
    companion object {
        fun matches(rawCommand: String): Boolean {
            return rawCommand.startsWith("system")
        }
        val HELP_MESSAGE = """
            - *GameSystem*
            usage: `::system [-c | --change <id | alias>] [-h | --help] [-l | --list]`
            > ゲームシステムに関するコマンド
            > -c, --change: ゲームシステムを変更する
            > -l, --list: 利用可能なゲームシステムのリストを表示
            > -h, --help: このメッセージを表示
        """.trimIndent()
    }
}