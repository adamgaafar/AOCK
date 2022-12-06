import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    var input = readInput("Day05")

    fun part1(input: List<String>) = alterCrate(input,true)

    fun part2(input: List<String>) = alterCrate(input,false)

    println(part1(input))
    println(part2(input))
}

fun alterCrate(input: List<String>, oneByOne: Boolean): String {
    val stackLines = input.filter { '[' in it }
    val moveLines = input.filter { it.startsWith('m') }

    val pattern = """move (\d+) from (\d+) to (\d+)""".toRegex()
    val commands = moveLines.map {
        pattern.matchEntire(it)!!.destructured.toList()
    }.map { it.map(String::toInt) }

    val stacks = Array((stackLines.maxOf { it.length } + 1) / 4) {
        ArrayDeque<Char>()
    }

    stackLines.forEach { line ->
        val crates = "$line ".chunked(4).map { it.trim() }
        crates.forEachIndexed { stack, crate ->
            if (crate.isNotEmpty()) {
                stacks[stack].addFirst(crate[1])
            }
        }
    }

    commands.forEach { (time ,from , to) ->
        if (oneByOne) {
            repeat(time) {
                val crate = stacks[from - 1].removeLast()
                stacks[to - 1].addLast(crate)
            }
        } else {
            var order = ""
            repeat(time) {
                order += stacks[from - 1].removeLast()
            }
            order.reversed().forEach { crate ->
                stacks[to - 1].addLast(crate)
            }
        }
    }
    return stacks.map { it.last() }.joinToString("")
}
