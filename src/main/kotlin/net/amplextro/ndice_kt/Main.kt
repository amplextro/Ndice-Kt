package net.amplextro.ndice_kt

import net.amplextro.ndice_kt.Ndice_Kt.BuildConfig
import net.amplextro.ndice_kt.handler.DiceEventHandler
import net.amplextro.ndice_kt.listener.MessageListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

fun main(args: Array<String>) {
    val jda = JDABuilder.create(GatewayIntent.GUILD_MESSAGES)
        .setToken(BuildConfig.BOT_TOKEN)
        .addEventListeners(MessageListener(DiceEventHandler()))
        .build()
}