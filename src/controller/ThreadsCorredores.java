package controller;

import java.util.concurrent.Semaphore; 

public class ThreadsCorredores extends Thread {
	private int corredor;
	private Semaphore semaforo;
	
	public ThreadsCorredores(int corredor, Semaphore semaforo) {
		this.corredor = corredor;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run(){
		Corrida();
		try {
			semaforo.acquire();
			PassarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void Corrida() {
		int percurso = 200000;
		int totalPercorrido = 0;
		int velocidade = (int)((Math.random()*2)+4);
		int tempo = 100;
		int aceleracao = velocidade * tempo;
		while(totalPercorrido < percurso){
			totalPercorrido += aceleracao;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int ajusteMetros = totalPercorrido / 1000;
			System.out.println("Corredor #" + corredor + " percorreu " + ajusteMetros + "m");
			if(ajusteMetros >= 200){
				System.out.println("Corredor #" + corredor + " chegou na porta");
			}
		}		
	}

	private void PassarPorta() {
		int tempo = (int)((Math.random()*1001)+1000);
		System.out.println("Corredor #" + corredor + " está passando pela porta");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Corredor #" + corredor + " passou pela porta");
	}
}
