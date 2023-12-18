import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// Rest of the code
public class Main extends Canvas implements Runnable, KeyListener {
    public Player player;
    public Comida comida;
    
public Main(){
    
    
 player = new Player(20,10,10);
 comida = new Comida(100,100);

}

    
@Override
    public void run() {
        while (true) { 
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (Exception e) {
             e.printStackTrace();
 
            }
            
         }
    }
    
    
   public static void main(String[] args) {
       Main snake = new Main();
        JFrame frame = new JFrame("Snake");
        frame.add(snake);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(snake).start();


       
       
   }
   public void tick(){
       player.tick();
   }

   public void render(){
    BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);
       
       
        comida.render(g);
        player.render(g);


        bs.show();
   }

   @Override
   public void keyTyped(KeyEvent e) {
   

   }

   @Override
   public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_W){
       player.up = true;
    }
    if(key == KeyEvent.VK_S){
       player.down = true;
    }
    if(key == KeyEvent.VK_A){
       player.left = true;
    }
    if(key == KeyEvent.VK_D){
       player.right = true;
    }

   }

   @Override
   public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_W){
      player.up = false;
    }
    if(key == KeyEvent.VK_S){
        player.down = false;
    }
    if(key == KeyEvent.VK_A){
        player.left = false;
    }
    if(key == KeyEvent.VK_D){
        player.right = false;
    }

   }
    
    
}