from flask import Flask, render_template

app = Flask(__name__)


#landing page
@app.route('/')
def home():
    return render_template("landing.html")


#página de login
@app.route("/login")
def login():
    return render_template("login.html")


if __name__ == "__main__":
    app.run(debug=True)