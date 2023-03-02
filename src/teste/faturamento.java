package teste;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class faturamento {

	public static void main(String[] args) {
		// Lê os dados do arquivo JSON
		JSONParser parser = new JSONParser();
		JSONArray faturamento;
		try {
			faturamento = (JSONArray) parser.parse(new FileReader("dados.json"));
		} catch (IOException | ParseException e) {
			System.err.println("Erro ao ler o arquivo de dados.");
			return;
		}

		// Calcula o menor e o maior faturamento diário
		double menor = Double.MAX_VALUE;
		double maior = Double.MIN_VALUE;
		for (Object o : faturamento) {
			double valor = (double) o;
			if (valor < menor) {
				menor = valor;
			}
			if (valor > maior) {
				maior = valor;
			}
		}
		System.out.printf("Menor faturamento diário: R$ %.2f\n", menor);
		System.out.printf("Maior faturamento diário: R$ %.2f\n", maior);

		// Calcula a média mensal de faturamento (ignorando dias sem faturamento)
		int numDiasComFaturamento = 0;
		double somaFaturamento = 0;
		for (Object o : faturamento) {
			double valor = (double) o;
			if (valor > 0) {
				numDiasComFaturamento++;
				somaFaturamento += valor;
			}
		}
		double mediaMensal = somaFaturamento / numDiasComFaturamento;

		// Conta o número de dias com faturamento acima da média mensal
		int numDiasAcimaDaMedia = 0;
		for (Object o : faturamento) {
			double valor = (double) o;
			if (valor > mediaMensal) {
				numDiasAcimaDaMedia++;
			}
		}
		System.out.printf("Número de dias com faturamento acima da média mensal: %d\n", numDiasAcimaDaMedia);
	}

}
