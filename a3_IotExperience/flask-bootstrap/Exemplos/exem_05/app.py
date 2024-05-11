from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def index():
    return render_template("home.html")


@app.route("/sensores")
def sensores():
    return render_template("sensores.html")


@app.route("/atuadores")
def atuadores():
    return "Listar atuadores"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080, debug=True)