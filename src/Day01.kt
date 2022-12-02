fun main() {
    //global variables
    val input = readInput("Day01")
    var currentList = mutableListOf<Int>()
    var maxValue = mutableListOf<Int>()
    var maxTopThree = mutableListOf<Int>()

    fun part1(input: List<String>): Int {
        for (i in input){
            if (i == ""){
                maxValue.add(currentList.sum())
                currentList.clear()
            }else{
                currentList.add(i.toInt())
            }
        }
        return  maxValue.maxOf { it }
    }

    fun part2(input: List<String>): Int {
        for (i in 0..2){
            var curr = maxValue.maxOf { it }
            maxTopThree.add(curr)
            maxValue.remove(curr)
        }

        return  maxTopThree.sum()
    }


    // test if implementation meets criteria from the description, like:
  /*  val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/
    println(part1(input))
    println(part2(input))



}
