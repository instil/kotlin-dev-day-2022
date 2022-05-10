package language.delegated.properties

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LoggingDelegate<T>(var value: T) : ReadWriteProperty<Any?, T> {
    operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>): ReadWriteProperty<Any?, T> {
        println("Creating logger for property '${prop.name}'")
        return this
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("Writing to '${property.name}'")
        this.value = value
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Reading from '${property.name}'")
        return value
    }
}

class Person(val name: String, job: String) {
    var job: String by LoggingDelegate(job)
}

fun main() {
    val person = Person("Jane", "Junior Developer")

    person.job = "Senior Developer"
    println(person.job)
}
