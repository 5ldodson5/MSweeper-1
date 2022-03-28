import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class modelGUI extends JFrame {
	private static final long serialVersionUID = 1L;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private int x;
    private int y;
    private Timer timer;
    
    private JLabel statusbar;
	

    public modelGUI() {
    	setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initUI();
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                handleMouseMove(e);
            }
        });
        
//        this.timer = new Timer(100, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                handleTimerEvent(e);
//            }
//
//			@Override
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//        });
        
        // Schedule timer events to fire every 100 milliseconds (0.1 seconds)
        
    }
    

    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    private void initUI() {

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new ControllerMap(statusbar));

        setResizable(false);
        pack();

        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            modelGUI ex = new modelGUI();
            ex.setVisible(true);
        	});
    	}
    protected void handleMouseClick(MouseEvent e) {
        // TODO
        if(e.getButton() == MouseEvent.BUTTON1) {
            //left button
            this.x = e.getX();
            this.y = e.getY();

        }
        repaint();
    }
    
    protected void handleMouseMove(MouseEvent e) {
        // TODO
        this.x = e.getX();
        this.y = e.getY();
        repaint();
    }
    
    protected void handleTimerEvent(ActionEvent e) {
        // TODO
    }
    
	}

