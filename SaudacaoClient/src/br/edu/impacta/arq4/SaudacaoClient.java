package br.edu.impacta.arq4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SaudacaoClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String nome = JOptionPane.showInputDialog("Qual é o seu nome:");
		Socket soc = new Socket("127.0.0.1", 5888);
		InputStream is = soc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = soc.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println(nome);
		pw.flush();
		String resposta = br.readLine();
		JOptionPane.showMessageDialog(null, "Resposta do servidor: " + resposta);
		pw.close();
		br.close();
		soc.close();
	}
}
