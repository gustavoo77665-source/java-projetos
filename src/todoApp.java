import java.util.Scanner;
import java.util.ArrayList;

public class todoApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean exit = false;

        ArrayList<String> tarefas = new ArrayList<>();

        while(exit == false){
         System.out.println("oque você deseja fazer?");

         System.out.println("1-adicionar tarefa");
         System.out.println("2-ver tarefas");
         System.out.println("3-sair");

         String resposta = sc.nextLine();

         if (resposta.equals("1") || resposta.equals("1-adicionar tarefa")){
           System.out.println("Qual tarefa deseja adicionar?");
           String adicionar = sc.nextLine();
           tarefas.add(adicionar);
         }
         else if (resposta.equals("2") || resposta.equals("2-ver tarefas")){
             System.out.println(tarefas);
         } else if (resposta.equals("3") || resposta.equals("3-sair")) {
             exit = true;
         }
        }
        System.out.println("finalizado com sucesso,tenha um otimo dia!");
    }
}
