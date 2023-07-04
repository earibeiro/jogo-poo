package ifpr.paranavai.jogo.modelo;

import java.awt.event.KeyEvent;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;

    private int deslocamentoEmX;
    private int deslocamentoEmY;

    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;

    private int DESLOCAMENTO;

    private static final int POSICAO_INICIAL_EM_X = 0;
    private static final int POSICAO_INICIAL_EM_Y = 0;

    private ArrayList<Tiro> tiros;
    private ArrayList<Ultimate> ultimates;

    public Personagem(int DESLOCAMENTO){
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.DESLOCAMENTO = DESLOCAMENTO;
        this.tiros = new ArrayList<Tiro>();
        this.ultimates = new ArrayList<Ultimate>();
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("D:\\01_Documentos\\02_Faculdade\\02_2oAno\\04_POO\\JogoT2\\JogoV2\\JogoV2\\recursos\\personagem.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar() {
        this.posicaoEmX = this.posicaoEmX + this.deslocamentoEmX;
        this.posicaoEmY = this.posicaoEmY + this.deslocamentoEmY;
    }

    public void mover (KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
        }
    }

    public void parar(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = 0;
                break;
        }
    }

    public void atirar() {
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImagem / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void atirarUltimate() {
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImagem / 2);
        Ultimate ultimate = new Ultimate(frenteDaNave, meioDaNave);
        this.ultimates.add(ultimate);
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

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
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

    public int getDESLOCAMENTO() {
        return this.DESLOCAMENTO;
    }

    public void setDESLOCAMENTO(int DESLOCAMENTO) {
        this.DESLOCAMENTO = DESLOCAMENTO;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public ArrayList<Ultimate> getUltimates() {
        return this.ultimates;
    }

    public void setUltimates(ArrayList<Ultimate> ultimates) {
        this.ultimates = ultimates;
    }
    
}