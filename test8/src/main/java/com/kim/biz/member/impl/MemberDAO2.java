package com.kim.biz.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kim.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	final String sql_selectAll="SELECT * FROM MEMBER";
	final String sql_insert="INSERT INTO MEMBER VALUES(?,?,?,?)";
	final String sql_update="UPDATE MEMBER SET MPW=? WHERE MID=?";
	final String sql_delete="DELETE MEMBER WHERE MID=? AND MPW=?";
	
	void insertMember(MemberVO vo) {
		jdbcTemplate.update(sql_insert,vo.getMid(),vo.getMpw(),vo.getName(),vo.getRole());
	}
	void deleteMember(MemberVO vo) {
		jdbcTemplate.update(sql_delete,vo.getMid(),vo.getMpw());
	}
	void updateMember(MemberVO vo) {
		jdbcTemplate.update(sql_update,vo.getMpw(),vo.getMid());
	}
	MemberVO selectOneMember(MemberVO vo) {
		Object[] args= {vo.getMid(),vo.getMpw()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new MemberRowMapper());
	}
	List<MemberVO> selectAllMember(MemberVO vo) {
		return jdbcTemplate.query(sql_selectAll,new MemberRowMapper());
	}
}
class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("MID"));
		data.setMpw(rs.getString("MPW"));
		data.setName(rs.getString("NAME"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}
	
}