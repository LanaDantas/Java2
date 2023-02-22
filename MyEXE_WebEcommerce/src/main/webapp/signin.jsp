<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style2.css">
    <title>Sign-in</title>
</head>

    <div class="container">
        <div class="form-image">
            <img src="img/undraw_shopping_re_3wst.svg" alt="">
        </div>
        <div class="form">
            <form action="signin" method="post">
                <div class="form-header">
                    <div class="title">
                        <h1>Registrati</h1>
                    </div>
                    <div class="login-button">
                        <button><a href="login.html">Login</a></button>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-box">
                        <label for="nome">Nome</label>
                        <input id="nome" type="text" name="nome" placeholder="Inserisci il nome" required>
                    </div>

                    <div class="input-box">
                        <label for="cognome">Cognome</label>
                        <input id="cognome" type="text" name="${cognome}" placeholder="Inserisci cognome" required>
                    </div>
                    
                    <div class="input-box">
                        <label for="eta">Età</label>
                        <input id="eta" type="number" name="eta" placeholder="Inserisci la tua età" step="2" required>
                    </div>
                    
                    <div class="input-box">
                        <label for="citta">Città</label>
                        <input id="citta" type="text" name="citta" placeholder="Inserisci cognome" required>
                    </div>

                    <div class="input-box">
                        <label for="password1">Password</label>
                        <input id="password1" type="password1" name="password1" placeholder="Inserisci password" required>
                    </div>

                </div>

                <div class="continue-button">
                    <button><a href="signin">Invia</a> </button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>