import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerManager implements ActionListener {

	ArrayList<Conta> data;

	public void vinculateData(ArrayList<Conta> data) {
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0;i<data.size();i++) {
			data.get(i).saving.rise();
		}
	}
	
}
