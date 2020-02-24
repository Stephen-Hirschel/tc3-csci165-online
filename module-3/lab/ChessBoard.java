import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

class ChessBoard extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public ChessBoard() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(816, 839);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

	// add your own drawing intructions in this method
    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;

        //<====> ADD YOUR DRAWING CODE HERE <==========>//
        
        // set variables
        int width = getWidth();
        int height = getHeight();
        int sqx = width / 8;
        int sqy = height / 8;
        int x = 0, y = 0;
        
        // set color for first set of squares
        g2d.setColor(Color.PINK);
        
        // create for loop to fill appropriate squares
        for(int i = 0; i <= 4; ++i) {
        	
        	if(i <= 4) {
        		g2d.fillRect(x, y, sqx, sqy);
        		y += height / 4;
            	// set conditions to avoid infinite loops and going past the window's border
        		
        		if(y >= height) {
        			x += width / 4;
        			y = 0;
        			i = 0;
        			if(x >= width) {
        				i = 5;
        			}
        	
        		}
        	}
        }
        
        // set variables for offset squares
        int offx = sqx;
        int offy = sqy;
        
        // create for loop to fill appropriate squares
        for(int i = 0; i <= 4; ++i) {
        	if(i <= 4) {
        	g2d.fillRect(offx, offy, sqx, sqy);
        	offy += height / 4;
        	// set conditions to avoid infinite loops and going past the window's border
        	if(offy >= height) {
        		offx += width / 4;
        		offy = sqy;
        		i = 0;
        		if(offx >= width) {
        			i = 5;
        		}
        	}
        	}
        }
        x = sqx; y = 0;  // reset variables
        g2d.setColor(Color.CYAN);
        for(int i = 0; i <= 4; ++i) {
        	if(i <= 4) {
        	g2d.fillRect(x, y, sqx, sqy);
        	y += height / 4;
            
        	// set conditions to avoid infinite loops and going past the window's border
        	if(y >= height) {
        		x += width / 4;
        		y = 0;
        		i = 0;
        		if(x >= width) {
        			i = 5;
        			}
        		}
        	}
        }
        // set/reset variables
        offx = 0; offy = sqy;
        for(int i = 0; i <= 4; ++i) {
        	if(i <= 4) {
        		g2d.fillRect(offx, offy, sqx, sqy);
        		offy += height / 4;
           	// set conditions to avoid infinite loops and going past the window's border
	
        		if(offy >= height) {
        			offx += width / 4;
        			offy = sqy;
        			i = 0;
        			
        			if(offx >= width) {
        				i = 5;
        			}
        		}
        	}
        }
        
    }
    
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChessBoard ex = new ChessBoard();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
