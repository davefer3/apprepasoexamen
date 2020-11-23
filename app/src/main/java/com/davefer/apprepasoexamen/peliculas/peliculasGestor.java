package com.davefer.apprepasoexamen.peliculas;

import java.util.ArrayList;
import java.util.List;

public class peliculasGestor {

    static final String URL ="https://webcarlos.com/fotosmarvel/";

    public static List<pelicula> PELICULAS = new ArrayList<pelicula>();

    public static void crearPeliculas(){
        PELICULAS.add(new pelicula("0","Avengers: End Game","Marvel",URL + "endgame.jpg"));
        PELICULAS.add(new pelicula("1","Pantera Negra","Marvel",URL + "panteranegra.jpg"));
        PELICULAS.add(new pelicula("2","Capitana Marvel","Marvel",URL + "capitanamarvel.jpg"));
        PELICULAS.add(new pelicula("3","Avengers: Infinity War","Marvel",URL + "infinitywar.jpg"));
        PELICULAS.add(new pelicula("4","Guardianes de la Galaxia Vol. 2","Marvel",URL + "guardianes2.jpg"));
        PELICULAS.add(new pelicula("5","Spider-Man: Lejos de casa","Marvel",URL + "spidermanlejoscasa.jpg"));
        PELICULAS.add(new pelicula("6","Avengers: Age of Ultron","Marvel",URL + "eradeultron.jpg"));
        PELICULAS.add(new pelicula("7","Hombre Hormiga","Marvel",URL + "antman.jpg"));
        PELICULAS.add(new pelicula("8","Spider-man: Homecoming","Marvel",URL + "homcoming.jpg"));
        PELICULAS.add(new pelicula("9","Thor: The Dark World","Marvel",URL + "darkworld.jpg"));
        PELICULAS.add(new pelicula("10","Captain America: The Winter Soldier","Marvel",URL + "winersoldier.jpg"));
        PELICULAS.add(new pelicula("11","Guardianes de la Galaxia","Marvel",URL + "guardianes1.jpg"));
        PELICULAS.add(new pelicula("12","Iron Man 3","Marvel",URL + "ironman3.jpg"));
        PELICULAS.add(new pelicula("13","Ant-Man and the Wasp","Marvel",URL + "antmanwasp.jpg"));
        PELICULAS.add(new pelicula("14","Thor: Ragnarok","Marvel",URL + "ragnarok.jpg"));
        PELICULAS.add(new pelicula("15","The Avengers","Marvel",URL + "avengers.jpg"));
    }

    public static pelicula getPeliculaById(String id){
        pelicula pelicula = null;
        for (pelicula p:PELICULAS) {
            if(p.getId().toLowerCase().compareTo(id.toLowerCase())==0){
                pelicula = p;
                break;
            }
        }

        return pelicula;
    }

}
