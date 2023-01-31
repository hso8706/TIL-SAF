class Point:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y

class Rectangle(Point):
    def __init__(self, p1, p2) -> None:
        self.p1 = p1 # p1 : 좌상단 좌표
        self.p2 = p2 # p2 : 우하단 좌표
        self.height = p1.y - p2.y
        self.width = p2.x - p1.x

    def get_area(self):
        return self.width * self.height

    def get_perimeter(self):
        return (self.width + self.height) * 2

    def is_square(self):
        if self.width == self.height: return True
        else: return False

p1 = Point(1, 3)
p2 = Point(3, 1)
r1 = Rectangle(p1, p2)
print(r1.get_area())
print(r1.get_perimeter())
print(r1.is_square())

p3 = Point(3, 7)
p4 = Point(6, 4)
r2 = Rectangle(p3, p4)
print(r2.get_area())
print(r2.get_perimeter())
print(r2.is_square())

