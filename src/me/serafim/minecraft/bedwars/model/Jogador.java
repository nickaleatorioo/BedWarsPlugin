package me.serafim.minecraft.bedwars.model;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/* Classe responsável por gerenciar as informações de um jogador em relação as partidas jogadas */
public class Jogador {

    private String name;
    private int vitorias;
    private int derrotas;
    private int abates;
    private int mortes;
    private int camas;
    private int kits;

    /** Retorna a class Player com todas as informações do jogador **/
    public Player getBukkitPlayer() {
        return Bukkit.getPlayerExact(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getAbates() {
        return abates;
    }

    public void setAbates(int abates) {
        this.abates = abates;
    }

    public int getMortes() {
        return mortes;
    }

    public void setMortes(int mortes) {
        this.mortes = mortes;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getCamas() {
        return camas;
    }

    public int getKits() {
        return kits;
    }

    public void setKits(int kits) {
        this.kits = kits;
    }
}
