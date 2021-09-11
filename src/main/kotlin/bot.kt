
fun main(args: Array<String>) {
    val token = args.firstOrNull() ?: throw IllegalArgumentException(
        """
        Please provide a Discord gateway token as the first program argument!
        You can obtain your bot token at https://discord.com/developers/applications
        """.trimIndent()
    )

    println(token)
}