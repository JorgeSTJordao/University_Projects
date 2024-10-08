from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def index():
    return render_template('home.html')

@app.route('/sensors')
def sensors():
    sensores = {'T1': 56, 'T2': 25, 'T3': 15}
    return render_template('sensors.html', sensores=sensores)

@app.route('/actuators')
def actuators():
    atuadores = {'State1': 0, 'State2': 0, 'State3': 1}
    return render_template('actuators.html', atuadores=atuadores)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)