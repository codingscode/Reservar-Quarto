package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroquarto;
	private Date chegada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroquarto, Date chegada, Date saida) {
		super();
		this.numeroquarto = numeroquarto;
		this.chegada = chegada;
		this.saida = saida;
	}

	public Integer getNumeroquarto() {
		return numeroquarto;
	}

	public void setNumeroquarto(Integer numeroquarto) {
		this.numeroquarto = numeroquarto;
	}

	public Date getChegada() {
		return chegada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diferenca = saida.getTime() - chegada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date chegada, Date saida) {
		this.chegada = chegada;
		this.saida = saida;	
	}
	
	@Override
	public String toString() {
	   return "Quarto "
			   + numeroquarto
			   + ", chegada : "
			   + sdf.format(chegada)
			   + ", saida : "
			   + sdf.format(saida)
			   + ", "
			   + duracao()
			   + " noites";	
	}
	
}
