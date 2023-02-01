# class Collatz:
#     def __init__(self, num) -> None:
#         self.num = num

#     def collatz(self):
#         if type(self.num) != int: return '정수를 입력한 Collatz 인스턴스를 다시 만들어 주십시오.'

#         cnt = 0
#         while self.num != 1:
#             if self.num % 2 == 0:
#                 self.num //= 2
#             else:
#                 self.num *= 3
#                 self.num += 1
#             cnt += 1
#             if cnt == 500: return -1
#         return cnt

# c1 = Collatz(6)
# c2 = Collatz(1304)
# print(c1.collatz()) # 8
# print(c2.collatz()) # 26

def collatz(num):
    if type(num) != int: return '정수를 입력한 Collatz 인스턴스를 다시 만들어 주십시오.'

    cnt = 0
    while num != 1:
        if num % 2 == 0:
            num //= 2
        else:
            num *= 3
            num += 1
        cnt += 1
        if cnt == 500: return -1

    return cnt

print(collatz(6)) #=> 8
print(collatz(16)) #=> 4
print(collatz(27)) #=> 111
print(collatz(626331)) #=> -1
print(collatz(1304)) #=> 26