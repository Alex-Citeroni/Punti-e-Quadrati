# Punti e Quadrati

## Relazione Programmazione Avanzata

**Alex Citeroni – Davide Perozzi – Pietro Angelici**

### Presentazione

Prima di iniziare a sviluppare il programma, abbiamo analizzato le specifiche del progetto e tutte le regole del gioco, pensando bene a come procedere per strutturare il tutto.

Per prima cosa abbiamo iniziato a creare la struttura del software tramite Gradle, per poi passare alla struttura di gioco (**structure**), formata dalla griglia (**Grid**), che è formata a sua volta da punti (**Dot**) e quadrati, dove ogni quadrato è composto da 4 linee ed ogni linea (**Line**) collega due punti della griglia.

Dopodiché ci siamo chiesti chi dovesse giocare, così abbiamo creato il giocatore (**player**), formato da giocatori controllati dal computer (**Bot**) e giocatori reali (**RealPlayer**), ognuno avente dei punti (**PlayerPoints**).

A questo punto c'era bisogno di dare una strategia (**strategy**) ai giocatori controllati dal computer, così l'abbiamo creata: **DumbStrategy**.

Per far sì che tutto funzionasse in modo adeguato, abbiamo pensato ad un manager, formato da un controllore (**Controller**) e da un **MatchController**.

Infine, abbiamo fatto un test per assicurarci che la creazione della griglia andasse a buon fine.

### Obiettivi

Il nostro obiettivo è creare un gioco funzionante che possa far divertire qualcuno e, nel frattempo, migliorare nella programmazione orientata agli oggetti e imparare a creare un software ben strutturato, che rispetti quindi i principi **S.O.L.I.D.**.

### Estensioni

Le future estensioni saranno:
- Un'interfaccia grafica
- La trasformazione dell'app in una Web App, così da offrire l'opportunità di giocarci in molti altri dispositivi (ad esempio Smartphone)
- Molte altre funzionalità che purtroppo non siamo riusciti ad implementare a causa di mancanza di tempo

### Architettura del Software

- **main**
  - Main
- **manager**
  - Controller
  - MatchController
- **player**
  - AbstractPlayer
  - Bot
  - Player
  - PlayerPoints
  - RealPlayer
- **strategy**
  - DumbStrategy
  - Strategy
- **structure**: pacchetto che comprende le classi che formano la struttura del gioco e hanno la responsabilità di sancire la struttura delle componenti usate durante le partite
  - **Dot**: classe pubblica che rappresenta la struttura di un punto che andrà poi a formare la griglia, formato da due interi rappresentanti le coordinate x e y
    - Presenta metodi *Getters* per avere i punti x e y e metodi *Getters* e *Setters* per sapere se sono presenti linee verticali o orizzontali
    - `boolean isAdjacent(dot)`: metodo che permette di verificare se 2 punti sono adiacenti
    - `void update(dot)`: metodo che permette di aggiornare le linee orizzontali e verticali
    - `boolean equals(object)`: metodo sovrascritto che permette di controllare se l'elemento è un'istanza di Dot
  - **Grid**: classe pubblica che ha la responsabilità di creare la matrice di gioco e di effettuare alcuni controlli, composta da un array bidimensionale di punti
    - Possiede diversi metodi *Getters* per `boxesCounter`, `grid` e `lines` e un metodo *Setters* per il `boxesCounter`
    - Diversi metodi per il controllo delle linee e per controllare se sono linee opposte parallele
    - `List<line> checkForBoxes(line)`: metodo che controlla se c'è un quadrato
    - `void addToGrid(line)`: aggiunge alla griglia le linee attraverso i punti
    - `boolean checkDot(dot)`: metodo che controlla la presenza di un punto
    - `int position(line)`: metodo che ritorna la posizione della linea nella griglia
    - `String toString()`: metodo sovrascritto che stampa la griglia
  - **Line**: classe pubblica che rappresenta l'unione di due punti adiacenti e non sovrapposti ed è formata appunto da due punti
    - Presenta metodi *Getters* per ottenere il punto 1 ed il punto 2 della linea ed un metodo *Setters* riguardante la linea
    - `boolean isVertical()`: permette di sapere se una linea è verticale o orizzontale
    - `boolean equals(object)`: metodo sovrascritto che permette di controllare se l'elemento è un'istanza di Line
- **structureTest**
  - `testGrid`: permette il test per la creazione della griglia

### Design Pattern e Struttura

- **MVC**
- **Factory Method**
- **Gradle**
- **Streams**
- **Thread**
- Metodi con massimo 15 righe
- Efficienza
- Test

### Responsabilità di Ogni Classe e Metodi Coerenti

Il design del software è basato sui principi **S.O.L.I.D.** per garantire la coerenza delle responsabilità delle classi e l'efficienza degli algoritmi.

### Algoritmi Più Complessi

Il progetto include algoritmi più complessi per gestire la logica di gioco e ottimizzare le prestazioni, garantendo al contempo una buona esperienza utente.

