package data

data class PurchasesCounter(val numberOfPurchases: Int, val bookNames: List<String>) {
    operator fun plus(other: PurchasesCounter): PurchasesCounter {
        return PurchasesCounter(numberOfPurchases + other.numberOfPurchases, bookNames + other.bookNames)
    }
}
