import java.util.Timer;
import java.util.TimerTask;

public class Savings extends Conta {
	
	protected double rentability = 0.005;
	
	public Savings(String name, double money, int id) {
		super(name, money, id);
		// TODO Auto-generated constructor stub
	}
	
	
	public void rise() {
		this.money += rentability*this.money;
	}

	
	
	
}
