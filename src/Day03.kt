
fun main() {
    var scoreMap = mapOf<Char,Int>(
        'a' to 1,
        'b' to 2,
        'c' to 3,
        'd' to 4,
        'e' to 5,
        'f' to 6,
        'g' to 7,
        'h' to 8,
        'i' to 9,
        'j' to 10,
        'k' to 11,
        'l' to 12,
        'm' to 13,
        'n' to 14,
        'o' to 15,
        'p' to 16,
        'q' to 17,
        'r' to 18,
        's' to 19,
        't' to 20,
        'u' to 21,
        'v' to 22,
        'w' to 23,
        'x' to 24,
        'y' to 25,
        'z' to 26,
        'A' to 27,
        'B' to 28,
        'C' to 29,
        'D' to 30,
        'E' to 31,
        'F' to 32,
        'G' to 33,
        'H' to 34,
        'I' to 35,
        'J' to 36,
        'K' to 37,
        'L' to 38,
        'M' to 39,
        'N' to 40,
        'O' to 41,
        'P' to 42,
        'Q' to 43,
        'R' to 44,
        'S' to 45,
        'T' to 46,
        'U' to 47,
        'V' to 48,
        'W' to 49,
        'X' to 50,
        'Y' to 51,
        'Z' to 52,
    )

    fun part1(input: List<String>): Int {
        var score = 0

        var compartments:MutableList<Pair<MutableList<Char>,MutableList<Char>>> =  mutableListOf()
        var commonList = mutableListOf<Char>()
        for(i in input){
            compartments.add(i.splitAtIndex(i.length / 2))
        }

        compartments.forEach { pair ->
            var letters = 'a'
            pair.second.forEach { letter ->
                if (pair.first.contains(letter)){
                    letters = letter
                }
            }
            commonList.add(letters)
        }

        commonList.forEach { c ->
            score += scoreMap.getValue(c)
        }
        return score
    }

    fun part2(input: List<String>): Int {
        var triplets = mutableListOf<String>()
        var firstThree = mutableListOf<MutableList<String>>()
        var firstCompTriple = mutableListOf<Char>()
        var score = 0
        var oo = 0
        for (i in input){
            oo += 1
            triplets.add(i)
            if (oo >= 3){
                firstThree.add(triplets.toMutableList())
                oo = 0
                triplets.clear()
            }
        }
        for(t in 0 until firstThree.size){
          firstCompTriple.add(commonChars(firstThree[t]).first().toCharArray().first())
            score += scoreMap.getValue(commonChars(firstThree[t]).first().toCharArray().first())
        }

        return score
    }


// test if implementation meets criteria from the description, like:
    /*  val testInput = readInput("Day01_test")
  check(part1(testInput) == 1)*/
    val input = readInput("Day003")
    println(part1(input))
    println(part2(input))
}

fun commonChars(wordList: MutableList<String>): List<String> {
    val res = mutableListOf<String>()
    if(wordList.isEmpty()) {
        return res
    }

    val lettersMap = Array(wordList.size) { mutableMapOf<Char, Int>() }

    for(i in wordList.indices) {
        for(letter in wordList[i]) {
            val letterCount = lettersMap[i].get(letter) ?: 0
            lettersMap[i].put(letter, letterCount + 1)
        }
    }
    //iterate over the first word
    for(letterEntry in lettersMap[0]){
        var count = letterEntry.value
        //check if the letter appears in each word i (!= 0)
        loop@for(i in 1 until wordList.size) {
            var letterCount = lettersMap[i].get(letterEntry.key)
            if(letterCount == null) {
                //it means that the letter doesn't appear any word
                count = 0
                break@loop //break inner loop and move to next iteration
            } else {
                //update to minimum appearances (in case of duplicates letters in word)
                count = count.coerceAtMost(letterCount)
            }
        }

        for(i in 1..count) {
            res.add(letterEntry.key.toString())
        }
    }

    return res
}

fun String.splitAtIndex(index: Int) = when {
    index < 0 -> 0
    index > length -> length
    else -> index
}.let { it ->
    take(it).map { it.toChar() }.toMutableList() to substring(it).map { it.toChar() }.toMutableList()
}
