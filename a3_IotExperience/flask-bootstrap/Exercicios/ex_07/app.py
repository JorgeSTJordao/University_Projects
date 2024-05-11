from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def index():
    return render_template('home.html')


@app.route('/sensores')
def sensores():
    sensores_list = {'Umidade': 22, 'Temperatura': 23, 'Luminosidade': 1024}
    return render_template('sensores.html', sensores_list=sensores_list)


@app.route('/atuadores')
def atuadores():
    atuadores_list = {'Servor': 122, 'Lâmpada': 1}
    return render_template('atuadores.html', atuadores_list=atuadores_list)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)