package ptbs;

public class Trading {
    Product productBeingTraded;
    int tradeNumber;

    Trading(Product prod, int tNo)
    {
        this.productBeingTraded = prod;
        this.tradeNumber = tNo;
    }
    public void accept(NodeVisitor visitor)
    {
        visitor.visitTrading(this);
    }
}
