import random

class ClassHelper:
    students = []

    def __init__(self, students) -> None:
        self.students = students

    def pick(self, idx):
        return random.sample(self.students, idx)

    def match_pair(self):
        if len(self.students) == 1 or len(self.students) == 3
        return random.sample(self.students, 2)



ch = ClassHelper(['김해피', '이해킹', '조민지', '박영수', '정민수'])

print(ch.pick(1))
print(ch.pick(1))
print(ch.pick(2))
print(ch.pick(3))
print(ch.pick(4))

print(ch.match_pair())