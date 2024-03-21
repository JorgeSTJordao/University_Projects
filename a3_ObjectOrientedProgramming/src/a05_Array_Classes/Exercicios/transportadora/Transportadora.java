package a05_Array_Classes.Exercicios.transportadora;

public class Transportadora {

    //Podemos tratar de qualquer caminhão nesse caso

    public void atualizarViagens(Caminhao caminhao, int n_viagens){
        caminhao.n_viagens += 1;
    }

    public void atualizarQuilometragem(Caminhao caminhao){
        caminhao.quilometragem += (caminhao.n_viagens * 100)*2;
    }

    //Dados do caminhao
    public String numeroViagens(Caminhao caminhao){
        return String.format("O nº total de viagens realizadas foram %d", caminhao.n_viagens);
    }

    public String quilometragem(Caminhao caminhao){
        return String.format("O valor total de km's percorridos foram %d km", caminhao.quilometragem);
    }
}
