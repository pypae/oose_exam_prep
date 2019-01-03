import abstractfactory.ChicagoPizzaStore;
import abstractfactory.NYPizzaStore;
import abstractfactory.PizzaStore;
import abstractfactory.pizza.Pizza;
import adapter.PeekIterator;
import adapter.Peekerator;
import bridge.*;
import builder.Person;
import composite.FinancialInstrument;
import composite.Portfolio;
import composite.PricedComponent;
import factory.AbstrakterHersteller;
import factory.AbstraktesFahrzeug;
import factory.BMW;
import factory.Volkswagen;
import singleton.FileLogger;
import singleton.Service;
import strategy.Panel;
import strategy.RedBackground;
import strategy.YellowBackground;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        test_covariance();
        test_composite();
        test_strategy();
        test_singleton();
        test_adapter();
        test_abstract_factory();
        test_factory();
        test_bridge();
        test_builder();
    }

    private static void test_adapter() {
//        List<Integer> myList = new ArrayList<>() {{
//            add(1);
//            add(2);
//            add(3);
//        }};
//
//        ListIterator<Integer> iterator = myList.listIterator();
//        Peekerator<Integer> peekerator = new PeekIterator<Integer>(iterator);
//
//        System.out.println(peekerator.peek()); // 1
//        System.out.println(iterator.next()); // 1
//        System.out.println(peekerator.peek()); // 2
    }

    private static void test_covariance(){
        System.out.println(Object[].class.isAssignableFrom(String[].class));
        System.out.println(new String[0] instanceof Object[]);
        System.out.println(String[].class.getSuperclass());
    }

    private static void test_singleton(){
        Service myService = new Service();
        FileLogger l1 = myService.do_something_and_log();
        FileLogger l2 = myService.do_something_else_and_log();
        System.out.println(l1.equals(l2));
    }

    private static void test_composite(){
        PricedComponent myInstrument = new FinancialInstrument();
        System.out.println(myInstrument.getPrice());

        Portfolio myPortfolio = new Portfolio(new ArrayList<PricedComponent>());

        for (int i=0; i < 10; i++) {
            myPortfolio.addInstrument(new FinancialInstrument());
        }

        System.out.println(myPortfolio.getPrice());
    }

    private static void test_strategy(){
        Panel myPanel = new Panel();

        myPanel.setDrawingStrategy(new RedBackground());
        myPanel.drawBackground();

        myPanel.setDrawingStrategy(new YellowBackground());
        myPanel.drawBackground();
    }

    private static void test_abstract_factory(){
        PizzaStore testStore = new NYPizzaStore();
        Pizza pizza = testStore.orderPizza("cheese");
        System.out.println("Ethan from New York ordered a " + pizza.getName() + "\n");

        testStore = new ChicagoPizzaStore();
        pizza = testStore.orderPizza("cheese");
        System.out.println("Joel from Texas ordered a " + pizza.getName() + "\n");
    }

    private static void test_factory(){
        /*
         * Hersteller Volkswagen und BMW instanziieren
         */
        AbstrakterHersteller vw = new Volkswagen();
        AbstrakterHersteller bmw = new BMW();

        /*
         * Ausgabe der Fahrzeuge eines jeden Herstellers
         */
        for (AbstraktesFahrzeug fahrzeug : vw.getFahrzeuge()) {
            System.out.println(
                    fahrzeug.getHersteller() + " " +
                            fahrzeug.getModell() + ", " +
                            fahrzeug.getKw() + " KW");
        }

        for (AbstraktesFahrzeug fahrzeug : bmw.getFahrzeuge()) {
            System.out.println(
                    fahrzeug.getHersteller() + " " +
                            fahrzeug.getModell() + ", " +
                            fahrzeug.getKw() + " KW");
        }
    }

    private static void test_bridge(){
        System.out.println();
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }

    private static void test_builder(){
        Person person = new Person.Builder("Ada", "Lovelace", Person.Sex.FEMALE)
                .profession("mathematician")
                .birthday(LocalDate.of(1815, 12, 10))
                .build();

        System.out.println(person.toString());
    }
}
