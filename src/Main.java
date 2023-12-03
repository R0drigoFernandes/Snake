import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;

// Rest of the code
public class Main extends Canvas implements Runnable {
    public Player player;
    public Comida comida;
    
public Main(){
    
    
 player = new Player(20,5,10,10);
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
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(snake);
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

  
    
    
}