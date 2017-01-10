import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;


public class MultiThread {
    public static void main(String[] args)
    {
        MultiThread app = new MultiThread();
        app.makeGui();
    }

	void makeGui()
    {
		// Create the window.
		JFrame frame = new JFrame("Hello World Of Threading!");
		// Set the window size.
		frame.setMinimumSize(new Dimension(800, 800));
		// Close when you click the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Stack our components vertically.
		frame.setLayout(
			new BoxLayout(
				frame.getContentPane(),
				BoxLayout.Y_AXIS)
		);

        // There needs to be 3 image panels.
        ImagePanel panel1 = new ImagePanel();
		frame.add(panel1);

        ImagePanel panel2 = new ImagePanel();
    frame.add(panel2);

        ImagePanel panel3 = new ImagePanel();
    frame.add(panel3);

        // There needs to be 3 threads.
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                         panel1.setPath("flowers/flo1.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("flowers/flo2.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("flowers/flo3.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("flowers/flo4.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("flowers/flo5.jpg");
                        Thread.sleep(1000);

                    } catch (Exception ex) {
                        // if something goes wrong, print it and return.
                        // Things that can go wrong are setting the path to a file that does not exist, or is not a valid image.
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                        panel2.setPath("flowers/flo1.jpg");
                        Thread.sleep(2000);
                        panel2.setPath("flowers/flo2.jpg");
                        Thread.sleep(2000);
                        panel2.setPath("flowers/flo3.jpg");
                        Thread.sleep(2000);
                        panel2.setPath("flowers/flo4.jpg");
                        Thread.sleep(2000);
                        panel2.setPath("flowers/flo5.jpg");
                        Thread.sleep(2000);

                    } catch (Exception ex) {
                        // if something goes wrong, print it and return.
                        // Things that can go wrong are setting the path to a file that does not exist, or is not a valid image.
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                        panel3.setPath("flowers/flo1.jpg");
                        Thread.sleep(3000);
                        panel3.setPath("flowers/flo2.jpg");
                        Thread.sleep(3000);
                        panel3.setPath("flowers/flo3.jpg");
                        Thread.sleep(3000);
                        panel3.setPath("flowers/flo4.jpg");
                        Thread.sleep(3000);
                        panel3.setPath("flowers/flo5.jpg");
                        Thread.sleep(3000);

                    } catch (Exception ex) {
                        // if something goes wrong, print it and return.
                        // Things that can go wrong are setting the path to a file that does not exist, or is not a valid image.
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });

        t1.start();

        t2.start();

        t3.start();
		frame.setVisible(true);
	}
}
