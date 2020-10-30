import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Receiving prime numbers")
        sendPrimes().collect {
            println("Received prime number: $it")
        }
        println("Finished receiving prime numbers")
    }
}

fun sendPrimes(): Flow<Int> = flow {
    val listOfPrimNumbers = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    listOfPrimNumbers.forEach {
        kotlinx.coroutines.delay(it * 100L)
        emit(it)
    }
}
