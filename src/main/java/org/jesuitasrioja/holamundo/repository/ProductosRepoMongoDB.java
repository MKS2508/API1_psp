package org.jesuitasrioja.holamundo.repository;

import java.util.List;

import org.bson.Document;
import org.jesuitasrioja.holamundo.modelo.Producto;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ProductosRepoMongoDB implements IProductosRepo {

	private MongoCollection<Document> collection;

	public ProductosRepoMongoDB() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("ProductosDB");
		collection = database.getCollection("Productos");
	}

	
	/**
	 * @return El producto con el id pasado por parámetro o null en caso de no existir.
	 * @param id producto
	 * */
	@Override
	public Producto getById(String id) {
    	Document d = new Document("id", id);
		Producto p = null;
//		Document productoDocument = collection.find(Filters.eq("id",id)).first();

		Document productoDocument = collection.find(d).first();
		if(productoDocument != null) {
			p = document2Producto(productoDocument);
		}

		return p;
	}

	/**
	 * @return Funcion Auxiliar transformar documento en Clase Producto.
	 * @param id producto
	 * */
	private Producto document2Producto(Document productoDocument) {
		Producto p;
		Gson gson = new Gson();
		String productoJSON = productoDocument.toJson();
		System.out.println("JSON: " + productoJSON);
		System.out.println("Documento: " + productoDocument);
		p = gson.fromJson(productoJSON, Producto.class);
		return p;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProducto(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rmProducto(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
