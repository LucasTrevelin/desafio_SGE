import java.util.Scanner;


public class Cadastro_Login {
    public static void main(String[] args) {
//  CADASTRO DE USUÁRIO


        Scanner scanner = new Scanner(System.in);
        System.out.print("Cadastro de usuário iniciado - pressione ENTER para continuar");
        String inutil = scanner.nextLine();
        System.out.println("Digite o seu nome completo com espaço entre os nomes e pressione ENTER:");
        String nome = scanner.nextLine();

//  GERANDO USERNAME A PARTIR DO NOME COMPLETO
        String[] nomeQuebrado = nome.split(" "); // quebra a string contida na variável nome nos espaços vazios e adionca na array de strings "splited"
        String primeiro_nome = nomeQuebrado[0]; //guarda o primeiro item do array na variável "primeiro_nome"
        char primeira_letra= primeiro_nome.charAt(0);
        String ultimo_sobrenome = nomeQuebrado[nomeQuebrado.length - 1];
        String usuario = primeira_letra + "_" + ultimo_sobrenome;

//  CADASTRO DA SENHA

        System.out.println("Cadastre uma senha: ");
        System.out.println("ATENÇÃO - ela deve conter: ");
        System.out.println("- No mínimo 8 letras;");
        System.out.println("- 1 letra maiúscula;");
        System.out.println("- 1 letra minúscula;");
        System.out.println("- 1 número;");
        System.out.println("- 1 caracter especial: ! ou @");
        String senha = scanner.nextLine();
        int contador = 0;
        boolean temCaracterEspecial = false;
        char caracter1 = '@';
        char caracter2 = '!';

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
            System.out.println("sua senha tem menos de 8 letras, reinicie o cadastro e tente novamente");
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
            System.out.println("senha não contêm letra maiúscula, reinicie o cadastro e tente novamete;");
        }
//  CONDIÇÃO LETRA MINÚSCULA
        if (contaMinuscula == 0){
            System.out.println("senha não contêm letra minúscula, reinicie o cadastro e tente novamete;");
        }

//  AUTENTICAÇÃO SENHA MÍNIMO 1 NÚMERO

        if (contaNumero == 0){
            System.out.println("sua senha não contêm números, reinicie o cadastro e tente novamente");
        }
//  AUTENTICAÇÃO CARACTER ESPECIAL
        while (contador < senha.length()) {
            if (((senha.charAt(contador)) == caracter1) || (senha.charAt(contador) == caracter2)) {
                temCaracterEspecial = true;
                break;
            }
            contador++;
        }

        if (temCaracterEspecial == true) {
            System.out.println("Usuário e senha cadastrados com sucesso!");
        } else {
            System.out.println("senha não contêm caracter especial ! ou @, reinicie o cadastro e tente novamente");
        }

//  RETORNO DO USERNAME DE LOGIN NO SISTEMA
        System.out.println("Seu username para acesso ao sistema é: " + usuario);
        System.out.println("carregando a área de login...");


//  LOGIN E AUTENTICAÇÃO USERNAME E SENHA
        boolean loginErrado = false;
        System.out.println("Área de Login - pressione ENTER para continuar"); // entrada do login
        while (loginErrado == false){
            boolean erroUsername = false;
            boolean erroSenha = false;
            String inutil2 = scanner.nextLine();
            System.out.println("Digite o username e pressione ENTER"); // entrada da senha
            String autenticaUsername = scanner.nextLine();
            System.out.println("Digite a senha cadastrada para o username e pressione ENTER");
            String autenticaSenha = scanner.nextLine();
            if (!autenticaUsername.equals(usuario)){
                erroUsername = true;
            }
            if (!autenticaSenha.equals(senha)){
                erroSenha = true;
            }
            if (erroUsername == true && erroSenha == true){
                System.out.println("Username e senha estão incorretos, tente novamente");
            }
            if (erroUsername == true && erroSenha == false){
                System.out.println("Username está incorreto, tente novamente");
            }
            if (erroUsername == false && erroSenha == true){
                System.out.println("Senha esta incorreta, tente novamente");
            }
            if (erroUsername == false && erroSenha == false){
                System.out.println("Login efetuado");
                break;
            }
        }
    }
}



