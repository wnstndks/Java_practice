package pack.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pack.member.MemberDto;
import pack.order.OrderBean;
import pack.product.ProductDto;

public class ProductManager {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public ProductManager() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패 : " + e.getMessage());
		}
	}

	public ArrayList<ProductDto> getProductAll() {
		ArrayList<ProductDto> plist = new ArrayList<ProductDto>();
		try {
			String sql = "select * from shop_product order by no desc";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
				plist.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getMemberAll err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return plist;
	}

	// 파일 업로드가 있는 insert: cos.jar 사용
	public boolean insertProduct(HttpServletRequest request) {
		// System.out.println(request.getParameter("name"));
		// System.out.println(request.getParameter("price"));
		boolean b = false;
		try {
			// 업로드할 폴더 경로는 절대경로
			String uploadDir = "C:\\work\\java_web7shop\\src\\main\\webapp\\upload";

			MultipartRequest multi = new MultipartRequest(request, uploadDir, 5 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			// System.out.println(multi.getParameter("name"));
			conn = ds.getConnection();
			String sql = "insert into shop_product(name,price,detail,sdate,stock,image) values(?,?,?,now(),?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, multi.getParameter("price"));
			pstmt.setString(3, multi.getParameter("detail"));
			pstmt.setString(4, multi.getParameter("stock"));
			if (multi.getFilesystemName("image") == null) {
				pstmt.setString(5, "ready.gif");
			} else {
				pstmt.setString(5, multi.getFilesystemName("image"));
			}
			if (pstmt.executeUpdate() > 0)
				b = true;
		} catch (Exception e) {
			System.out.println("insertProduct err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return b;
	}

	public ProductDto getProduct(String no) {
		ProductDto dto = new ProductDto();
		try {
			String sql = "select *from shop_product where no=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ProductDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			System.out.println("getProduct err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return dto;
	}

	public boolean updateProduct(HttpServletRequest request) {
		boolean b = false;

		try {
			// 업로드할 폴더 경로는 절대경로
			String uploadDir = "C:\\work\\java_web7shop\\src\\main\\webapp\\upload";

			MultipartRequest multi = new MultipartRequest(request, uploadDir, 5 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			// System.out.println(multi.getParameter("name"));
			conn = ds.getConnection();
			if(multi.getFilesystemName("image")==null) {
				String sql="update shop_product set name=?,price=?,detail=?,stock=? where no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, multi.getParameter("name"));
				pstmt.setString(2, multi.getParameter("price"));
				pstmt.setString(3, multi.getParameter("detail"));
				pstmt.setString(4, multi.getParameter("stock"));
				pstmt.setString(5, multi.getParameter("no"));
			}else {
				String sql="update shop_product set name=?,price=?,detail=?,stock=?,image=? where no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, multi.getParameter("name"));
				pstmt.setString(2, multi.getParameter("price"));
				pstmt.setString(3, multi.getParameter("detail"));
				pstmt.setString(4, multi.getParameter("stock"));
				pstmt.setString(5, multi.getFilesystemName("image"));
				pstmt.setString(6, multi.getParameter("no"));
			}
			if(pstmt.executeUpdate()>0)b=true;
		} catch (Exception e) {
			System.out.println("updateProduct err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
	
	public boolean deleteProduct(String no) {
		boolean b=false;
		//System.out.println("no: "+no);
		try {
			conn = ds.getConnection();
			String sql="delete from shop_product where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			if(pstmt.executeUpdate()>0)b=true;
		} catch (Exception e) {
			System.out.println("deleteProduct err: " + e);
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
	//고객이 상품 주문을 할 경우에 주문 수만큼 재고에서 빼기
	public void reduceProduct(OrderBean orderBean) {
		try {
			String sql="update shop_product set stock=(stock-?) where no=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderBean.getQuantity());
			pstmt.setString(2, orderBean.getProduct_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("reduceProduct err: " + e);
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}















