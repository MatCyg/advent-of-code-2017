import io.reactivex.rxkotlin.toObservable


fun processStream(stream: String): Int {
    return process(stream)
}

internal fun process(stream:String): Int {
    stream.find { character ->
        listOf("{" , "}").toObservable()
                .window(3)
                .subscribe(
    }
}