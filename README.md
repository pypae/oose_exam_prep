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
Die Voraussetzung für dynamische Bindung ist, dass der dynamische Typ ein Subtyp des statischen Types ist. Dies gilt jedoch nur für static typed languages.
Voraussetzung für dynamische Bindung ist die Möglichkeit Objekte zu erzeugen und Vererbung handzuhaben.

__2. Diskutieren sie die Vor- und Nachteile von mehrfacher Vererbung. Welche Alternativen gibt es zu mehrfacher Vererbung?__
*Aus Prüfungsvorbereitung 2018*


Vorteile:
- Faktoriesierung (gibt jedoch bessere Möglichkeiten)
- Wiederverwendung der Funktionalitäten der Basisklasse ohne Einhaltung des Interfaces
- Code sharing

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

In Java sind Arrays Kovariant, das heisst die Zuweisung von String Arrays zu Object Arrays wie im untenstehenden Snippet ist erlaubt:

```java
Object[] foo = new String[2];
```

Das heisst aber nicht, dass `String[]` ein Subtyp von `Object[]` ist.

```java
cls = String[].class.getSuperclass(); // java.lang.Object
```
Somit ist es eine Subklasse, aber kein Subtyp?

```java
// Das klappt komischerweise..
Object[].class.isAssignableFrom(String[].class); // true
new String[0] instanceof Object[]; //true
```

Ein Problem entsteht, wenn im ersten Beispiel versucht wird ein Object zum String Array hinzufügen:

```java
Object[] foo = new String[2];
foo[0] = new Object(); // ArrayStoreException at runtime
```

Das Gegenprinzip heisst Kontravarianz; In einer überschriebenen Methode wird ein Parameter offener deklariert.
__4. Erklären Sie die SOLID Prinzipien.__
*Aus Prüfungsprotokoll 2016*

- **S**ingle Resoponsibility Prinzip
  - Da je grösser der Implementationsumfang einer Klasser, desto höher die Wahrscheinlichkeit, dass sie angepasst werden muss. Diese Änderungen können ungewollte Side-Effects haben.
  - Änderung an einer Klasse sollten genau eine einzige Absicht haben.
  - Führt zu hoher Kohäsion (Klasse in sich ist geschlossen)
  - Falls Klasse nicht in kleinere Teile aufgebrochen werden kann: ISP
- **O**pen Closed Prinzip
  - Jede Implementationseinheit kann erweitert werden (open), ohne sie zu verändern (closed). 
  - Dadurch kann die Implementation an einen neuen Kontext angepasst werden.
  - Zugang zum Quellcode ist für die Anpassung nicht nötig.
  - Zur Umsetzung des OCP ist Abstraktion zwingend nötig.
- **L**iskov Substitution Prinzip
  - Subtypen müssen mindesrtens alle Methoden des Basistypen implementieren.
  - Preconditions dürfen nicht enger/genauer definiert werden.
  - Postconditions dürfen nicht offener definiert werden. (Postcondition == return values)
  - Exceptions dürfen nur geworfen werden, wenn sie von einer Exception erben, die in der Basis Implementation geworfen wird.
  - Werden die obigen Punkte eingehalten, können Subklassen ohne Veränderung verwendet werden.
  - Kovarianz als Gegenbeispiel
- **I**nterface Segregation Prinzip
  - Anwender sollten keine Abhängigkeiten zu unbenutzten Interfaces haben
  - Daher Interfaces klein und Client-Spezifisch halten.
- **D**ependency Inversion Prinzip
  - Abstraktionen sollten nicht von konkreten Implementationen abhängen.
  - Änderungen in low-level (spezifischen) Strukturen sollten keine Auswirkungen auf high-level (allgemeine) Strukturen haben.
  - Low-level Strukturen sollten austauschbar sein.

__5.  * Was ist Dependency Injection? Welches Problem wird durch Dependency Injection gelöst und wie wird es gelöst?__
*Aus Prüfungsprotokoll 2016*


Dependency Injection erlaubt die Spezifikation von Implementationen und deren Dependencies (Abhängigkeiten). 
Dabei werden die Abhängigkeiten via Konstruktor, Setter oder ein Interface "injected".

