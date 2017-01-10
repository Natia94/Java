import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;


public class SingleThread {
    public static void main(String[] args)
    {
        SingleThread app = new SingleThread();
        app.makeGui();
    }

	void makeGui()
	{
		try{
		// Create the window.
		JFrame frame = new JFrame("Hello World Of Threading!");
		// Set the window size.
		frame.setMinimumSize(new Dimension(800, 400));
		// Close when you click the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Stack our components vertically.
		frame.setLayout(
			new BoxLayout(
				frame.getContentPane(),
				BoxLayout.Y_AXIS)
		);

        ImagePanel panel1 = new ImagePanel();
	frame.add(panel1);

        ImagePanel panel2 = new ImagePanel();
        frame.add(panel2);
        
        ImagePanel panel3 = new ImagePanel();
        frame.add(panel3);


        while (true)
        {

        panel1.setPath("flowers/flo1.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo2.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo3.jpg");
        panel2.setPath("flowers/flo1.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo4.jpg");
        panel3.setPath("flowers/flo1.jpg");
        Thread.sleep(1000);
        panel2.setPath("flowers/flo2.jpg");
        panel1.setPath("flowers/flo5.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo1.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo2.jpg");
        panel2.setPath("flowers/flo3.jpg");
        panel3.setPath("flowers/flo2.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo3.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo4.jpg");
        panel2.setPath("flowers/flo4.jpg");
        Thread.sleep(1000);
        panel1.setPath("flowers/flo5.jpg");
        panel3.setPath("flowers/flo3.jpg");
        Thread.sleep(1000);
   
       
        
        // To set the image to a file named `wts1.jpg` in the same directory:
        // panel1.setPath("wts1.jpg");
        //
        // You can name your images whatever you want!

		// Show our window.
		frame.setVisible(true);



	}

}catch(Exception ex)
{
System.out.println(ex.getMessage());
return;

}

}
}
