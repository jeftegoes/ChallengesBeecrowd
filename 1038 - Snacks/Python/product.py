class Product:
    def __init__(self, code: int, description: str, price: float) -> None:
        self.code = code
        self.description = description
        self.price = price

    def purchase(self, quantity: int) -> float:
        return self.price * quantity
