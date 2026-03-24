package com.bonbon;

public class NetworkService {
    public String fetchData(String host, int port, String path){
        StringBuilder response = new StringBuilder();
        //socket
        try(Socket socket = new Socket(host, port)){
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader responseReader = new BufferedReader(new InputStreamReader());

            System.out.print("Connected to server...");
            //send an HTTP request: Method, Patch, Protocol version, Host header , b1

            requestWriter.println("GET" + path + "HTTP?1.1");
            requestWriter.println("Host:" + host);
            requestWriter.println("Connection: close");
            requestWriter.println();
            
            System.out.println("\n --- HTTP resoponse Headers ---");

            String line;
            while((line = responseReader.readLine()) != null){
                response.append(line);
            }



        }catch(IOException e){
            e.printStackTrace();
        }

        return response.toSting();
    }
    
}
