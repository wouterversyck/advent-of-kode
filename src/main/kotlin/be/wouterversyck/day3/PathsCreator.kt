package be.wouterversyck.day3

import java.lang.IllegalArgumentException

class PathsCreator (private val path: String) {
    private var index = Pair(0, 0)
    private var stepsCounter = 0

    fun mapPath(): Set<Element> =
        mapPathToPoints(this.path.split(",")
            .map { Pair(it.substring(0, 1), it.substring(1).toInt()) })


    private fun mapPathToPoints(path: List<Pair<String, Int>>): Set<Element> = path.flatMapTo(HashSet(), this::getPointsList)

    private fun getPointsList(item: Pair<String, Int>): Set<Element> =
        when(item.first) {
            "R" -> runDirection(item, ::right)
            "U" -> runDirection(item, ::up)
            "D" -> runDirection(item, ::down)
            "L" -> runDirection(item, ::left)
            else -> throw IllegalArgumentException("Direction not supported")
        }


    private fun runDirection(move: Pair<String, Int>, action: (Pair<String, Int>) -> Set<Element>): Set<Element> {
        val set = action(move)
        calculateIndex(move)
        return set
    }

    private fun calculateIndex(move: Pair<String, Int>) {
        index = when(move.first) {
            "R" -> Pair(index.first + move.second, index.second)
            "L" -> Pair(index.first - move.second, index.second)
            "D" -> Pair(index.first, index.second - move.second)
            "U" -> Pair(index.first, index.second + move.second)
            else -> throw IllegalArgumentException("Direction not supported")
        }
    }

    private fun down(move: Pair<String, Int>): Set<Element> =
        (1..move.second).mapTo(HashSet()) {
            Element(index.first, index.second - it, ++stepsCounter)
        }


    private fun left(move: Pair<String, Int>): Set<Element> =
        (1..move.second).mapTo(HashSet()) {
            Element(index.first - it, index.second, ++stepsCounter)
        }

    private fun right(move: Pair<String, Int>): Set<Element> =
        (1..move.second).mapTo(HashSet())  {
            Element(index.first + it, index.second, ++stepsCounter)
        }

    private fun up(move: Pair<String, Int>): Set<Element> =
        (1..move.second).mapTo(HashSet()) {
            Element(index.first, index.second + it, ++stepsCounter)
        }

}
