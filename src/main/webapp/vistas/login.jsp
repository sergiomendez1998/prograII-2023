<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <title>Login</title>
</head>
<body>
<div class="container py-5">
  <div class="row justify-content-center align-items-center" style="height:  90vh">
    <form class="d-flex align-items-center flex-column" action="Controlador" class="was-validated">
      <h1 class="text-center fw-bold">Inicio de sesion</h1>
      <div class="col-12 col-md-8">
        <div class="form-floating mb-3">
          <input type="text" name="txtUsername" class="form-control" id="floatingInput" placeholder="userName" required>
          <label for="floatingInput">Usuario</label>
        </div>
      </div>
      <div class="col-12 col-md-8 pb-4">
        <div class="form-floating">
          <input type="password" name="txtPassword" class="form-control" id="floatingPassword" placeholder="Password" required>
          <label for="floatingPassword">Contraseña</label>
        </div>
      </div>
      <input class="btn btn-primary" type="submit" name="accion" value="inicio">
    </form>
  </div>
</div>

</body>
</html>
