public class Usuario {
    private String senha = "123";
    int tentativas = 3;

    public Usuario() {
    }

    public String getSenha() {
        return senha;
    }

    public boolean setSenha(String senha) {
        if (senha.equals(this.senha)) {
            System.out.println("Senha Correta!");
            tentativas = 3;
            this.senha = senha;
            return true;
        } else {
            tentativas--;
            System.out.println("Senha errada, mais " + tentativas + " tentativas");
            if (tentativas == 0) {
                System.out.println("Número maximo de tentativas excedido!");
                System.exit(0);
            }
            return false;
        }

    }

    public void mudarSenha(String senhaNova) {
        this.senha = senhaNova;
        System.out.println("Senha alterada com sucesso\nSenha atual = " + this.senha);
    }

}
