#importar o pyrebase4 no pip
import pyrebase

firebaseConfig = {
    "apiKey": "AIzaSyCO5J2eR4wSUc0drR82TgIUUUd7p-S1SD4",
    "authDomain": "datasecur-efe01.firebaseapp.com",
    "projectId": "datasecur-efe01",
    "storageBucket": "datasecur-efe01.appspot.com",
    "databaseURL": "https://" + "datasecur-efe01-default-rtdb" + ".firebaseio.com",
    "messagingSenderId": "491362049098",
    "appId": "1:491362049098:web:e08c183bf002031e5ddab3",
    "measurementId": "G-HSC7FE75SK"
}

firebase = pyrebase.initialize_app(firebaseConfig)
auth = firebase.auth()

user = input("Digite seu e-mail: ")
password = input("Digite sua senha, com pelo menos 6 caracteres: ")
token = auth.create_user_with_email_and_password(user,password) # method will return user data including a token you can use to adhere to security rules
print("Resultado: ", token)



