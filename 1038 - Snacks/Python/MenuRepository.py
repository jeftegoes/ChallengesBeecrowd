from Menu import Menu


class MenuRepository:
    menu_itens: Menu = []

    def __init__(self) -> None:
        pass

    def set_menu_item(self, menu: Menu) -> None:
        self.menu_itens.append(menu)

    def check_if_itens_exists(self, code: int) -> bool:
        for item in self.menu_itens:
            if (item.code == code):
                return True

        return False

    def get_total_price(self, codes: list[int]) -> float:
        total_price = 0.0

        for item in self.menu_itens:
            if (item.code in [int(x) for x in codes]):
                total_price += item.price

        return total_price

    def __str__(self) -> str:
        formatText = "{0:<10} {1:<20} {2:<20}\n"
        menu = formatText.format("Code", "Name", "Price")

        for item in self.menu_itens:
            menu += formatText.format(item.code, item.name, f"$ {item.price}")

        return menu
