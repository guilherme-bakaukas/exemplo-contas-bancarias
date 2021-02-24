public class Conta {

    protected String name;
    protected float money;
    protected int id;

    public Conta(String name, float money, int id ){
        this.name = name;
        this.money = money;
        this.id = id;
    }

    public float showMoney(){
        return money;
    }

    public void transfer(float value){
        this.money -= value;
    }

    public void recieve(float value){
        this.money += value;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String new_name){
        this.name = new_name;
    }
}
