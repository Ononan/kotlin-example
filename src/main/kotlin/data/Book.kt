package data

data class Book(
    val id: Int,
    val name: String,
    val author: Author,
    val price: Double,
    val numberOfPages: Int,
    val publishingHouse: PublishingHouse,
    val year: Int,
    val bookGenre: BookGenre,
    val annotationFileName: String
)
