package Application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE N.1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TESTE N.2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE N.3: seller findAll ===");
		list = sellerDao.findAll();		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE N.4: seller insert ===");
		Seller newSeller = new Seller(null, "Gregory Matthews", "greg_m@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("ID from the new inserted seller: " + newSeller.getId());
	}

}
