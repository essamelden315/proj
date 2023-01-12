/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageHandler extends Thread {

    DataInputStream dis;
    DataOutputStream dos;
    PrintStream ps;
    DataAccessLayer DAL = new DataAccessLayer();
    String ip;
    int result;
    Socket clientSocket;
    //Thread thread;
    //ServerSocket serverSocket;
    boolean serverIsOn = true;

    public MessageHandler(Socket client) {
        try {
            clientSocket = client;
            dis = new DataInputStream(client.getInputStream());
            ps = new PrintStream(client.getOutputStream());
            ip = clientSocket.getInetAddress().toString();
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            String read;
            String msg;
            try {

                read = dis.readLine();
                System.out.println("inside server " + read);
                StringTokenizer st = new StringTokenizer(read, ",");

                msg = st.nextToken();
                System.out.println(msg);
                if (msg.equals("login")) {
                    String email = st.nextToken();
                    String pass = st.nextToken();
                    result = DAL.check(email, pass, ip);
                    if (result != -1) {
                        new RequestHandler(clientSocket, result);
                    }
                    System.out.println("res=" + result);
                    ps.println(result);
                } else if (msg.equals("signup")) {
                    String name = st.nextToken();
                    System.out.println(name);
                    String email = st.nextToken();
                    System.out.println(email);
                    String pass = st.nextToken();
                    System.out.println(pass);
                    result = DAL.addPlayer(name, email, pass);
                    ps.println(result);
                } else if (msg.equals("logout")) {
                    int id = Integer.parseInt(st.nextToken());
                    DataAccessLayer.logout(id);
                    RequestHandler.clinetsHashMap.remove(id);

                } else if (msg.equals("show")) {

                    ObjectOutputStream objectStream = new ObjectOutputStream(clientSocket.getOutputStream());

                    System.out.println("inside show players");
                    int senderId = Integer.parseInt(st.nextToken());
                    objectStream.writeObject(DataAccessLayer.retrieveOnlineList(senderId));
                } else if (msg.equals("playRequest")) {
                    int competitorId = Integer.parseInt(st.nextToken());
                    int senderId = Integer.parseInt(st.nextToken());
                    RequestHandler.sendMessage("Do you want to play?", competitorId, senderId);

                }
            } catch (IOException ex) {
                Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
