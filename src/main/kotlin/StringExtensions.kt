fun Char.isVowel(): Boolean = setOf('a', 'e', 'i', 'o', 'u', 'y').contains(this.lowercaseChar())

// https://codereview.stackexchange.com/a/9974
fun String.countSyllables(): Int {
    if (this.isBlank()) return 0

    val start = if (this[0].isVowel()) 1 else 0
    val count = start + this.trim()
        .lowercase()
        .zipWithNext()
        .count { (last, current) -> current.isVowel() && !last.isVowel() }

    // List of suffixes that decrease the count by one
    val suffixes = setOf("e", "es", "ed", "le")

    return if (suffixes.any { this.endsWith(it) }) count - 1
    else count
}

fun String.words(): List<String> = this.split("""\P{L}+""".toRegex())

// TODO: Rewrite this in a more functional style
fun String.haikuLines(): List<String>? {
    val words = this.words().iterator()
    val structure = listOf(5, 7, 5)

    val lines = mutableListOf<String>()
    val line = mutableListOf<String>()

    var syllables = 0

    for (count in structure) {
        while (syllables < count) {
            // The words were exhausted before the last verse was met
            if (!words.hasNext()) return null

            val word = words.next()

            line += word
            syllables += word.countSyllables()

            if (syllables == count) {
                lines += line.joinToString(" ")
                line.clear()
            }

            // There is more syllables in the last word
            if (syllables > count) {
                return null
            }
        }
    }

    return lines
}

fun String.isHaiku(): Boolean = this.haikuLines() != null