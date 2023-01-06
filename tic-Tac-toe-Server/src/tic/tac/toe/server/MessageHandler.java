/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import Controlers.DataAccessLayer;
import java.util.StringTokenizer;
class MessageHandler extends Thread
{
    DataInputStream dis;
    PrintStream prints;
    DataAccessLayer DAL = new DataAccessLayer();
    //static Vector<MessageHandler> clientsVector =new Vector<MessageHandler>();
    String ip;
    int result;
    public MessageHandler(Socket cs)
    {
        try {
            dis = new DataInputStream(cs.getInputStream());
            prints = new PrintStream(cs.getOutputStream());
            ip=cs.getInetAddress().toString();
            //MessageHandler.clientsVector.add(this);
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run()
    {
        while(true)
        {
            String read;
            String msg;
            try {
                read = dis.readLine();
                StringTokenizer st = new StringTokenizer(read,",");
		
                    msg=st.nextToken();
                if(msg.equals("login"))
                {
                    String email =st.nextToken();
                    String pass =st.nextToken();
                    result=DAL.check(email,pass,ip);
                    prints.println(result);
                }else if(msg.equals("logout")){
                    int id =Integer.parseInt(st.nextToken());
                   result= DAL.logout(id);
                   prints.println(result);
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}