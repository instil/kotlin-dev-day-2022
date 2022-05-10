package language.lambdas.with.receivers.pt2

data class Person(val name: String, var age: Int)

typealias EvilLambda = Person.(
    p1: Int,
    p2: Int,
    p3: Int,
    p4: Int,
    p5: Int,
    p6: Int,
    p7: Int,
    p8: Int,
    p9: Int,
    p10: Int,
    p11: Int,
    p12: Int,
    p13: Int,
    p14: Int,
    p15: Int,
    p16: Int,
    p17: Int,
    p18: Int,
    p19: Int,
    p20: Int,
    p21: Int
) -> Unit

fun demo(
    person: Person,
    action: EvilLambda
) = person.action(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)

fun main() {
    val person = Person("Jane", 25)
    demo(person) { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u ->
        age += 10
        println(this)
    }
}
