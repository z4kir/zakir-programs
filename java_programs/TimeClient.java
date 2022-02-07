

package com.zak.TimeSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.DataInputStream;


public class TimeClient {

    public static void main(String[] args) {
        String str = "";
        try (Socket socket = new Socket("localhost", 6632)) {


            InputStream input = socket.getInputStream();
            DataInputStream reader = new DataInputStream(input);

            OutputStream output = socket.getOutputStream();
            DataOutputStream writer = new DataOutputStream(output);

            System.out.println(reader.readUTF());

            ReadThread t3 = new ReadThread(socket, false);
            WriteThread t4 = new WriteThread(socket, false);
            t3.start();
            t4.start();
            while (true) {
                if (!t3.isAlive() && !t4.isAlive()) {
                    break;
                }

            }

            // while(!str.equalsIgnoreCase("stop2")){

            // System.out.println("Server :"+reader.readUTF());
            // str="Client :"+sc.nextLine();
            // writer.writeUTF(str);

            // }
            // sc.close();

        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Server not found: " + e.getMessage());
            e.printStackTrace();

        }
    }

}
    

