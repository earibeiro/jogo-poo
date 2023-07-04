package ifpr.paranavai.jogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ultimate {

    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;

    private int posicaoEmX;
    private int posicaoEmY;
  
    private static int VELOCIDADE = 2;

    public Ultimate(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        //this.carregar();
        this.posicaoEmX = posicaoPersonagemEmX;
        this.posicaoEmY = posicaoPersonagemEmY;
        //this.posicaoEmY = posicaoPersonagemEmY - (this.alturaImagem / 2);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("D:\\01_Documentos\\02_Faculdade\\02_2oAno\\04_POO\\JogoT2\\JogoV2\\JogoV2\\recursos\\ultimate.png");
        this.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getHeight(null);
        this.larguraImagem = this.imagem.getWidth(null);
    }

    
    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
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
    
}
