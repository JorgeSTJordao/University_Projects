from flask_sqlalchemy import SQLAlchemy

#Instância do banco de dados no MySQL Workbench
db = SQLAlchemy()

instance = "mysql+pymysql://test1:test1@localhost:3306/ra3"