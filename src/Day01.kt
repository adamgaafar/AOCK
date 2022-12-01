fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
  /*  val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day01")

    println(input)

    var currentList = mutableListOf<Int>()
    var maxValue = mutableListOf<Int>()
    var maxTopThree = mutableListOf<Int>()

    for (i in input){
        if (i == ""){
            maxValue.add(currentList.sum())
            currentList.clear()
        }else{
            currentList.add(i.toInt())
        }
    }
    for (i in 0..2){
        var curr = maxValue.maxOf { it }
        maxTopThree.add(curr)
        maxValue.remove(curr)
    }
    println(maxValue.maxOf { it })
    println(maxTopThree.sum())
}
