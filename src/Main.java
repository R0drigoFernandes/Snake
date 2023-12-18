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
    int keyCode = e.getKeyCode();
    // Handle key pressed event
    if (keyCode == KeyEvent.VK_UP) {
        // Up key is pressed
        player.up=true;
    } else if (keyCode == KeyEvent.VK_DOWN) {
        // Down key is pressed
       player.down  = true;
    } else if (keyCode == KeyEvent.VK_LEFT) {
        // Left key is pressed
        player.left = true;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
        // Right key is pressed
        player.right = true;
    }

   }

   @Override
   public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
    // Handle key released event
    if (keyCode == KeyEvent.VK_UP) {
        // Up key is released
        player.up = false;
    } else if (keyCode == KeyEvent.VK_DOWN) {
        // Down key is released
        player.down = false;
    } else if (keyCode == KeyEvent.VK_LEFT) {
        // Left key is released
        player.left = false;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
        // Right key is released
        player.right = false;
    }

   }
    
    
}