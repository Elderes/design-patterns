public class NotificadorEmailAdapter implements Notificador {
    private NotificacaoPorEmail notificacaoPorEmail;

    public NotificadorEmailAdapter(NotificacaoPorEmail notificacaoPorEmail) {
        this.notificacaoPorEmail = notificacaoPorEmail;
    }

    @Override
    public void enviarNotificao(String mensagem) {
        notificacaoPorEmail.enviarEmail(mensagem);
    }
}