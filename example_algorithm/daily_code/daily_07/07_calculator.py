class Calculator:
    @staticmethod
    def add(num1, num2):
        return num1 + num2
    
    @staticmethod
    def subtract(num1, num2):
        return num1 - num2

    @staticmethod
    def multiply(num1, num2):
        return num1 * num2

    @staticmethod
    def divide(num1, num2):
        try:
            return num1 / num2
        except:
            return "0으로 나눌 수 없습니다."
    
cal = Calculator()
# 1 + 2
print(cal.add(1, 2))
# 2 – 1
print(cal.subtract(2, 1))
# 3 * 4
print(cal.multiply(3, 4))
# 4 / 0
print(cal.divide(4, 0))