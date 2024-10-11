package main;

import java.util.Scanner;

import manager.Controller;
import manager.MatchController;

public class Main {
	private static Controller controller;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(
				"Benveto su Punti e Quadrati!\n\nLo scopo del gioco è cercare di formare più quadrati possibili tracciando a turno\nuna linea tra due punti adiacenti. Ad ogni quadrato formato si guadagna un punto \ne, quando la griglia sarà riempita, il giocatore che avrà guadagnato più punti sarà il vincitore!\n\nSpecificare la modalità di gioco:\n-'1vsCP' se si vuole giocare contro il bot;\n-'CPvsCP' se si vuole far giocare due bot uno contro l'altro;\n-'1vs1' se si vuole giocare contro un altro giocatore reale;\n\nInserire la grandezza dei lati della griglia (un numero maggiore di 2).\n\nPer tracciare una linea occorre inserire le coordinate dei due punti\ncome da esempio:\nEsempio (0,1) (1,1)\nInserisci modalità:");
		scanGameMode();
		System.out.print("La partita ha inizio!\n" + controller.getGrid());
		while (!controller.finished()) {
			System.out.print("\nE' il turno di: " + controller.getCurrentTurn().getPlayer().getName() + "!\n");
			controller.nextTurn();
			System.out.print("\n" + controller.getGrid());
		}
		controller.getWinner();
	}

	private static void scanGameMode() {
		String line = input.nextLine();
		if (line.equals("1vsCP"))
			controller = MatchController.create1vsCPManager(scanGridSize(), scanName());
		else if (line.equals("CPvsCP"))
			controller = MatchController.createCPvsCPManager(scanGridSize());
		else if (line.equals("1vs1"))
			controller = MatchController.create1vs1Manager(scanGridSize(), scanName(), scanName());
		else {
			System.out.println("Modalità inesistente.\nInserisci modalità:");
			scanGameMode();
		}
	}

	private static int scanGridSize() {
		System.out.println("Inserisci la dimensione della griglia:");
		input = new Scanner(System.in);
		if (!input.hasNextInt()) {
			System.out.println("Deve essere un numero intero!");
			return scanGridSize();
		}
		int i = input.nextInt();
		if (i < 3) {
			System.out.println("La dimensione deve essere maggiore di 2!");
			return scanGridSize();
		} else
			return i;
	}

	private static String scanName() {
		System.out.println("Inserisci il nome del giocatore:");
		input = new Scanner(System.in);
		return input.nextLine();
	}
}