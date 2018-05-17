/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia;

import br.edu.ifpb.entidades.Album;
import br.edu.ifpb.entidades.Banda;
import br.edu.ifpb.enums.Estilo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifpb
 */
public class AlbumDao {

    public AlbumDao() {
    }

    public boolean create(Album album) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO album (estilo,banda,anodelancamento) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, album.getEstilo().name());
            stmt.setString(2, album.getBanda().getNome());
            stmt.setDate(3, Date.valueOf(album.getAnoDeLancamento()));
            boolean retorno = stmt.executeUpdate() > 0;
            con.close();
            stmt.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Album> read() {
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM album");
            ResultSet r = st.executeQuery();
            ArrayList<Album> albuns = new ArrayList<>();
            while (r.next()) {
                Album album = new Album();
                album.setEstilo( Estilo.valueOf(r.getString("estilo")));
                album.setBanda(readBanda(r.getString("banda")));
                album.setAnoDeLancamento(r.getDate("anodelancamento").toLocalDate());
                albuns.add(album);
            }
            st.close();
            con.close();
            return albuns;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        try {
            try (Connection con = ConnectionFactory.getConnection()) {

                PreparedStatement st = con.prepareStatement(
                        "DELETE FROM album WHERE id = ?");
                st.setInt(1, id);

                boolean retorno = st.executeUpdate() > 0;
                con.close();
                st.close();
                return retorno;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Album albumNovo, int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "UPDATE album SET (estilo, banda, anodelancamento)"
                    + " = (?,?,?) WHERE id = ?");
            st.setString(1, albumNovo.getEstilo().name());
            st.setString(2, albumNovo.getBanda().getNome());
            st.setDate(3, Date.valueOf(albumNovo.getAnoDeLancamento()));
            st.setInt(4, id);

            boolean retorno = st.executeUpdate() > 0;
            st.close();
            con.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public Banda readBanda(String nome) {
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM banda WHERE nome = ?");
            st.setString(1, nome);
            ResultSet r = st.executeQuery();
            Banda banda = new Banda();
            if (r.next()) {
               banda.setNome(r.getString("nome"));
               banda.setIntegrantes(readIntegrantes(r.getString("nome")));
               banda.setLocalDeOrigiem(r.getString("localdeorigem"));
               return banda;
            }
            st.close();
            con.close();
            return banda;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> readIntegrantes(String nome) {
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM integrante WHERE banda = ?");
            st.setString(1, nome);
            ResultSet r = st.executeQuery();
            ArrayList<String> integrantes = new ArrayList<>();
            if (r.next()) {
                integrantes.add(r.getString("nome"));
            }
            st.close();
            con.close();
            return integrantes;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlbumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



}
