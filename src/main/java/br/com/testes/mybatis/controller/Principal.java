package br.com.testes.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import br.com.testes.mybatis.dao.ClienteMapper;
import br.com.testes.mybatis.model.Cliente;

public class Principal {
	public static void main(String[] args) {
		String resource = "br/com/testes/mybatis/controller/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			ClienteMapper mapper = sqlSession.getMapper(ClienteMapper.class);
			List<Cliente> allRecords = new ArrayList<Cliente>();
			allRecords.addAll(mapper.findAll());
			for (Cliente cliente : allRecords) {
				System.out.println(cliente.getNome());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
