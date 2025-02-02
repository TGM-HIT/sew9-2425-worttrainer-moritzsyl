# sew9-2425-worttrainer-moritzsyl

## Worttrainer

---
Dieses Projekt implementiert einen Worttrainer, das bedeutet, dass
der Benutzer ein Bild angezeigt bekommt und das Wort dazu erraten muss.
Weiters gibt es die Möglichkeit den aktuellen Spielstand zu speichern und
später wieder zu laden.
---
## Projektstruktur
src/main/java/at.ac.tgm.msyllaba
* Main.java - Startklasse des Programms
* SaveLoad.java - Interface für Austauschbarkeit der Persistierungsart
* SaveLoadJSON.java - Implementierung des Interfaces mit JSON Persistierung
* TrainingPair.java - Klasse für ein Bild-Wort Paar
* Worttrainer.java - Klass für die Spiellogik und das Interface

src/main/resources

Hier werden die Spielstände von der SaveLoadJSON Klasse gespeichert.
* trainer.json - JSON File welches den Spielstand speichert

uml/
* .asta Datei - UML Diagramm des Projekts in AstahUML
* .jpg Datei - UML Diagramm des Projekts als Bild
---
## Anleitung
1. Starten Sie das Programm mit der Main Klasse.
2. Sie werden aufgefordert ein Spiel zu laden oder ein neues (default) zu starten
3. Spielen Sie! Geben sie das Wort zu dem Bild ein.
4. Ein Klick auf Abbrechen beendet das Spiel.
5. Abschließend werden Sie gefragt ob Sie den Spielstand speichern wollen.
