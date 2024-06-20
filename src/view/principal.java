package view;

import java.io.IOException;
import java.util.Scanner;

import controller.LeituraController;

public class principal {

	public static void main(String[] args) throws IOException {

		LeituraController cont = new LeituraController();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira o nome do market:");
		String info = scan.nextLine();
			
		cont.lerArquivo(info);
//		cont.lerArquivo("btcusdt");
	}
}
