package model;

import enums.TipoServico;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO_ITENS")
public class ServicoProduto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SERVICO", nullable = false, referencedColumnName = "ID")
    private Servico servico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUTO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Produto")
    private Produto produto;

    @Column(name = "QT_PRODUTO_UTILIZADA", nullable = false)
    @SwingColumn(description = "Quantidade")
    private int quantidade;

    public ServicoProduto() {
        this.setServico(new Servico());
        this.setProduto(new Produto());
        this.setQuantidade(0);
        this.setId(0);
    }

    public ServicoProduto(int id, Servico servico, Produto produto, int quantidade) {
        this.setServico(servico);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        this.setId(id);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico == null ? new Servico() : servico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto == null ? new Produto() : produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.produto.getId() + this.servico.getId();
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
        final ServicoProduto other = (ServicoProduto) obj;
        if (this.produto.getId() != other.produto.getId() && this.servico.getId() != other.servico.getId()) {
            return false;
        }
        return true;
    }

}
