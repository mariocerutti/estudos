import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Fazer conexão http com top 250 filmes //
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação) //
        var parser = new Jsonparser();
        List<Map<String, String>> listaDeFilmes = parser. parse(body);
        


        // exibir e manipilar os dados //
        var criadora = new criadorDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {
            
            String urlImagem = filme.get("imDbRating");
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            criadora.cria(inputStream, nomeArquivo);

            System.out.println(filme.get("title"));
            //System.out.println(filme.get("image"));
            //System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
