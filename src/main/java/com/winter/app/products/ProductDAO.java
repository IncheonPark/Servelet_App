package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class ProductDAO {
	
	
	// 리스트 조회
	public List<ProductDTO> getList() throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setProductName(rs.getString("PRODUCTNAME"));
			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
			dto.setProductDate(rs.getDate("PRODUCTDATE"));
			dto.setProductDetail(rs.getString("PRODUCTDETAIL"));
			
			list.add(dto);
			
		}
		
		DBConnection.disConnection(rs, st, con);		
		return list;
		
	}
	
	
	//
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, dto.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setProductName(rs.getString("PRODUCTNAME"));
			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
			dto.setProductDate(rs.getDate("PRODUCTDATE"));
			dto.setProductDetail(rs.getString("PRODUCTDETAIL"));
			
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
	}
	
	
	//
	public int add(ProductDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS VALUES (PRODUCTNUM_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getProductName());
		st.setDouble(2, dto.getProductRate());
		st.setDate(3, dto.getProductDate());
		System.out.println("date1 : " + dto.getProductDate());
		System.out.println("date2 : " + dto.getProductDate().toString());
		st.setString(4, dto.getProductDetail());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	//
	public int update(ProductDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE PRODUCTS SET PRODUCTNAME=?, PRODUCTRATE=?, PRODUCTDATE=?, PRODUCTDETAIL=?  "
				+ "WHERE PRODUCTNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getProductName());
		st.setDouble(2, dto.getProductRate());
		st.setDate(3, dto.getProductDate());
		System.out.println("date1 : " + dto.getProductDate());
		System.out.println("date2 : " + dto.getProductDate().toString());
		st.setString(4, dto.getProductDetail());
		st.setLong(5, dto.getProductNum());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	
	
	

}
