import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    JTextField ipAd;

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        ipAd=new JTextField("input server ip here");

        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.setVisible(false);
        sendButton.addActionListener(new SendButtonListener());
        incoming.append("Please Connect\n");
        incoming.append("Send Button will be visible after connection with server\n");

        mainPanel.add(ipAd);
        JButton conButton= new JButton("Connect");
        conButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpNetworking();

                Thread readerThread = new Thread(new IncomingReader());
                readerThread.start();
                sendButton.setVisible(true);
            }
        });
        mainPanel.add(conButton);
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);


        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(650, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            // We're using localhost for testing
            sock = new Socket(ipAd.getText(), 1337);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            incoming.append("Networking established.\n");
        } catch (IOException ex) {
            ex.printStackTrace();
            incoming.append("Error While connecting\n");
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                // Actually write. Writer is chained to input stream from socket.
                // So this is actually going out to the server.
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable {
        // Stay in the loop and read a line at a time.
        // Print out to the scrolling text area with a newline added.
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception ex) { ex.printStackTrace();}
        }

    }
    public static void main(String[] args) {
        new ChatClient().go();
    }

}