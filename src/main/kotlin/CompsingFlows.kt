import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        //zipComposing()
        combineComposing()
    }
}

suspend fun combineComposing() {
    val numbers = (1..5).asFlow()
        .onEach { delay(300L) }
    val values = flowOf("One", "Two", "Three", "Four", "Five")
    .onEach { delay(400L) }
    numbers.combine(values) { a, b -> "$a -> $b"}
        .collect { println("$it") }
}
suspend fun zipComposing() {
    val english = kotlinx.coroutines.flow.flowOf("One", "Two", "Three")
    val french = kotlinx.coroutines.flow.flowOf("Un", "Deux", "Triox")
    english.zip(french){
            a, b -> "$a in french is $b"
    }
        .collect { println("$it") }
}