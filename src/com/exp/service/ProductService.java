package com.exp.service;

import java.util.List;

import com.exp.dao.ProductDao;
import com.exp.modle.Product;


public class ProductService {
	
	ProductDao pd = new ProductDao();
	
	public List Query(){
		return pd.Query();
	}
	
	public int Edit(Product pro){
		return pd.Edit(pro);
	}

}
