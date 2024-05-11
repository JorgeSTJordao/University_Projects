from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def index():
    return render_template('home.html')


@app.route('/quarto')
def quarto():
    return render_template('quarto.html')


@app.route('/quarto/sensor_luminosidade')
def sensor_luminosidade():
    return render_template('sensor_luminosidade.html')


@app.route('/quarto/interruptor')
def interruptor():
    return render_template('interruptor.html')


@app.route('/banheiro')
def banheiro():
    return render_template('banheiro.html')


@app.route('/banheiro/sensor_umidade')
def sensor_umidade():
    return render_template('sensor_umidade.html')


@app.route('/banheiro/lampada_inteligente')
def lampada_inteligente():
    return render_template('lampada_inteligente.html')


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)