package processi;

public class MainProcessi {

    public static void main(String[] args) throws InterruptedException {
//        creo classi ProcessoDerivato
//////        ProcessoDerivato p1 = new ProcessoDerivato();
//////        ProcessoDerivato p2 = new ProcessoDerivato();

//        per avviare il processo creo la classe Thread
//        la quale cre la classe ProcessoImplementato
        Thread p1 = new Thread(new ProcessoImplementato());
        Thread p2 = new Thread(new ProcessoImplementato());

//        avvio i processi
//        chiamo metodo start della classe Thread
//        output cambia ad ogni avvio
//        possono venire processi paralleli
//        oppure uno successivo all'altro
        p1.start();
//        mettendo uno sleep dopo aver lanciato il primo processo
//        il processo si interrompe quindi count si incrementa
//        stampa la somma dei processi eseguiti        
//////        try {
//////            Thread.sleep(100);
//////        } catch (InterruptedException ex) {
//////        }
        p2.start();

//        join blocca il main e attende che finiscano p1 e p2
//        mettendo il join il main riesce a mandare la stampa del count
        p1.join();
        p2.join();

//        stampo la variabile count di ProcessoImplementao
//        risulta 0 --> ci sono 3 thread : parte main, fa partire p1, si tiene la CPU
//        fa partire p2. I thread sono in parallelo quindi 
//        bypassano la stampa
        System.out.println("La somma è: " + ProcessoImplementato.count);
    }

}
