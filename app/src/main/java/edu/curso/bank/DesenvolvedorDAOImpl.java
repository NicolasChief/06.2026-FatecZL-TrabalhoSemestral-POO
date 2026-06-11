package edu.curso.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.curso.model.Desenvolvedor;

public class DesenvolvedorDAOImpl implements DesenvolvedorDAO {

    private static final String DB_JDBC_URI = "jdbc:mariadb://localhost:3306/JogoDatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "12345678"; 
    private Connection con;

    public DesenvolvedorDAOImpl() { 

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
    public void cadastrarDesenvolvedor(Desenvolvedor desenvolvedor) {
        try { 
            String sql = "INSERT INTO desenvolvedor (nomeEmpresa, cnpjcpf, email, telefone, dataNasc, senhaConta) VALUES " +
            "(?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, desenvolvedor.getNomeEmpresa());
            stm.setString(2, desenvolvedor.getCnpjCpf());
            stm.setString(3, desenvolvedor.getEmail());
            stm.setString(4, desenvolvedor.getTelefone());
            stm.setDate(5, java.sql.Date.valueOf(desenvolvedor.getDataNasc()));
            stm.setString(6, desenvolvedor.getSenhaConta());
            stm.executeUpdate();

            System.out.println("Comando executado com sucesso"); 

        } catch (SQLException e) {

            System.out.println("Erro ao conectar");
            e.printStackTrace();

        }
    }

    @Override
    public List<Desenvolvedor> consultarDesenvolvedor(String nomeEmpresa) {

        List<Desenvolvedor> lista = new ArrayList<>();
        try { 

            String sql = "SELECT * FROM desenvolvedor WHERE nomeEmpresa LIKE ?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + nomeEmpresa + "%" );

            ResultSet rs = stm.executeQuery();
            while (rs.next()) { 
                Long id = rs.getLong("id");
                String nomeD = rs.getString("nomeEmpresa");
                String cnpjcpfD = rs.getString("cnpjcpf");
                String emailD = rs.getString("email");
                String telefoneD = rs.getString("telefone");
                LocalDate dataNascD = rs.getDate("dataNasc").toLocalDate();
                String senhaContaD = rs.getString("senhaConta");

                Desenvolvedor desenvolvedor = new Desenvolvedor(id, nomeD, cnpjcpfD, emailD, telefoneD, dataNascD, senhaContaD);

                desenvolvedor.setNomeEmpresa(nomeD);
                desenvolvedor.setCnpjCpf(cnpjcpfD);desenvolvedor.setEmail(emailD);
                desenvolvedor.setTelefone(telefoneD);
                desenvolvedor.setDataNasc(dataNascD);
                desenvolvedor.setSenhaConta(senhaContaD);

                lista.add(desenvolvedor);

            }

            System.out.println("Comando executado com sucesso");   
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Desenvolvedor autenticar(String nomeEmpresa, String senhaConta) {
        try {
            String sql = "SELECT * FROM desenvolvedor WHERE nomeEmpresa = ? AND senhaConta = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nomeEmpresa);
            stm.setString(2, senhaConta);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String nomeD = rs.getString("nomeEmpresa");
                String cnpjcpfD = rs.getString("cnpjcpf");
                String emailD = rs.getString("email");
                String telefoneD = rs.getString("telefone");
                LocalDate dataNascD = rs.getDate("dataNasc").toLocalDate();
                String senhaContaD = rs.getString("senhaConta");
                return new Desenvolvedor(id, nomeD, cnpjcpfD, emailD, telefoneD, dataNascD, senhaContaD);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar desenvolvedor");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizarDesenvolvedor(long id, Desenvolvedor desenvolvedor) {
        try { 
            String sql = "UPDATE desenvolvedor SET nomeEmpresa = ?, cnpjcpf = ?, email = ?, telefone = ?, dataNasc = ?, senhaConta = ? WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, desenvolvedor.getNomeEmpresa());
            stm.setString(2, desenvolvedor.getCnpjCpf());
            stm.setString(3, desenvolvedor.getEmail());
            stm.setString(4, desenvolvedor.getTelefone());
            stm.setDate(5, java.sql.Date.valueOf(desenvolvedor.getDataNasc()));
            stm.setString(6, desenvolvedor.getSenhaConta());
            stm.setLong(7, id);
            stm.executeUpdate();
            System.out.println("Desenvolvedor atualizado com sucesso"); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }
    }

    @Override
    public void apagarDesenvolvedor(Long id) { 
        try { 
            String sql = "DELETE FROM desenvolvedor WHERE id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            stm.executeUpdate();
            System.out.println("Desenvolvedor apagado com sucesso"); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }
    }
}