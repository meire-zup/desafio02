package service;

public class ValidacaoService {

    // Método verifica se o nome digitado é um número ou valor vazio
    public boolean nomeENumeroOuVazio (String nome){

        for(char c : nome.toCharArray()) {

            if(!Character.isDigit(c)){

                return false;

            }
        }
        return true;
    }
    // Método verifica se o CPF contém 11 digitos e se não são dígitos iguais
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
