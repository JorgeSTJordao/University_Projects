from flask import Flask

app = Flask(__name__)

#Main Page
@app.route("/")
def index():
    return "<p>Hello, web World!</p>"

@app.route('/sensors')
def sensors():
    return "Lista Sensores"

@app.route('/actuators')
def actuators():
    return "Listar de Atuadores"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)