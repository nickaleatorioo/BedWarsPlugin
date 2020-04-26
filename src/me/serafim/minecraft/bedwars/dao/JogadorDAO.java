package me.serafim.minecraft.bedwars.dao;

import me.serafim.minecraft.bedwars.model.Jogador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogadorDAO {

    private PreparedStatement stm;
    private ResultSet rs;

    /* Buscando um jogador pelo nome */
    public Jogador getJogador(String player) {
        String sql = "SELECT * FROM tbl_jogador WHERE player = ?";

        Jogador jogador = new Jogador();

        try {
            stm = Conexao.getConexao().prepareStatement(sql);
            stm.setString(1, player);
            rs = stm.executeQuery();

            if (rs.next()) {
                jogador.setName(rs.getString("player"));
                jogador.setVitorias(rs.getInt("vitorias"));
                jogador.setDerrotas(rs.getInt("derrotas"));
                jogador.setAbates(rs.getInt("abates"));
                jogador.setMortes(rs.getInt("mortes"));
                jogador.setCamas(rs.getInt("camas"));
            }

            return jogador;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return jogador;
        }
    }

    /* Guardar um jogador no banco */
    public boolean saveJogador(String player) {
        String sql = "INSERT INTO tbl_jogador " +
                "(player, vitorias, derrotas, abates, mortes, camas) " +
                "VALUES (?, 0, 0, 0, 0, 0)";

        try {
            stm = Conexao.getConexao().prepareStatement(sql);
            stm.setString(1, player);
            stm.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /* Verifica se um jogador está no banco pelo nick */
    public boolean checkJogador(String player) {
        String sql = "SELECT player FROM tbl_jogador WHERE player = ?";

        try {
            stm = Conexao.getConexao().prepareStatement(sql);
            stm.setString(1, player);
            rs = stm.executeQuery();

            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
