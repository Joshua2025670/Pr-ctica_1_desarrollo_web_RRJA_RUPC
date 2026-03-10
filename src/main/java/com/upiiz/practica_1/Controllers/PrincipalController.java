package com.upiiz.practica_1.Controllers;
import com.upiiz.practica_1.model.etiqueta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrincipalController {

    private List<etiqueta> etiquetas = new ArrayList<>();

    public PrincipalController() {
        // --- ESTRUCTURA ---
        etiquetas.add(new etiqueta("html", "Raíz de un documento HTML.", "<html>...</html>", "lang", ""));
        etiquetas.add(new etiqueta("head", "Contenedor de metadatos (título, scripts, estilos).", "<head>...</head>", "Ninguno común", "<head><title>Página</title></head>"));
        etiquetas.add(new etiqueta("body", "Contiene el contenido visible de la página.", "<body>...</body>", "class, id, style", "<body><h1>Contenido</h1></body>"));

        // --- TEXTO ---
        etiquetas.add(new etiqueta("h1", "Encabezado de nivel 1 (el más importante).", "<h1>Texto</h1>", "class, id", "<h1>Título Principal</h1>"));
        etiquetas.add(new etiqueta("p", "Define un párrafo de texto.", "<p>Texto</p>", "class, id", "<p>Este es un párrafo de ejemplo.</p>"));
        etiquetas.add(new etiqueta("span", "Contenedor en línea para frases o palabras.", "<span>Texto</span>", "class, style", "Hoy es un <span style='color:red'>buen día</span>."));
        etiquetas.add(new etiqueta("strong", "Indica importancia fuerte (negrita semántica).", "<strong>Texto</strong>", "class", "<strong>¡Atención!</strong> Esto es importante."));

        // --- ENLACES E IMÁGENES ---
        etiquetas.add(new etiqueta("a", "Crea un hipervínculo a otras páginas.", "<a href='...'>Link</a>", "href, target, title", "<a href='https://google.com' target='_blank'>Ir a Google</a>"));
        etiquetas.add(new etiqueta("img", "Incrusta una imagen en el documento.", "<img src='...' alt='...'>", "src, alt, width, height", "<img src='https://via.placeholder.com/150' alt='Imagen de prueba'>"));

        // --- LISTAS ---
        etiquetas.add(new etiqueta("ul", "Lista desordenada (con viñetas).", "<ul><li>...</li></ul>", "type", "<ul><li>Item 1</li><li>Item 2</li></ul>"));
        etiquetas.add(new etiqueta("ol", "Lista ordenada (con números).", "<ol><li>...</li></ol>", "start, type", "<ol><li>Primero</li><li>Segundo</li></ol>"));

        // --- TABLAS ---
        etiquetas.add(new etiqueta("table", "Define una tabla de datos.", "<table>...</table>", "border", "<table class='table'><tr><th>Nombre</th></tr><tr><td>Juan</td></tr></table>"));

        // --- FORMULARIOS ---
        etiquetas.add(new etiqueta("form", "Contenedor para controles de entrada de usuario.", "<form>...</form>", "action, method", "<form><input type='text' placeholder='Nombre'></form>"));
        etiquetas.add(new etiqueta("input", "Campo de entrada de datos.", "<input type='...'>", "type, value, name, placeholder", "<input type='checkbox'> Acepto términos"));
        etiquetas.add(new etiqueta("button", "Botón clickeable.", "<button>Click</button>", "type, name", "<button class='btn btn-success'>Enviar</button>"));

        // --- MULTIMEDIA ---
        etiquetas.add(new etiqueta("video", "Incrusta contenido de video.", "<video src='...'></video>", "controls, autoplay, width", "<video controls width='250'><source src='#' type='video/mp4'></video>"));

        // --- SEMÁNTICAS ---
        etiquetas.add(new etiqueta("header", "Cabecera de una sección o página.", "<header>...</header>", "class", "<header><h3>Logo de la App</h3></header>"));
        etiquetas.add(new etiqueta("footer", "Pie de página de una sección.", "<footer>...</footer>", "class", "<footer>© 2026 Desarrollo Web</footer>"));
        etiquetas.add(new etiqueta("nav", "Sección que contiene enlaces de navegación.", "<nav>...</nav>", "class", "<nav><a href='#'>Inicio</a> | <a href='#'>Contacto</a></nav>"));
        etiquetas.add(new etiqueta("section", "Define una sección genérica en un documento.", "<section>...</section>", "id, class", "<section><h4>Sección de Noticias</h4></section>"));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("lista", etiquetas);
        return "index";
    }

    @GetMapping("/{id}") // Cambiamos de "/etiqueta/{id}" a "/{id}" para que coincida con tus <a>
    public String detalles(@PathVariable int id, Model model) {
        // Restamos 1 al ID recibido porque tus enlaces empiezan en 1 y la lista en 0
        int index = id - 1;

        if (index < 0 || index >= etiquetas.size()) {
            return "redirect:/";
        }

        model.addAttribute("tag", etiquetas.get(index));
        model.addAttribute("currentId", id); // Usamos el ID original para los botones sig/ant
        model.addAttribute("total", etiquetas.size());
        return "detalles";
    }
}