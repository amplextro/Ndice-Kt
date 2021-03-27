package net.amplextro.ndice_kt

enum class GameSystem {
    DB {
        override val alias = setOf("default", "db")
        override val id = "DiceBot"
    },
    SW {
        override val alias = setOf("sw")
        override val id = "SwordWorld"
    },
    SW2 {
        override val alias = setOf("sw2", "sw2.0", "swordworld2")
        override val id = "SwordWorld2.0"
    },
    SW25 {
        override val alias = setOf("sw2.5")
        override val id = "SwordWorld2.5"
    },
    Paranoia {
        override val alias = setOf<String>()
        override val id = "Paranoia"
    },
    CoC {
        override val alias = setOf("coc")
        override val id = "Cthulhu"
    },
    CoC7 {
        override val alias = setOf("coc7", "newcoc", "coc7th", "cthulhu7", "newcthulhu")
        override val id = "Cthulhu7th"
    };

    abstract val alias: Set<String>
    abstract val id: String

    fun isAlias(name: String): Boolean {
        val set = mutableSetOf(id.toLowerCase()).apply {
            addAll(alias)
        }
        return set.contains(name.toLowerCase())
    }
}
