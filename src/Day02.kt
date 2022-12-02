var score = mutableListOf<Int>()
var secScore = mutableListOf<Int>()
fun main() {
    fun part1(input: List<String>): Int {
        for (i in input.indices){
            determineWinner(input[i].last(),input[i].first())
        }
        return score.sum()
    }

    fun part2(input: List<String>): Int {
        for (i in input.indices){
            determinePlayerOneMove(input[i].first(),input[i].last())
        }
        return secScore.sum()
    }

    val input = readInput("Day02")

    println(part1(input))
    println(part2(input))



    // test if implementation meets criteria from the description, like:
    /*  val testInput = readInput("Day01_test")
      check(part1(testInput) == 1)*/


}


fun determineWinner(player1: Char, player2:Char):Int{
    if(isPlayerOneWInner(player1,player2)){
        score.add(determineScore(player1) + 6)
    }else if (isTie(player1,player2)){
        score.add(determineScore(player1) + 3)
    }else{
        score.add(determineScore(player1) + 0)
    }
    return score.sum()
}

fun isPlayerOneWInner(playerOneInput: Char, playerTwoInput: Char): Boolean {
    return (playerOneInput == 'X' && playerTwoInput == 'C') ||
            (playerOneInput == 'Y' && playerTwoInput == 'A') ||
            (playerOneInput == 'Z' && playerTwoInput == 'B')
}
fun isTie(playerOneInput: Char, playerTwoInput: Char): Boolean {
    return (playerOneInput == 'X' && playerTwoInput == 'A') ||
            (playerOneInput == 'Y' && playerTwoInput == 'B') ||
            (playerOneInput == 'Z' && playerTwoInput == 'C')
}

fun determineScore(i:Char):Int{
   return when(i){
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> 0
    }
}

//part 2

fun determinePlayerOneMove(opponent:Char,strategy:Char): Int {
    when(strategy){
        'X' -> {
           var move = when(opponent){
                'A' -> 'Z'
                'B' -> 'X'
                'C' -> 'Y'
                else -> 'e'
            }
            secScore.add( 0 + determineScore(move))
        }
        'Y' -> {
          var move = when(opponent){
                'A' -> 'X'
                'B' -> 'Y'
                'C' -> 'Z'
                else -> 'e'
            }
            secScore.add( 3 + determineScore(move))
        }
        'Z' -> {
          var  move = when(opponent){
                'A' -> 'Y'
                'B' -> 'Z'
                'C' -> 'X'
                else -> 'e'
            }
            secScore.add(6 + determineScore(move))
        }
        else -> 'j'
    }
    return secScore.sum()
}
