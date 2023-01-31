class PublicTransport:
    def __init__(self, name, fare) -> None:
        self.name = name # name of a publicTransport
        self.fare = fare # fare of a publicTransport
        self.num_passenger = 0 # default_num of passenger

    def get_in(self):
        self.num_passenger += 1

    def get_off(self):
        if self.num_passenger == 0: return print('현재 탑승객이 없습니다.')
        self.num_passenger -= 1

    def get_status(self):
        return self.num_passenger

    def profit(self):
        return self.fare * self.num_passenger

bus = PublicTransport('bus', 1000)
subway = PublicTransport('subway', 1500)

bus.get_in()
bus.get_in()
bus.get_off()
bus.get_in()
print(bus.get_status()) 
print(bus.profit())

subway.get_in()
subway.get_in()
subway.get_in()
subway.get_in()
print(subway.get_status())
print(subway.profit())