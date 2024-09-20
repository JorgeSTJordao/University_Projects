from flask import Flask, render_template, request

app = Flask(__name__)

dados = ["Ligado", "Desligado"]

users = {
    "user1": "1234",
    "user2": "1234"
}

paginas = {'Quarto': '/quarto', 'Banheiro': '/banheiro'}


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
            return render_template('home.html', paginas=paginas)
        else:
            return '<h1>invalid credentials!</h1>'
    else:
        return render_template('login.html')

@app.route("/home")
def home():
    return render_template('home.html', paginas = paginas)

@app.route('/quarto')
def quarto():
    paginas = {'Sensor de Luminosidade': '/quarto/sensor_luminosidade', 'Interruptor': '/quarto/interruptor'}
    return render_template('quarto.html', paginas = paginas)

@app.route('/quarto/sensor_luminosidade')
def sensor_luminosidade():
    return render_template('sensor_luminosidade.html', state=dados[0])

@app.route('/quarto/interruptor')
def interruptor():
    return render_template('interruptor.html', state=dados[0])

@app.route('/banheiro')
def banheiro():
    paginas = {'Sensor de Umidade': '/banheiro/sensor_umidade', 'Lâmpada Inteligente': '/banheiro/lampada_inteligente'}
    return render_template('banheiro.html', paginas=paginas)

@app.route('/banheiro/sensor_umidade')
def sensor_umidade():
    return render_template('sensor_umidade.html', state=dados[0])

@app.route('/banheiro/lampada_inteligente')
def lampada_inteligente():
    return render_template('lampada_inteligente.html', state=dados[1])

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)