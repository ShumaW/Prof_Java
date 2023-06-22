package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
@ToString
public class Storage {

    private Map<String, List<BankCard>> mapOfClient = new TreeMap<>();

    public void add(Client client){
        mapOfClient.put(client.getName(), client.getBankCardList());
    }

    public void readMap() {
        for (Map.Entry<String, List<BankCard>> entry : mapOfClient.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void updateMap(Client client){
        for (Map.Entry<String, List<BankCard>> entry : mapOfClient.entrySet()) {
            if (client.getName().equals(entry.getKey())){
                mapOfClient.put(client.getName(),client.getBankCardList());
            }
        }
    }

    public void delete(Client client){
        for (Map.Entry<String, List<BankCard>> entry : mapOfClient.entrySet()) {
            if (client.getPassNumber().equals(entry.getKey())){
                mapOfClient.remove(client.getName(),client.getBankCardList());
            }
        }
    }

    public void printMap(){
        mapOfClient.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