Dependency Injection löst das Problem der Konfiguration von Abhängigkeiten. 
Für die Produktionsumgebung und die Testumgbung wird beipielsweise ein anderer Logger benötigt. 
Ein spezifischer Logger kann je nach Kontext für alle Klassen die ihn benötigen bereitgestellt werden.
Gute Dependency Injection Frameworks erlauben auch die Anzahl Instanzen der Dependencies (bspw. Logger) zu bestimmen. 
(Eine pro Request, per Session etc.)


__6. Welches sind die Nachteile der Instanzerzeugung durch Konstruktoraufruf?  Welches die Vorteile? Welche Alternativen (abstrahierte Konstruktorenaufrufe) gibt es?__
*Aus Prüfungsprotokoll 2016*

Vorteile: 
- Einfache Implementierung für kleine Anzahl Instanz-Variablen (0-2)
- Default Konstruktor
- Kann in Subklasse einfach überschrieben werden.

Nachteile:
- Kann in Subklasse überschrieben werden, ohne Aufruf von Superkonstruktor. 
- Jeder Konstruktor-Aufruf erstellt immer ein Objekt (vs Singleton/Factory)
- Wird unübersichtlich für mehrere Parameter
- Default parameter sind nicht ersichtlich (vs Builder)

Alternativen:
- Factory Method
  - Eine/Mehrere statische Methoden, die ein Objekt der Klasse zurück geben.
  - Vorteile: Deskriptiver Name, Überschreibung kann verhindert werden, Kann Subtyp zurückgeben.
- Builder Pattern + (Fluent API)
  - Viel flexibler und expressiver
  - Default Instanzvariablen können ersichtlich gemacht werden
  - Hinzufügen von neuen optionalen Parametern ist einfach
  - Validierung der Objektkonstruktion
  - Nachteil: Verbose Implementation

__7. Was bedeutet Faktorisierung? Wie kann Faktorisierung erreicht werden (2 Beispiele)? Wie hängt Faktorisierung zusammen mit Softwaremaintenance?__
*Aus Prüfungsprotokoll 2015*

