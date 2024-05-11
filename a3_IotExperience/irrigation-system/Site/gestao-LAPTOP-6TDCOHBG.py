from flask import Blueprint, Flask, render_template, request ,url_for
gestao = Blueprint("gestao",__name__, template_folder="templates")
from globals import *


@gestao.route('/cadastro')
def cadastro():
    return render_template('cadastro.html', usuarios=users)


@gestao.route('/validated_user', methods=['GET', 'POST'])
def validated_user():
    global bits
    global users
    global produtos
    global amdmin
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
        if user in admin and admin['admin'] == password:
            return render_template('gestao.html', bits=bits, usuarios=users,produtos=produtos,admin=admin)
        if user in users and users[user] == password:
            return render_template('aparelhos.html', bits=bits, usuarios=users,produtos=produtos,admin=admin)
        else:
            return '<h1>senha invalida!</h1>'
    else:
        return render_template('login.html')

@gestao.route('/gestao_pagina')
def gestao_pagina():
    global users
    global produtos
    global admin
    return render_template("gestao.html", usuarios=users,produtos=produtos, admin=admin)

@gestao.route('/add_user', methods=['GET','POST'])
def add_user():
    global users
    global produtos
    global admin
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
    else:
        user = request.args.get('user', None)
        password = request.args.get('password', None)
    users[user] = password
    return render_template("gestao.html", usuarios=users,produtos=produtos, admin=admin)

@gestao.route('/del_user', methods=['POST'])
def del_user():
    global users
    global admin
    global produtos
    user_to_delete = request.form['user']
    if user_to_delete in users:
        users.pop(user_to_delete)
    return render_template("gestao.html", usuarios=users,produtos=produtos, admin=admin)

@gestao.route('/edit_user', methods=['POST'])
def edit_user():
    global users
    global produtos
    global admin
    if request.method == 'POST':
        user_to_edit = request.form['user']
        new_name = request.form['new_name']
        if user_to_edit in users:
            users[new_name] = users.pop(user_to_edit)
    return render_template('gestao.html', usuarios=users,produtos=produtos,admin=admin)

@gestao.route('/create_user', methods=['GET','POST'])
def create_user():
    global users
    global produtos
    global bits
    if request.method == 'POST':
        user = request.form['user']
        password = request.form['password']
    else:
        user = request.args.get('user', None)
        password = request.args.get('password', None)
    users[user] = password
    return render_template("aparelhos.html", usuarios=users,produtos=produtos,bits=bits)

@gestao.route('/admin_dash')
def admin_dash():
    global users
    global produtos
    global bits
    return render_template('admin_dash.html',usuarios=users,produtos=produtos,bits=bits)

@gestao.route('/aparelhos')
def aparelhos():
    global bits
    global users
    global produtos
    return render_template('aparelhos.html', bits=bits, usuarios=users, produtos=produtos)


@gestao.route('/add_product', methods=['GET','POST'])
def add_product():
    global produtos
    global users
    global bits
    global admin
    if request.method == 'POST':
        nome = request.form['nome']
        id = request.form['id']
    else:
        nome = request.args.get('nome', None)
        id= request.args.get('id', None)
    produtos[nome] = id
    return render_template("gestao.html", usuarios=users, produtos=produtos,bits=bits, admin=admin)

