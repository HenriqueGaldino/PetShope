public class Tutor {
    int id;
    String nome;
    String telefone;
    String email;

    public Tutor(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
