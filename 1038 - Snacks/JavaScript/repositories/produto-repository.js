const IProdutoRepository = require("../interfaces/i_produto-repository");

class ProdutoRepository extends IProdutoRepository {
  #produtos = [];

  constructor() {
    super();
  }

  adicionarProduto = async (produto) => {
    this.#produtos.push(produto);
  }

  get = async (codigo) => {
    return this.#produtos.find((produto) => produto.codigo === codigo);
  }

  getAll = async () => {
    let produtos = "Codigo        Descrição     Valor \n";

    this.#produtos.forEach((produto) => {
      produtos +=
        produto.codigo +
        "    -    " +
        produto.nome +
        "    -    " +
        produto.valor +
        "\n";
    });

    return produtos;
  }
}

module.exports = ProdutoRepository;
