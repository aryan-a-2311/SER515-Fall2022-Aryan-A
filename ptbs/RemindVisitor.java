package ptbs;

public class RemindVisitor extends NodeVisitor{
    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("\n\n(visitProduct visiting the Product: " + product.name + ")");
        for(int i=0; i<product.allTradings.size(); i++)
        {
            //Visiting all trades in a product
            product.allTradings.get(i).accept(this);
        }
        return;
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("\n(visitTrading visiting the Trade Number " + trading.tradeNumber + " of product " + trading.productBeingTraded.name +")");
        System.out.println("\nREMINDER FOR UPCOMING TRADING WINDOW ON TRADE " + trading.tradeNumber + " OF PRODUCT " + trading.productBeingTraded.name.toUpperCase());
        return;
    }

    @Override
    public void visitFacade(Facade facade) {
        //Iterator Implementation
        System.out.println("\nvisitFacade visiting the following products: ");
        ProductIterator iterator = new ProductIterator();
        iterator.listOfProducts = facade.theProductList;
        for(;iterator.hasNext();) {
            System.out.println(iterator.Next());
        }
        //Visiting the list of products
        facade.theProductList.accept(this);
        return;
    }
}
