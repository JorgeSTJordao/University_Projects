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
            <h2>Home</h2>
            <hr>
            <h3>Menu:</h3>
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
            <title>Sensores</title>
        </head>
        <body>
            <h1>Sensores</h1>
            <hr>
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
    return """
    <html>
        <head>
            <title>Atuadores</title>
        </head>
        <body>
            <h1>Atuadores</h1>
            <hr>
            <ul>
            <li>Sensor Motor</li>
            <li>LED</li>
            </ul>
            <p>Voltar para <a href="/">página inicial</a>!</p>
        </body>
    </html>
    """

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080, debug=True)