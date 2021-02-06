package com.glints.onlinestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.onlinestore.model.Member;
import com.glints.onlinestore.model.Product;
import com.glints.onlinestore.model.Sale;
import com.glints.onlinestore.payload.SalePayload;
import com.glints.onlinestore.repository.MemberRepo;
import com.glints.onlinestore.repository.ProductRepo;
import com.glints.onlinestore.repository.SaleRepo;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleRepo saleRepo;
	
	@Autowired
	MemberRepo memberRepo;
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Sale> read() {
		List<Sale> sales = saleRepo.findAll();
		return sales;
	}

	@Override
	public Sale create(SalePayload salePayload) {
		Product product = productRepo.findById(salePayload.getProductId()).orElse(null);
		Member member = memberRepo.findById(salePayload.getMemberId()).orElse(null);
		Sale sale = new Sale(salePayload.getTransactionDate(), product, member, product.getPrice());
		product.setQuantity(product.getQuantity()-1);
		productRepo.save(product);
		sale = saleRepo.save(sale);
		return sale;
	}

	@Override
	public Sale update(Integer id, SalePayload salePayload) {
		Sale sale = saleRepo.findById(id).orElse(null);
		Member member = memberRepo.findById(salePayload.getMemberId()).orElse(null);
		
		Product product = sale.getProduct();
		Product productOld = productRepo.findById(product.getId()).orElse(null);
		productOld.setQuantity(productOld.getQuantity() + 1);
		productRepo.save(productOld);
		
		Product productNew = productRepo.findById(salePayload.getProductId()).orElse(null);
		productNew.setQuantity(productNew.getQuantity() - 1);
		productRepo.save(productNew);
		
		sale.setTransactionDate(salePayload.getTransactionDate());
		sale.setProduct(productNew);
		sale.setMember(member);
		sale.setTotalPrice(productNew.getPrice());
		sale.setUpdatedTime(new Date());
		sale = saleRepo.save(sale);
		return sale;
	}

	@Override
	public String delete(Integer id) {
		saleRepo.deleteById(id);
		return "Transaction with id: " + id + " has been deleted!";
	}

	@Override
	public Sale readById(Integer id) {
		Sale sale = saleRepo.findById(id).orElse(null);
		return sale;
	}
}
