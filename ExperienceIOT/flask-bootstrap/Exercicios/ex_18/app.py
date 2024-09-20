from flask import Flask, render_template, request
from sensor import sensor, sensores

app = Flask(__name__)

app.register_blueprint(sensor, url_prefix='/')

users = {
    "user1": "1234",
    "user2": "1234"
}

atuadores = {
    "Servor Motor": "1 b",
    "LED": "0 b"
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


@app.route('/register_actuator')
def register_actuator():
    return render_template("register_actuator.html")


@app.route('/add_actuator', methods=['GET','POST'])
def add_actuator():
    if request.method == 'POST':
        nome = request.form['nome']
        estado = request.form['estado']
    else:
        nome = request.args.get('nome', None)
        estado = request.args.get('estado', None)
    atuadores[nome] = estado + " b"
    return render_template("actuator.html", atuadores=atuadores)


@app.route('/remove_actuator')
def remove_actuator():
    return render_template("remove_actuator.html", atuadores=atuadores)


@app.route('/del_actuator', methods=['GET','POST'])
def del_actuator():
    if request.method == 'POST':
        actuator = request.form['actuator']
    else:
        actuator = request.args.get('actuator', None)
    atuadores.pop(actuator)
    return render_template("actuator.html", atuadores=atuadores)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)