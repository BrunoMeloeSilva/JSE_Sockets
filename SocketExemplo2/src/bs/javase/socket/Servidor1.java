package bs.javase.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor1 {
	public static void main(String[] args) throws Exception {
		//Ouvindo a porta 8081
		ServerSocket serverSocket = new ServerSocket(8081);//Servidor de Socket aberto na porta 8081
		
		while(true){
			//faz uma copia em nova instancia do socket cliente ??
			//esperando conexao nesse ip e porta definidos
			Socket socket = serverSocket.accept();
			//apartir daqui deveria criar uma thread para cada conexao(socket), por questoes arquiteturais
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			//recuperando os dados da requisicao do cliente
			int int01 = dataInputStream.readInt();
			int int02 = dataInputStream.readInt();
			float resultado = (float) (int01+int02)/2;
			
			//Enviando a resposta pela rede
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeFloat(resultado);
			dataOutputStream.flush();
			
			socket.close();//fechou o cliente que se conectou com o server
		}
	}
}