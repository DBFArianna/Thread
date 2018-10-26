package processi;

//classe concreta
//estende classe Thread
public class ProcessoDerivato extends Thread {
//    variabili e costanti gloabli

//    motdo run senza parametri
    public void run() {
//        ciclo che da 0 a 9
        for (int i = 0; i < 100; i++) {
//            stampa l'ID del processo e il valore
/*            ID --> numero univoco creato dalla classe Thread
                     rimane invariato durante tutto il processo
                     alla fine del processo l'ID può essere riutilizzato*/
            System.out.println("Processo " + getId() + " " + i);
//            rallentiamo il processo di un numero indicato di millisecondi
//            è interrompibile bisogna fare try catch
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
