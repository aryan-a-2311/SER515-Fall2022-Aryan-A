package ptbs;

public class ProductIterator implements ListIterator{

    ClassProductList listOfProducts;
    int index = 0;
    @Override
    public boolean hasNext() {
        if(index < listOfProducts.size())
            return true;

        else
            return false;
    }

    @Override
    public Object Next() {
        if(this.hasNext()){
            return listOfProducts.get(index++);
        }
        return null;
    }

    @Override
    public void MoveToHead() {
        System.out.println("Moved to Head");
        return;
    }

    @Override
    public void Remove() {
        System.out.println("Removed the product");
    }
}
