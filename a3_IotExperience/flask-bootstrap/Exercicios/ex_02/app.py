from flask import Flask

app = Flask(__name__)

@app.route("/")
def index():
    return """
    <html>
        <head>
            <title>Menu</title>
        </head>
        <body>
            <h2>Página Principal</h2>
            <h3>Menu Principal</h3>
            <ul>
                <li><a href="/quarto">Quarto</a></li>
                <li><a href="/banheiro">Banheiro</a></li>
            <ul>
        </body>    
    </html>
    """


@app.route('/quarto')
def quarto():
    return """
    <html>
        <head>
            <title>Página de Quarto</title>
        </head>
        <body>
            <h2>Dispositivos</h2>
            <ul>
                <li><a href="/quarto/sensor_luminosidade">Sensor de luminosidade</a></li>
                <li><a href="/quarto/interruptor">Interruptor</a></li>
            </ul>
            <p>Voltar para a <a href="/">página principal</a></p>
        </body>    
    </html>
    """


@app.route('/banheiro')
def banheiro():
    return """
    <html>
        <head>
            <title>Banheiro</title>
        </head>
        <body>
            <h2>Menu</h2>
            <ul>
                <li><a href="/banheiro/sensor_umidade">Sensor de umidade</a></li>
                <li><a href="/banheiro/lampada_inteligente">Lâmpada inteligente</a></li>
            </ul>
            <p>Voltar para a <a href="/">Página Principal</a></p>
        </body>    
    </html>
    """


@app.route('/quarto/sensor_luminosidade')
def sensor_luminosidade():
    return """
        <html>
        <head>
            <title>Sensor de luminosidade</title>
        </head>
        <body>
            <h3>Sensor de luminosidade</h3>
            <p>Voltar para a <a href="/quarto">Página do Quarto</a></p>
        </body>    
    </html>
    """


@app.route('/quarto/interruptor')
def interruptor():
    return """
        <html>
        <head>
            <title>Interruptor</title>
        </head>
        <body>
            <h3>Interruptor</h3>
            <p>Voltar para a <a href="/quarto">Página do Quarto</a></p>
        </body>    
    </html>
    """


@app.route('/banheiro/sensor_umidade')
def sensor_umidade():
    return """
         <html>
         <head>
             <title>Sensor de Umidade</title>
         </head>
         <body>
            <h3>Sensor de umidade</h3>
             <p>Voltar para a <a href="/banheiro">Página do Banheiro</a></p>
         </body>    
     </html>
     """


@app.route('/banheiro/lampada_inteligente')
def lampada_inteligente():
    return """
         <html>
         <head>
             <title>Lâmpada Inteligente</title>
         </head>
         <body>
            <h3>Lâmpada Inteligente</h3>
             <p>Voltar para a <a href="/banheiro">Página do Banheiro</a></p>
         </body>    
     </html>
     """
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)