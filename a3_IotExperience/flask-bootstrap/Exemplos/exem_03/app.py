from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return "Home page"


@app.route("/sensores")
def sensores():
    return "Listar sensores"


@app.route("/atuadores")
def atuadores():
    return "Listar atuadores"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080, debug=True)