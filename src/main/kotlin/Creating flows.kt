import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        /*flowOf().collect {
            println("Received $it")
        }*/
        val numbers = sendNumbers()
        println("Flow has not started yet")
        numbers.collect {
            println("Received $it")
        }
    }
}

private fun sendNumbers() = flow {
    for(i in 1..10) {
        println("emitting $i")
        emit(i)
    }
}

fun asFlow() = listOf(1, 2, 3).asFlow()

fun flowOf() = flowOf(1,2, 3, 4, 5, 6, 7)