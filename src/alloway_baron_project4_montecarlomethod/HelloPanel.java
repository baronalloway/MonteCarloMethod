/*
 BARON ALLOWAY
 Mr. Lim
 ICS4U1-1
 Project 4 Part 2
 February 6, 2014
 */
package alloway_baron_project4_montecarlomethod;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Baron
 */
public class HelloPanel extends JPanel {

    //defining variables
    int width = 600;
    int height = 600;
    //creating a new Circle
    Circle target = new Circle();
    //creating a new Square
    Square mySquare = new Square();
    //creating our 2D array of all our points
    double[][] myPoints = new double[2000][2];
    int dartsThrown;
    boolean running = true;

    //every time we create a new Panel    
    HelloPanel() {
        //set the size to the width and height
        this.setSize(width, height);
        //set the panel visible
        this.setVisible(true);
        //request the focus of the panel
        this.requestFocus();

    }

    //paint the GUI
    public void paintComponent(Graphics g) {
        //if the calculation is complete
        if(running == false)
        {
            //set the font to the font that we would like
            g.setFont(new Font("Arial", Font.BOLD, 40));
            //tell the user what Pi is
            g.drawString("Pi from this Attempt is " + Pi.getPi(), 0, 250);
        }
        //otherwise
        else
        {
        //draw our circle in the centre of our panel
        g.drawOval((width / 2) - (target.getRadius()), (height / 2) - (target.getRadius()), target.getRadius() * 2, target.getRadius() * 2);
        //draw a string informing the user of pi
        g.drawString("PI IS: " + Pi.getPi(), 450, 575);
        //draw a string informing the user of the number of darts thrown
        g.drawString("Darts Thrown: " + dartsThrown, 80, 570);
        //draw a square in the middle perfectly touching our circle, as needed
        g.drawRect((width / 2) - (mySquare.getWidth() / 2), (height / 2) - (mySquare.getHeight() / 2), mySquare.getWidth(), mySquare.getHeight());
        //cycle through this loop as many times as we have points
        for (int i = 0; i < myPoints.length; i++) {
            //draw a pixel in the relative location to where our point would be on the circle with radius 1, to visually represent it
            g.fillRect((int) (myPoints[i][0] * 500) + (mySquare.getWidth() / 10), (int) (myPoints[i][1] * 500) + (mySquare.getHeight() / 10), 1, 1);
        }
        }

    }

    //set the points that are passed into here after the calculations to be graphically represented
    public void setPoints(double randomX, double randomY, int i) {
        //set the x coordinate (we use a 2D array)
        myPoints[i][0] = randomX;
        //set the y coordinate
        myPoints[i][1] = randomY;

    }

    //set the number of darts that have been thrown
    public void setDarts(double dartsThrownIn) {
        //set the number of darts thrown given what is passed in
        dartsThrown = (int) dartsThrownIn;
    }

}
