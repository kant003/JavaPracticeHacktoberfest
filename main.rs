use actix_web::{web, App, HttpResponse, HttpServer, Responder};
use std::sync::Mutex;

struct AppState {
    tasks: Mutex<Vec<String>>,
}

async fn index(data: web::Data<AppState>) -> impl Responder {
    let tasks = data.tasks.lock().unwrap();
    let mut response_html = String::from("<h1>Lista de Tareas</h1><ul>");
    
    for task in tasks.iter() {
        response_html.push_str(&format!("<li>{}</li>", task));
    }

    if tasks.is_empty() {
        response_html.push_str("<li>No hay tareas pendientes.</li>");
    }

    response_html.push_str("</ul>
        <form action=\"/add\" method=\"POST\">
            <input type=\"text\" name=\"task\" placeholder=\"Nueva tarea\" required>
            <button type=\"submit\">Agregar Tarea</button>
        </form>");

    HttpResponse::Ok().body(response_html)
}

async fn add_task(data: web::Data<AppState>, form: web::Form<String>) -> impl Responder {
    let mut tasks = data.tasks.lock().unwrap();
    tasks.push(form.into_inner());
    HttpResponse::SeeOther().header("Location", "/").finish()
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    let app_data = web::Data::new(AppState {
        tasks: Mutex::new(Vec::new()),
    });

    HttpServer::new(move || {
        App::new()
            .app_data(app_data.clone())
            .route("/", web::get().to(index))
            .route("/add", web::post().to(add_task))
    })
    .bind("127.0.0.1:8080")?
    .run()
    .await
}
