import java.net.*;
import java.io.*;

public class CalcuServer{
	public static void main(String args[]){

		int x,y;
		int resultado = 0;
		int port = 1111;
		String a,b,c, tipo;
		ServerSocket ss = null;
		String url = "localhost";	
		
		try{
			ss = new ServerSocket(port);
			Socket s1 = ss.accept();
			
			InputStream is = s1.getInputStream();
			OutputStream os1 = s1.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos1 = new DataOutputStream(os1);

			System.out.println("Esperando el tipo de operacion...");
			tipo = dis.readUTF();
			System.out.println("El tipo de operacion es: " + tipo);

			System.out.println("Esperando al 1er numero...");
			a = dis.readUTF();
			
			System.out.println("El numero recibido es: " + a);
			
			System.out.println("Esperando el 2do numero...");
			b = dis.readUTF();
			
			System.out.println("El numero recibido es: " + b);
			x = Integer.parseInt(a);
			y = Integer.parseInt(b);

			if(tipo.equals("1")){
				resultado = x + y;
				
			}
			else if (tipo.equals("2")) {
				resultado = x + y;
			}
			else if (tipo.equals("3")) {
				resultado = x + y;
			}
			else if (tipo.equals("4")) {
				resultado = x + y;
			}
			else{
				System.out.print("Error");
			}

			System.out.println("El resultado es: " + resultado);
			dos1.writeUTF(Integer.toString(resultado));

			s1.close();
			dis.close();		
		}
		catch(IOException e){
			System.out.println("ERROR EN EL CLIENTE");	
		}	
	}
}