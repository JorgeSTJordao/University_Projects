from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def index():
    return render_template("home.html")


@app.route("/sensores")
def sensores():
    sensores_list = ["Umidade", "Temperatura", "Luminosidade"]
    return render_template("sensores.html", sensores_list=sensores_list)


@app.route("/atuadores")
def atuadores():
    atuadores_list = ["LED", "Servor Motor"]
    return render_template("atuadores.html", atuadores_list=atuadores_list)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080, debug=True)