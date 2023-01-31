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

class Bus(PublicTransport):
    def __init__(self, name, fare) -> None:
        super().__init__(name, fare)
        self.limit_num = 20
    
    def get_in(self):
        if self.num_passenger >= self.limit_num: return print('더 이상 탑승할 수 없습니다.')
        super().get_in()

bus = PublicTransport('bus', 1000)

bus.get_in()
bus.get_in()
bus.get_off()
bus.get_in()
print(bus.get_status()) # 2
print(bus.profit()) # 2000

bus_bus = Bus('bus', 1000)
bus_bus.get_in()
bus_bus.get_in()
bus_bus.get_off()
bus_bus.get_in()
print(bus_bus.get_status()) # 2
print(bus_bus.profit()) # 2000

for i in range(1, 19):
    bus_bus.get_in()
bus_bus.get_in() # 더 이상 탑승할 수 없습니다.