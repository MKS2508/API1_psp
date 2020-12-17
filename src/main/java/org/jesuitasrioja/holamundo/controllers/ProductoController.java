package org.jesuitasrioja.holamundo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;
import org.jesuitasrioja.holamundo.repository.IProductosRepo;
import org.jesuitasrioja.holamundo.repository.ProductosRepoMongoDB;
import org.jesuitasrioja.holamundo.repository.ProductosRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
	
	private IProductosRepo repo = new ProductosRepoMongoDB();
	
	@GetMapping("/productos")
	public List<Producto> allProducts(){
		
		return repo.getAll();
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {
		return repo.getById(id);
	}
	
	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam String id) {
		return repo.getById(id);
	}	
	
	@PostMapping("/producto")
	public String postProducto(@RequestBody Producto nuevoProducto) {
		return "Añadido: "+repo.addProducto(nuevoProducto);
	}
	
	@PutMapping("/producto")
	public String putProducto(@RequestBody Producto editadoProducto) {
		
		return null;
	}
	
	@DeleteMapping("/producto/{id}")
	public String deleteProducto(@PathVariable String id) {
		
		return String.valueOf(repo.rmProducto(id));
	}
	
//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo(@PathVariable String nombre) {
//		return "hola "+nombre;
//	}
//	
//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo2(@PathVariable String nombre) {
//		return "hola "+nombre;
//	}
//	
//	@GetMapping("/saludos")
//	public String getSaludo(@RequestParam String nombre) {
//		return "hola "+nombre;
//	}
//	
//	@PostMapping("/saludos")
//	public String postSaludo(@RequestBody String cuerpo) {
//		System.out.println("----Cuerpo----");
//		System.out.println(cuerpo);
//		return cuerpo;
//	}
//	
//	@DeleteMapping("/saludos")
//	public String deleteSaludo() {
//		return "hola mundo con delete";
//	}
//	
//	@PutMapping("/saludos")
//	public String putSaludo() {
//		return "hola mundo con put";
//	}
}
