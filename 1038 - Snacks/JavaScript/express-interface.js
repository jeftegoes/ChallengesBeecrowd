const express = require("express");
const app = express();
const port = 3000;

const Produto = require("./models/produto");
const ProdutoRepository = require("./repositories/produto-repository");
const ProdutoApplication = require("./applications/produto-application");
const ProdutoFacade = require("./facade/produto-facade");
var prompt = require("prompt-sync")();

produto1 = new Produto(1, "Hotdog", 4);
produto2 = new Produto(2, "X-Salada", 4.5);
produto3 = new Produto(3, "Teste", 5);
produto4 = new Produto(4, "123", 2);
produto5 = new Produto(5, "123123", 1.5);

var produtoRepository = new ProdutoRepository();
produtoRepository.adicionarProduto(produto1);
produtoRepository.adicionarProduto(produto2);
produtoRepository.adicionarProduto(produto3);
produtoRepository.adicionarProduto(produto4);
produtoRepository.adicionarProduto(produto5);

var produtoApplication = new ProdutoApplication(produtoRepository);
var produtoFacade = new ProdutoFacade(produtoApplication);

app.get("/codigo/:codigo/quantidade/:quantidade", async (req, res) => {
  let codigo = parseFloat(req.params.codigo);
  let quantidade = parseFloat(req.params.quantidade);

  let valorProduto = await produtoFacade.getPrecoTotal(codigo, quantidade);
  res.json({ resultado: valorProduto });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
