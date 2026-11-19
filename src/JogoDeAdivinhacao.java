import java.util.Scanner;

public class JogoDeAdivinhacao{
    public static void main(String[] args){
        int max = 100;
        int min = 1;

        int palpite = (max + min) / 2;

        Scanner sc = new Scanner(System.in);


        String resposta = "bka";
        while (!resposta.equals("A")){

            System.out.println("--JOGO DE ADIVINHACOES,DEIXE-ME ACERTAR O NUMERO DA SUA MENTE--");
            System.out.println("MA-para Maior");
            System.out.println("ME-para menor");
            System.out.println("A-para acertou");
            System.out.printf("O SEU NUMERO É %d?",palpite);
             resposta = sc.nextLine();

         if (resposta.equals("MA")){
             min = palpite + 1;
             palpite = (min + max) / 2;
         }
         if (resposta.equals("ME")){
             max = palpite - 1;
         }
            palpite = (max + min) / 2;
         if (resposta.equals("A")){
             break;
         }

        }
        System.out.println("**EU SOU O GENIO DAS ADIVINHACOES**");



    }



}
