package a05_Array_Classes.Exercicios.transportadora;

public class Caminhao{
        String n_placa;
        int ano_aquisicao;
        int quilometragem = 0;
        int n_viagens = 0;

        Transportadora transportadora = new Transportadora();

        //Definir a placa
        public void definirPlaca(String n_placa_){n_placa = n_placa_;
        }

        //Definir o ano de aquisição
        public void definirAnoAquisicao(int ano_aquisicao_){
            ano_aquisicao = ano_aquisicao_;
        }

        //Nº de viagens a serem realizadas
        public int realizarViagensNumero(int numero_viagens){
            return transportadora.atualizarViagens(this, numero_viagens);
        }

        //Nº de viagens registradas será feito por meio da transportadora
        public String  definirNumeroViagens(){
                return transportadora.numeroViagens(this);
        };

        public String  definirQuilometragem(){
                return transportadora.quilometragem(this);
        };
}

