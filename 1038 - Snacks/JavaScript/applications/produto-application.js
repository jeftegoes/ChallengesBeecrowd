class ProdutoApplication {
  constructor(produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  getPrecoTotalQuantidade = async(codigo, quantidade) => {
    let produto = await this.produtoRepository.get(codigo);
    return produto.getPrecoTotalQuantidade(quantidade);
  }

  get = async(codigo) => {
    return await this.produtoRepository.get(codigo);
  }
}

module.exports = ProdutoApplication;
