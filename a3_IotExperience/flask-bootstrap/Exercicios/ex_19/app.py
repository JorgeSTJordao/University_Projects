from flask import Flask, render_template, request
from sensor import sensor, sensores
from actuator import actuator, atuadores

app = Flask(__name__)

app.register_blueprint(sensor, url_prefix='/')
app.register_blueprint(actuator, url_prefix='/')

users = {
    "user1": "1234",
    "user2": "1234"
}


@app.route("/")
def index():
    return render_template('login.html')

@app.route('/validated_user', methods=['POST'])
def validated_user():
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
        print(user, password)
        if user in users and users[user] == password:
            return render_template('home.html')
        else:
            return '<h1>invalid credentials!</h1>'
    else:
        return render_template('login.html')


@app.route('/home')
def home():
    return render_template("home.html")


@app.route('/sensor')
def sensor():
    return render_template('sensor.html', sensores=sensores)


@app.route('/actuator')
def actuator():
    return render_template('actuator.html', atuadores=atuadores)



if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)