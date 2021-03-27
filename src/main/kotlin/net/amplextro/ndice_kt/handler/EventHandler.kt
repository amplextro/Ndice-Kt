package net.amplextro.ndice_kt.handler

import net.dv8tion.jda.api.events.Event

interface EventHandler {
    fun handle(event: Event)
}