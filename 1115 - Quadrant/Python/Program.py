from Menu import Menu
from Quadrant import Quadrant

menu = Menu()

while menu.show_menu():
    coordinates = menu.coordinates

    my_quadrant = Quadrant(coordinates)
    print(f"{my_quadrant.get_quadrant_coordinate()} quadrant.")
