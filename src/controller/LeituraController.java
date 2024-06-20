package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraController {

	public void lerArquivo(String arq) throws IOException {
		
		String os = System.getProperty("os.name");
		String caminho ="";
		
		if(os.contains("Windows")) {
			caminho = "C:\\Windows\\Temp";
		}else if(os.contains("Linux")){
			caminho = "/tmp/";
		}
		File file = new File(caminho, "trades.json");

		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {

				String[] info = linha.split("\"");
				if (info[0].trim().equals("[") || info[0].trim().equals("]") || info[0].trim().equals("},")
						|| info[0].trim().equals("{") || info.length <= 3) {
				} else {
					if (info[3].equals(arq)) {
 						System.out.println("market: " + info[3]);
					}else if(info[1].equals("funds")) {
						System.out.println("funds: "+ info[3]);
					}else if(info[1].equals("created_at")) {
						System.out.println("created_at: "+ info[3]+"\n");
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
	}
}
