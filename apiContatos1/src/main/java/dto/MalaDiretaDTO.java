package dto;

public record MalaDiretaDTO(Long id, String nome, String malaDireta) {
    public MalaDiretaDTO(Long id, String nome, String endereco, String cep, String cidade, String uf) {
        this(id, nome, formatMalaDireta(endereco, cep, cidade, uf));
    }

    private static String formatMalaDireta(String endereco, String cep, String cidade, String uf) {
        return String.format("%s, %s, %s, %s", endereco, cep, cidade, uf);
    }
}