package CRUDtarefas;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/todos";
        String usuario = "usuario";
        String senha = "senha";
        String resposta = "osk";

        while(resposta != "5"){
            System.out.println("--SISTEMA DE TAREFAS--");
            System.out.println("OQUE VOCE GOSTARIA DE FAZER?");
            System.out.println("1-CRIAR UMA TAREFA");
            System.out.println("2-VER TODAS AS TAREFAS");
            System.out.println("3-CONCLUIR TAREFA");
            System.out.println("4-APAGAR UMA TAREFA");
            System.out.println("5-SAIR");
            resposta = sc.nextLine();

            if(resposta.equals("1")){

                System.out.println("Insira o nome da tarefa:");
                String nomeTarefa = sc.nextLine();

                String sqlCriar = "INSERT INTO tarefas (nome) VALUES(?)";


                try (Connection cx = DriverManager.getConnection(url,usuario,senha)){
                      PreparedStatement ps = cx.prepareStatement(sqlCriar);

                      ps.setString(1,nomeTarefa);

                      ps.executeUpdate();
                      System.out.println("Tarefa anotada com sucesso paizao");
                }
                catch (SQLException e){
                    System.out.println("ERRO:"+ e.getMessage());
                }
            }
            if (resposta.equals("2")){
                String sqlBusca = "SELECT nome,concluido FROM tarefas";

                try(Connection cx = DriverManager.getConnection(url,usuario,senha); PreparedStatement ps = cx.prepareStatement(sqlBusca)){

                    java.sql.ResultSet rs = ps.executeQuery();

                    while(rs.next()){
                        String nome = rs.getString("nome");
                        Boolean concluido = rs.getBoolean("concluido");

                        String status = concluido ? "[ x ]" : "[ ]";

                        System.out.println(status+ "" +nome);
                    }

                }
                catch (SQLException e){
                    System.out.println("ERRO:"+e.getMessage());
                }
            }
           if (resposta.equals("3")){

               System.out.println("DIGITE A TAREFA A SER CONCLUIDA EMBAIXO");
               String concluir = sc.nextLine();

               String sqlconclui = "UPDATE tarefas SET concluido = true WHERE nome = ? ";

               try(Connection cx = DriverManager.getConnection(url,usuario,senha); PreparedStatement ps = cx.prepareStatement(sqlconclui)){

                   ps.setString(1,concluir);

                   int linhasAfetadas = ps.executeUpdate();

                   if(linhasAfetadas > 0 ){
                       System.out.println("Tarefa marcada como concluida com sucesso morenu!");
                   }else {
                       System.out.println("nenhuma tarefa com este nome paizao");
                   }
               }
               catch (SQLException e){
                   System.out.println("ERRO:"+ e);
               }


           }
           if(resposta.equals("4")){
               System.out.println("DIGITE O NOME DA TAREFA QUE DESEJA EXCLUIR");
               String tarefaExcluir = sc.nextLine();

               String sqlExcluir = "DELETE FROM tarefas WHERE nome = ?";

               try (Connection cx = DriverManager.getConnection(url,usuario,senha); PreparedStatement ps = cx.prepareStatement(sqlExcluir)){

                  ps.setString(1,tarefaExcluir);

                  int linhasAfetadas = ps.executeUpdate();

                  if(linhasAfetadas > 0){
                      System.out.println("tarefa excluida com sucesso pae!tmj");
                  }
                  else {
                      System.out.println("vix,nao tem nenhuma tarefa com esse nome na viu");
                  }

               }catch (SQLException e){
                   System.out.println("ERRO:"+e.getMessage());
               }

           }
           if (resposta.equals("5")){
               break;
           }
        }
        System.out.println("tmj valeu por usar o app,é noixxxx");

    }
}