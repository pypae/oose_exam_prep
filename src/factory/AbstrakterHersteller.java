package factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt im UML-Klassendiagramm "Creator" dar, von der konkrete
 * Klassen abgeleitet werden, die auch instanziiert werden koennen.
 */
public abstract class AbstrakterHersteller {
	protected List<AbstraktesFahrzeug> fahrzeuge =
		new ArrayList<AbstraktesFahrzeug>();
	
	/**
	 * Delegiert die Instanziierung der konkreten Fahrzeuge an
	 * implementierende Unterklassen
	 *
	 */
	public AbstrakterHersteller() {
		this.erzeugeFahrzeuge();
	}

	public List<AbstraktesFahrzeug> getFahrzeuge() {
		return fahrzeuge;
	}

	/**
	 * Muss von einer Methode �berschrieben werden, die konkrete
	 * Fahrzeuge instanziiert. Dies ist das Herzst�ck des Factory
	 * Method Patterns
	 *
	 */
	protected abstract void erzeugeFahrzeuge();
}