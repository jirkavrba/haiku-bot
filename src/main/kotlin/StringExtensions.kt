// TODO: Rewrite this in a nicer, functional style probably?
// https://medium.com/@mholtzscher/programmatically-counting-syllables-ca760435fab4
fun String.countSyllables(): Int {
    var count = 0
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')

    if (this.isBlank()) return 0
    if (this.length <= 3) return 1

    if (vowels.contains(this[0])) count++

    for ((last, current) in this.zipWithNext()) {
        if (vowels.contains(current) && !vowels.contains(last)) count++
    }

    if (this.endsWith('e')) count--
    if (this.endsWith("le") && this.length > 2 && !vowels.contains(this[-3])) count++

    return count.coerceAtMost(1)
}

fun String.words(): List<String> = this.split("""\P{L}+""".toRegex())

fun String.isHaiku(): Boolean = TODO()