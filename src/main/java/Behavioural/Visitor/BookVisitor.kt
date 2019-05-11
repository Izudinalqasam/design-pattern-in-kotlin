package Behavioural.Visitor

data class BookVisitor(
        var cost: Int,
        var isbn: String
) : ItemElement {

    override fun accept(visitor: ShoppingCartVisitor) = visitor.visit(this)
}