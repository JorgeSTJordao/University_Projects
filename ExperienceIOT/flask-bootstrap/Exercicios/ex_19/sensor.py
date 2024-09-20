from flask import Blueprint, request, render_template, url_for

sensor = Blueprint("sensor",__name__, template_folder="templates")

sensores = {
    "Fotosensor": "1 b",
    "DHT11": "0 b"
}


@sensor.route('/register_sensor')
def register_sensor():
    return render_template("register_sensor.html")


@sensor.route('/add_sensor', methods=['GET','POST'])
def add_sensors():
    if request.method == 'POST':
        nome = request.form['nome']
        estado = request.form['estado']
    else:
        nome = request.args.get('nome', None)
        estado = request.args.get('estado', None)
    sensores[nome] = estado + " b"
    return render_template("sensor.html", sensores=sensores)


@sensor.route('/remove_sensor')
def remove_sensor():
    return render_template("remove_sensor.html", sensores=sensores)


@sensor.route('/del_sensor', methods=['GET','POST'])
def del_sensor():
    if request.method == 'POST':
        sensor_ = request.form['sensor']
    else:
        sensor_ = request.args.get('sensor', None)
    sensores.pop(sensor_)
    return render_template("sensor.html", sensores=sensores)