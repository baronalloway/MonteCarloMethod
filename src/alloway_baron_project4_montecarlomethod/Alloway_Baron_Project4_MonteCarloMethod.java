/*
 BARON ALLOWAY
 Mr. Lim
 ICS4U1-1
 Project 4 Part 2
 February 6, 2014
 */
package alloway_baron_project4_montecarlomethod;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import quicktime.qd3d.math.Point2D;

/**
 *
 * @author Baron
 */
public class Alloway_Baron_Project4_MonteCarloMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //creating a new panel
        HelloPanel myPanel = new HelloPanel();
        //creating the JFrame in which the program will run - give it a title
        JFrame myFrame = new JFrame("Calculation of Pi From the Monte Carlo Method");
        //setting the frame to visible
        myFrame.setVisible(true);
        //making the frame not resizable
        myFrame.setResizable(false);
        //setting the size of the frame to the width and height of our panel
        myFrame.setSize(myPanel.width, myPanel.height);
        //setting the content in the frame to be the panel
        myFrame.setContentPane(myPanel);
        //setting it so that the program closes when we hit the x
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //defining some variables to be used in the calculations
        double numDartsThrown = 0;
        double numDartsInside = 0;
        double pi;
        double pointChosen;
        double randomX;
        double randomY;

        //run this loop until we have thrown 2000 darts
        while (myPanel.running) {
            //run this loop 2000 times, then start over again when we come back in the true loop
            for (int a = 0; a < 2000; a++) {
                //choose a random number for our x value
                randomX = (Math.random());
                //choose a random number for our y value
                randomY = (Math.random());
                //increment the number of darts thrown (we threw a dart)
                numDartsThrown++;
                //if the dart we threw fell inside the circle
                if (insideCircle(randomX, randomY)) {
                    //increment the number of darts that are inside the circle
                    numDartsInside++;
                }
                //adding the points we made to our list of points, and passing in where they are indexed
                myPanel.setPoints(randomX, randomY, a);
                //setting the number of darts thrown (we just threw a dart)
                myPanel.setDarts(numDartsThrown);
                //sleeping the thread for 40 seconds
                Thread.sleep(20);
                //by definition of the Monte Carlo Method, pi is the number of darts landed inside the circle / the total darts thrown times 4 
                pi = (numDartsInside) / (numDartsThrown) * 4;
                //set pi to our recalculated value
                Pi.setPi(pi);
                //update the GUI to match what has just happened
                myPanel.repaint();
            }
            //we have thrown 2000 darts, and no longer need to run the program
            myPanel.running = false;
        }
        //repaint the panel
        myPanel.repaint();

    }

    //to find out if our points are in the circle
    public static boolean insideCircle(double randomX, double randomY) {
        //defining variables
        boolean inside = false;
        double together;
        //square the x value
        randomX = Math.pow(randomX, 2);
        //square the y value
        randomY = Math.pow(randomY, 2);
        //add them together
        together = randomX + randomY;
        //root them once they are together
        Math.sqrt(together);
        //essentially, if (root) Xsquared + Ysquared <= radius, they are in the circle
        if (together <= 1) {
            //they are inside the circle, set it to true
            inside = true;
        }
        //return if they are in the circle or not
        return inside;
    }

}
