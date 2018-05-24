package org.eclipse.om2m.ipu.sample;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Yeelight {
    private static final String CMD_HSV = "{\"id\":%id,\"method\":\"set_hsv\",\"params\":[%value, 100, \"smooth\", 1000]}\r\n";
    private static final String CMD_ON = "{\"id\":%id,\"method\":\"set_power\",\"params\":[\"on\",\"smooth\",500]}\r\n" ;
    private static final String CMD_OFF = "{\"id\":%id,\"method\":\"set_power\",\"params\":[\"off\",\"smooth\",500]}\r\n";

    private static int mCmdId = 0;
    private PrintWriter out;

    public PrintWriter getOut() {
		return out;
	}

	public static String change(boolean on){
        String cmd;
        if (on){
            cmd = CMD_ON.replace("%id", String.valueOf(++mCmdId));
        }else {
            cmd = CMD_OFF.replace("%id", String.valueOf(++mCmdId));
        }
        return cmd;
    }

    private static String parseColorCmd(int color){
        return CMD_HSV.replace("%id",String.valueOf(++mCmdId)).replace("%value",String.valueOf(color));
    }

    public static String[] getPortandHost(String msg){
        String[] lines = msg.trim().split("\n");
        String ip_port = lines[4].split("/")[2];
        String[] hosts = ip_port.split(":");
        hosts[1] = hosts[1].substring(0,hosts[1].length()-1);
        return hosts;

    }

    public static boolean isLiftTurnOn(String msg){
        String[] lines = msg.trim().split("\n");
        String power = lines[10].split(":")[1];
        power = power.substring(1, power.length()-1);
        System.out.println("POWER"+power.length());

        return power.equals("on");


    }

    public Yeelight() {
        byte[] sendData;
        byte[] receiveData = new byte[1024];
        //Transformation temperatureTransformation = new Transformation();
        DatagramSocket clientSocket = null;

    /* Create the search request */
        String NL = "\r\n";
        StringBuilder mSearch = new StringBuilder();
        mSearch.append("M-SEARCH * HTTP/1.1").append(NL);
        mSearch.append("HOST: 239.255.255.250:1982").append(NL);
        mSearch.append("MAN: \"ssdp:discover\"").append(NL);
        mSearch.append("ST: wifi_bulb").append(NL);
        try {

    /* Send the request */
            sendData = mSearch.toString().getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    sendData, sendData.length, InetAddress.getByName("239.255.255.250"), 1982);
            clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(20000);
            clientSocket.send(sendPacket);

    /* Receive one response */

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String msg = new String(receivePacket.getData());

            String[] hostAndPost = getPortandHost(msg);
            int port_ = Integer.parseInt(hostAndPost[1]);

            Socket clientSocketTcp = new Socket(hostAndPost[0], port_);
            out = new PrintWriter(clientSocketTcp.getOutputStream(), true);


        } catch (Exception e) {
            e.printStackTrace();

        }
        if (clientSocket != null)
            clientSocket.close();
    }

    public static void main(String[] args){
        try {
            //Device device = null;
            //new Thread( new MyMonitor()).start();
            //int temp = MyMonitor.MyHandler.temperature;
            //System.out.println("TEMPERATURE"+temp);

            byte[] sendData;
            byte[] receiveData = new byte[1024];
            //Transformation temperatureTransformation = new Transformation();
            DatagramSocket clientSocket = null;

    /* Create the search request */
            String NL = "\r\n";
            StringBuilder mSearch = new StringBuilder();
            mSearch.append("M-SEARCH * HTTP/1.1").append(NL);
            mSearch.append("HOST: 239.255.255.250:1982").append(NL);
            mSearch.append("MAN: \"ssdp:discover\"").append(NL);
            mSearch.append("ST: wifi_bulb").append(NL);
            try {

    /* Send the request */
                sendData = mSearch.toString().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, InetAddress.getByName("239.255.255.250"), 1982);
                clientSocket = new DatagramSocket();
                clientSocket.setSoTimeout(20000);
                clientSocket.send(sendPacket);

    /* Receive one response */

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String msg = new String(receivePacket.getData());

                String[] hostAndPost = getPortandHost(msg);
                int port_ = Integer.parseInt(hostAndPost[1]);

                Socket clientSocketTcp = new Socket(hostAndPost[0], port_);
                PrintWriter out = new PrintWriter(clientSocketTcp.getOutputStream(), true);

                //if(!isLiftTurnOn(msg))
                out.println(change(false));

                clientSocketTcp.close();

/*
                int duration;
                int i =0;
                while(true) {

                    Thread.sleep(1000);
                    temp = MyMonitor.MyHandler.temperature;
                    duration = temperatureTransformation.transform(temp);
                    out.println(parseColorCmd(i));
                    i = (i+ duration)%360;

                    }
*/
            } catch (Exception e) {
                e.printStackTrace();

            }
            assert clientSocket != null;
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
