class Produto {
  constructor(codigo, nome, valor) {
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
  }

  getPrecoTotalQuantidade(quantidade) {
    return this.valor * quantidade;
  }

  setDesconto(desconto) {
    return this.valor * 0.10;
  }
}

module.exports = Produto;
