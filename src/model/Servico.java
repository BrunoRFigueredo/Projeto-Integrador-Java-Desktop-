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
@Table(name = "SERVICO")
public class Servico implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;

    @Column(name = "NOME", nullable = false, length = 200)
    @SwingColumn(description = "Nome")
    private String nome;

    @Column(name = "DS_SERVICO", length = 150)
    private String descricao;

    @Column(name = "DT_SERVICO", nullable = false)
    private LocalDate dataServico;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    @SwingColumn(description = "Tipo de Serviço")
    private TipoServico tipoServico;

    @Column(name = "VL_SERVICO", nullable = false, precision = 10, scale = 2)
    @SwingColumn(description = "Valor do serviço")
    private double valorServico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FUNCIONARIO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Funcionario")
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cliente")
    private Cliente cliente;

    public Servico() {
        this.setId(0);
        this.setNome("nome padrão");
        this.setDescricao("descrição padrão");
        this.setDataServico(LocalDate.now());
        this.setTipoServico(TipoServico.CORTE_CABELO);
        this.setValorServico(0);
        this.setCliente(new Cliente());
        this.setFuncionario(new Funcionario());
    }

    public Servico(int id, String nome, String descricao, LocalDate dataServico, TipoServico tipoServico, double valorServico, Cliente cliente, Funcionario funcionario) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setDataServico(dataServico);
        this.setTipoServico(tipoServico);
        this.setValorServico(valorServico);
        this.setCliente(cliente);
        this.setFuncionario(funcionario);

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty()? "DESCRIÇÃO PADRÃO" : descricao.toUpperCase();
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico == null ? LocalDate.now() : dataServico;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico == null ? TipoServico.CORTE_CABELO : tipoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario == null ? new Funcionario() : funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente == null ? new Cliente() : cliente;
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
        final Servico other = (Servico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
