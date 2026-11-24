public class PetMachine {
    private static final int MAX_AGUA = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int ABASTECIMENTO_POR_VEZ = 2;

    private static final int CONSUMO_BANHO_AGUA = 10;
    private static final int CONSUMO_BANHO_SHAMPOO = 2;

    private static final int CONSUMO_LIMPEZA_AGUA = 3;
    private static final int CONSUMO_LIMPEZA_SHAMPOO = 1;

    private int agua;
    private int shampoo;
    private boolean limpa;
    private Pet pet;

    public PetMachine() {
        this.agua = 0;
        this.shampoo = 0;
        this.limpa = true;
        this.pet = null;
    }

    public void darBanho() {
        if (this.pet == null) {
            System.out.println("Nao ha nenhum pet na maquina para tomar banho.");
            return;
        }
        if (this.agua < CONSUMO_BANHO_AGUA || this.shampoo < CONSUMO_BANHO_SHAMPOO) {
            System.out.println("Agua ou shampoo insuficientes para dar banho (necessario 10L de agua e 2L de shampoo).");
            return;
        }

        this.agua -= CONSUMO_BANHO_AGUA;
        this.shampoo -= CONSUMO_BANHO_SHAMPOO;
        this.pet.setLimpo(true);
        System.out.println("Banho concluido! O pet " + this.pet.getNome() + " agora esta limpo.");
    }

    public void abastecerAgua() {
        if (this.agua >= MAX_AGUA) {
            System.out.println("A maquina ja esta com a capacidade maxima de agua (" + MAX_AGUA + "L).");
            return;
        }
        this.agua = Math.min(MAX_AGUA, this.agua + ABASTECIMENTO_POR_VEZ);
        System.out.println("Agua abastecida (+2L). Nivel atual: " + this.agua + "L.");
    }

    public void abastecerShampoo() {
        if (this.shampoo >= MAX_SHAMPOO) {
            System.out.println("A maquina ja esta com a capacidade maxima de shampoo (" + MAX_SHAMPOO + "L).");
            return;
        }
        this.shampoo = Math.min(MAX_SHAMPOO, this.shampoo + ABASTECIMENTO_POR_VEZ);
        System.out.println("Shampoo abastecido (+2L). Nivel atual: " + this.shampoo + "L.");
    }

    public int verificarNivelAgua() {
        System.out.println("Nivel de agua atual: " + this.agua + "L / " + MAX_AGUA + "L.");
        return this.agua;
    }

    public int verificarNivelShampoo() {
        System.out.println("Nivel de shampoo atual: " + this.shampoo + "L / " + MAX_SHAMPOO + "L.");
        return this.shampoo;
    }

    public boolean temPetNoBanho() {
        boolean temPet = this.pet != null;
        if (temPet) {
            System.out.println("Ha um pet na maquina: " + this.pet.getNome() + ".");
        } else {
            System.out.println("Nao ha nenhum pet na maquina no momento.");
        }
        return temPet;
    }

    public void colocarPet(Pet pet) {
        if (pet == null) {
            System.out.println("Pet invalido.");
            return;
        }
        if (this.pet != null) {
            System.out.println("Ja existe um pet na maquina (" + this.pet.getNome() + "). So e permitido 1 pet por vez.");
            return;
        }
        if (!this.limpa) {
            System.out.println("A maquina precisa ser limpa antes de receber outro pet.");
            return;
        }

        this.pet = pet;
        System.out.println("Pet " + pet.getNome() + " colocado na maquina.");
    }

    public void retirarPet() {
        if (this.pet == null) {
            System.out.println("Nao ha nenhum pet na maquina para retirar.");
            return;
        }

        if (!this.pet.isLimpo()) {
            this.limpa = false;
            System.out.println("Pet " + this.pet.getNome() + " retirado SEM estar limpo. A maquina agora precisa ser limpa!");
        } else {
            this.limpa = true;
            System.out.println("Pet " + this.pet.getNome() + " retirado limpo.");
        }

        this.pet = null;
    }

    public void limparMaquina() {
        if (this.pet != null) {
            System.out.println("Retire o pet da maquina antes de limpa-la.");
            return;
        }
        if (this.agua < CONSUMO_LIMPEZA_AGUA || this.shampoo < CONSUMO_LIMPEZA_SHAMPOO) {
            System.out.println("Agua ou shampoo insuficientes para limpar a maquina (necessario 3L de agua e 1L de shampoo).");
            return;
        }

        this.agua -= CONSUMO_LIMPEZA_AGUA;
        this.shampoo -= CONSUMO_LIMPEZA_SHAMPOO;
        this.limpa = true;
        System.out.println("Maquina limpa com sucesso! (Consumido 3L de agua e 1L de shampoo).");
    }
}
