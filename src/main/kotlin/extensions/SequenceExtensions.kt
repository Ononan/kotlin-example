package extensions

import data.Book

fun Sequence<Map.Entry<Book,Int>>.filterBookInStock(): Sequence<Map.Entry<Book,Int>> = filter { it.value > 0 }