package language.companion.objekts.pt2

class Employee(val name: String, val dept: String) {
    companion object EmployeeFactory {
        fun buildForHR(name: String) = Employee(name, "HR")
        fun buildForIT(name: String) = Employee(name, "IT")
    }

    override fun toString() = "$name working in $dept"
}

fun main() {
    val emp1 = Employee.buildForHR("Dave")
    val emp2 = Employee.buildForIT("Jane")

    println(emp1)
    println(emp2)
}
