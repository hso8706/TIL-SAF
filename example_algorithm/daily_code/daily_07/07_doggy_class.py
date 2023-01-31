class Doggy:
    birth_of_dogs = 0
    num_of_dogs = 0

    def __init__(self, dog_name, dog_kind) -> None:
        self.dog_name = dog_name
        self.dog_kind = dog_kind
        Doggy.birth_of_dogs += 1
        Doggy.num_of_dogs += 1
    
    def bark():
        print("bark! bark! brr.....")
        
    @classmethod    
    def kill(cls):
        if cls.num_of_dogs == 0:
            return print('현재 존재하는 개가 없습니다.')
        cls.num_of_dogs -= 1

    @classmethod
    def get_status(cls):
        return f'태어난 개의 수 : {cls.birth_of_dogs}\n현재 개의 수: {cls.num_of_dogs}'

