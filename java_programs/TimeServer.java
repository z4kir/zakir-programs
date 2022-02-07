


package com.zak.TimeSocket;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.InputStream;
import java.io.DataInputStream;

class ReadThread extends Thread {
    private Socket socket;
    private boolean serverORclient;

    ReadThread(Socket socket, boolean serverORclient) {
        this.socket = socket;
        this.serverORclient = serverORclient;

    }

    public void run() {

        try {
            InputStream ip = socket.getInputStream();
            DataInputStream Reader = new DataInputStream(ip);
            String read = "";
            while (!read.equalsIgnoreCase("stop")) {
                read = Reader.readUTF();
                if (serverORclient) {
                    System.out.println("CLient :" + read);
                } else {
                    System.out.println("Server :" + read);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // while (!Reader.readUTF().equalsIgnoreCase("stop")) {

        //     System.out.println("CLient :"+Reader.readUTF());


        // }

    }
}

class WriteThread extends Thread {
    private Socket socket;
    private boolean serverORclient;

    WriteThread(Socket socket, boolean serverORclient) {
        this.socket = socket;
        this.serverORclient = serverORclient;

    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        String str = "";
        try {
            OutputStream op = socket.getOutputStream();
            DataOutputStream Writer = new DataOutputStream(op);
            while (!str.equalsIgnoreCase("stop")) {
                if (serverORclient) {
                    str = sc.nextLine();
                    if (!str.isEmpty()) {
                        System.out.println("Server :" + str);
                        Writer.writeUTF(str);
                    }
                } else {
                    str = sc.nextLine();
                    if (!str.isEmpty()) {
                        System.out.println("Client :" + str);
                        Writer.writeUTF(str);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


public class TimeServer {

    public static void main(String[] args) {
        String str = "";
        try (ServerSocket serversocket = new ServerSocket(6632)) {
            System.out.println("Server is listening on port: 6632");
            while (true) {
                Socket socket = serversocket.accept();
                // while(str.equalsIgnoreCase("stop2")){
                OutputStream op = socket.getOutputStream();
                DataOutputStream Writer = new DataOutputStream(op);

                InputStream ip = socket.getInputStream();
                DataInputStream Reader = new DataInputStream(ip);

                LocalDateTime dt = LocalDateTime.now();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter df1 = DateTimeFormatter.ofPattern("h:m:s");
                String date = dt.format(df);
                String Time = dt.format(df1);
                String datenTime = "Date-" + date + "\nTime-" + Time;


                Writer.writeUTF(datenTime);

                ReadThread t1 = new ReadThread(socket, true);
                WriteThread t2 = new WriteThread(socket, true);
                t1.start();
                t2.start();
                while (true) {
                    if (!t1.isAlive() && !t2.isAlive()) {
                        break;
                    }

                }

                // while (!str.equalsIgnoreCase("stop")) {

                //     str="Server :"+sc.nextLine();
                //     Writer.writeUTF(str);
                //     System.out.println("CLient :"+Reader.readUTF());

                // }
                // sc.close();


            }

        } catch (IOException e) {
            System.out.println("Server expection: " + e.getMessage());
            e.printStackTrace();

        }
    }
}