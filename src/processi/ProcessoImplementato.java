package processi;

//classe concreta
//implementa intefaccia Runnuble
public class ProcessoImplementato implements Runnable {
//    variabili e costanti globali

//    variabile statica 
    public static int count = 0;

//    metodo sincronizzato incrementa
    private static synchronized void incrementa() {

//        incrementiamo count
        count++;
    }

//    metodo run sovrascritto da Runnable
    @Override
    public void run() {

//        ciclo che da 0 a 9        
        for (int i = 0; i < 100; i++) {
//            stampa l'ID del processo e il valore
//            il metodo getID non posso chiamarlo dall'interfaccia
//            quindi devo chiamarla dalla classe Thread
//            con il metodo currentThread
            System.out.println("Processo " + Thread.currentThread().getId() + " " + i);

//            incrementiamo count
//            incrementando il count in questo modo è interrompibile 
//            la somma è probabile che venga sbagliata
//////            count++;

//            chiamo il metodo incrementa
//            chiamando il metodo sincronizzato il codice non è interrompibile
//            quindi riesce a contare tutti i processi anche alla max velocità
            incrementa();

//            rallentiamo il processo di un numero indicato di millisecondi
//            è interrompibile bisogna fare try catch
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
