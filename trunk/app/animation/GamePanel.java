import javax.swing.JPanel;
import java.lang.Thread.Runnable;
import java.lang.Thread;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private static final int PWIDTH = 500;
    private static final int PHEIGHT = 400;
    
    private Thread animator;
    private volatile boolean running = false;
    
    private volatile boolean gameover = false;
    
    public GamePanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        
        //
        setFocusable(true);
        requestFocus();    // JPanel now receives key events
        readyForTermination();
        
        // listen for mouse presses
        addMouseListener(
            new MouseAdapter( ) {
                public void mousePressed(MouseEvent e) {
                    testPress(e.getX(), e.getY());
                }
            }
        );

    }

    public void addNotify() {
        super.addNotify();
        startGame();
    }
    
    private void startGame() {
        if (animator == null || !running)
        {
            animator = new Thread(this);
            animator.start();
        }
    }
    
    public void stopGame() {
        running = false;
    }
    
    public void run() {
        running = true;
        
        while (running) {
            gameUpdate();
            gameRender();
            repaint();
            
            try {
                Thread.sleep(20);
            } catch (InteruptedException ex) {
            
            }
        }
        System.exit(0);
    }
    
    private void gameUpdate() {
    
    }
    
    private void gameRender() {
    
    }
    
    private void readyForTermination( )
    {
        addKeyListener(
            new KeyAdapter() {
                // listen for esc, q, end, ctrl-c
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if ((keyCode == KeyEvent.VK_ESCAPE) ||
                        (keyCode == KeyEvent.VK_Q) ||
                        (keyCode == KeyEvent.VK_END) ||
                        ((keyCode == KeyEvent.VK_C) && e.isControlDown( )) ) {
                        running = false;
                    }
                }
            }
        );
    }
    
    private void testPress(int x, int y)
    {
        if (!gameover) {
            // do something
        }
    }
}