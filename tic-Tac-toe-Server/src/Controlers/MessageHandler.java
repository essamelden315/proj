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
    public static boolean isStarted;

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

        String read;
        String msg;
        while (true) {
            try {

                read = dis.readLine();
                System.out.println(read);
                StringTokenizer st = new StringTokenizer(read, ",");

                msg = st.nextToken();

                if (msg.equals("login")) {
                    String email = st.nextToken();
                    String pass = st.nextToken();
                    result = DAL.check(email, pass, ip);
                    if (result != -1) {
                        new RequestHandler(clientSocket, result);
                    }

                    ps.println(result);
                } else if (msg.equals("signup")) {
                    String name = st.nextToken();

                    String email = st.nextToken();

                    String pass = st.nextToken();

                    result = DAL.addPlayer(name, email, pass);
                    ps.println(result);
                } else if (msg.equals("logout")) {
                    System.out.println("inside logout");
                    int id = Integer.parseInt(st.nextToken());

                    //RequestHandler.removeOFflinePlayer(id);
                    DataAccessLayer.logout(id);
                } else if (msg.equals("show")) {

                    ObjectOutputStream objectStream = new ObjectOutputStream(clientSocket.getOutputStream());

                    int senderId = Integer.parseInt(st.nextToken());
                    objectStream.writeObject(DataAccessLayer.retrieveOnlineList(senderId));

                } else if (msg.equals("playRequest")) {
                    int competitorId = Integer.parseInt(st.nextToken());
                    int senderId = Integer.parseInt(st.nextToken());
                    RequestHandler.sendMessage("play", competitorId, senderId);

                } else if (msg.equals("invitationRejected")) {
                    int competitorId = Integer.parseInt(st.nextToken());
                    int senderId = Integer.parseInt(st.nextToken());
                    RequestHandler.sendMessage("invitationRejected", competitorId, senderId);

                } else if (msg.equals("invitationAccept")) {
                    int competitorId = Integer.parseInt(st.nextToken());
                    int senderId = Integer.parseInt(st.nextToken());
                    RequestHandler.sendMessage("invitationAccept", competitorId, senderId);

                }else if(msg.equals("gameTurn")){
                     int competitorId = Integer.parseInt(st.nextToken());
                    int senderId = Integer.parseInt(st.nextToken());
                    int gameIndex = Integer.parseInt(st.nextToken());
                    RequestHandler.sendMessage("myGameTurn,"+gameIndex, competitorId, senderId);

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
