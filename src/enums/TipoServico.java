package enums;

public enum TipoServico {
    CORTE_CABELO("Corte de cabelo"),
    CORTE_BARBA("Corte de barba"),
    LAVAGEM_CABELO("Lavagem de cabelo"),
    LAVAGEM_BARBA("Lavagem de barba");
    
    private String descricao;

    private TipoServico(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
