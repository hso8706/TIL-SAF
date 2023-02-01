class Stack:

    def __init__(self) -> None:
        self.lst = []

    def empty(self):
        if len(self.lst) == 0: return True
        else: return False
    
    def top(self):
        if self.empty(): None
        else: return self.lst[len(self.lst)-1]
    
    def pop(self):
        if self.empty(): None
        else: return self.lst.pop()
    
    def push(self, any):
        self.lst.append(any)

    def __repr__(self) -> str:
        return f'{self.lst}'

st = Stack()
print('확인: ', st.__repr__())
print(st.empty())
print(st.push('a'))
print('확인: ', st.__repr__())
print(st.empty())
print('확인: ', st.__repr__())
print(st.push(2))
print('확인: ', st.__repr__())
print(st.top())
print('확인: ', st.__repr__())
print(st.pop())
print('확인: ', st.__repr__())