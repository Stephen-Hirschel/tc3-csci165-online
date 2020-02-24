import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ShowMinMax extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public ShowMinMax() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(520, 243);
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
        // fill the window with a 50x20 grid of grey squares
        int x = 0, y = 0;
        g2d.setColor(new Color(128, 128, 128));
        for(int i = 0; i < 1000; i++) {
        	if(i % 50 != 0 && i != 0) {
        	g2d.fillRect(x, y, 10, 10);
        	x += 10;
        	}
        	if(i % 50 == 0 && i != 0) {
        		g2d.fillRect(x, y, 10, 10);
        		y += 10;
        		x = 0;
        	}
        	if(i == 999) {
        		g2d.fillRect(490, 190, 10, 10);
        	}
        }
    // initialize array for the numbers list
		int[][] matrix = new int[50][20];
    // access the number list and fill the array with it's contents
    try {
			File numFile = new File("number_list.txt");
			Scanner scanner = new Scanner(numFile);
			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 20; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			scanner.close();
		} // failsafes for file errors
		catch(FileNotFoundException fnf) {
			System.out.println("ERROR: File Not Found");
		}
    // initialize arrays to hold coordinates for maximum and minimum values
		int max = matrix[0][0];
		int min = matrix[0][0];
    // loop through the array
		for(int i = 0; i < matrix.length; i++) {
			int[] coordsmax = new int[2];
			int[] coordsmin = new int[2];
			for(int j = 0; j < matrix[0].length; j++) {



				if(j < 20) {
					if(matrix[i][j] > max) {
						max = matrix[i][j];
						coordsmax[0] = i;
						coordsmax[1] = j;
					}

					else if(matrix[i][j] < min) {
							min = matrix[i][j];
							coordsmin[0] = i;
							coordsmin[1] = j;
					}
					}
					if(j == 19) {
						if(i < 49) {
						g2d.setColor(Color.RED);
						g2d.fillRect(coordsmax[0] * 10, coordsmax[1] * 10, 10, 10);
						g2d.setColor(Color.GREEN);
						g2d.fillRect(coordsmin[0] * 10, coordsmin[1] * 10, 10, 10);
						}
						if(i == 49) {
							g2d.setColor(Color.RED);
							g2d.fillRect(coordsmax[0] * 10, coordsmax[1] * 10, 10, 10);
							g2d.setColor(Color.GREEN);
							g2d.fillRect(coordsmin[0] * 10, coordsmin[1] * 10, 10, 10);
						}
						if(i < 49) {
						max = matrix[i + 1][0];
						min = matrix[i + 1][0];

							}

						else {
							max = matrix[i][0];
							min = matrix[i][0];
						}

					}


				}
			}
    }






    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowMinMax ex = new ShowMinMax();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
