from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("home.html")


@app.route("/sensores")
def sensores():
    return "Sensores"


@app.route("/atuadores")
def atuadores():
    return "Atuadores"


#Esse código só vai rodar abaixo será executado somente se o nome do arquivo for igual a __main__
if __name__ == '__main__':
    app.run(debug=True)