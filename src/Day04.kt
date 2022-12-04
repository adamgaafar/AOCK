import java.util.regex.Pattern

fun main(){
    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input){
            val (first,second) = line.split(",")
            val (start1,end1) = first.split("-")
            val (start2,end2) = second.split("-")
            val assign1low = start1.toInt()
            val assign1high = end1.toInt()
            val assign2low = start2.toInt()
            val assign2high = end2.toInt()
            if (assign1low <= assign2low && assign1high >= assign2high){
                score++
            }else if (assign1low >= assign2low && assign1high <= assign2high){
                score++
            }
        }

        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        var noOverlapCount = 0
        var total = 0
        for (line in input){
            val (first,second) = line.split(",")
            val (start1,end1) = first.split("-")
            val (start2,end2) = second.split("-")
            val assign1low = start1.toInt()
            val assign1high = end1.toInt()
            val assign2low = start2.toInt()
            val assign2high = end2.toInt()
            if (assign1low <= assign2low && assign1high >= assign2high){
                score++
            }else if (assign1low >= assign2low && assign1high <= assign2high){
                score++
            }
            if(assign1low > assign2high){
                noOverlapCount++
            }else if(assign2low > assign1high){
                noOverlapCount++
            }
            total++
        }
        return total - noOverlapCount
    }


// test if implementation meets criteria from the description, like:
    /*  val testInput = readInput("Day01_test")
  check(part1(testInput) == 1)*/
    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))



}