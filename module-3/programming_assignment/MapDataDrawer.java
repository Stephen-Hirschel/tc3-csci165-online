
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

class MapDataDrawer extends JPanel {
	
	public static int[][] pathMap;
	public static int[][] datMap;
    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    
    public MapDataDrawer() {
        initUI();
        
    }

    private void initUI() {
        window.add(this);
        window.setTitle("Colorado Topographical Map");
        window.setSize(861, 520);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        
    }


	public static int[][] ArrayFiller(String filename, int rows, int cols) {

		int[][] mapArray = new int[rows][cols];
		try {
		File numFile = new File(filename);
		Scanner scanRay = new Scanner(numFile);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				mapArray[i][j] = scanRay.nextInt();
			}
		}
			scanRay.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("Error: File Not Found!");
		}
		return mapArray;
	}
	private static int findMin(int[][] array) {		 
			int min;
			min = array[0][0];

			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[0].length; j++) {
					if(array[i][j] < min) {
						min = array[i][j];
					}
				}
			}
			return min;
	}
	private static int findMax(int[][] array) {
		int max;
		max = array[0][0];

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		return max;
		
	}
	
	public static int indexOfMinRow(int[][] array, int col) {
		int min = array[0][col];
		int mindex = 0;
		for(int i = 0; i < array.length; i++ ) {
			if(array[i][col] < min) {
				min = array[i][col];
				mindex = i;
			}
			
		}
		return mindex;
	}
	private static int getRandom(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	// add your own drawing intructions in this method
    private void drawMap(Graphics g) {
       
        Graphics2D g2d = (Graphics2D) g;
             
        int[][] mapDat = new int[480][844];
        int[][] pathMap = new int[844][480];
        try {
        	File mapFile = new File("Colorado_844x480.dat");
        	Scanner s = new Scanner(mapFile);
        
        for(int r = 0; r < mapDat.length; r++) {
        	for(int c = 0; c< mapDat[0].length; c++) {
        		mapDat[r][c]= s.nextInt();
                pathMap[c][r]= mapDat[r][c];
        		int max = 4334;
                int min = 1010;
                float range = max - min;
        		float val = mapDat[r][c];
        		float diff = (val - min);
        		float divs = (diff / range);
        		float shady = divs * 255;
        		int shade = Math.round(shady);
        		g2d.setColor(new Color(shade, shade, shade));
        		g2d.fillRect(c, r, 1, 1);
        	}	
        	}
        s.close();
        }
        catch(FileNotFoundException fnf) {
        	System.out.println("Error: File Not Found");
        }
        g2d.setColor(Color.RED);
        int total = 0;
        for(int k = 0; k < 40; k++) {
        int row = getRandom(0, 480);

        int start = pathMap[0][row];
    	int randomizer;
        g2d.fillRect(row, 0, 1, 1);
    	total = 0;
        for(int i = 1; i < pathMap.length; i++) {
    		int ne;
    		int e;
    		int se;
    		if(row < 1) {
    			ne = pathMap[i][row];
    		}
    		else {
    		ne = pathMap[i][row - 1];
    		}
    		e = pathMap[i][row];
    		if(row == 479) {
    			se = pathMap[i][row];
    		}
    		else {
    		se = pathMap[i][row + 1];
    		}
    		int upr = start - ne;
    		int r = start - e;
    		int dnr = start - se;
    		int a = Math.abs(upr);
    		int b = Math.abs(r);
    		int c = Math.abs(dnr);
    		if(a == b) {
    			g2d.fillRect(i, row, 1, 1);
				total += b;
				start = pathMap[i][row];
    		}
    		if (b == c) {
    			g2d.fillRect(i, row, 1, 1);
				total += b;
				start = pathMap[i][row];
    		}
    		if(a == c) {
    			randomizer = getRandom(0,2);
    			if(randomizer == 0) {
    			g2d.fillRect(i, row - 1, 1,	1);
				total += a;
				if(row == 0) {
					start = pathMap[i][row];
				}
				else {
				start = pathMap[i][row - 1];
				row = row - 1;
				}
				if(randomizer == 1) {
					g2d.fillRect(i, row + 1, 1, 1);
    				total += c;
    				if(row == 480) {
    					start = pathMap[i][row];
    				}
    				else {
    				start = pathMap[i][row + 1];
    				row = row + 1;
    				}
				}
    		}
    		}
    		else if(a < b) {
    			if(a < c){
    				g2d.fillRect(i, row - 1, 1,	1);
    				total += a;
    				if(row == 0) {
    					start = pathMap[i][row];
    				}
    				else {
    				start = pathMap[i][row - 1];
    				row = row - 1;
    				}
    			}
    			else {
    				g2d.fillRect(i, row + 1, 1, 1);
    				total += c;
    				if(row == 480) {
    					start = pathMap[i][row];
    				}
    				else {
    				start = pathMap[i][row + 1];
    				row = row + 1;
    				}
    			}
    		}
    		else if(b < c){
    				if(b < a) {
    				g2d.fillRect(i, row, 1, 1);
    				total += b;
    				start = pathMap[i][row];
    				}
    		}
    			
    			if(c < b) {
    				g2d.fillRect(i, row + 1, 1, 1);
    				total += c;
    				if(row == 479) {
    					start = pathMap[i][row];
    				}
    				else {
    				start = pathMap[i][row + 1];
    				row = row + 1;
    				};
    			}
    		
    	} 
    	
    }
    	System.out.println(total);
    }
		
		
    

    public static void main(String[] args) {

		System.out.print("\nPlease enter the name of the data file: ");
		Scanner datFile = new Scanner(System.in);
		String fileName = datFile.nextLine();		
		int a = fileName.indexOf("_");
		int b = fileName.indexOf("x");
		int c = fileName.indexOf(".");

		String colString = fileName.substring(a + 1, b);
		String rowString = fileName.substring(b + 1, c);
	
		int cols = Integer.valueOf(colString);
		int rows = Integer.valueOf(rowString);
		datMap = ArrayFiller(fileName, rows, cols);
		pathMap = ArrayFiller(fileName, cols, rows);
		datFile.close();
		System.out.println("\nThe lowest point is: " + findMin(datMap));
		System.out.println("\nThe highest point is: " + findMax(datMap));
		System.out.println("\nThe index of the lowest elevation in that column is: " + (indexOfMinRow(datMap, 16)));
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MapDataDrawer ex = new MapDataDrawer();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
