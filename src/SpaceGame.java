import java.util.Scanner;
public class SpaceGame {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        int combustivel = 100;
        int saude = 100;
        int exploracoes = 0;
        int reparacoes = 0;

        while (combustivel != 0 || saude != 0){
            if (saude <= 0 || combustivel <=0 ){
                System.out.printf("voce morreu por falta de recursos!,ao todo voce fez %d reparacoes e %d exploracoes",reparacoes,exploracoes);
                break;
            }

            System.out.println("Oque você gostaria de fazer?");
            System.out.println("1-EXPLORAR");
            System.out.println("2-REPARAR");
            System.out.println("3-CHECAR RECURSOS");
            System.out.println("4-SAIR");
            String resposta =sc.nextLine();

            if (resposta.equals("1-EXPLORAR")|| resposta.equals("1")){
                if (combustivel < 15){
                    System.out.println("COMBUSTIVEL INSUFICIENTE");
                    break;
                }
                int[]resultado_explorar = explorar(combustivel,saude);
                saude = resultado_explorar[0];
                combustivel = resultado_explorar[1];
                exploracoes++;
            }

            if (resposta.equals("2-REPARAR") || resposta.equals("2")){
                if (combustivel < 5){
                    System.out.println("COMBUSTIVEL INSUFICIENTE");
                    break;
                }
                int[]resultado_reparar = reparar(combustivel,saude);
                saude = resultado_reparar[0];
                combustivel = resultado_reparar[1];
                reparacoes++;

            }
            if (resposta.equals("3-CHECAR RECURSOS") || resposta.equals("3")){
                System.out.printf("Sua saude atual é de %d hp ",saude);
                System.out.printf("Seu combustivel atual é de %d l ",combustivel);
            }
            if (resposta.equals("4-SAIR") || resposta.equals("4")){
                System.out.printf("parabens pela sua aventura!durante a jogatina voce fez %d reparacoes e %d exploracoes",reparacoes,exploracoes);
                break;
            }


        }

    }
    public static int[] explorar(int combustivel,int saude){
       combustivel -= 15;
       saude -= 20;
       return new int[]{saude,combustivel};
    }

    public static int[]reparar(int combustivel,int saude){
        combustivel -= 5;
        saude += 15;
        return  new int[]{saude,combustivel};
    }
}
