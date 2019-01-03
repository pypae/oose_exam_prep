package factory;

/**
 * Stellt im UML-Klassendiagramm "ConcreteProduct" dar, die von
 * der Factory Methode instanziiert wird.
 */
public class Touareg extends AbstraktesFahrzeug {
	public Touareg(int kw) {
		super("Volkswagen", "Touareg", kw);
	}
}