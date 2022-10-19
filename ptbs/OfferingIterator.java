package ptbs;

public class OfferingIterator implements ListIterator{
    OfferingList listOfOfferings;
    int index = 0;
    @Override
    public boolean hasNext() {
        if(index < listOfOfferings.size())
            return true;

        else
            return false;
    }

    @Override
    public Object Next() {
        if(this.hasNext()){
            return listOfOfferings.get(index++);
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
