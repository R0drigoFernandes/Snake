import java.awt.Color;
import java.awt.Graphics;
public class Player {
    private int tamanho;
    private int velocidade = 1;
    private int x = 10;
    private int y = 10;
    

    public Player(int tamanho, int velocidade, int x, int y) {
        this.tamanho = tamanho;
        this.velocidade = velocidade;
        this.x = x;
        this.y = y;
    }

    public void tick() {
        x += velocidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getVelocidade() {
        return velocidade;
    }
    public int setTamanho(int tamanho) {
        return this.tamanho = tamanho;
    }

    public int setVelocidade(int velocidade) {
        return this.velocidade = velocidade;
    }

    public int getX() {
        return x;
    }
    public int setX(int x) {
        return this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public int setY(int y) {
        return this.y = y;
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, tamanho, 10);
    }
}
