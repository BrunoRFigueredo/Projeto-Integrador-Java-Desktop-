package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;

    @Column(name = "NOME", nullable = false, length = 200)
    @SwingColumn(description = "Nome")
    private String nome;

    @Column(name = "FUNCAO", nullable = false, length = 45)
    @SwingColumn(description = "Função")
    private String funcao;

    @Column(name = "SALARIO", nullable = false, precision = 10, scale = 2)
    @SwingColumn(description = "Salário")
    private double salario;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    public Funcionario() {
        this.setId(0);
        this.setNome("NOME PADRÃO");
        this.setFuncao("FUNÇÃO PADRÃO");
        this.setSalario(0);
        this.setDataNascimento(LocalDate.now());
    }

    
    
    public Funcionario(int id, String nome, String funcao, double salario, LocalDate dataNascimento) {
        this.setId(id);
        this.setNome(nome);
        this.setFuncao(funcao);
        this.setSalario(salario);
        this.setDataNascimento(dataNascimento);
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao.trim().isEmpty() ? "FUNÇÃO PADRÃO" :  funcao.toUpperCase();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nome;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
