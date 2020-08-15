import java.util.Scanner;


public class Cadastro_Login {
    public static void main(String[] args) {
//  CADASTRO DE USUÁRIO

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeja Bem-vindo ao Sistema de Gerenciamento de Estoques!");
        System.out.print("\nÁREA DE CADASTRO - pressione ENTER para continuar");
        String inutil = scanner.nextLine();
        System.out.print("\nDigite o seu nome completo com espaço entre os nomes e pressione ENTER: ");
        String nome = scanner.nextLine();

//  FLAGS PARA O CADASTRO DA SENHA
        boolean autenticaLetras = false;
        boolean autenticaMaiuscula = false;
        boolean autenticaMinuscula = false;
        boolean autenticaNumero = false;
        boolean autenticaCaracterEspecial = false;

//  GERANDO USERNAME A PARTIR DO NOME COMPLETO
        String[] nomeQuebrado = nome.split(" ");
        String primeiro_nome = nomeQuebrado[0];
        char primeira_letra= primeiro_nome.charAt(0);
        String ultimo_sobrenome = nomeQuebrado[nomeQuebrado.length - 1];
        String usuario = primeira_letra + "_" + ultimo_sobrenome;

//  CADASTRO DA SENHA

        System.out.println("\nCadastre sua senha!\n");
        System.out.println("***ATENÇÃO*** - ela deve conter, no mínimo: ");
        System.out.println("- 8 letras;");
        System.out.println("- 1 letra maiúscula;");
        System.out.println("- 1 letra minúscula;");
        System.out.println("- 1 número;");
        System.out.println("- 1 caracter especial, dentre - , ! ou @");
        System.out.print("\nDigite a senha escolhida e pressione ENTER: ");
        String senha = scanner.nextLine();
        int contador = 0;
        boolean temCaracterEspecial = false;
        char caracter1 = '@';
        char caracter2 = '!';
        char caracter3 = '-';

//  AUTENTICAÇÃO SENHA MÍNIMO 8 LETRAS
        char[] listaNumeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int contaLetra = 0;
        int contaNumero = 0;
        int contador2 = 0;
        int tamanhoArray = listaNumeros.length;
        while (contador2 < senha.length()){
            int passaProximoIndice = 0;
            while (passaProximoIndice < tamanhoArray){
                if ((senha.charAt(contador2)) == listaNumeros[passaProximoIndice]){
                    contaNumero ++;
                }
                passaProximoIndice ++;
            }
            contador2 ++;
        }
        if ((senha.length() - contaNumero) < 8){
            System.out.println("a senha escolhida tem menos de 8 letras;");
        } else {
            autenticaLetras = true;
        }

//  AUTENTICAÇÃO LETRA MAIÚSCULA E MINÚSCULA

        int contador3 = 0;
        int contaMaiuscula = 0;
        int contaMinuscula = 0;
        while (contador3 < senha.length()){
            boolean ehMaiuscula = Character.isUpperCase(senha.charAt(contador3));
            boolean ehMinuscula = Character.isLowerCase(senha.charAt(contador3));
            if (ehMaiuscula == true){
                contaMaiuscula ++;
            } else if (ehMinuscula == true){
                contaMinuscula ++;
            }
            contador3 ++;
        }
//  CONDIÇÃO LETRA MAIÚSCULA
        if (contaMaiuscula == 0){
            System.out.println("a senha escolhida não contêm letra maiúscula;");
        } else {
            autenticaMaiuscula = true;
        }
//  CONDIÇÃO LETRA MINÚSCULA
        if (contaMinuscula == 0){
            System.out.println("a senha escolhida não contêm letra minúscula;");
        } else{
            autenticaMinuscula = true;
        }

//  AUTENTICAÇÃO SENHA MÍNIMO 1 NÚMERO

        if (contaNumero == 0){
            System.out.println("a senha escolhida não contêm números;");
        } else {
            autenticaNumero = true;
        }
//  AUTENTICAÇÃO CARACTER ESPECIAL
        while (contador < senha.length()) {
            if (((senha.charAt(contador)) == caracter1) || (senha.charAt(contador) == caracter2) || (senha.charAt(contador) == caracter3)) {
                temCaracterEspecial = true;
                break;
            }
            contador++;
        }

        if (temCaracterEspecial == true) {
            autenticaCaracterEspecial = true;
        } else {
            System.out.println("a senha escolhida não contêm caracter especial;");
        }


//  UTILIZANDO AS FLAGS PARA INICIAR O CADASTRO E INICIAR O LOGIN
        if (autenticaLetras == true && autenticaMaiuscula == true && autenticaMinuscula == true && autenticaNumero == true && autenticaCaracterEspecial == true){
            System.out.println("\nSeu Cadastro foi concluído com sucesso!\n");

//  RETORNO DO USERNAME DE LOGIN NO SISTEMA
            System.out.println("Seu username para acesso ao sistema é: " + usuario + "\n");

//  LOGIN E AUTENTICAÇÃO USERNAME E SENHA
            System.out.println("Iniciando a Área de login...\n");
            boolean loginErrado = false;
            System.out.println("ÁREA DE LOGIN - pressione ENTER para continuar");
            while (loginErrado == false){
                boolean erroUsername = false;
                boolean erroSenha = false;
                String inutil2 = scanner.nextLine();
                System.out.print("Digite o username e pressione ENTER: "); // entrada da senha
                String autenticaUsername = scanner.nextLine();
                System.out.print("\nDigite a senha cadastrada para o username e pressione ENTER: ");
                String autenticaSenha = scanner.nextLine();
                if (!autenticaUsername.equals(usuario)){
                    erroUsername = true;
                }
                if (!autenticaSenha.equals(senha)){
                    erroSenha = true;
                }
                if (erroUsername == true && erroSenha == true){
                    System.out.println("\nUsername e senha estão incorretos, pressione ENTER para tentar novamente!\n");
                }
                if (erroUsername == true && erroSenha == false){
                    System.out.println("\nUsername está incorreto, pressione ENTER para tentar novamente!\n");
                }
                if (erroUsername == false && erroSenha == true){
                    System.out.println("\nA senha inserida esta incorreta, pressione ENTER para tentar novamente!");
                }
                if (erroUsername == false && erroSenha == false){
                    System.out.println("\nLogin efetuado!\n");
                    break;
                }
            }
        } else {
            System.out.println("\n Não foi possível concluir seu cadastro, por favor reinicie e tente novamente!");
        }

    }
}



