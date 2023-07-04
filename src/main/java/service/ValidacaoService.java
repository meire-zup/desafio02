package service;

public class ValidacaoService {

    // Método verifica se o nome digitado é uma String
    public boolean eNumero (String nome){

        for(char c : nome.toCharArray()) {

            if(!Character.isDigit(c)){

                return false;

            }
        }
        return true;
    }
    // Método verifica se o CPF coném 11 digitos
    public boolean validarCPF(String cpf) {

        cpf = cpf.replaceAll("\\D+", "");

        if (cpf.length() != 11) {

            return  false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;

    }


}
