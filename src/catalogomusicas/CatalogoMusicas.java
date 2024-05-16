package catalogomusicas;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class CatalogoMusicas {
    public static int indexMusicas = 1;
    
    public static void main(String[] args) {
        
        Musica musicas[] = new Musica[5];
        
        musicas[0] = new Musica(1, "Bohemian Rhapsody", "Queen", 345);
        musicas[1] = new Musica(2, "Hotel California", "Eagles", 230);
        musicas[2] = new Musica(3, "Stairway to Heaven", "Led Zeppelin", 582);
        musicas[3] = new Musica(4, "Smells Like Teen Spirit", "Nirvana", 901);
        musicas[4] = new Musica(5, "Hey Jude", "The Beatles", 311);
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** Catalogo de Musicas *******");
        System.out.println("");
        
        System.out.println("Músicas catalogadas: ");
        for (int i = 0; i < musicas.length; i++) {
            if(musicas[i] == null)
                continue;
            
            System.out.println("Código " + musicas[i].getCodigo() + "; Música: " + musicas[i].getNome()+ "; Cantor " + musicas[i].getArtista() + "; Tempo: " + musicas[i].getTempoEmSegundos());
        }
        
        boolean isSair = false;
       
        do {
            System.out.println("");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Remover; 2 - Pesquisar; 3 - Ordenar por nome; 4 - Sair");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    removerMusica(musicas);
                    break;
                case 2:
                    pesquisar(musicas);
                    break;
                case 3:
                    ordernarMusicas(musicas);
                    break;  
                 case 4:
                    isSair = true;
                    break;       
                default:
                    System.out.println("Opção inválida. Tente novamente");;
            }
        } while (!isSair);
        
        
    }
    
    
    public static void removerMusica(Musica[] musicas)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Código da música: ");
        String codigo = scanner.next();
        boolean isRemovido = false;
        
        for (int i = 0; i < musicas.length; i++) {
            if(musicas[i] == null)
                continue;
            
            if (String.valueOf(musicas[i].getCodigo()).equalsIgnoreCase(codigo)) {
                musicas[i] = null;
                isRemovido = true;
                break;
            }
        }
        
        if(isRemovido){
            System.out.println("Música removida com sucesso!");
            for (int i = 0; i < musicas.length; i++) {
                if(musicas[i] == null)
                    continue;

                System.out.println("Código " + musicas[i].getCodigo() + " ; Música: " + musicas[i].getNome()+ "Cantor " + musicas[i].getArtista() + " ; Tempo: " + musicas[i].getTempoEmSegundos());
            }
        }
        else
            System.out.println("Código não pertence a nenhum música cadastrada.");
        
        
    }
    
    public static void pesquisar(Musica musicas[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja pesquisar por 1 - Música ou 2 - Artista: ");
        
        Musica musica = null;
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
               musica = pesquisarPorMusica(musicas);
                break;
            case 2:
               musica = pesquisarPorCantor(musicas);
                break;    
            default:
                System.out.println("Opção inválida");
        }
        
        if(musica != null)
            System.out.println("Código " + musica.getCodigo() + " ; Música: " + musica.getNome()+ "Cantor " + musica.getArtista() + " ; Tempo: " + musica.getTempoEmSegundos());
        else
            System.out.println("Música não encontrada");
    }
    
    public static Musica pesquisarPorMusica(Musica musicas[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o nome da música: ");
        String nome = scanner.next();
        
        ordernarMusicas(musicas);

        int esquerda = 0;
        int direita = musicas.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (musicas[meio].getNome().equalsIgnoreCase(nome)) {
                return musicas[meio];
            }

            int comparacao = musicas[meio].getNome().compareToIgnoreCase(nome);

            if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return null; 
    }
    
    public static Musica pesquisarPorCantor(Musica musicas[])
    { 
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Insira o nome do cantor: ");
        String artista = scanner.next();
        
        Arrays.sort(musicas, Comparator.comparing(Musica::getArtista));
        
        int esquerda = 0;
        int direita = musicas.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (musicas[meio].getArtista().equalsIgnoreCase(artista)) {
                return musicas[meio];
            }

            int comparacao = musicas[meio].getArtista().compareToIgnoreCase(artista);

            if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return null; 
    }
    
    public static void ordernarMusicas(Musica musicas[])
    {
        Arrays.sort(musicas, (m1, m2) -> {
            if (m1 != null && m2 != null) {
                return m1.getNome().compareTo(m2.getNome());
            } else if (m1 == null && m2 != null) {
                return 1; 
            } else if (m1 != null && m2 == null) {
                return -1;
            } else {
                return 0; 
            }
        });
        
        for (int i = 0; i < musicas.length; i++) {
            
            if(musicas[i] == null)
                continue;
            
            System.out.println("Código " + musicas[i].getCodigo() + " ; Música: " + musicas[i].getNome()+ "Cantor " + musicas[i].getArtista() + " ; Tempo: " + musicas[i].getTempoEmSegundos());
        }
    }
    
    
    
}
