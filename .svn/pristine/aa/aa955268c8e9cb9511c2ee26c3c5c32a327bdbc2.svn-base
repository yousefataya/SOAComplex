package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.Socket;

public class EmpClient {
    public static void main(String[] args) {
        try {
            Socket socket;
            String HOST = "10.10.78.227";
            int PORT = 1987;
            String msg = "02001234567890123456   71    C00000000250000C00000000000000C00000000250000JOD1010060937171010090937653405728309653405002211     6534050240204500412400001                     JIB MARKA Shamaliya 2n DEFAULT REGIOJO";
            if(args.length > 0 && args.length <3){
                HOST = args[0];
                PORT = Integer.parseInt(args[1]);
            }else if (args.length == 3){
                HOST = args[0];
                PORT = Integer.parseInt(args[1]);
                msg = args[2];
            }
           
            try {
                socket = new Socket(HOST, PORT);
            } catch (IOException ioe) {
                System.out.println(">>>");
                System.out.println(ioe.getMessage());
                System.out.println(">>>");
                throw ioe;
            }
            System.out.println("sending data: ");
            OutputStream os = socket.getOutputStream();
            byte[] b = msg.getBytes();
            for (int i = 0; i < b.length; i++) {
                os.write(b[i]);
            }
            os.flush();
            socket.shutdownOutput();
            System.out.println("receiving data");
            BufferedReader soc_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String successCode = soc_in.readLine();
            System.out.println("response data: " + successCode);
            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}


