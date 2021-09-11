import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SyllablesTest {

    @Test
    fun testSyllableCounter() {
        assertEquals(1, "Dog!!!".countSyllables())
        assertEquals(0, "".countSyllables())
        assertEquals(0, " ".countSyllables())
        assertEquals(4, "ostentatious".countSyllables())
        assertEquals(2, "because".countSyllables())
        assertEquals(2, "woman".countSyllables())
        assertEquals(5, "international".countSyllables())
        assertEquals(2, "norway".countSyllables())
        assertEquals(2, "Norway".countSyllables())
    }

}