package factory;

/**
 * Stellt im UML-Klassendiagramm "ConcreteCreator" dar, die die
 * konkreten Klassen (ConcreteProduct) instanziiert.
 */
public class Volkswagen extends AbstrakterHersteller {
	/**
	 * Implementiert die abstrakte Methode aus der Oberklasse
	 * und erzeugt konkrete Fahrzeugobjekte
	 */
	protected void erzeugeFahrzeuge() {
		fahrzeuge.add(new Passat(147));
		fahrzeuge.add(new Touareg(331));
	}
}