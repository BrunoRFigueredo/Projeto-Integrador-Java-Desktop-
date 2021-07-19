package model;

import enums.Sexo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;

    @Column(name = "NOME", nullable = false, length = 200)
    @SwingColumn(description = "Nome")
    private String nome;

    @Column(name = "RG", nullable = false, length = 15)
    private String rg;

    @Column(name = "telefone", nullable = false, length = 11)
    @SwingColumn(description = "Telefone")
    private String telefone;

    @Column(name = "ENDERECO", nullable = false, length = 200)
    private String endereco;

    @Column(name = "SEXO", length = 1)
    private Sexo sexo;

    @Column(name = "EMAIL", nullable = false, length = 100)
    @SwingColumn(description = "Email")
    private String email;

    public Cliente() {
        this.setId(0);
        this.setNome("nome padrão");
        this.setRg("0.000.000");
        this.setTelefone("00000000000");
        this.setEndereco("endereço padrão");
        this.setSexo(Sexo.M);
        this.setEmail("padrão@email.com");
    }

    public Cliente(int id, String nome, String rg, String telefone, String endereco, Sexo sexo, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setRg(rg);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setSexo(sexo);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg.equals(" .   .   ") ? "0.000.000" : rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ? "0000000000" : telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "ENDEREÇO PADRÃO" : endereco.toUpperCase();
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim().isEmpty() ? "PADRÃO@EMAIL.COM" : email.toUpperCase();
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
