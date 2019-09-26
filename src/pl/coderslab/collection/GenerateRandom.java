package pl.coderslab.collection;

import java.util.*;

public class GenerateRandom {

    public static void main(String[] args) {

        Map<Integer, Integer> randomMap = checkRand(500000, 10);

        for (Map.Entry<Integer, Integer> entry : randomMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static Map<Integer, Integer> checkRand(int amount, int interval) {

        //metoda ta ma zwracać mapę wystąpień wartości losowych generowanych za pomocą klasy Random.
        //Kluczem mapy ma być losowana liczba, wartością ilość jej wystąpień.
        //amount - oznaczają ilość losowań jaka ma być wykonana.
        //interval - zakres wartości dla metody klasy nextInt klasy Random.

        Random random = new Random();
        List<Integer> drawnNumbers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            drawnNumbers.add(random.nextInt(interval));//dodanie wylosowanej liczby do listy
//            System.out.println(i + ": " + drawnNumbers.get(i));
        }

        Map<Integer, Integer> randNumbers = new HashMap<>();//utworzenie mapy

        int numOccurence = 0;
        int tempValue = 0;
        for(int i=0; i<interval; i++) {
            for(int j=0; j< drawnNumbers.size(); j++) {
                if(i==drawnNumbers.get(j)) {
                    numOccurence++;
                    tempValue = numOccurence;
                }
                randNumbers.put(i,tempValue); //zapisanie do mapy klucza i wartości
            }
            numOccurence = 0;
        }


        return randNumbers;
    }
}



