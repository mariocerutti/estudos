import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
//import java.io.FileInputStream;
//import java.net.URL;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class criadorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.png"));
        //(leitor de URL)InputStream inputStream = new URL("https:raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        // creia uma nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 100;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a imagem original para a nova imagem(em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.BLUE);
        graphics.setFont(fonte);

        // escrever uma nova frase na nova imagem
        graphics.drawString("TOPZERA", 15, novaAltura - 25);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
    
// (teste)public static void main(String[] args) throws Exception {
        
        //var geradora = new criadorDeFigurinhas();
        //geradora.cria();
    }

//}
