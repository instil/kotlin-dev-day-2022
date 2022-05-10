package language.enumerations

enum class Colour {
    Red,
    Green,
    Blue
}

fun main() {
    Colour.values().forEach(::println)
}
