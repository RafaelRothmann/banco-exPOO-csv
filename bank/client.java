package bank;

public class client {
    private String name;
    private int age;
    private int id;
    private tipes tipe;
    private accounts account;
    private double balance;

    public client(String name, int age, int id, tipes tipe, accounts account, double balance){
        this.name = name;
        this.age = age;
        this.id = id;
        this.tipe = tipe;
        this.account = account;
        this.balance = balance;

    }

    public tipes getTipe() {
        return tipe;
    }

    public void setTipe(tipes tipe) {
        this.tipe = tipe;
    }

    public accounts getAccount() {
        return account;
    }

    public void setAccount(accounts account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Name: " +getName() + "\n"
        + "ID: " + getId() + "\n"
        + "Balance: " + getBalance();
        
    }

}
