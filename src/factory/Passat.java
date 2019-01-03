package factory;

/**
 * Stellt im UML-Klassendiagramm "ConcreteProduct" dar, die von
 * der Factory Methode instanziiert wird.
 */
public class Passat extends AbstraktesFahrzeug {
	public Passat(int kw) {
		super("Volkswagen", "Passat", kw);
	}
}