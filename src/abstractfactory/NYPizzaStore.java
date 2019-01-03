package abstractfactory;

import abstractfactory.pizza.NYStyleCheesePizza;
import abstractfactory.pizza.NYStylePepperoniPizza;
import abstractfactory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return  new NYStyleCheesePizza();
        } else if (item.equals("pepperoni")) {
            return  new NYStylePepperoniPizza();
        }
        else return null;
    }
}
