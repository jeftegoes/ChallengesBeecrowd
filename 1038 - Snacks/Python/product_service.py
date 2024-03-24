from product import Product
from product_repository import ProductRepository


class ProductService:
    def __init__(self, product_repository: ProductRepository) -> None:
        self.product_repository = product_repository

    def get_product(self, code: int) -> Product:
        if (self.product_repository.check_if_product_exists(code)):
            return self.product_repository.get(code)

        return None
