package br.edu.impacta.arq4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaudacaoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5888);
		while(true) {
			System.out.println("Servidor esperando conexão...");
			Socket soc = ss.accept();
			System.out.println("Conectado!");
			InputStream is = soc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			String nome = br.readLine();
			Date data = new Date();
			SimpleDateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat fmtHora= new SimpleDateFormat("hh:mm:ss");
			String msg = "Olá " + nome + "! ";
			msg += " O relógio deste servidor indica que hoje é " + fmtData.format(data);
			msg += " e o horário é " + fmtHora.format(data);
			pw.println(msg);
			pw.flush();
			pw.close();
			br.close();
			soc.close();
		}
	}
}
