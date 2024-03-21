package a05_Array_Classes.Exercicios.transportadora;

public class main {
    public static void main(String[] args) {
        //Primeiro Caminhão
        Caminhao caminhao1 = new Caminhao();

        //Transportadora
        Transportadora transportadora = new Transportadora();

        //Tratando os dados do caminhão
        caminhao1.definirPlaca("ABC-1234");
        caminhao1.definirAnoAquisicao(1985);

        //O primeiro caminhão irá realizar um nº X de viagens
        int total_viagem = caminhao1.realizarViagensNumero(3);
        total_viagem += 2;

        //Agora iremos realizar as viagens
        while (total_viagem != 0){

            total_viagem -= 1;
            //Tudo será registrado pela transportadora
            transportadora.atualizarViagens(caminhao1);
        }

        transportadora.atualizarQuilometragem(caminhao1);

        //Agora quando querer saber os dados do nº de viagens, será dado pela transportadora
        System.out.println(caminhao1.definirNumeroViagens());
        System.out.println(caminhao1.definirQuilometragem());
    }
}
