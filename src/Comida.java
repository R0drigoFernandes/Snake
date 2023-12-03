import java.awt.Graphics;
import java.awt.Color;
public class Comida {
    private int x, y;
    public Comida(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void render(Graphics g){

        g.setColor(Color.RED);
        g.fillRect(x, y, 10, 10);
    }
}
