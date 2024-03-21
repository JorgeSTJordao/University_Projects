package SwingTraining;

import javax.swing.*;
import java.awt.*;

public class a01_hello_swing {

    public static void helloSwing(String text){

        //Apresentando os objetos que buscamos implementar na interface
        final JLabel label = new JLabel(text);
        final JButton button = new JButton("Click");

        //Adicionando um novo termo ao texto escolhido pelo usuário
        label.setText(String.format("Texto: %s", text));

        final JLabel label1 = new JLabel("Digite alguma coisa no campo abaixo: ");
        final JTextField edField = new JTextField();

        //Gerando o objeto frame que fica na parte mais baixo nível
        JFrame frame = new JFrame("HelloWorldSwing");

        //Pegando a parte que será vísivel para o usuário
        //Adicionando o label
        frame.getContentPane().add(label);
        frame.getContentPane().add(label1);

        //Campo de preeenchimento
        frame.getContentPane().add(button);
        frame.getContentPane().add(edField);
        //Fecha o objeto frame

        Container contentPane = frame.getContentPane();
        contentPane.applyComponentOrientation(
                ComponentOrientation.getOrientation(
                        contentPane.getLocale()));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ajusta o objeto de acordo com o devido tamanho
        frame.pack();

        //Mostra o resultado
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        String text = "Hello World";
        helloSwing(text);
    }
}
