package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("N�mero do quarto : ");
		int numeroquarto = sc.nextInt();
		System.out.print("Data de chegada (dd/MM/yyyy) : ");
		Date chegada = sdf.parse(sc.next());
		System.out.print("Data de sa�da (dd/MM/yyyy) : ");
		Date saida = sdf.parse(sc.next());
		
		if(!saida.after(chegada)) {
			System.out.println("Erro na reserva : data de sa�da deve ser depois da data de chegada");
		}
		else {
			Reserva reserva = new Reserva(numeroquarto, chegada, saida);
			System.out.print("Reserva : " + reserva);
			
			System.out.println();
			System.out.println("Entre com dados para atualizar a reserva : ");
			System.out.println("Data de chegada (dd/MM/yy) : ");
			chegada = sdf.parse(sc.next());
			System.out.println("Data de sa�da (dd/MM/yy) : ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(chegada.before(agora) || saida.before(agora)) {
				System.out.println("Erro de reserva: Datas de reserva para atualiza��o devem ser datas futuras");
			}
			else if(!saida.after(chegada)) {
				System.out.println("Erro de reserva: Data de sa�da deve ser depois da data de chegada");
			}
			else {
				reserva.atualizarDatas(chegada, saida);
				System.out.print("Reserva : " + reserva);
			}
			
		}
		
        sc.close();
	}

}
