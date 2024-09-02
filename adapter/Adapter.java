class Main {
    public static void main(String[] args) {
        NotificacaoPorEmail notificacaoPorEmail = new NotificacaoPorEmail();
        Notificador notificador = new NotificadorEmailAdapter(notificacaoPorEmail);
        notificador.enviarNotificao("\nOlá, Mundo!\n");
    }
}

class NotificacaoPorEmail { // Biblioteca externa com interface diferente.
    public void enviarEmail(String conteudo) {
        System.out.println(conteudo);
    }
}

interface Notificador { // Interface da aplicação em uso.
    void enviarNotificao(String mensagem);
}

class NotificadorEmailAdapter implements Notificador {
    private NotificacaoPorEmail notificacaoPorEmail;

    public NotificadorEmailAdapter(NotificacaoPorEmail notificacaoPorEmail) {
        this.notificacaoPorEmail = notificacaoPorEmail;
    }

    @Override
    public void enviarNotificao(String mensagem) {
        notificacaoPorEmail.enviarEmail(mensagem);
    }
}