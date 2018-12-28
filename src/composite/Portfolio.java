package composite;

import java.util.List;

// Composite
public class Portfolio implements PricedComponent {
    private List<PricedComponent> priced_children;

    public Portfolio(List<PricedComponent> list){
        priced_children = list;
    }

    // Keep method name for compatibility, should be named addComponent
    public void addInstrument(PricedComponent fi) {
        priced_children.add(fi);
    }

    public void removeInstrument(int index) {
        priced_children.remove(index);
    }

    // Keep method name for compatibility, should be named getComponent
    public PricedComponent instrumentAt(int index) {
        return priced_children.get(index);
    }

    public int size() {
        return priced_children.size();
    }

    public int getPrice() {
        int price = 0;
        for (PricedComponent child : priced_children){
            price += child.getPrice();
        }
        return price;
    }

}