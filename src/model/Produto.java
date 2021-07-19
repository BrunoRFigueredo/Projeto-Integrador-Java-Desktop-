package model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;

    @Column(name = "NOME", nullable = false, length = 200)
    @SwingColumn(description = "Nome")
    private String nome;

    @Column(name = "QT_PRODUTO", nullable = false)
    @SwingColumn(description = "Quantidade")
    private int quantidadeProduto;

    @Column(name = "VL_PRODUTO", nullable = false, precision = 10, scale = 2)
    @SwingColumn(description = "Valor")
    private double valorProduto;

    public Produto() {
        this.setId(id);
        this.setNome("nome padrão");
        this.setQuantidadeProduto(0);
        this.setValorProduto(0);
    }

    public Produto(int id, String nome, int quantidadeProduto, double valorProduto) {
        this.setId(id);
        this.setNome(nome);
        this.setQuantidadeProduto(quantidadeProduto);
        this.setValorProduto(valorProduto);
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

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
