fun main() {
    //1080
    fun part1(input: List<String>): Int {
        val windowed = input[0].windowed(4)
        windowed.forEachIndexed { index, window ->
            if (window.toSet().count() == window.count()){
                return index + 4
            }
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        val window = input[0].windowed(14)
        window.forEachIndexed { index, s ->
            if (s.toSet().count() == s.count()){
                return index + 14
            }
        }
        return -1
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))

}