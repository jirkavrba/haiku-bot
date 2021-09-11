
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

fun String.isHaiku(): Boolean = TODO()