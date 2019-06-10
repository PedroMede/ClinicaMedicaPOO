package clinica.controller;

import java.util.ArrayList;
import java.util.List;


public class Cadastro {

    List<Fucionario> list = new ArrayList<>();

//Retorna 0 caso dê algo errado ou 1 caso dê tudo certo.
    public int criaFuncionario(int tipoFunc) {  //Recebe um int informando o tipo de funcionário que será criado, se 1 = medico, se 2 = secretaria.
        
        private stop = false;
        
        while(!stop){
            if(tipoFunc == 1){
                //Pedir todos os cados relacionados ao medico
                return 1;
            }else if(tipoFunc == 2){
                //Pedir todos os cados relacionados a secretaria
                return 1;
                }else {
                    return 0;
                    stop = true;
                }
        }
    }

}