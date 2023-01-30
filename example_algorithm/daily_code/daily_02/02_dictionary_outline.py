todo = [("Python Homework", 3), ("Assay", 4), ("Vacation", 100)]

print(todo) # [('Python Homework', 3), ('Assay', 4), ('Vacation', 100)]

todo_act = input() # Soccer Contest
todo_day = int(input()) # 10

todo.append((todo_act, todo_day)) 

print(todo) # [('Python Homework', 3), ('Assay', 4), ('Vacation', 100), ('Soccer Contest', 10)]