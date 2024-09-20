# app.py
from controllers.app_controller import create_app
from utils.create_db import create_db


#cria o aplicativo e o banco de dados
if __name__ == "__main__":
    app = create_app()
    create_db(app)
    app.run(host='0.0.0.0', port=8080, debug=False)
