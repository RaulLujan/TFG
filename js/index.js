
document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Previene el envío por defecto del formulario

        // Recoger los valores de los inputs
        const correo = document.querySelector('[name="correo"]').value;
        const contrasenya = document.querySelector('[name="contrasenya"]').value;

        // Datos que se enviarán al servidor
        const loginData = {
            correo: correo,
            contrasenya: contrasenya
        };

        // Realizar la solicitud POST al servidor
        fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // Indicar que el contenido enviado es JSON
            },
            body: JSON.stringify(loginData) // Convertir los datos del login a string JSON
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Login successful:', data);
            // Aquí puedes manejar la redirección o actualización de la interfaz
        })
        .catch(error => {
            console.error('Error during login:', error);
        });
    });
});
