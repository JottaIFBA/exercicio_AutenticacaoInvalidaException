package br.edu.ifba.saj.ads.poo;
import java.util.ArrayList;
import java.util.List;

class AutenticacaoInvalidaException extends Exception {
    public AutenticacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}

class BancoDeUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        // Inicialização dos usuários cadastrados
        usuarios.add(new Usuario("usuarioJOTTA", "123123"));
        usuarios.add(new Usuario("usuarioLUCAS", "123123"));
        usuarios.add(new Usuario("usuarioANA", "123123"));
    }

    public static void autenticar(String login, String senha) throws AutenticacaoInvalidaException {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                System.out.println("Usuário autenticado: " + usuario.getLogin());
                return;
            }
        }
        throw new AutenticacaoInvalidaException("Usuário " + login + " não foi encontrado ou a senha está errada");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            BancoDeUsuarios.autenticar("usuario1", "senha1");
            BancoDeUsuarios.autenticar("usuario2", "senha_errada");
        } catch (AutenticacaoInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
