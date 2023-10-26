from threading import Thread
def task1():
    x = 0
    while x < 10:
        print("Task 1")
        x += 1

def task2():
    y = 0
    while y < 10:
        print("Task 2")
        y += 1

t1 = Thread(target=task1)
t2 = Thread(target=task2)
t1.start()
t2.start()

t1.join()
t2.join()



