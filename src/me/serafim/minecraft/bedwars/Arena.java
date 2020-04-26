package me.serafim.minecraft.bedwars;

import org.bukkit.Location;
import org.bukkit.WorldBorder;

import java.util.List;

public class Arena {

    private String nome;
    private Location locationMin;
    private Location locationMax;
    private WorldBorder worldBorder;
    private List<Time> timeList;
    private List<Gerador> geradorList;

    public Arena() {

        // pegar config
    }
}
