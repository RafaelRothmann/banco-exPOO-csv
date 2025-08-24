import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bank.accounts;
import bank.bankAccount;
import bank.client;
import bank.tipes;

public class app {
    public static void main(String[] args) {
        String path = "clientes-v1.csv";

        List<bankAccount> banks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                boolean aux = false;

                String[] vet = line.split(",");

                int id = Integer.parseInt(vet[0]);
                String name = vet[1];
                int age = Integer.parseInt(vet[2]);
                tipes tipe = tipes.valueOf(vet[3]);
                accounts account = accounts.valueOf(vet[4]);
                double balance = Double.parseDouble(vet[5]);
                String bankName = vet[6];
                int bankNumber = Integer.parseInt(vet[7]);

                client c1 = new client(name, age, id, tipe, account, balance);

                for (int i = 0; i < banks.size(); i++) {
                    if (bankName.equals(banks.get(i).getBankName())) {
                        banks.get(i).addClient(c1);
                        aux = true;
                    }
                }

                if (aux == false) {
                    bankAccount bank = new bankAccount(bankName, bankNumber);
                    banks.add(bank);
                    banks.get(banks.size() - 1).addClient(c1);

                }

                line = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//

        String path2 = "banks-v1.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){

            bw.write("nome,total_saldo,media_saldo,media_idade,total_cliente,id_maior_saldo,nome_maior_saldo,saldo_maior_conta");
            bw.newLine();

            for(int i = 0; i < banks.size(); i++) {
                bw.write(banks.get(i).getBankName() + ","
                + banks.get(i).TotalBalance() + ","
                + banks.get(i).balanceAverage() + ","
                + banks.get(i).ageAverage() + ","
                + banks.get(i).totalClient()+ ","
                + banks.get(i).bestBalance().getId()+ ","
                + banks.get(i).bestBalance().getName()+ ","
                + banks.get(i).bestBalance().getBalance());

                if ((i < banks.size() - 1)) {
                    bw.newLine();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}