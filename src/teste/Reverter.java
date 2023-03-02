package teste;

public class Reverter {

    public static void main(String[] args) {
        // Define a string a ser invertida
        String str = "Exemplo de string a ser invertida";
        
        // Converte a string em um array de caracteres
        char[] charArray = str.toCharArray();
        
        // Inverte os caracteres do array
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        
        // Converte o array de volta para a string
        String strInvertida = new String(charArray);
        
        // Imprime a string invertida
        System.out.println(strInvertida);
    }

}
