package abstractfactory;

import abstractfactory.pizza.ChicagoStyleCheesePizza;
import abstractfactory.pizza.ChicagoStylePepperoniPizza;
import abstractfactory.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else return null;
    }
}
