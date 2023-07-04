package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiro {
    private int posicaoEmX;
    private int posicaoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;
    // private boolean visivel;

    // private static final int LARGURA = 1200;
    private static int VELOCIDADE = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        this.carregar();
        this.posicaoEmX = posicaoPersonagemEmX;
        this.posicaoEmY = posicaoPersonagemEmY;
        // visivel = true;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("D:\\01_Documentos\\02_Faculdade\\02_2oAno\\04_POO\\JogoT2\\JogoV2\\JogoV2\\recursos\\tiro.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar () {
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
        // if (this.posicaoEmX > LARGURA) {
        //     this.visivel = false;
        // }
    }


    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    // public boolean isVisivel() {
    //     return this.visivel;
    // }

    // public boolean getVisivel() {
    //     return this.visivel;
    // }

    // public void setVisivel(boolean visivel) {
    //     this.visivel = visivel;
    // }


 
}