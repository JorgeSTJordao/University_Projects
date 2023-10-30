# Reference video: https://youtu.be/PJ4t2U15ACo?si=KoiWdYyite35K3Lb
# For a given list of numbers print square and cube of every numbers
# Let's see

# Input: [2, 3, 8, 9]
# Output: square list [4, 9, 64, 81], cube list [8, 27, 512, 729]

from time import time, sleep
import threading

def square(numbers):
    print("Calculate square numbers")
    for n in numbers:
        sleep(0.2)
        print('Square: ', n**2)

def cube(numbers):
    print("Calculate cube numbers")
    for n in numbers:
        sleep(0.2)
        print('Cube: ', n**3)

array_ = [2, 3, 8, 9]

t = time()
t1 = threading.Thread(target=square, args=(array_,))
t2 = threading.Thread(target=cube, args=(array_,))

t1.start()
t2.start()

t1.join()
t2.join()
f = time()

print("Done in: ", f - t)

