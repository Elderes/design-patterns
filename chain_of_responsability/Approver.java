package chain_of_responsability;

class Main {
    public static void main(String[] args) {
        Approver teamLeader = new TeamLeader();
        Approver manager = new Manager();
        Approver director = new Director();

        teamLeader.setNextApprover(manager);
        manager.setNextApprover(director);

        teamLeader.approveRequest(980);
        teamLeader.approveRequest(1500);
        teamLeader.approveRequest(3900);
        teamLeader.approveRequest(5200);
        teamLeader.approveRequest(7800);
        teamLeader.approveRequest(11000);
    }
}

abstract class Approver {
    protected Approver nextApprover; // Apontador para o próximo da fila;

    // Construtor do apontador.
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approveRequest(int amount); // Método abstrato para aprovar a solicitação.
}

class TeamLeader extends Approver {

    @Override
    public void approveRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Líder de Time aprovou a solicitação no valor de " + amount);
       } else if (nextApprover != null) {
            nextApprover.approveRequest(amount);
       }
    }
}

class Manager extends Approver {

    @Override
    public void approveRequest(int amount) {
        if (amount <= 5000) {
            System.out.println("Gerente aprovou a solicitação no valor de " + amount);
       } else if (nextApprover != null) {
            nextApprover.approveRequest(amount);
       }
    }
}

class Director extends Approver {

    @Override
    public void approveRequest(int amount) {
        if (amount <= 10000) {
            System.out.println("Diretor aprovou a solicitação no valor de " + amount);
       } else if (nextApprover != null) {
            nextApprover.approveRequest(amount);
       } else {
            System.out.println("Solicitação de valor " + amount + " requer maior nível para aprovação.");
       }
    }
}