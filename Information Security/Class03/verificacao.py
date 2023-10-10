class admin():

    def __init__(self):
        self.login = None
        self.password = None
        self.dict = {"User": ["peter@hotmail.com", "deb@gmail.com"], "Password": [1234, 12345]}

    def authentication(self, login, password):
        self.login = login
        self.password = password
        if (self.login == self.dict["User"][0]) and (self.password == self.dict["Password"][0]):
            #print("Welcome, user!")
            return 0
        else:
            #print("Ops, your login or password is incorrect. Try again later!")
            return -1

    def block(self):
        print("You failed. You are not able to try it anymore")

chances = 5


login = input("Type your login: ")
password = int(input("Type your password: "))

admin1 = admin()

if admin1.authentication(login, password) == 0:
    print("Welcome, user!")
else:
    chances -= 1
    while 0 < chances:

        print("Ops, your login or password is incorrect. Try again later!")
        login = input("Type your login: ")
        password = int(input("Type your password: "))

        if admin1.authentication(login, password) == 0:
            print("Welcome, user!")
            break

        chances -= 1

if chances == 0:
    admin1.block()
