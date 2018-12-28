## Theoriefragen
__1. Erklären sie die Begriffe “dynamische Bindung”, “statischer Typ” und “dynamischer Typ” und illustrieren sie diese mit einem Beispiel. Was ist die Voraussetzung für dynamische Bindung?__
*Aus Prüfungsvorbereitung 2018*

Beispiel:

```java
// statischer Typ          dynamischer Typ
//  |                            |
//  v                            v        
List<Object> myList = new ArrayList<Object>();
myList.add(1) // <--- Dynamische Bindung, add wird auf dem dynamischen Typen aufgerufen.
              //      Es wird also ArrayList.add() aufgerufen und nicht List.add()
```

Voraussetzung für dynamische Bindung ist die Möglichkeit Objekte zu erzeugen und Vererbung handzuhaben.

__2. Diskutieren sie die Vor- und Nachteile von mehrfacher Vererbung. Welche Alternativen gibt es zu mehrfacher Vererbung?__
*Aus Prüfungsvorbereitung 2018*


Vorteile:
?

Nachteile:
- Komplexe Programmiersprache benötigt (Semantik, Synatx)
- Komplexe Klassenhirarchien können entstehen
- Potential für Namesnkonflikte
- Wird oft anstelle von Komposition verwendet.

Alternativen:

Mixin Klassen
- Definieren Funktionalität, aber keinen Status.
  - > Kann in Java 8 mit Interfaces mit default methoden umgesetzt werden
- Subklassen erben von einer Basisklasse und 0..n Mixins

Komposition
- Has-A-Relationship statt Is-A-Relationship
- Viel flexibler, Klassen sind unabhängiger
- Implementation kann einfach ausgetauscht werden

__3. Java erlaubt die Zuweisung von String[] and Object[]. Ist String[] ein Subtyp von Object[]? Wie nennt man dieses Konzept? Zeige ein Beispiel, wo eine solche Zuweisung zu Problemen führen kann. Wie heisst das Gegenprinzip?__
*Aus Prüfungsprotokoll 2016*

TODO

__4. Erklären Sie die SOLID Prinzipien.__
*Aus Prüfungsprotokoll 2016*

TODO

__5. Was ist Dependency Injection? Welches Problem wird durch Dependency Injection gelöst und wie wird es gelöst?__
*Aus Prüfungsprotokoll 2016*

TODO

__6. Welches sind die Nachteile der Instanzerzeugung durch Konstruktoraufruf?  Welches die Vorteile? Welche Alternativen (abstrahierte Konstruktorenaufrufe) gibt es?__
*Aus Prüfungsprotokoll 2016*

TODO

__7. Was bedeutet Faktorisierung? Wie kann Faktorisierung erreicht werden (2 Beispiele)? Wie hängt Faktorisierung zusammen mit Softwaremaintenance?__
*Aus Prüfungsprotokoll 2015*

TODO

__8. Erkläre das Principle of Substitutability in Relation zu den Begriffen Subclass und Subtype.__
*Aus Prüfungsprotokoll 2015*

TODO

__9. PECS, was bedeutet dieses Akronym? Erläutere anhand von Codebeispielen (Java Code) die Problematik und zeige die Lösung auf.__
*Aus Prüfungsprotokoll 2015*

TODO

__10. Wie könnte man SWITCH Anweisungen mit einem Objekt-orientierten Ansatz ersetzten?__
*Aus Prüfungsprotokoll 2013*

TODO

__11. Erkläre Stub__
*Aus Prüfungsprotokoll 2017*

TODO

__12. Substitution Principle erklären & Verknüpfung zu Subtypen und Subklassen.__
*Aus Prüfungsprotokoll 2017*

TODO
Ref SOLID


