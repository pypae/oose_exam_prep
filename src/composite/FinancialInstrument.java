package composite;

import java.util.Random;

// Leaf
public class FinancialInstrument implements PricedComponent {
    public int getPrice(){
        return new Random().nextInt(10);
    }
}