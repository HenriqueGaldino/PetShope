public class Animal {
    int id;
    String nome;
    String raca;
    double peso;
    int idCategoria;
    int idTutor;

    public Animal(int id, String nome, String raca, double peso, int idCategoria, int idTutor) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.idCategoria = idCategoria;
        this.idTutor = idTutor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public String getNome() {
        return nome;
    }
}
