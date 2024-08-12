public class Adapter {
    public static void main(String[] args) {
        NotificacaoPorEmail notificacaoPorEmail = new NotificacaoPorEmail();
        Notificador notificador = new NotificadorEmailAdapter(notificacaoPorEmail);
        notificador.enviarNotificao("\nOlá, Mundo!\n");
    }
}