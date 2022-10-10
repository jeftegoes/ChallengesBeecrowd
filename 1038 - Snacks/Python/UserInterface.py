from sqlalchemy import true

from MenuRepository import MenuRepository


class UserInterface:
    def __init__(self, menu_repository: MenuRepository) -> None:
        self.menu_repository = menu_repository

    def get_user_input(self) -> list[int]:
        return input(
            "Inform two codes (valid) included in menu separated by space to buy snacks: ").split()

    def get_total_price(self, codes: list[int]):
        print(f"Total: $ {self.menu_repository.get_total_price(codes)}")

    def get_interaction(self) -> bool:
        codes = self.get_user_input()

        for code in codes:
            if (self.menu_repository.check_if_itens_exists(int(code)) == False):
                print("Invalid code!")
                return False

        self.get_total_price(codes)
        return True
