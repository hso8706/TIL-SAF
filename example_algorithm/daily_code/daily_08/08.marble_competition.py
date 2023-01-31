class Marble_Competition:
    def __init__(self, participants) -> None:
        self.participants = participants
    
    def who_is_the_one(self):
        for person in self.participants:
            if self.participants.count(person) == 1:
                return self.participants.index(person)+1

m1 = Marble_Competition([3, 7, 100, 21, 13, 6, 5, 7, 5, 6, 3, 13, 21])
print(m1.who_is_the_one())