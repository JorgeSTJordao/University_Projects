from flask import Flask, render_template, request

app = Flask(__name__)

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

@app.route("/home")
def home():
    return render_template('home.html')

@app.route('/sensors')
def sensors():
    return render_template('sensores.html')

@app.route('/actuators')
def actuators():
    return render_template('atuadores.html')

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)