from flask import Blueprint, request, render_template, url_for

actuator = Blueprint("actuator",__name__, template_folder="templates")

atuadores = {
    "Servor Motor": "1 b",
    "LED": "0 b"
}

@actuator.route('/register_actuator')
def register_actuator():
    return render_template("register_actuator.html")


@actuator.route('/add_actuator', methods=['GET','POST'])
def add_actuator():
    if request.method == 'POST':
        nome = request.form['nome']
        estado = request.form['estado']
    else:
        nome = request.args.get('nome', None)
        estado = request.args.get('estado', None)
    atuadores[nome] = estado + " b"
    return render_template("actuator.html", atuadores=atuadores)


@actuator.route('/remove_actuator')
def remove_actuator():
    return render_template("remove_actuator.html", atuadores=atuadores)


@actuator.route('/del_actuator', methods=['GET','POST'])
def del_actuator():
    if request.method == 'POST':
        actuator = request.form['actuator']
    else:
        actuator = request.args.get('actuator', None)
    atuadores.pop(actuator)
    return render_template("actuator.html", atuadores=atuadores)