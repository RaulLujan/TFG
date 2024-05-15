const express = require('express');
const axios = require('axios');
const app = express();
const path = require('path');
let usuarioSesion = {};  // Variable global para almacenar la información del usuario
let listST = {};  // Variable global para almacenar la información de los sitios turisticos
let sitio = {};  // Variable global para almacenar la información del sitio turistico
let listAlojamientos = {};  // Variable global para almacenar la información de los Alojamientos
let alojamiento = {};  // Variable global para almacenar la información del alojamiento
// Middleware para parsear JSON
app.use(express.json());

// Sirviendo archivos estáticos desde la carpeta 'public'
app.use(express.static(path.join(__dirname, 'public')));

// Ruta principal que sirve tu archivo HTML
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '/public/login.html'));
});

// Ruta que hace una solicitud POST a tu API de Java Spring
app.post('/api/login', async (req, res) => {
  const { correo, contrasenya } = req.body;  // Asegúrate de que estos campos se envían desde el cliente
  try {
    const response = await axios.post('http://localhost:8080/login', {
      correo: correo,
      contrasenya: contrasenya
    });
	  usuarioSesion = response.data;
    res.json(response.data);
  } catch (error) {
    console.error('Error al conectar con el API de Java Spring:', error.response ? error.response.data : error.message);
    res.status(201).send('Error al conectar con el API de Java Spring');
  }
});

// Ruta que envía los datos del usuario al cliente
app.get('/api/usuario', (req, res) => {
  if (Object.keys(usuarioSesion).length === 0) {
    return res.status(404).json({ error: "Usuario no encontrado" });
  }
  res.json(usuarioSesion);
});


// Ruta que hace una solicitud POST a tu API de Java Spring
app.post('/api/register', async (req, res) => {
  const { nombreUsuario, correo, contrasenya, numeroTelefono, nombreCompleto, edad, estadoCivil, tamanyoFamilia, tieneVehiculo } = req.body;  // Asegúrate de que estos campos se envían desde el cliente
  try {
    const response = await axios.post('http://localhost:8080/register', {
	  nombreUsuario: nombreUsuario,	
    correo: correo,
    contrasenya: contrasenya,
	  numeroTelefono: numeroTelefono,
	  nombreCompleto: nombreCompleto,
	  edad: edad,
	  estadoCivil: estadoCivil,
	  tamanyoFamilia: tamanyoFamilia,
	  tieneVehiculo: tieneVehiculo
    });
    res.json(response.data);
  } catch (error) {
    console.error('Error al conectar con el API de Java Spring:', error.response ? error.response.data : error.message);
    res.status(201).send('Error al conectar con el API de Java Spring');
  }
});

// Ruta que hace una solicitud GET a tu API de Java Spring para obtener datos del perfil
app.get('/api/perfil', async (req, res) => {
  // Aquí usamos un valor de ejemplo, deberías obtener `idUsuario` de manera adecuada, como de una sesión
  if (!usuarioSesion.id) {
    return res.status(401).json({ error: "Usuario no autenticado" });
  }

  try {
    const response = await axios.get(`http://localhost:8080/perfil?idUsuario=${usuarioSesion.id}`);
    res.json(response.data);  // Enviar los datos del perfil al cliente
  } catch (error) {
    console.error('Error al obtener el perfil:', error.response ? error.response.data : error.message);
    res.status(201).json({ error: 'Error al conectar con el API de Java Spring' });
  }
});

// Ruta que hace una solicitud GET a tu API de Java Spring para obtener datos del perfil
app.get('/api/listAmigos', async (req, res) => {
  // Aquí usamos un valor de ejemplo, deberías obtener `idUsuario` de manera adecuada, como de una sesión
  if (!usuarioSesion.id) {
    return res.status(401).json({ error: "Usuario no autenticado" });
  }

  try {
    const response = await axios.get(`http://localhost:8080/listaAmigos?idUsuario=${usuarioSesion.id}`);
    res.json(response.data);  // Enviar los datos del perfil al cliente
  } catch (error) {
    console.error('Error al obtener el perfil:', error.response ? error.response.data : error.message);
    res.status(201).json({ error: 'Error al conectar con el API de Java Spring' });
  }
});

app.post('/api/actualizarPerfil', async (req, res) => {
  const { usuario, preferenciasUsuario } = req.body;
  usuario.id = usuarioSesion.id;
  preferenciasUsuario.usuarioId = usuarioSesion.id;
  try {
    // Llamar al API externo con la información del usuario y sus preferencias
    const apiResponse = await axios.put('http://localhost:8080/perfil', {
      usuario: usuario,
      preferenciasUsuario: preferenciasUsuario
    });
	  usuarioSesion = apiResponse.data;
    // Si la respuesta del API externo es exitosa, enviar una confirmación al cliente
    res.status(200).json({ message: "Perfil actualizado con éxito", data: apiResponse.data });
  } catch (error) {
    console.error('Error al actualizar el perfil en el API externo:', error.message);
    // Enviar un mensaje de error al cliente
    res.status(500).json({ message: "Error al actualizar el perfil", error: error.message });
  }
});


