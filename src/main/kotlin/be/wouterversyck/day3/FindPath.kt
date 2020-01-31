package be.wouterversyck.day3

import java.util.*
import kotlin.math.abs

fun calculateDistance(paths: Pair<Set<Element>, Set<Element>>): Int {
    val intermediate = paths.first.filter { paths.second.contains(it) && (it.x != 0 || it.y != 0) }
    return intermediate.mapTo(TreeSet()) { abs(it.x) + abs(it.y) }
        .first()
}

fun calculateDistanceInSteps(paths: Pair<Set<Element>, Set<Element>>): Int {
    val intermediate = mutableListOf<Element>()

    paths.first.forEach { if (paths.second.contains(it) && (it.x != 0 || it.y != 0)) {
        intermediate.add(Element(it.x, it.y, it.step + paths.second.find { el -> el == it }!!.step))
    } }
    intermediate.sortWith(compareByDescending { it.step })
    return intermediate.last().step
}

