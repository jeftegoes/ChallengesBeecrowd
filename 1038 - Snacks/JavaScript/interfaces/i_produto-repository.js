class IProdutoRepository {
    constructor() {
        if (new.target === IProdutoRepository) {
            throw new Error("A interface IProdutoRepository não pode ser instanciada.");
        }
    }

    adicionarProduto = async (produto) => {
        throw new Error("Esse método não pode ser chamado")
    }

    get = async (codigo) => {
        throw new Error("Esse método não pode ser chamado")
    }

    getAll = async () => {
        throw new Error("Esse método não pode ser chamado")
    };
}

module.exports = IProdutoRepository