app.post('/api/buscarST', async (req, res) => {
  const { busqueda } = req.body;
  const usuario = usuarioSesion;
  busqueda.tipoBusqueda = "Turística";
  try {
    // Llamar al API externo con la información del usuario y sus preferencias
    const apiResponse = await axios.post('http://localhost:8080/buscarST', {
      usuario: usuario,
      busqueda: busqueda
    });
    listST = apiResponse.data;
    res.status(200).json({ message: "Sitios turisticos buscandos con exito", data: apiResponse.data }); 
  } catch (error) {
    console.error('Error al buscar Sitios Turisticos en el API externo:', error.message);
    // Enviar un mensaje de error al cliente
    res.status(201).json({ message: "Error al buscar Sitios Turisticos", error: error.message });
  }
});

app.get('/api/resultadoST', async (req, res) => {
  res.json(listST);
});

app.post('/api/resultadoST', async (req, res) => {
  sitio = req.body; 
});

app.get('/api/mostrarST', async (req, res) => {
  res.json(sitio);
});


app.get('/api/guardarST', async (req, res) => {
  try {
    // Llamar al API externo con la información del usuario y sus preferencias
    const response = await  axios.post('http://localhost:8080/guardarST', {
      usuarioId: usuarioSesion.id,
      nombre: sitio.site.nombre,
      descripcion: sitio.site.descripcion,
      url: sitio.site.url,
      precioEntrada: sitio.site.precioEntrada,
      actividades: sitio.site.actividades,
      modoTransporte: sitio.site.modoTransporte,
      clima: sitio.site.clima,
      ubicacion: sitio.site.ubicacion
    });
    sitio = response.data;
    // Si la respuesta del API externo es exitosa, enviar una confirmación al cliente
    res.status(200).json({ message: "Sitio Tristico guardado con éxito", data: response.data });
  } catch (error) {
    console.error('Error al guardar Sitio Turistico en el API externo:', error.message);
    // Enviar un mensaje de error al cliente
    res.status(500).json({ message: "Error al guardar Sitio Turistico", error: error.message });
  }
});


app.post('/api/buscarAlojamiento', async (req, res) => {
  const { busqueda } = req.body;
  const usuario = usuarioSesion;
  try {
    // Llamar al API externo con la información del usuario y sus preferencias
    const apiResponse = await axios.post('http://localhost:8080/buscarAlojamiento', {
      sitio : sitio,
      usuario: usuario,
      busqueda: busqueda
    });
    listAlojamientos = apiResponse.data;
    res.status(200).json({ message: "Alojamientos buscandos con exito", data: apiResponse.data }); 
  } catch (error) {
    console.error('Error al buscar Alojamientos en el API externo:', error.message);
    // Enviar un mensaje de error al cliente
    res.status(201).json({ message: "Error al buscar Alojamientos", error: error.message });
  }
});


app.get('/api/resultadoAlojamiento', async (req, res) => {
  res.json(listAlojamientos);
});

app.post('/api/guardarAlojamiento', async (req, res) => {
  alojamiento = req.body;
  try {
    // Llamar al API externo con la información del usuario y sus preferencias
    const response = await  axios.post('http://localhost:8080/guardarAlojamiento', {
      idUsuario: usuarioSesion.id,
      idSitio : sitio.id,
      nombre: alojamiento.alojamiento.nombre,
      descripcion: alojamiento.alojamiento.descripcion,
      urlReserva: alojamiento.alojamiento.urlReserva,
      precioPorNoche: alojamiento.alojamiento.precioPorNoche,
      facilidades: alojamiento.alojamiento.facilidades,
      tipoAlojamiento: alojamiento.alojamiento.tipoAlojamiento,
      distancia: alojamiento.alojamiento.distancia,
      valoracion: alojamiento.alojamiento.valoracion
    });
    // Si la respuesta del API externo es exitosa, enviar una confirmación al cliente
    res.status(200).json({ message: "Alojamientos guardado con éxito", data: response.data });
  } catch (error) {
    console.error('Error al guardar Alojamientos en el API externo:', error.message);
    // Enviar un mensaje de error al cliente
    res.status(500).json({ message: "Error al guardar Alojamientos", error: error.message });
  }
});


app.get('/api/viajesGuardados', async (req, res) => {
  try {
    const response = await axios.get(`http://localhost:8080/obtenerViajes?idUsuario=${usuarioSesion.id}`);
    res.json(response.data); 
  } catch (error) {
    console.error('Error al obtener viajes:', error.response ? error.response.data : error.message);
    res.status(201).json({ error: 'Error al conectar con el API de Java Spring' });
  }
});


const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
