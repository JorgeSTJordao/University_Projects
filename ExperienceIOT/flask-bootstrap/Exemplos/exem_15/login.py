from flask import Blueprint, request, render_template, url_for

login = Blueprint("login",__name__, template_folder="templates")

users = {
    "user1":"1234",
    "user2":"12345"
}

@login.route('/validated_user', methods=['POST'])
def validated_user():
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
        print(user, password)
        if user in users and users[user] == password:
            return render_template('home.html')
        else:
            return '<h1>invalid credentials!</h1>'
    else:
        return render_template('login.html')



@login.route('/list_users')
def list_users():
    return render_template("users.html", users=users)


@login.route('/register_user')
def register_user():
    return render_template("register_user.html")


@login.route('/add_user', methods=['GET','POST'])
def add_user():
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
    else:
        user = request.args.get('user', None)
        password = request.args.get('password', None)
    users[user] = password
    return render_template("users.html", users=users)


@login.route('/remove_user')
def remove_user():
    return render_template("remove_user.html", users=users)


@login.route('/del_user', methods=['GET','POST'])
def del_user():
    if request.method == 'POST':
        print(request.form)
        user = request.form['user']
    else:
        user = request.args.get('user', None)
    users.pop(user)
    return render_template("users.html", users=users)