package Behavioural.Visitor


interface ShoppingCartVisitor {
    fun visit(book: BookVisitor) : Int
    fun visit(fruitVisitor: FruitVisitor): Int
}