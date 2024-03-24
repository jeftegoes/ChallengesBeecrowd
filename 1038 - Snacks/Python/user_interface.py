from product import Product
from product_service import ProductService


class UserInterface:
    def __init__(self, product_service: ProductService) -> None:
        self.product_service = product_service

    def purchase(self, code: int, quantity: int) -> float:
        product: Product = self.product_service.get_product(code)

        if (product == None):
            return -1

        return product.purchase(quantity)
