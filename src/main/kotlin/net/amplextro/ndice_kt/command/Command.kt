package net.amplextro.ndice_kt.command

import net.dv8tion.jda.api.events.Event

interface Command {
    val event: Event
    fun handle()
}