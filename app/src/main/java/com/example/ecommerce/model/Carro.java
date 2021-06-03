package com.example.ecommerce.model;

import java.util.ArrayList;

public class Carro {
        public static Carro carro = null;
        ArrayList<Game> carroList = new ArrayList<>();

        public Carro(){

        }

    public void addToCarro(Game game){
           if(!inCarro(game.ID)){
               carroList.add(game);
           }
    }

    public boolean inCarro(int id){
        for(int i = 0; i < this.carroList.size(); i++){
            if (carroList.get(i).ID == id){
                return true;
            }
        }
        return false;
    }

    public float getTotal(){
            float total = 0;
            for(int i = 0; i < this.carroList.size(); i++){
                if(carroList.get(i).SALE != 0) {
                    total = total + carroList.get(i).PRICE;
                }else{
                    total = total + carroList.get(i).SALE_PRICE;
                }
            }
            return total;
    }

    public ArrayList<Game> getLista(){
            return carroList;
    }

    public static Carro getClase(){
            if(carro == null){
                carro = new Carro();
            }
            return carro;
    }

}
