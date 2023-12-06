import java.awt.Color;
import java.awt.Graphics;
public class Player {
    private int tamanho;
    private int velocidade = 5;
    private int x = 10;
    private int y = 10;
    private boolean right, left, up, down;
    

    public Player(int tamanho, int x, int y) {
        this.tamanho = tamanho;
        this.x = x;
        this.y = y;
    }

    public void tick() {
        
        
        if(right) {
            x += velocidade;
        }
        if(left) {
            x -= velocidade;
        }
        if(up) {
            y -= velocidade;
        }
        if(down) {
            System.out.println(down);
            y += velocidade;
        }
    }

    

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
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
