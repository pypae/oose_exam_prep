__Verbessern sie das untenstehende Design bzw. die Implementierung. Welches Entwurfsmuster können sie dazu verwenden?__
*Aus Prüfungsvorbereitung 2018*

```java
public class composite.FinancialInstrument {
    private String fId;

    public void setId(String id) {
        this.fId = id
    }

    public String getId() {
        return this.fId
    }

    public BigDecimal getPrice() {
        //calculate price
    }
}

public class composite.Portfolio {
    private List<composite.FinancialInstrument> fInstruments;

    public void addInstrument(composite.FinancialInstrument fi) {
        // do stuff
    }

    public int size() {
        return fInstruments.size();
    }

    public composite.FinancialInstrument instrumentAt(int index) {
        // do stuff
    }
}

public class Pricer {
    public BigDecimal calculatePrice(Object instrument) {
        BigDecimal price = BigDecimal.valueOf(0);

        if (instrument instanceof composite.FinancialInstrument) {
            price = ((composite.FinancialInstrument)instrument).getPrice();
        } else if (instrument instanceof composite.Portfolio) {
            composite.Portfolio portfolio = (composite.Portfolio)instrument;
            for (int i = 0; i < portfolio.size(); i++) {
                price.add(portfolio.instrumentAt(i).getPrice());
            }
        }
        return price;
    }
}
```