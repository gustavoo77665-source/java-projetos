package CRUDtarefasV2;
import java.util.Scanner;


public class main {
    public static void main(String[] args){
        tarefas sistema = new tarefas();

        Scanner sc = new Scanner(System.in);
        String resposta = "osk";

      while(!resposta.equals("5")) {
          System.out.println("---SISTEMA DE TAREFAS---");
          System.out.println("ᵐᵃᵈᵉ ᵇʸ ˡᵘⁱᶻ ᵍᵘˢᵗᵃᵛᵒ");
          System.out.println("1-CRIAR TAREFA");
          System.out.println("2-CHECAR TAREFAS");
          System.out.println("3-CONCLUIR TAREFA");
          System.out.println("4-DELETAR TAREFAS");
          System.out.println("5-SAIR");
          resposta = sc.nextLine();

          if (resposta.equals("1")){
              sistema.registrar();
          }
          if (resposta.equals("2")){
              sistema.verTarefas();
          }
          if (resposta.equals("3")){
              sistema.concluirTarefas();
          }
          if (resposta.equals("4")){
              sistema.deletar();
          }
          if(resposta.equals("5")){
              break;
          }
      }
        System.out.println("vlw por usar o sistema eu,fica com Deus eu!é noixx");
    }
}
;