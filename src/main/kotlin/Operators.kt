import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        //mapOperator()
        //filterOperator()
        //transforOperator()
        //takeOperator()
        //reduceOperator()
        flowOnOperator()
    }
}

suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println("value is $it")
        }
}

suspend fun reduceOperator() {
    val size = 3
    val factorial = (1..size).asFlow()
        .reduce { accumulator, value ->
            accumulator*value
        }
    println("Factorial of $size is $factorial")
}
suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}
suspend fun mapOperator() {
    listOf(1, 2, 3, 4, 5, 10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }.collect {
            println("Received $it")
        }
}

suspend fun filterOperator() {
    (1..10).asFlow()
        .filter { it%2 == 0 }
        .collect { println("$it") }
}

suspend fun transforOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }
        .collect {
            println(it)
        }

}