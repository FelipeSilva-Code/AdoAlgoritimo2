
package catalogomusicas;

public class Musica {
    private int codigo;    
    private String nome;    
    private String artista;    
    private int tempoEmSegundos;

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getTempoEmSegundos() {
        return tempoEmSegundos;
    }

    public void setTempoEmSegundos(int tempoEmSegundos) {
        this.tempoEmSegundos = tempoEmSegundos;
    }

    public Musica(int codigo, String nome, String artista, int tempoEmSegundos) {
        this.codigo = codigo;        
        this.nome = nome;
        this.artista = artista;
        this.tempoEmSegundos = tempoEmSegundos;
    }

    

}
