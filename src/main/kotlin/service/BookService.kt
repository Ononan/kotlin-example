package service

import Factory
import Response
import Warehouse
import data.Book
import extensions.filterBookInStock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class BookService private constructor(private val bookArray: MutableMap<Book, Int>) {


    companion object BookServiceFactory : Factory<BookService> {
        override fun create(): BookService {
            return BookService(Warehouse.bookArray)
        }
    }

    fun printAllBooks() {
        bookArray.asSequence()
            .filterBookInStock()
            .forEach { println(it) }
    }

    fun printBookByAuthorId(authorId: Int) {
        val book = bookArray.asSequence()
            .filterBookInStock()
            .find { it.key.author.id == authorId }
            ?.key
        println(book)
    }

    fun printBooksByPublisherId(publisherId: Int) {
        val book = bookArray.asSequence()
            .filterBookInStock()
            .find { it.key.publishingHouse.id == publisherId }
            ?.key
        println(book)
    }

    fun printBooksByGenreId(genreId: Int) {
        val book = bookArray.asSequence()
            .filterBookInStock()
            .find { it.key.bookGenre.id == genreId }
            ?.key
        println(book)
    }

    fun buyBook(bookId: Int): Pair<Book?, Response> {
        val book = bookArray.asSequence()
            .filterBookInStock()
            .find { it.key.id == bookId }
        return when (book) {
            null -> null to Response.Error("Книга с переданным id: $bookId не найдена")
            else -> {
                bookArray[book.key] = book.value - 1
                book.key to Response.Success("Книга \"${book.key}\" куплена")
            }
        }
    }

    suspend fun printBooksAnnotation(bookId: Int) {
        val book = bookArray.asSequence()
            .filterBookInStock()
            .find { it.key.id == bookId }
            ?.key ?: return

        withContext(Dispatchers.IO) {
            val text = File(book.annotationFileName).readText(Charsets.UTF_8)
            println(text)
        }


    }
}