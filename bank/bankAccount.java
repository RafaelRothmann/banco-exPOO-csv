package bank;

import java.util.ArrayList;
import java.util.List;

public class bankAccount {
    private String bankName;
    private int bankNumber;

    private List<client> listClient = new ArrayList<>();

    public bankAccount(String bankName, int bankNumber) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void addClient(client c) {
        listClient.add(c);
    }

    public client bestBalance() {
        client aux = listClient.get(0);
        for (int i = 0; i < listClient.size(); i++) {
            if (aux.getBalance() < listClient.get(i).getBalance()) {
                aux = listClient.get(i);
            }
        }
        return aux;
    }

    public double TotalBalance(){
        double sum = 0;
        for (int i = 0; i < listClient.size(); i++){
            sum += listClient.get(i).getBalance();
        }
        return sum;
    }
    public int totalClient(){
        return listClient.size();
    }

    public double balanceAverage(){
        double aux = 0;
        for (int i = 0; i < listClient.size(); i++) {
            aux += listClient.get(i).getBalance();
        }
        return aux / listClient.size();
    }

    public double ageAverage(){
        double aux = 0;
        for (int i = 0; i < listClient.size(); i++) {
            aux += listClient.get(i).getAge();
        }
        return aux / listClient.size();
    }
}
