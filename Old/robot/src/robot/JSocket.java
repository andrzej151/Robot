package robot;

import java.io.*;
import java.net.*;

public class JSocket {
	private BufferedReader inFromUser;
	private DatagramSocket clientSocket;
	private InetAddress IPAddress;
	private static DatagramSocket dsocket;
	private int port;
	private int front, left, right, back;

	public JSocket(int port, String IP) throws SocketException, UnknownHostException {
		inFromUser = new BufferedReader(new InputStreamReader(System.in));
		clientSocket = new DatagramSocket();
		IPAddress = InetAddress.getByName(IP);
		this.port = port;
	}

	public void sendPacket(String data) throws IOException {
		byte[] sendData = new byte[1024];
		String sentence = data;
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		clientSocket.send(sendPacket);
	}

//	public void get(int port) {
//		// get
//
//		try {
//			dsocket = new DatagramSocket(port);
//		} catch (SocketException e1) {
//			// TODO Auto-generated catch block
//
//		}
//
//		byte[] buffer;
//		String msg;
//
//		buffer = new byte[2048];
//		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//
//		// Wait to receive a datagram
//		try {
//			dsocket.receive(packet);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//		}
//
//		// Convert the contents to a string, and display them
//		msg = new String(buffer, 0, packet.getLength());
//		System.out.println(msg);
//	}
//
//	dsocket.close();
//
//	}

	public void closeSocket() {
		clientSocket.close();
	}

}