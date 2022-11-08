
from Entities.Produto import Produto


def test_baixar_estoque():
    product1 = Produto(1, "Milk", 50, 10)
    product2 = Produto(1, "Rice", 30, 50)
    product1.baixar_estoque(5)
    product2.baixar_estoque(15)

    assert product1.estoque == 5
    assert product2.estoque == 35

