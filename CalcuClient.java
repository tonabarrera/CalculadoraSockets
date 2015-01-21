import java.net.*;
import java.io.*;

public class CalcuClient{

	public static void main(String args[]){

		String cad1,cad2,cad3;
		String resultado = "";
		String url = "localhost";
		int port = 1111;

		try{
			Socket sc1 = new Socket(url, port);
			InputStreamReader isr = new InputStreamReader( System.in );
			InputStream is = sc1.getInputStream();
			BufferedReader bf = new BufferedReader(isr);	
			OutputStream os1 = sc1.getOutputStream();
			DataOutputStream dos1 = new DataOutputStream(os1);
			DataInputStream dis = new DataInputStream(is);

			System.out.println("Que tipo de operacion quieres");
			System.out.println("1)Suma 2)Resta 3)Multiplicacion 4)Division");
			cad3 = bf.readLine();
			dos1.writeUTF(cad3);

			System.out.println("Dame un numero para enviar al servidor: ");
			cad1 = bf.readLine();
			dos1.writeUTF(cad1);

			System.out.println("Dame un otro numero para enviar al servidor: ");
			cad1 = bf.readLine();
			dos1.writeUTF(cad1);

			resultado = dis.readUTF();
			System.out.println("El resultado es: " + resultado);

			dos1.flush();	
			dos1.close();
		}
		catch(IOException e){	
			System.out.println("ERROR: NO SE ENCONTRO EL SERVIDOR");
		}
	}	
}