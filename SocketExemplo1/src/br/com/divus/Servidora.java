package br.com.divus;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidora {
	public static void main(String[] args) throws IOException {
		System.out.println("Criando servidor...");
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("Servidor Criado.");
		while (true) {
			System.out.println("Aguardando conexao...");
			Socket socket = serverSocket.accept();
			System.out.println("Conexao realixada.");
			
			new Tarefa(socket).start();
		}
	}
	
}

class Tarefa extends Thread{
	
	Socket socket;
	
	public Tarefa(Socket socket) {
		System.out.println("Nova Thread criada para atendimento ao cliente.");
		this.socket = socket;
	}
	
	@Override
	public void run() {
		System.out.println("Iniciando atendimento ao cliente...");
		try {
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String s = in.readUTF();
			System.out.println("Conteudo Recebido: "+s.toString());
		} catch (IOException e) {e.printStackTrace();}
	}
}
