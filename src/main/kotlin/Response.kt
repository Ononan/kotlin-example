sealed class Response(val message: String){
    class Success(message: String): Response(message)
    class Error(message: String): Response(message)
}


