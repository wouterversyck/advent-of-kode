package be.wouterversyck.day3

import java.io.File
import java.lang.IllegalArgumentException

fun main1() {
    val paths = loadPaths();

    println(calculateDistance(paths))
    println("finished")
}


fun main() {
    val first = PathsCreator("R75,D30,R83,U83,L12,D49,R71,U7,L72").mapPath()
    val second = PathsCreator("U62,R66,U55,R34,D71,R55,D58,R83").mapPath()
    println(calculateDistanceInSteps(Pair(first, second)))
}

fun loadPaths(): Pair<Set<Element>, Set<Element>> {
    val paths = File("""C:\Projects\adventofkode\src\main\resources\paths.csv""")
        .readLines()

    if(paths.size != 2) {
        throw IllegalArgumentException("Amount of paths: (${paths.size}) is invalid, valid number is 2")
    }

    val firstPath= PathsCreator((paths[0])).mapPath()
    val secondPath= PathsCreator((paths[1])).mapPath()
    return Pair(firstPath, secondPath)
}

