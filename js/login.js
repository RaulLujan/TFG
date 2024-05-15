function login() {
    const email = document.getElementById('email-input').value;
    const password = document.getElementById('password-input').value;

	fetch('http://localhost:8080/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			correo: email,
			contrasenya: password
		})
	})
	.then(response => {
		if (!response.ok) {
			throw new Error('Network response was not ok');
		}
		return response.json();
	})
	.then(data => {
		console.log('Success:', data);
		// Aquí puedes redirigir al usuario o mostrar un mensaje de éxito
	})
	.catch(error => {
		console.error('Error:', error);
		// Aquí puedes mostrar un mensaje de error
	});

}
