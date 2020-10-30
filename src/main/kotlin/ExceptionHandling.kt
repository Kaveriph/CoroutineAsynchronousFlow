import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
    runBlocking {
        //tryCatch()
        //catch()
        onCompletion()
    }
}

suspend fun onCompletion() {
    (1..3).asFlow()
        .onEach { check(it!=2) }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed with exception $cause")
            } else {
                println("Flow completed successfully")
            }
        }
        .catch { e -> println("caught expection $e") }

        .collect { println("$it") }
}

suspend fun catch() {
    (1..3).asFlow()
        .onEach { check(it!=2)
            }
        .catch { e -> println("caught expection $e")}
        .collect { println("$it") }
}

suspend fun tryCatch() {
try {
    (1..3).asFlow()
        .onEach { check(it!=2) }
        .collect { println(it) }
} catch (e: Exception) {
    println("Caught exception :$e")
}
}
