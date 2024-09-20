package a07_Collection_Class.IBGE;

import java.util.ArrayList;
import java.util.Scanner;


//Primeiro devemos criar os objeto que no caso serão país, estado e município
public class IBGE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Preenchendo o nº de municípios, estados e países
        System.out.print("Digite o número de municípios a serem cadastrados: ");
        int totalMunicipios = input.nextInt();

        System.out.print("Digite o número de estados a serem cadastrados: ");
        int totalEstados = input.nextInt();

        System.out.print("Digite o número de países a serem cadastrados: ");
        int totalPaises = input.nextInt();

        //Arrays que armazenarão os tipos de classes
        Municipio[] municipios = new Municipio[totalMunicipios];
        Estado[] estados = new Estado[totalEstados];
        Pais[] paises = new Pais[totalPaises];

        ArrayList<String> municipiosDisponiveis = new ArrayList<>();
        ArrayList<String> estadosDisponiveis = new ArrayList<>();


        int i = 0;

        input.nextLine();

        //Definir o município
        for (Municipio municipio : municipios){
            System.out.print("Digite o nome do município: ");
            String nome = input.nextLine();

            System.out.print("Digite a população total do município: ");
            int pop = input.nextInt();

            System.out.print("Digite a área total do município: ");
            double area = input.nextDouble();


            municipios[i] = new Municipio(nome, pop, area);
            municipiosDisponiveis.add(nome);

            i += 1;

            input.nextLine();
        }


        //Definir os estados
        i = 0;
        for (Estado estado : estados){
            System.out.printf("Digite o nome do %dº estado: ", i + 1);
            String nome = input.nextLine();

            estados[i] = new Estado(nome);

            estadosDisponiveis.add(nome);

            while (!municipiosDisponiveis.isEmpty()) {
                System.out.println("Adicione um dos municípios " + municipiosDisponiveis);
                String nomeMunicipio = input.nextLine();

                //Verifica o nome do município na classe
                for (Municipio municipio: municipios){
                    if (municipio.nome.equals(nomeMunicipio)) {
                        estados[i].adicionarMunicipio(municipio);
                        break;
                    }
                }

                municipiosDisponiveis.remove(nomeMunicipio);

                System.out.print("Deseja adicionar mais um? (S/N) ");
                String status = input.next();

                input.nextLine();

                if (status.equals("N") || municipiosDisponiveis.isEmpty())
                    break;
            }
            i += 1;
        }

        ///Definir o país
        i = 0;
        for (Pais pais : paises){
            System.out.printf("Digite o nome do %dº país: ", i + 1);
            String nome = input.nextLine();

            paises[i] = new Pais(nome);

            while (!estadosDisponiveis.isEmpty()) {
                System.out.println("Adicione um dos estados " + estadosDisponiveis);
                String nomeEstado = input.nextLine();

                //Verifica o nome do estadi na classe
                for (Estado estado: estados){
                    if (estado.nome.equals(nomeEstado)) {
                        paises[i].adicionarEstado(estado);
                        break;
                    }
                }

                estadosDisponiveis.remove(nomeEstado);

                System.out.print("Deseja adicionar mais um? (S/N) ");
                String status = input.next();

                input.nextLine();

                if (status.equals("N") || estadosDisponiveis.isEmpty())
                    break;
            }
        }

        System.out.println(paises[0].nome);
        System.out.println(paises[0].densidade());
        System.out.println(paises[0].menorPopulacaoEstado());
    }
}
