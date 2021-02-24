import java.util.Random;
import java.util.ArrayList;

public class Functions {

    private static ArrayList<Conta> data = new ArrayList();
    static Random rand = new Random();

    public static void add(String name, float money){
        if (data.size()<=1000) {
            data.add(new Conta(name,money,create_id()));
        }
        else {
            System.out.println("vc ultrapassou o tamanho máximo de clientes (1000)");
        }
    }

    public static void remove(int id){
        boolean removed = false;
        for (int i = 0; i<data.size();i++){
            if (data.get(i).getId()==id){
                data.remove(i);
                removed = true;
            }
        }
        if (removed==false){
            System.out.println("esse id não existe");
        }
    }

    public static void transfer(int idGive, int idRecieve, float money){
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
                System.out.println("name: "+element.getName()+" id: "+element.getId()+" cash: "+ element.showMoney());
                found = true;
            }
        }
        if (!found){
            System.out.println("esse id não existe");
        }
    }

    public static void ShowData(){
        for (int i = 0; i<data.size();i++){
            ShowInfoById(data.get(i).getId());
        }
    }

    private static int create_id(){
        //definimos um id aleatoriamente, poderíamos utilizar uma função de hash também mas para simplificar, utilizamos aleatoriedade
        //vale lembrar que isso possibilita a existência de erros, não  seria recomendável criar um id dessa maneira
        //checamos se o id já existe, se existir geramos outro
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
}
