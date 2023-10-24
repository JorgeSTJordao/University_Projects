# Reference video: https://www.youtube.com/watch?v=3dEPY3HiPtI

import threading
import time

def eat_breakfast():
    time.sleep(3)
    print("You ate breakfast")
def drink_coffe():
    time.sleep(4)
    print("You drank coffe")
def study():
    time.sleep(5)
    print("You finish studying")

eat_breakfast()
drink_coffe()
study()

print(threading.active_count())
print(threading.enumerate())