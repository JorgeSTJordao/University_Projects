from flask import Blueprint, Flask, render_template, request, url_for, jsonify
from flask_mqtt import Mqtt
from flask_socketio import SocketIO
import json

app = Flask(__name__)

app.config['MQTT_BROKER_URL'] = 'mqtt-dashboard.com'
app.config['MQTT_BROKER_PORT'] = 1883
app.config['MQTT_USERNAME'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_PASSWORD'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_KEEPALIVE'] = 1000  # Set KeepAlive time in seconds
app.config['MQTT_TLS_ENABLED'] = False  # If your broker supports TLS, set it True

#Objeto MQTT
mqtt_client= Mqtt()
mqtt_client.init_app(app)

estado = "0"
bits = {}
i = 0

topic_subscribe = "led/publish"  #subscribe  /publish

admin = {
    "admin":"admin"
}

users = {
    "user1":"1234",
    "user2":"12345",
    "1":"1"
}

produtos = {
    "Produto1":"01"
}


@app.route('/')
def index():
    return render_template("login.html")

@app.route('/gestao')
def gestao():
    global users
    global produtos
    return render_template("gestao.html", usuarios=users,produtos=produtos)

@app.route('/admin_dash')
def admin_dash():
    global users
    global produtos
    global bits
    return render_template('admin_dash.html',usuarios=users,produtos=produtos,bits=bits)

@app.route('/validated_user', methods=['GET', 'POST'])
def validated_user():
    global bits
    global users
    global produtos
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
        if user in admin and admin['admin'] == password:
            return render_template('admin_dash.html', bits=bits, usuarios=users,produtos=produtos)
        if user in users and users[user] == password:
            return render_template('aparelhos.html', bits=bits, usuarios=users,produtos=produtos)
        else:
            return '<h1>senha invalida!</h1>'
    else:
        return render_template('login.html')


@app.route('/add_user', methods=['GET','POST'])
def add_user():
    global users
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
    else:
        user = request.args.get('user', None)
        password = request.args.get('password', None)
    users[user] = password
    return render_template("gestao.html", usuarios=users,produtos=produtos)



@app.route('/del_user', methods=['POST'])
def del_user():
    global users
    user_to_delete = request.form['user']
    if user_to_delete in users:
        users.pop(user_to_delete)
    return render_template("gestao.html", usuarios=users,produtos=produtos)

@app.route('/edit_user', methods=['POST'])
def edit_user():
    global users
    if request.method == 'POST':
        user_to_edit = request.form['user']
        new_name = request.form['new_name']
        if user_to_edit in users:
            users[new_name] = users.pop(user_to_edit)
    return render_template('gestao.html', usuarios=users,produtos=produtos)

@app.route('/aparelhos')
def aparelhos():
    global bits
    global users
    global produtos
    return render_template('aparelhos.html', bits=bits, usuarios=users, produtos=produtos)

@app.route('/cadastro')
def cadastro():
    return render_template('cadastro.html', usuarios=users)

@app.route('/create_user', methods=['GET','POST'])
def create_user():
    global users
    global bits
    global produtos
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
    else:
        user = request.args.get('user', None)
        password = request.args.get('password', None)
    users[user] = password
    return render_template("aparelhos.html", bits=bits, usuarios=users,produtos=produtos)

@app.route('/add_product', methods=['GET','POST'])
def add_product():
    global produtos
    global users
    if request.method == 'POST':
        nome = request.form['nome']
        id = request.form['id']
    else:
        nome = request.args.get('nome', None)
        id= request.args.get('id', None)
    produtos[nome] = id
    return render_template("gestao.html", usuarios=users, produtos=produtos,bits=bits)


@mqtt_client.on_connect()
def handle_connect(client, userdata, flags, rc):
    if rc == 0:
        print('Broker Connected successfully')
        mqtt_client.publish("Funcionou!")
        mqtt_client.subscribe(topic_subscribe) # subscribe topic
    else:
        print('Bad connection. Code:', rc)

@mqtt_client.on_disconnect()
def handle_disconnect(client, userdata, rc):
    print("Disconnected from broker")

@mqtt_client.on_message()
def handle_mqtt_message(client, userdata, message):
    global bits
    global i
    js = json.loads(message.payload.decode())
    print(js)

    i += 1
    bits[i] = str(js)

@app.route('/publish')
def publish():
    return render_template('publish.html')

@app.route('/publish_message', methods=['GET','POST'])
def publish_message():
    request_data = request.get_json()
    publish_result = mqtt_client.publish(request_data['topic'], request_data['message'])
    return jsonify(publish_result)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8080, debug=False)