package be.wouterversyck.day2

import java.io.File

fun loadIntegers(fileName: String) = File(fileName)
    .readLines()[0]
    .split(",")
    .map { it.toInt() }.toMutableList()
