from Coordinate import Coordinate
from Quadrant import Quadrant
from Menu import Menu

def test_first_quadrant():
    # Arrange / Setup
    a = 2
    b = 2
    coordinates = Coordinate(a, b)
    quadrant = Quadrant(coordinates)

    # Act / Action
    result = quadrant.get_quadrant_coordinate()

    # Assert
    assert result == "First"

def test_fourth_quadrant():
    # Arrange / Setup
    a = 3
    b = -2
    coordinates = Coordinate(a, b)
    quadrant = Quadrant(coordinates)

    # Act / Action
    result = quadrant.get_quadrant_coordinate()

    # Assert
    assert result == "Fourth"


def test_third_quadrant():
    # Arrange / Setup
    a = -8
    b = -1
    coordinates = Coordinate(a, b)
    quadrant = Quadrant(coordinates)

    # Act / Action
    result = quadrant.get_quadrant_coordinate()

    # Assert
    assert result == "Third"

def test_second_quadrant():
    # Arrange / Setup
    a = -7
    b = 1
    coordinates = Coordinate(a, b)
    quadrant = Quadrant(coordinates)

    # Act / Action
    result = quadrant.get_quadrant_coordinate()

    # Assert
    assert result == "Second"

def test_cordinate_is_valid():
    a = 0
    b = 2
    coordinates = Coordinate(a, b)
    menu = Menu()

    # Act / Action
    result = menu.cordinate_is_valid(coordinates)

    # Assert
    assert result == False

def test_get_user_coordinate():
    a = 1
    b = 's'
    
    assert type(a) == int
    assert type(b) == str
