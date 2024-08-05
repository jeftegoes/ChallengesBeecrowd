class ProdutoFacade {
  constructor(produtoApplication) {
    this.produtoApplication = produtoApplication;
  }

  getPrecoTotal = async(codigo, quantidade) => {
    if (this.produtoApplication.get(codigo)) {
      let result = await this.produtoApplication.getPrecoTotalQuantidade(
        codigo,
        quantidade
      );
      return result;
    }

    return "Produto nao encontrado";
  }

  async getPrecoTotal2(codigo, quantidade) {
    return await this.produtoApplication.getPrecoTotalQuantidade(codigo, quantidade);
  }
}
module.exports = ProdutoFacade;
