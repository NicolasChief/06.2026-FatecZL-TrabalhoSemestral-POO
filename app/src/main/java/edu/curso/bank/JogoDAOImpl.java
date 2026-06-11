package edu.curso.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.curso.model.Jogo;

public class JogoDAOImpl implements JogoDAO {

    private static final String DB_JDBC_URI = "jdbc:mariadb://localhost:3306/jogodatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "12345678"; 
    private Connection con;

    public JogoDAOImpl() { 

        System.out.println("Jogo DAO criado - com database");
        try {        
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe carregada...");
            con = DriverManager.getConnection(DB_JDBC_URI, DB_USER, DB_PASS);
            System.out.println("Conexao foi feita com sucesso");
        } catch (ClassNotFoundException e) { 
            System.out.println("Erro ao carregar a classe");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }

    }

    @Override
    public void cadastrarJogo(Jogo jogo) {
        try { 
            String sql = "INSERT INTO jogo (nome, preco, dataLancamento, espacoGB, genero, descricao) VALUES " +
            "(?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, jogo.getNome());
            stm.setDouble(2, jogo.getPreco());
            stm.setDate(3, java.sql.Date.valueOf(jogo.getDataLancamento()));
            stm.setDouble(4, jogo.getEspacoGB());
            stm.setString(5, jogo.getGenero());
            stm.setString(6, jogo.getDescricao());
            stm.executeUpdate();

            System.out.println("Comando executado com sucesso"); 

        } catch (SQLException e) {

            System.out.println("Erro ao conectar");
            e.printStackTrace();

        }
    }

    @Override
    public List<Jogo> consultarJogo(String nome) {

        List<Jogo> lista = new ArrayList<>();
        try { 

            String sql = "SELECT * FROM jogo WHERE nome LIKE ?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + nome + "%" );

            ResultSet rs = stm.executeQuery();
            while (rs.next()) { 

//                Long id = rs.getLong("id");
                Long id = rs.getLong("id");
                String nomeJ = rs.getString("nome");
                Double precoJ = rs.getDouble("preco");
                LocalDate dataLancamentoJ = rs.getDate("dataLancamento").toLocalDate();
                Double espacoGBJ = rs.getDouble("espacoGB");
                String generoJ = rs.getString("genero");
                String descricaoJ = rs.getString("descricao");


                Jogo jogo = new Jogo(id, nomeJ, precoJ, dataLancamentoJ, espacoGBJ, generoJ, descricaoJ);

                jogo.setNome(nomeJ);
                jogo.setPreco(precoJ);
                jogo.setDataLancamento(dataLancamentoJ);
                jogo.setEspacoGB(espacoGBJ);
                jogo.setGenero(generoJ);
                jogo.setDescricao(descricaoJ);

                lista.add(jogo);

            }

            System.out.println("Comando executado com sucesso");   
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void atualizarJogo(long id, Jogo jogo) {
        try { 
            String sql = "UPDATE jogo SET nome = ?, preco = ?, dataLancamento = ?, espacoGB = ?, genero = ?, descricao = ? WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, jogo.getNome());
            stm.setDouble(2, jogo.getPreco());
            stm.setDate(3, java.sql.Date.valueOf(jogo.getDataLancamento()));
            stm.setDouble(4, jogo.getEspacoGB());
            stm.setString(5, jogo.getGenero());
            stm.setString(6, jogo.getDescricao());
            stm.setLong(7, id);
            stm.executeUpdate();
            System.out.println("Jogo atualizado com sucesso"); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }
    }

    @Override
    public void apagarJogo(Long id) { 
        try { 
            String sql = "DELETE FROM jogo WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            stm.executeUpdate();
            System.out.println("Pet apagado com sucesso"); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }
    }

}