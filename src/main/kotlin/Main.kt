import data.PurchasesCounter
import extensions.createErrorResponse
import extensions.createSuccessResponse
import extensions.doAction
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import service.BookService

fun main(args: Array<String>) = runBlocking {

    println("-----Книжный магазин-----")
    val bookService = BookService.create()
    var purchasesCounter = PurchasesCounter(0, listOf())
    do {
        println(
            """
                1 - Вывести список всех книг
                2 - Вывести список книг одного автора
                3 - Вывести список книг одно издательства
                4 - Вывести список книг одного жанра
                5 - Купить книгу
                6 - Вывести список купленных книг
                7 - Вывести аннотации к книгам
                0 - Выход
            """.trimIndent()
        )
        val answer: Int = readIntFromConsole()
        when (answer) {
            1 -> {
                bookService.printAllBooks()
            }
            2 -> {
                println("Введите id автора")
                val authorId = readIntFromConsole()
                bookService.printBookByAuthorId(authorId)
            }
            3 -> {
                println("Введите id издательства")
                val publisherId = readIntFromConsole()
                bookService.printBooksByPublisherId(publisherId)
            }
            4 -> {
                println("Введите id жанра")
                val genreId = readIntFromConsole()
                bookService.printBooksByGenreId(genreId)
            }
            5 -> {
                println("Введите id книги")
                val bookId = readIntFromConsole()
                val (book, response) = bookService.buyBook(bookId)
                when(response){
                    is Response.Success -> {
                        book?.doAction { println("Стоимость книги ${book.price}") }
                        book?.doAction { purchasesCounter += PurchasesCounter(1, listOf(book.name))}
                        println(response.message.createSuccessResponse())
                    }
                    is Response.Error -> println(response.message.createErrorResponse())
                }
            }
            6 -> println(purchasesCounter)
            7 ->{
                println("Введите id книги")
                val bookId = readIntFromConsole()
                bookService.printBooksAnnotation(bookId)
            }
            0 -> println("Завершение программы")
            else -> println("Некорректный номер действия")
        }
        println("---------------------")

    } while (answer != 0)
}
