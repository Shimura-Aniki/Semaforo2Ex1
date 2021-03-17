package view;

import java.util.concurrent.Semaphore;
import controller.ThreadsCorredores;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int corredor = 1; corredor < 5; corredor++){
		ThreadsCorredores tCorredor = new ThreadsCorredores(corredor, semaforo);
		tCorredor.start();
		}
	}
}