Faktorisierung: Jeder "Fakt" (Interfaces, Klassen, Methoden, Codesnippet) kommt genau einmal vor. (DRY - Don't Repeat Yourself)

- Kann beispielsweise durch Abstrakte Klassen oder Interfaces mit default Methoden erreicht werden. 
Diese implementieren gemeinsame Funktionalität der Subklassen an einem Ort.

- Template Methoden können wiederholten Code reduzieren.

Zusammenhang mit Software Maintenance:
Wenn jede bestimmte Funktionalität nur an einem Ort implementiert ist, kann diese leicht angepasst werden. 
Alle Teile des Systems, welche diese Funktionalität benötigen, können gleich weiter verwendet werden.
Falls gleiche Funktionalität an mehreren Orten implementiert ist, muss eine Änderung an all diesen Orten durchgeführt werden,
was die Wartung eines solchen Systems erschwert.
 
__8. Erkläre das Principle of Substitutability in Relation zu den Begriffen Subclass und Subtype.__
*Aus Prüfungsprotokoll 2015*

Principle of Sustitutability = LSK

Eine Subklasse ist eine Klasse welches vom einer Basisklasse eerbt.
Eine Subklasse ist nur ein Subtyp, wenn es das LSK einhält.

LSK:
- Subtypen müssen mindesrtens alle Methoden des Basistypen implementieren.
- Preconditions dürfen nicht enger/genauer definiert werden.
- Postconditions dürfen nicht offener definiert werden.
- Exceptions dürfen nur geworfen werden, wenn sie von einer Exception erben, die in der Basis Implementation geworfen wird.

Subtypen müssen das LSK einhalten:
- Dadurch wird Polymorphismus ermöglicht
- TODO

Subklassen können das Prinzip verletzen:
- Verletzung durch Erweiterung des Protokols
- Implementation-Inheritance für reines Code-Sharing
- Muss sich nicht an Signatur und Conditions der Superklasse halten.
- Sollte meist durch Komposition anstatt Vererbung ersetzt werden.

__9. PECS, was bedeutet dieses Akronym? Erläutere anhand von Codebeispielen (Java Code) die Problematik und zeige die Lösung auf.__
*Aus Prüfungsprotokoll 2015*

PECS: producer extend, consumer super.

TODO: add link ti image of table s52.

Problematik erklärt anhand eines generischen Stacks des Typen `T`:

```java
class Stack<T>{
    //...
    public pop(T item){
        
    }
    
    public void push(T item){
        
    }
}
```

Verwendung (angenommen Integer erbt von Number und Number erbt von Object):
```java
Stack<Number> numberStack = new Stack<Number>;
Number myNumber = new Number(1);
numberStack.push(myNumber); // OK
numberStack.push(new Integer(1)); // fails

Object alsoMyNumber = myNumber;
numberStack.pop(myNumber) // OK
numberStack.pop(alsoMyNumber) // fails
```
Fix dafür "producer" `push` extends, "consumer" `pop` super:
```java
class Stack<T>{
    //...
    public void pop(? super T item){
        
    }
    
    public void push(? extends T item){
        
    }
}
```

__10. Wie könnte man SWITCH Anweisungen mit einem Objekt-orientierten Ansatz ersetzten?__
*Aus Prüfungsprotokoll 2013*

Mithilfe des [Strategy Patterns](src/strategy)
- Das Strategy Pattern definiert eine Familie an Algorithmen. 
Jeder zu dieser Familie gehörende Algorithmus wird einzeln Implementiert. 
Dieses Pattern macht die verschiedenen Algorithmen einfach austauschbar ohne eine Änderung des Clients zu verlangen.


__11. Erkläre Stub__
*Aus Prüfungsprotokoll 2017*

### Gemeinsamkeiten Stub und Mocks
- Beide imitieren das Verhalten einer realen Klasse im Rahmen von Testing
- Retournieren vorgefertigte, statische Antworten --> nur benötigte 'Component under Test'
### Unterschiede Stub und Mocks
#### Stubs
- Verifizierung der Tests mit Hilfe des States.
  - Nur finaler State wird betrachtet
  - Möglicherweise zusätzliche Methoden zum State access benötigt.
- Ein Stub kann anstatt einer tatsächlichen Abhängigkeit verwendet werden wenn:
  - Viele Kontextabhängigkeiten bestehen
  - Die echte Klasse langsam ist (z.B. bei Datenbankzugriffen)
  - Der state der Klasse nicht zugänglich ist. (Anstatt reflection)
- Stubs sind robuster als Mocks.  
 #### Mocks
 - Verifizierung der Tests mit Hilfe des Verhaltens.
  - Interaktion mit Komponenten wird aufgezeichnet 
 - Gibt vorgefertigte Antworten für Anfragen zurück. (Nur soweit vom Compintent under Test benötigt.)
 - Wird immer anstatt einer tatsächlichen Abhängigkeit verwendet.

__12. Erläutern Sie das Law of Demeter.__
*Hinzugefügt von Patrick*

Das Law of Demeter ist eine anzahl an Faustregeln, um lose Kopplung sicherzustellen.

- Eine Methode m eines Objektes o sollte nur Methoden eines der folgenden Objekte aufrufen:
  - o selbst
  - m’s Parameter
  - Alle in m erzeugten Objekte
  - o’s direkten Komponenten
  - Globale variablen
- Objekte, die von Methoden zurückgegeben werden, sollten vermieden werden.
  - Bspw. getters
- Keine Ketten an . verwenden (in Java)
  - Bspw. currentShipment.getItems()[0].getManufacturer().getAddress().getEmail()
  - Ausnahme: FluentApi
  
 __13. Vergleichen Sie Inheritance und Compositions miteinander.__
 *Hinzugefügt von William und Andy*
 Inheritance:
 - Protokol wird erweitert (Restriktionen sind nicht erlaubt --> Widerspricht der Suptypisierung)
 - Subtyping (is-a-relationship)
 - Protokol der Basisklass und der SUbklass sind sehr ähnlich
 
 Komposition:
 - Geringe übereinstimmung zwischen Basisklasse und Subklasse. --> Basisklasse ist nur ein kleiner Bestandteil der Subklasse
 - Komposition ist einne has-a-relationship
 - Implementierung ist austauschbar

## Design Patterns
Die praktischen Aufgaben sind in Module aufgeteilt und nach Pattern sortiert.
- __[Singleton](src/singleton)__
- __[Factory](src/factory)__
- __[Abstract Factory](src/abstractfactory)__
- __[Builder](src/builder)__
- __[Adapter](src/adapter)__
- __[Bridge](src/bridge)__
- __[Decorator](src/decorator)__
- __[Observer](src/observer)__


- __[Composite](src/composite)__
- __[Strategy](src/strategy)__





