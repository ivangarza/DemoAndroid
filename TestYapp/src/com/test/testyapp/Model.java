package com.test.testyapp;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "foto_espectaculos.png", "Espect‡culos","Shakira muestra la primera foto de Milan"));
        Items.add(new Item(2, "foto_hoy.png", "Lo de Hoy","Secuestra a 3 personas en la comunidad"));
        Items.add(new Item(3, "foto_horoscopos.png", "Hor—scopos","Aries 5 Febrero..."));
        Items.add(new Item(4, "foto_cine.png", "Cine","Estreno de Hansel y Gretel."));
        Items.add(new Item(5, "foto_clima.png", "Clima","Monterrey: Max 23¼ Min 9¼"));
        Items.add(new Item(6, "foto_deportes.png", "Deportes","Prepara Messi su renovaci—n con el barca"));
        //Items.add(new Item(7, "ic_action_stamp.png", "Stamp"));
        
        /*Items.add(new Item(1, "ic_action_alarm_2.png", "Alarm"));
        Items.add(new Item(2, "ic_action_calculator.png", "Calculator"));
        Items.add(new Item(3, "ic_action_google_play.png", "Play"));
        Items.add(new Item(4, "ic_action_line_chart.png", "Line Chart"));
        Items.add(new Item(5, "ic_action_location_2.png", "Location"));
        Items.add(new Item(6, "ic_action_news.png", "News"));
        Items.add(new Item(7, "ic_action_stamp.png", "Stamp"));*/

    }

    public static Item GetbyId(int id){

        for(Item item : Items) {
            if (item.Id == id) {
                return item;
            }
        }
        return null;
    }

}
