import composite.FinancialInstrument;
import composite.Portfolio;
import composite.PricedComponent;
import singleton.FileLogger;
import singleton.Service;
import strategy.Panel;
import strategy.RedBackground;
import strategy.YellowBackground;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test_covariance();
        test_composite();
        test_strategy();
        test_singleton();
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


}
