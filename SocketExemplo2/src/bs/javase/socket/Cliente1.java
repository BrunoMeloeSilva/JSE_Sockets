package bs.javase.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente1 {
	public static void main(String[] args) throws Exception{
		int x=104;
		int y=335;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		//estabelecendo conexao com servidor
		Socket socket = new Socket("localhost", 8081);
		//obtendo o stream de saida para rede
		outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		//enviando dados pela rede
		dataOutputStream.writeInt(x);//pega o valor x(104) e converte num stream de bits e joga na mao do outputStream
		dataOutputStream.writeInt(y);
		dataOutputStream.flush();
		
		//obtendo o stream de entrada da rede
		inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		//recebendo resposta pela rede
		float resultado = dataInputStream.readFloat();
		//ao fechar o socket os streams de entrada e saida tambem serao fechados
		socket.close();
		System.out.println("Média entre "+x+" e "+y+" : "+resultado);
	}
}