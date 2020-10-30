
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbers = sendNumbers()
        println("Flow has not started yet")
        //Cold
        numbers.collect {
            println("Received $it")
        }

        //Cancellation
        withTimeoutOrNull(1000L) {
            numbers.collect {
                println("Received $it")
            }
        }
    }
}

private fun sendNumbers() = flow {
    for(i in 1..10) {
        kotlinx.coroutines.delay(400L)
        emit(i)
    }
}