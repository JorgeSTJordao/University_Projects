from flask import Flask, render_template, request
from login import login

app = Flask(__name__)

app.register_blueprint(login, url_prefix='/')


@app.route("/")
def index():
    return render_template('login.html')


@app.route('/sensors')
def sensors():
    return render_template('sensor.html')


@app.route('/actuators')
def actuators():
    return render_template('actuator.html')


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)