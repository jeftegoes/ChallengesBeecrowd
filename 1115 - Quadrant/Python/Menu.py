from Coordinate import Coordinate


class Menu:
    def __init__(self):
        pass

    def get_user_coordinate(self) -> Coordinate:
        coordinateX = int(input("Inform the coordinate X: "))
        coordinateY = int(input("Inform the coordinate Y: "))
        self.coordinates = Coordinate(coordinateX, coordinateY)
        return self.coordinates

    def cordinate_is_valid(self, coordinates: Coordinate) -> bool:
        if (coordinates.coordinateX == 0 or coordinates.coordinateY == 0):
            return False
        else:
            return True

    def show_menu(self) -> bool:
        self.get_user_coordinate()
        return self.cordinate_is_valid(self.coordinates)
