package com.team.dao;

import java.sql.*;
import java.util.*;
import util.DBManager;

import com.team.dto.PageVO;

public class PageDAO {
	private PageDAO() {
	}

	private static PageDAO instance = new PageDAO();

	public static PageDAO getInstance() {
		return instance;
	}

	public boolean joinMember(PageVO pVo) {
		String sql = "insert into users values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean chid = true;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getUserId());
			pstmt.setString(2, pVo.getUName());
			pstmt.setString(3, pVo.getUPw());
			pstmt.setString(4, pVo.getUPhone());
			pstmt.setString(5, pVo.getUEmail());
			pstmt.setString(6, pVo.getUAddr());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			chid = false;
		} finally {
			DBManager.close(conn, pstmt);
		}
		return chid;
	}

	public boolean checkPw(PageVO pVo) {
		String sql = "select * from users where UserId=? and UPw=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean chpw = false;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getUserId());
			pstmt.setString(2, pVo.getUPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				chpw = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return chpw;
	}

	public void productAdd(PageVO pVo) {
		String sql = "insert into product(PNo, PName, PPrice, PClass1, PClass2, PDetail, PPhoto, PSId) values(product_seq.nextval,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getPName());
			pstmt.setString(2, pVo.getPPrice());
			pstmt.setString(3, pVo.getPClass1());
			pstmt.setString(4, pVo.getPClass2());
			pstmt.setString(5, pVo.getPDetail());
			pstmt.setString(6, pVo.getPPhoto());
			pstmt.setString(7, pVo.getPSId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public PageVO myInfo(PageVO pVo) {
		String sql = "select * from users where UserId=?";
		PageVO info = null;
		ArrayList<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				info = new PageVO();
				info.setUName(rs.getString("UName"));
				info.setUEmail(rs.getString("UEmail"));
				info.setUPhone(rs.getString("UPhone"));
				info.setUAddr(rs.getString("UAddr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return info;
	}

	public void deleteMember(String UserId) {
		String sql = "delete from users where UserId=?";
		String sql2 = "delete from product where PSId=? and PSelled=0";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserId);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, UserId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void modifyMInfo(PageVO pVo) {
		String sql = "update users set UPw=?, UPhone=?, UEmail=?, UAddr=? where UserId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getUPw());
			pstmt.setString(2, pVo.getUPhone());
			pstmt.setString(3, pVo.getUEmail());
			pstmt.setString(4, pVo.getUAddr());
			pstmt.setString(5, pVo.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public PageVO PViewSelect(String PNo) {
		String sql = "select * from product where PNo=?";
		PageVO pVo = null;
		ArrayList<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(PNo));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pVo = new PageVO();
				pVo.setPPhoto(rs.getString("PPhoto"));
				pVo.setPName(rs.getString("PName"));
				pVo.setPSId(rs.getString("PSId"));
				pVo.setPPrice(rs.getString("PPrice"));
				pVo.setPDetail(rs.getString("PDetail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}

	public String RProduct() {
		String sql = "select max(PNo) as pd from product";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String rp = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rp = rs.getString("pd");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return rp;
	}

	public void deleteProduct(String PNo) {
		String sql = "delete from product where PNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public PageVO selectProductByPno(String PNo) {
		String sql = "select * from product where PNo=?";
		PageVO pVo = null;
		ArrayList<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(PNo));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pVo = new PageVO();
				pVo.setPPhoto(rs.getString("PPhoto"));
				pVo.setPName(rs.getString("PName"));
				pVo.setPSId(rs.getString("PSId"));
				pVo.setPPrice(rs.getString("PPrice"));
				pVo.setPDetail(rs.getString("PDetail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}

	public List<PageVO> BuyProductList(PageVO pVo) {
		String sql = "select product.PPhoto, product.PNo, product.PName, product.PPrice, buy.DealDate, product.PSId, users.UPhone, users.UEmail from product join buy on product.PNo = buy.PNo left join users on product.PSId=users.UserId where buy.UserId = ?";

		List<PageVO> list = new ArrayList<PageVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getUserId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO tVo = new PageVO();
				tVo.setPPhoto(rs.getString("PPhoto"));
				tVo.setPNo(rs.getInt("PNo"));
				tVo.setPName(rs.getString("PName"));
				tVo.setPPrice(rs.getString("PPrice"));
				tVo.setDealDate(rs.getTimestamp("DealDate"));
				tVo.setPSId(rs.getString("PSId"));
				tVo.setUPhone(rs.getString("UPhone"));
				tVo.setUEmail(rs.getString("UEmail"));

				list.add(tVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public void productModify(PageVO pVo) {
		String sql = "update product set PName=?, PPrice=?, PDetail=?, PPhoto=? where PNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getPName());
			pstmt.setString(2, pVo.getPPrice());
			pstmt.setString(3, pVo.getPDetail());
			pstmt.setString(4, pVo.getPPhoto());
			pstmt.setInt(5, pVo.getPNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void productBuy(String PBId, String PNo) {
		String sql = "insert into buy(UserId, PNo) values(?,?)";
		String sql2 = "update product set PSelled=1 where PNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, PBId);
			pstmt.setInt(2, Integer.parseInt(PNo));
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, Integer.parseInt(PNo));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public int checkSelled(String PNo) {
		String sql = "select PSelled from product where PNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int RS = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, PNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RS = rs.getInt("PSelled");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return RS;
	}

	public List<PageVO> PListSelect(PageVO pVo) {
		String sql = "select * from product order by PSDate desc";
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO pVo1 = new PageVO();

				pVo1.setPName(rs.getString("PName"));
				pVo1.setPPhoto(rs.getString("PPhoto"));
				pVo1.setPPrice(rs.getString("PPrice"));
				pVo1.setPSId(rs.getString("PSId"));
				pVo1.setPSDate(rs.getTimestamp("PSDate"));
				pVo1.setPNo(rs.getInt("PNo"));
				pVo1.setPSelled(rs.getInt("PSelled"));
				pVo1.setPClass1(rs.getString("PClass1"));
				pVo1.setPClass2(rs.getString("PClass2"));
				list.add(pVo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<PageVO> MyProduct(PageVO pVo) {
		String sql = "select * from product where PSId=?";

		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getUserId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO PSList = new PageVO();
				PSList.setPPhoto(rs.getString("PPhoto"));
				PSList.setPNo(rs.getInt("PNo"));
				PSList.setPName(rs.getString("PName"));
				PSList.setPPrice(rs.getString("PPrice"));
				PSList.setPSDate(rs.getTimestamp("PSDate"));
				PSList.setPSelled(rs.getInt("PSelled"));

				list.add(PSList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<PageVO> PListSearch(String search) {
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String search1 = "%" + search + "%";

		String[] category = { "家電製品", "テレビ", "冷蔵庫", "掃除機", "パソコン", "タブレット", "ノートパソコン", "モニター", "カメラ", "デジカメ", "DSLR", "フィルム",
				"携帯電話", "スマホ", "フォルダ", "ゲーム", "ニンテンドー", "プレステ" };

		String sql = "select * from product where PName like ? order by PSDate desc";

		for (String str : category) {
			if (search.equals(str)) {
				System.out.println("카테" + search);
				sql = "select * from product where PName like ? or PClass1 like '" + search + "' or PClass2 like '"
						+ search + "' order by PSDate desc";
			}
		}

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search1);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO pVo1 = new PageVO();
				pVo1.setPName(rs.getString("PName"));
				pVo1.setPPhoto(rs.getString("PPhoto"));
				pVo1.setPPrice(rs.getString("PPrice"));
				pVo1.setPSId(rs.getString("PSId"));
				pVo1.setPSDate(rs.getTimestamp("PSDate"));
				pVo1.setPNo(rs.getInt("PNo"));
				list.add(pVo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<PageVO> PListOpt(String opt, String PClass1, String PClass2, String search1) {
		String sql = null;
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String opt1 = null;
		String PClass01 = null;
		String PClass02 = null;
		String search01 = null;
		String[] category = { "家電製品", "テレビ", "冷蔵庫", "掃除機", "パソコン", "タブレット", "ノートパソコン", "モニター", "カメラ", "デジカメ", "DSLR", "フィルム",
				"携帯電話", "スマホ", "フォルダ", "ゲーム", "ニンテンドー", "プレステ" };

		System.out.println("다오 : " + opt);
		System.out.println("다오 : " + PClass1);
		System.out.println("다오 : " + PClass2);
		System.out.println("다오 : " + search1);

		if (search1 != null) {
			System.out.println("1");
			if (opt.equals("b")) {
				sql = "select * from product where PName like '%" + search1 + "%' order by PName desc";

			} else if (opt.equals("c")) {
				sql = "select * from product where PName like '%" + search1 + "%' order by TO_NUMBER(PPrice) desc";

			} else {
				sql = "select * from product where PName like '%" + search1 + "%' order by PSDate desc";

			}

			for (String str : category) {
				if (search1.equals(str)) {
					System.out.println("카테" + search1);
					if (opt.equals("b")) {
						sql = "select * from product where PName like '%" + search1 + "%' or PClass1 like '" + search1
								+ "' or PClass2 like '" + search1 + "' order by PName desc";

					} else if (opt.equals("c")) {
						sql = "select * from product where PName like '%" + search1 + "%' or PClass1 like '" + search1
								+ "' or PClass2 like '" + search1 + "' order by TO_NUMBER(PPrice) desc";

					} else {
						sql = "select * from product where PName like '%" + search1 + "%' or PClass1 like '" + search1
								+ "' or PClass2 like '" + search1 + "' order by PSDate desc";

					}
				}
			}

			////
		} else if (PClass2 != null) {
			System.out.println("2");
			if (opt.equals("b")) {
				sql = "select * from product where PClass2='" + PClass2 + "' order by PSDate desc";
			} else if (opt.equals("c")) {
				sql = "select * from product where PClass2='" + PClass2 + "' order by TO_NUMBER(PPrice) desc";
			} else {
				sql = "select * from product where PClass2='" + PClass2 + "' order by PSDate desc";
			}

		} else if (PClass1 != null) {
			System.out.println("3");
			if (opt.equals("b")) {
				sql = "select * from product where PClass1='" + PClass1 + "' order by PSDate desc";
			} else if (opt.equals("c")) {
				sql = "select * from product where PClass1='" + PClass1 + "' order by TO_NUMBER(PPrice) desc";
			} else {
				sql = "select * from product where PClass1='" + PClass1 + "' order by PSDate desc";
			}

		} else {
			System.out.println("4");
			if (opt.equals("b")) {
				sql = "select * from product order by PName desc";
			} else if (opt.equals("c")) {
				sql = "select * from product order by TO_NUMBER(PPrice) desc";
			} else {
				sql = "select * from product order by PSDate desc";
			}
		}

		System.out.println("다오" + opt1);

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO pVo1 = new PageVO();

				pVo1.setPName(rs.getString("PName"));
				pVo1.setPPhoto(rs.getString("PPhoto"));
				pVo1.setPPrice(rs.getString("PPrice"));
				pVo1.setPSId(rs.getString("PSId"));
				pVo1.setPSDate(rs.getTimestamp("PSDate"));
				pVo1.setPNo(rs.getInt("PNo"));

				list.add(pVo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<PageVO> PListClass1(String pclass1) {
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			String sql = "select * from product where PClass1=? order by PSDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pclass1);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO pVo1 = new PageVO();
				pVo1.setPName(rs.getString("PName"));
				pVo1.setPPhoto(rs.getString("PPhoto"));
				pVo1.setPPrice(rs.getString("PPrice"));
				pVo1.setPSId(rs.getString("PSId"));
				pVo1.setPSDate(rs.getTimestamp("PSDate"));
				pVo1.setPNo(rs.getInt("PNo"));
				list.add(pVo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<PageVO> PListClass2(String pclass2) {
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			String sql = "select * from product where PClass2=? order by PSDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pclass2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PageVO pVo1 = new PageVO();
				pVo1.setPName(rs.getString("PName"));
				pVo1.setPPhoto(rs.getString("PPhoto"));
				pVo1.setPPrice(rs.getString("PPrice"));
				pVo1.setPSId(rs.getString("PSId"));
				pVo1.setPSDate(rs.getTimestamp("PSDate"));
				pVo1.setPNo(rs.getInt("PNo"));
				list.add(pVo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public boolean checkMPw(PageVO pVo) {
		String sql = "select * from admin where AId=? and APw=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean chpw = false;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getAId());
			pstmt.setString(2, pVo.getAPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				chpw = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return chpw;
	}

	public List<PageVO> userInfo(PageVO pVo) {
		String sql = "select UserId, UName, UEmail, UPhone, UAddr from users";
		List<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PageVO info = new PageVO();

				info.setUserId(rs.getString("UserId"));
				info.setUName(rs.getString("UName"));
				info.setUEmail(rs.getString("UEmail"));
				info.setUPhone(rs.getString("UPhone"));
				info.setUAddr(rs.getString("UAddr"));

				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public PageVO FindUInfo(String UPhone, String UEmail) {
		String sql = "select UserId, UPw from users where UPhone=? and UEmail=?";
		PageVO info = null;
		ArrayList<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UPhone);
			pstmt.setString(2, UEmail);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				info = new PageVO();
				info.setUserId(rs.getString("UserId"));
				info.setUPw(rs.getString("UPw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return info;
	}
	public boolean FindUInfo1(String UPhone, String UEmail) {
		String sql = "select UserId, UPw from users where UPhone=? and UEmail=?";
		boolean i = false;
		ArrayList<PageVO> list = new ArrayList<PageVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UPhone);
			pstmt.setString(2, UEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				i = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return i;
	}

}
