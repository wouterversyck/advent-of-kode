package be.wouterversyck.day3

data class Element(val x: Int, val y: Int, val step: Int) {
    override fun equals(other: Any?): Boolean =
        when(other) {
            is Element -> x == other.x && y == other.y
            else -> false
        }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}
