import data.Author
import data.Book
import data.BookGenre
import data.PublishingHouse

object Warehouse {
    val bookArray = mutableMapOf<Book,Int>(
        Book(
            1,
            "Test1",
            Author(1, "Test1", "Test1"),
            100.0,
            2,
            PublishingHouse(1, "Test1"),
            2000,
            BookGenre.CRIME,
            "annotation/annotation1.txt"
        ) to 3,
        Book(
            2,
            "Test2",
            Author(2, "Test2", "Test2"),
            200.0,
            3,
            PublishingHouse(2, "Test2"),
            2002,
            BookGenre.SCIENCE_FICTION,
            "annotation/annotation2.txt"
        ) to 5,
        Book(
            3,
            "Test2",
            Author(2, "Test2", "Test2"),
            200.0,
            3,
            PublishingHouse(2, "Test2"),
            2002,
            BookGenre.SCIENCE_FICTION,
            "annotation/annotation3.txt"
        ) to 0
    )
}