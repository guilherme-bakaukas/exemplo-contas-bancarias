import java.util.Random;

import javax.swing.Timer;

import java.util.ArrayList;

public class Functions {
	

    private static ArrayList<Conta> data = new ArrayList();
    static Random rand = new Random();
    private static TimerManager manager;
    private static Timer timer;
    
    public static void setTimer() {
        
    	manager = new TimerManager();
        manager.vinculateData(data);
        timer = new Timer(10000, manager);
    	timer.start();
    	
    }
    
    public static void stopTimer() {
    	timer.stop();
    }


    public static void add(String name, double money){
        if (data.size()<=1000) {
        	//criamos a conta e uma poupança a ela vinculada e em seguida adicionamos ao data
        	Conta new_account = new Conta(name,money,create_id());
            new_account.createSaving();
        	data.add(new_account);
        	System.out.println("conta adicionado com sucesso, id de acesso: "+new_account.getId());
        }
        else {
            System.out.println("ultrapassou o tamanho máximo de clientes (1000)");
        }
    }

    public static void remove(int id){
        boolean removed = false;
        for (int i = 0; i<data.size();i++){
            if (data.get(i).getId()==id){
                data.remove(i);
                removed = true;
                System.out.println("removido com sucesso");
            }
        }
        if (removed==false){
            System.out.println("esse id não existe");
        }
    }

    public static void transfer(int idGive, int idRecieve, double money){
        for (int i = 0; i<data.size();i++){
            if (data.get(i).getId()==idRecieve){
                data.get(i).recieve(money);
            }
            else if (data.get(i).getId()==idGive){
                data.get(i).transfer(money);
            }
        }
    }

    public static void ShowInfoById(int id){
        boolean found = false;

        for (int i = 0; i<data.size();i++){
            if (data.get(i).getId() == id){
                Conta element = data.get(i);
                System.out.printf("Conta corrente: name: "+element.getName()+" id: "+element.getId()+" cash: %.2f %n", element.showMoney());
                System.out.println("Poupança: name: "+element.saving.getName()+" id: "+element.saving.getId()+" cash: "+ String.format("%.2f", element.saving.showMoney())+"\n");
                found = true;
            }
        }
        if (!found){
            System.out.println("esse id não existe");
        }
    }

    public static void ShowData(){
    	System.out.println("CONTAS");
        for (int i = 0; i<data.size();i++){
            ShowInfoById(data.get(i).getId());
        }
    }

    private static int create_id(){
        //definimos um id aleatoriamente, poderÃ­amos utilizar uma funÃ§Ã£o de hash tambÃ©m mas para simplificar, utilizamos aleatoriedade
        //vale lembrar que isso possibilita a existÃªncia de erros, nÃ£o  seria recomendÃ¡vel criar um id dessa maneira
        //checamos se o id jÃ¡ existe, se existir geramos outro
        boolean diferentId = false;
        int possibleId = -1;
        while(!diferentId){
            diferentId = true;
            possibleId = rand.nextInt(1000000);
            for (int i = 0; i<data.size();i++){
                if (data.get(i).getId() == possibleId ){
                    diferentId = false;
                    break;
                }
            }
        }
        return possibleId;
    }
    
    public static void apply(int id, double money) {
    	boolean found = false;
    	for (int i = 0; i<data.size();i++) {
    		if (data.get(i).getId() == id) {
    			data.get(i).apply(money);
    			found = true;
    		}
    	}
    	if (!found) {
    		System.out.println("id não encontrado!");
    	}
    }
    
    public static void rescue (int id, double money) {
    	boolean found = false;
    	for (int i = 0; i<data.size();i++) {
    		if (data.get(i).getId() == id) {
    			data.get(i).rescue(money);
    			found = true;
    		}
    	}
    	if (!found) {
    		System.out.println("id não encontrado!");
    	}
    }
    
}
