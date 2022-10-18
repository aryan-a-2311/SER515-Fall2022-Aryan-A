package ptbs;

public class RemindVisitor extends NodeVisitor{
    private Reminder m_Reminder;
    //Called by accept
    @Override
    public void visitProduct(Product product) {
        //Iterator Used
    }

    @Override
    public void visitTrading(Trading trading) {
    }
    //println
    @Override
    public void visitFacade(Facade facade) {

    }
}
