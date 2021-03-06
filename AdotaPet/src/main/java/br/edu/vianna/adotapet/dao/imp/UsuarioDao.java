/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.adotapet.dao.imp;

import br.edu.vianna.adotapet.banco.util.ConnectionFactory;
import br.edu.vianna.adotapet.dao.DaoGenerics;
import br.edu.vianna.adotapet.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author otavi
 */
public class UsuarioDao implements DaoGenerics {

    @Override
    public void inserir(Usuario p) throws ClassNotFoundException, SQLException {
        
        if (p.getSenha().equals("")) {
            throw new SQLException("Senha em branco!");
        }
        
        // 1ª conectar ao banco
        // Lembrar do padrão Singleton
        
        Connection c = ConnectionFactory.getConnection();
        
        // 2° preparar SQL - insert into
        String sql = "INSERT INTO "
                + "pessoa (nome, email, data_nascimento) "
                + "VALUES (?, ?, ?);"; // cuidado com os espaços
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        // 3° Trocar valores
        pst.setString(1, p.getSenha());
        pst.setString(2, p.getEmail());
        pst.setString(3, p.getDataNascimento().toString());
        
        // 4° Executar
        pst.executeUpdate();
    }   

    @Override
    public void inserir(Object c) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object c) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Object key) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Object key) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList buscarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long quantidade() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
