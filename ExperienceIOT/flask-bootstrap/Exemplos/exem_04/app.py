from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return """
    <html>
        <head>
            <title>Minha Casa</title>
        </head>
        <body>
            <h2>Minha Casa</h2>
            <h3>Acesse o menu:</h3>
            <ul>
            <li><a href="/sensores">Listar Sensores</a></li>
            <li><a href="/atuadores">Listar Atuadores</a></li>
            </ul>
        </body>
    </html
    """


@app.route("/sensores")
def sensores():
    return """
        <html>
        <head>
            <title>Minha Casa</title>
        </head>
        <body>
            <h1>Sensores</h1>
            <ul>
            <li>Sensor de Umidade</li>
            <li>Sensor de Temperatura</li>
            <li>Sensor de Luminosidade</li>
            </ul>
            <p>Voltar para <a href="/">página inicial</a>!</p>
        </body>
        </html>
"""


@app.route("/atuadores")
def atuadores():
    return "Listar atuadores"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080, debug=True)