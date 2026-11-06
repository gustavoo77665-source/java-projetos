package CRUDtarefasV2;
import  java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class tarefas {
     Scanner sc = new Scanner(System.in);
     String url = "jdbc:mysql://localhost:3306/todo2";
     String usuario = "usuario";
     String senha  = "senha" ;

     public void registrar(){
          System.out.println("Insira o nome da tarefa");
          String tarefa= sc.nextLine();

          String sqlCriar = "INSERT INTO tarefas2 (nome) VALUES(?)";


          try (Connection cx = DriverManager.getConnection(url,usuario,senha);
          PreparedStatement ps = cx.prepareStatement(sqlCriar)){

           ps.setString(1,tarefa);

           ps.executeUpdate();

           System.out.println("Tarefa anotada com sucesso pae");

          }catch (SQLException e){
               System.out.println("ERRO:"+ e.getMessage());
          }

     }
     public void verTarefas(){
        String sqlChecar = "SELECT nome,concluido FROM tarefas2";

        try (Connection cx = DriverManager.getConnection(url,usuario,senha);PreparedStatement ps = cx.prepareStatement(sqlChecar)){
         java.sql.ResultSet rs = ps.executeQuery();

         while(rs.next()){
             String nome = rs.getString("nome");
             Boolean concluido = rs.getBoolean("concluido");
             String status = concluido? "[ x ]" : "[   ]";

             System.out.println(nome+""+status);

         }

        }catch (SQLException e){
             System.out.println("ERRO: "+ e.getMessage());
        }
     }
     public void concluirTarefas(){
         System.out.println("DIGITE O NOME DA TAREFA NA QUAL DESEJA CONCLUIR PAE");
         String concrui = sc.nextLine();

         String sqlConcluir = " UPDATE tarefas2 SET concluido = true WHERE nome = ?";

         try (Connection cx = DriverManager.getConnection(url,usuario,senha);PreparedStatement ps = cx.prepareStatement(sqlConcluir)){

         ps.setString(1,concrui);

         int linhas = ps.executeUpdate();

         if (linhas > 0){
             System.out.println("tarefa concluida com sucesso pae");

         }else {
             System.out.print("ERRO:NAO HA NENHUMA TAREFA COM ESSE NOME");

         }
         }catch (SQLException e){
             System.out.println("ERRO:"+ e.getMessage());
         }
     }
     public void deletar(){
         System.out.println("DIGITE O NOME DA TAREFA NA QUAL DESEJA DELETAR");
         String delet = sc.nextLine();

         String sqlDeletar = "DELETE FROM tarefas2 WHERE nome = ?";
         try (Connection cx = DriverManager.getConnection(url,usuario,senha);PreparedStatement ps = cx.prepareStatement(sqlDeletar)){

             ps.setString(1,delet);
             int linhas = ps.executeUpdate();

             if (linhas >0 ){
                 System.out.print("tarefa deletada com sucesso paizao");

             }else{
                 System.out.println("tarefa nao encontrada");
             }

         }catch(SQLException e){
             System.out.println("ERRO:"+ e.getMessage());
         }
     }
}
