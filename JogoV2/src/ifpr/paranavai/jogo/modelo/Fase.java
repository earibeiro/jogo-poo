package ifpr.paranavai.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener, KeyListener {
    private Image fundo;
    private Personagem personagem;
    private Timer timer;

    private static final int DELAY = 5;
    private static final int VELOCIDADE_DE_DESLOCAMENTO = 3;

    private static final int LARGURA_DA_JANELA = 1280;

    private ArrayList<Inimigo> inimigos;
    private static final int QTDE_DE_INIMIGOS = 50;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("D:\\01_Documentos\\02_Faculdade\\02_2oAno\\04_POO\\JogoT2\\JogoV2\\JogoV2\\recursos\\fundo.png");
        this.fundo = carregando.getImage();
        personagem = new Personagem(VELOCIDADE_DE_DESLOCAMENTO);
        personagem.carregar();

        this.inicializaInimigos();

        addKeyListener(this);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(fundo, 0, 0, null);
        graphics.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);

        ArrayList<Tiro> tiros = personagem.getTiros();
        for (Tiro tiro : tiros) {
            tiro.carregar();
            graphics.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }

        ArrayList<Ultimate> ultimates = personagem.getUltimates();
        for (Ultimate ultimate: ultimates) {
            ultimate.carregar();
            graphics.drawImage(ultimate.getImagem(), ultimate.getPosicaoEmX(), ultimate.getPosicaoEmY(), this);
        }

         for (Inimigo inimigo : inimigos){
             inimigo.carregar();
             graphics.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
         }

        graphics.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.personagem.atirar();
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {
            this.personagem.atirarUltimate();
        }else {
            personagem.mover(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();

        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            //Tiro tiro = tiros.get(i);
            if (tiros.get(i).getPosicaoEmX() > LARGURA_DA_JANELA) {
                tiros.remove(i);
            } else {
                tiros.get(i).atualizar();
            }
        }
        ArrayList<Ultimate> ultimates = personagem.getUltimates();
        for (int i = 0; i < ultimates.size(); i++) {
            if (ultimates.get(i).getPosicaoEmX() > LARGURA_DA_JANELA) {
                ultimates.remove(i);
            } else {
                ultimates.get(i).atualizar();
            }
        }
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).getPosicaoEmX() < 0) {
                inimigos.remove(i);
            } else {
                inimigos.get(i).atualizar();
            }
        }
        repaint();
    }

    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 1000 + 1280);
            int y = (int) (Math.random() * 600);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }
  
}