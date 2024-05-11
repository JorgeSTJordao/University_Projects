from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def index():
    return render_template('home.html')


@app.route('/sensores')
def sensores():
    sensores_items = {'T1': 56, 'T2': 25, 'T3': 15}
    return render_template('sensores.html', sensores_items=sensores_items)


@app.route('/atuadores')
def atuadores():
    atuadores_items = {'State1': 0, 'State2': 0, 'State3': 1}
    return render_template('atuadores.html', atuadores_items=atuadores_items)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)